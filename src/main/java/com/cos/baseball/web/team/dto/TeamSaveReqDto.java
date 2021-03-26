package com.cos.baseball.web.team.dto;

import com.cos.baseball.domain.team.Team;

import lombok.Data;

@Data
public class TeamSaveReqDto {

	private String teamName;
	private int ballparkId;
	
	public Team toEntity() {
		return Team.builder()
				.teamName(teamName)
				.build();
	}
}
