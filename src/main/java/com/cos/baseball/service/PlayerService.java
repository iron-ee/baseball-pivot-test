package com.cos.baseball.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.PlayerRepository;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;
import com.cos.baseball.web.dto.PlayerPositionRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {

	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	private final EntityManager entityManager;
	
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
	
	@Transactional(readOnly = true)
	public List<PlayerPositionRespDto> 포지션별선수리스트() {
		StringBuffer sb = new StringBuffer();		
		sb.append("SELECT ");
		sb.append("position, ");
		sb.append("MAX(if(teamId = 1, playerName, \"\")) lotte, ");
		sb.append("MAX(if(teamId = 8, playerName, \"\")) nc, ");
		sb.append("MAX(if(teamId = 6, playerName, \"\")) doosan ");
		sb.append("from player ");
		sb.append("GROUP BY position;");
		Query query = entityManager.createNativeQuery(sb.toString());
		JpaResultMapper result = new JpaResultMapper();
		List<PlayerPositionRespDto> playerPositionRespDto = result.list(query, PlayerPositionRespDto.class);
		return playerPositionRespDto;
		
	}
}
