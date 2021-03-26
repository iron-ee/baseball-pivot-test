package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.ballpark.Ballpark;
import com.cos.baseball.domain.ballpark.BallparkRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BallparkService {

	private final BallparkRepository ballparkRepository;
	
	@Transactional
	public List<Ballpark> 전체찾기() {
		return ballparkRepository.findAll();
	}
	
	public Ballpark 구장추가(Ballpark ballpark) {
		return ballparkRepository.save(ballpark);
	}
	
	public void 삭제하기(int id) {
		ballparkRepository.deleteById(id);
	}
}
