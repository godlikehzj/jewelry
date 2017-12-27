package com.jewelry.dao.cn;

import com.jewelry.bean.jpa.cn.BodyPart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BodyPartRepository extends JpaRepository<BodyPart, Long> {
    List<BodyPart> findByTypeIdEquals(Long typeId);
}
