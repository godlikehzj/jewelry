package com.jewelry.dao.cn;

import com.jewelry.bean.jpa.cn.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutUsRepository  extends JpaRepository<AboutUs, Long>{
    List<AboutUs> findAllByStatus(int status);
}
