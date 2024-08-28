package Tayyab.Project.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import Tayyab.Project.entity.*;

public interface CommodityDao extends JpaRepository<Commodity, Long> {
}
