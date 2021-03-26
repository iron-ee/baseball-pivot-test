package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	
	@Transactional
	public List<Player> 전체찾기() {
		return playerRepository.findAll();
	}
	
	@Transactional
	public Player 선수등록(Player player, int teamId) {
		Team team = teamRepository.findById(teamId).get();
		player.setTeam(team);
	
		return playerRepository.save(player);
	}
	
	public void 삭제하기(int id) {
		playerRepository.deleteById(id);
	}
}
