package com.streetcheck.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.streetcheck.Entity.Report;
import com.streetcheck.Repository.ReportRepository;
import com.streetcheck.dto.ReportDto;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	
	public Page<ReportDto> getAllReports(String carNumber, String location ,String status , Pageable pageable ){
		return reportRepository.findAll(pageable).map(ReportDto::fromEntity);
	}
	
	public List<ReportDto> getMyReports(String userId) {
		return reportRepository.findByUserId(userId)
				.stream()
				.map(ReportDto::fromEntity)
				.toList();
	}
	
	public ReportDto getReportDetail(Long id ) {
		Report report = reportRepository.findById(id)
				.orElseThrow(()->new EntityNotFoundException("해당 신고 없음"));
		report.setViewCnt(report.getViewCnt()+1);
		return ReportDto.fromEntity(report);
	}

}
