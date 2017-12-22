package com.jewelry.dao;

import com.jewelry.bean.jpa.CPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CPictureRespository extends JpaRepository<CPicture, Long> {
    List<CPicture> findAllByCommodityIdAndPositionType(long commodity_id, int position_type);

}
