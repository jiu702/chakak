package com.streetcheck.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.streetcheck.Entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report , Long>{
	List<Report> findByUserId(String userId);
	

}
