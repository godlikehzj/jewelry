package com.jewelry.dao;

import com.jewelry.bean.jpa.JoinUs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JoinUsRepository extends JpaRepository<JoinUs, Long> {
    JoinUs getByStatus(int status);
}
