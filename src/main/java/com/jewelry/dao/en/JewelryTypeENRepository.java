package com.jewelry.dao.en;

import com.jewelry.bean.jpa.en.JewelryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JewelryTypeENRepository extends JpaRepository<JewelryType, Long> {
    JewelryType getById(long id);
}
