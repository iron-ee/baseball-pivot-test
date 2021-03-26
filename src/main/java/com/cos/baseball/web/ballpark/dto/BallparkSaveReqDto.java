package com.cos.baseball.web.ballpark.dto;

import com.cos.baseball.domain.ballpark.Ballpark;

import lombok.Data;

@Data
public class BallparkSaveReqDto {

	private String parkName;
	
	public Ballpark toEntity() {
		return Ballpark.builder()
				.parkName(parkName)
				.build();
	}
}
