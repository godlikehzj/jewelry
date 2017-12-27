package com.jewelry.dao.en;

import com.jewelry.bean.jpa.en.AboutUs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutUsENRepository extends JpaRepository<AboutUs, Long> {
    List<AboutUs> findAllByStatus(int status);
}
