package com.jewelry.dao.en;

import com.jewelry.bean.jpa.en.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodyPartENRepository extends JpaRepository<BodyPart, Long> {
    List<BodyPart> findByTypeIdEquals(Long typeId);
}
