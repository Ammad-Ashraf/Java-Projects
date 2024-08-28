package Tayyab.Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Tayyab.Project.dao.*;
import Tayyab.Project.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    public List<Commodity> findAll() {
        return commodityDao.findAll();
    }

    public Optional<Commodity> findById(Long id) {
        return commodityDao.findById(id);
    }

    public Commodity save(Commodity commodity) {
        return commodityDao.save(commodity);
    }

    public void deleteById(Long id) {
        commodityDao.deleteById(id);
    }

    public Commodity updateCommodity(Commodity updatedCommodity) {
        return commodityDao.save(updatedCommodity);
    }
    
    public List<CommodityInspectionReport> getInspectionReport() {
        List<Commodity> commodities = commodityDao.findAll();
        List<CommodityInspectionReport> report = new ArrayList<>();

        for (Commodity commodity : commodities) {
            double price = commodity.getPrice();
            int quantity = commodity.getQuantity();
            boolean goodForBuying = (price / quantity) < 10; // Implement your logic here

            report.add(new CommodityInspectionReport(
                    commodity.getName(), 
                    price, 
                    quantity, 
                    goodForBuying
            ));
        }

        return report;
    }
}
