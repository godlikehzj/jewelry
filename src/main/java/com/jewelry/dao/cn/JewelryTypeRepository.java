package com.jewelry.dao.cn;

import com.jewelry.bean.jpa.cn.JewelryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JewelryTypeRepository extends JpaRepository<JewelryType, Long> {
    JewelryType getById(long id);
}
