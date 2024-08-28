package Tayyab.Project.Controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Tayyab.Project.service.*;
import Tayyab.Project.entity.*;

@RestController
@RequestMapping("/api/commodities")
public class CommodityController {

    @Autowired
    private CommodityService service;

    @GetMapping
    public List<Commodity> retrieveAllCommodities() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commodity> retrieveCommodity(@PathVariable Long id) {
        Optional<Commodity> commodity = service.findById(id);
        return commodity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Commodity createCommodity(@RequestBody Commodity commodity) {
        return service.save(commodity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommodity(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commodity> updateCommodity(@RequestBody Commodity commodity, @PathVariable Long id) {
        Optional<Commodity> existingCommodity = service.findById(id);
        if (!existingCommodity.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        commodity.setId(id); // Ensure the ID in the request body matches the path variable
        Commodity updatedCommodity = service.updateCommodity(commodity);
        return ResponseEntity.ok(updatedCommodity);
    }
}
