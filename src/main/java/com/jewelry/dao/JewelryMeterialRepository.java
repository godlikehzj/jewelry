package com.jewelry.dao;

import com.jewelry.bean.jpa.JewelryMeterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JewelryMeterialRepository extends JpaRepository<JewelryMeterial, Long> {
    List<JewelryMeterial> findAllByTypeId(long type_id);
}
