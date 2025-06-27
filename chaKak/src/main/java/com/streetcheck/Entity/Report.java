package com.streetcheck.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reportId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	private String title;
	private String vehicleNumber;
	private LocalDateTime reportTime;
	
	private String violationType;
	private String locationType;
	
	private String address;
	private Double latitude;
	private Double longitude;
	
	private String description;
	private String status;
	
	private int viewCnt = 0;
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt;
	

}
