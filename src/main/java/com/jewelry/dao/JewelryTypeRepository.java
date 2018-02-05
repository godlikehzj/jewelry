package com.jewelry.dao;

import com.jewelry.bean.jpa.JewelryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JewelryTypeRepository extends JpaRepository<JewelryType, Long> {
    JewelryType getById(long id);
    List<JewelryType> getAllByStatus(int statu);
}
