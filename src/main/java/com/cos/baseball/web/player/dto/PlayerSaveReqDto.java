package com.cos.baseball.web.player.dto;

import com.cos.baseball.domain.player.Player;

import lombok.Data;

@Data
public class PlayerSaveReqDto {

	private String playerName;
	private String position;
	private int teamId;
	
	public Player toEntity() {
		return Player.builder()
				.playerName(playerName)
				.position(position)
				.build();
	}
}
