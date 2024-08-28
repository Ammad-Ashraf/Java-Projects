package Tayyab.Project.service;


import Tayyab.Project.dao.*;
import Tayyab.Project.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    @Autowired
    private OfferDao offerDao;

    @Autowired
    private CommodityDao commodityDao;

    public List<Offer> findAll() {
        return offerDao.findAll();
    }

    public Offer save(Offer offer) {
        Commodity commodity = commodityDao.findById(offer.getCommodity().getId())
                                          .orElseThrow(() -> new RuntimeException("Commodity not found"));
        offer.setCommodity(commodity);
        return offerDao.save(offer);
    }

    public Offer findById(int id) {
        return offerDao.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));
    }

    public void deleteById(int id) {
        offerDao.deleteById(id);
    }

    public Offer update(Offer offer) {
        return offerDao.save(offer);
    }
}
