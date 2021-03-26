package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.ballpark.Ballpark;
import com.cos.baseball.service.BallparkService;
import com.cos.baseball.web.ballpark.dto.BallparkSaveReqDto;
import com.cos.baseball.web.dto.CMRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BallparkController {

	private final BallparkService ballparkService;
	
	
	@GetMapping("/ballpark")
	public String findAll(Model model) {
		List<Ballpark> ballparks = ballparkService.전체찾기();
		model.addAttribute("ballparks", ballparks);
		
		return "/ballpark/ballparkForm";
	}
	
	@GetMapping("/ballpark/save")
	public String saveForm(Model model) {
		List<Ballpark> ballparks = ballparkService.전체찾기();
		model.addAttribute("ballparks", ballparks);
		return "/ballpark/bsaveForm";
	}
	
	@PostMapping("/ballparkAdd")
	public String save(BallparkSaveReqDto ballparkSaveReqDto, Model model) {
		ballparkService.구장추가(ballparkSaveReqDto.toEntity());
		return "redirect:/ballpark";
	}
	
	@DeleteMapping("/ballpark/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id) {
		ballparkService.삭제하기(id);
		return new CMRespDto<>(1, null);
	}
}
