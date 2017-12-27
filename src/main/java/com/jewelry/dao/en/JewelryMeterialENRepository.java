package com.jewelry.dao.en;

import com.jewelry.bean.jpa.en.JewelryMeterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JewelryMeterialENRepository extends JpaRepository<JewelryMeterial, Long> {
    List<JewelryMeterial> findAllByTypeId(long type_id);
}
