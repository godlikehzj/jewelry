package com.jewelry.dao;

import com.jewelry.bean.jpa.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodyPartRepository extends JpaRepository<BodyPart, Long> {
    List<BodyPart> findByTypeIdEquals(Long typeId);
}
