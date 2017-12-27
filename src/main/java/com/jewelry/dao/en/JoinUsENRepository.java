package com.jewelry.dao.en;

import com.jewelry.bean.jpa.en.JoinUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinUsENRepository extends JpaRepository<JoinUs, Long> {
    JoinUs getByStatus(int status);
}
