package com.streetcheck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.streetcheck.dto.ReportDto;
import com.streetcheck.service.ReportService;

@RestController
@RequestMapping("/api")
public class ReportController {
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/reports")
	public ResponseEntity<Page<ReportDto>> getAllReprots ( 
			@RequestParam(required=false) String carNumber, 
			@RequestParam(required=false) String location,
			@RequestParam(required=false) String status,
			@PageableDefault(size=10) Pageable pageable
			){
		return ResponseEntity.ok(reportService.getAllReports(carNumber, location, status, pageable));
		
	}
	
	@GetMapping("/users/me/reports")
	public ResponseEntity<List<ReportDto>> getMyReports(@AuthenticationPrincipal UserDetailsImpl user) {
		return ResponseEntity.ok(reportService.getMyReports(user.getUsername()));
	}
	
	@GetMapping("/reports/{id}")
	public ResponseEntity<ReportDetailDto> getDetail(@PathVariable Long id) {
		return ResponseEntity.ok(reportService.getReportDetail(id));
	}

}
