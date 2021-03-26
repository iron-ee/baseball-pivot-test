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
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.team.dto.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	
	@GetMapping("/team")
	public String findAll(Model model) {
		List<Team> teams = teamService.전체찾기();
		model.addAttribute("teams", teams);
		
		return "/team/teamForm";
	}
	
	@GetMapping("/team/save")
	public String saveForm(Model model) {
		List<Ballpark> parks = teamService.중복여부();
		model.addAttribute("parks", parks);
		return "/team/tsaveForm";
	}
	
	@PostMapping("/teamAdd")
	public String save(TeamSaveReqDto teamSaveReqDto, Model model) {
		teamService.팀등록(teamSaveReqDto.toEntity(), teamSaveReqDto.getBallparkId());
		return "redirect:/team";
	}
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id) {
		teamService.삭제하기(id);
		return new CMRespDto<>(1, null);
	}
	
}
