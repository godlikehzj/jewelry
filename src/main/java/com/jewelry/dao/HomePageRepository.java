package com.jewelry.dao;

import com.jewelry.bean.jpa.HomePage;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface HomePageRepository extends JpaRepository<HomePage, Long> {
//    @Query("select h from HomePage h where h.status > ?1")
    List<HomePage> findAllByStatusNot(int status, Sort sort);
}
