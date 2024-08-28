package Tayyab.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Tayyab.Project.entity.CommodityInspectionReport;
import Tayyab.Project.service.CommodityService;

@RestController
@RequestMapping("/api")
public class InspectionReportController {

    @Autowired
    private CommodityService commodityService;

    @GetMapping("/inspection-report")
    public List<CommodityInspectionReport> getInspectionReport() {
        return commodityService.getInspectionReport();
    }
}

