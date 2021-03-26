package com.cos.baseball.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.web.dto.CMRespDto;
import com.cos.baseball.web.player.dto.PlayerSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {

	private final PlayerService playerService;
	private final TeamService teamService;
	
	@GetMapping("/player")
	public String findAll(Model model) {
		model.addAttribute("players", playerService.전체찾기());
		return "player/playerForm";
	}
	
	@GetMapping("/player/save")
	public String saveForm(Model model) {
		model.addAttribute("teams", teamService.전체찾기());
		return "player/psaveForm";
	}
	
	@PostMapping("/playerAdd")
	public String save(PlayerSaveReqDto playerSaveReqDto, Model model) {
		playerService.선수등록(playerSaveReqDto.toEntity(), playerSaveReqDto.getTeamId());
		return "redirect:/player";
	}
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody CMRespDto<?> deleteById(@PathVariable int id) {
		playerService.삭제하기(id);
		return new CMRespDto<>(1, null);
	}
}
