package com.jewelry.dao.cn;

import com.jewelry.bean.jpa.cn.JoinUs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinUsRepository extends JpaRepository<JoinUs, Long> {
    JoinUs getByStatus(int status);
}
