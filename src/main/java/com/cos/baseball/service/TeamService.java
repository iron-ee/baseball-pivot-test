package com.cos.baseball.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.ballpark.Ballpark;
import com.cos.baseball.domain.ballpark.BallparkRepository;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {

	private final TeamRepository teamRepository;
	private final BallparkRepository ballparkRepository;
	
	@Transactional
	public List<Team> 전체찾기() {
		return teamRepository.findAll();
	}
	
	@Transactional
	public List<Ballpark> 중복여부() {
		List<Ballpark> list = new ArrayList<>();
		List<Ballpark> entity = ballparkRepository.findAll();
		
		for (Ballpark ballpark: entity) {
			if (ballpark.getTeam() == null) {
				list.add(ballpark);
			}
		}
		return list;
	}
	
	@Transactional
	public void 팀등록(Team team, int ballparkId) {
		Ballpark ballpark = ballparkRepository.findById(ballparkId).get();
		team.setBallpark(ballpark);
		teamRepository.save(team);
	}
	
	public void 삭제하기(int id) { 
		teamRepository.deleteById(id);
	}
}
