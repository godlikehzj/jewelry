package com.jewelry.dao;

import com.jewelry.bean.jpa.Commodity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {
    @Query("select c from Commodity c where c.type_id = ?1")
    List<Commodity> findAllByType_id(int type_id, Sort sort);

    @Query("select c from Commodity c where c.type_id = ?1 and c.part_id = ?2")
    List<Commodity> findAllByType_idAndPart_id(int type_id, int part_id, Sort sort);

    @Query("select c from Commodity c where c.type_id = ?1 and c.part_id = ?2 and c.meterial_id = ?3")
    List<Commodity> findAllByType_idAndPart_idAndMeterial_id(int type_id, int part_id, int meterial_id, Sort sort);

    Commodity getCommodityById(long id);
}
