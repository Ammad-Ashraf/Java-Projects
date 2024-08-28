package Tayyab.Project.Controller;


import Tayyab.Project.entity.Offer;
import Tayyab.Project.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.findAll();
    }

    @GetMapping("/{id}")
    public Offer getOffer(@PathVariable int id) {
        return offerService.findById(id);
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.save(offer);
    }

    @PutMapping("/{id}")
    public Offer updateOffer(@RequestBody Offer offer, @PathVariable int id) {
        offer.setId(id);
        return offerService.update(offer);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable int id) {
        offerService.deleteById(id);
    }
}

