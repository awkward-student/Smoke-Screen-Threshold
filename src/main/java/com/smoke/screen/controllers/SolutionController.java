package com.smoke.screen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoke.screen.payloads.SolutionDTO;
import com.smoke.screen.services.SolutionService;

@RestController
@RequestMapping("/v1/api/")
public class SolutionController {

	@Autowired
	private SolutionService solutionService;

	// For User
	
	@PostMapping("/user/{userId}/submission")
	public ResponseEntity<SolutionDTO> createSolution(@RequestBody SolutionDTO solutionDto, @PathVariable Integer userId){
		SolutionDTO postSolution = this.solutionService.createSolution(solutionDto, userId);
		return new ResponseEntity<>(postSolution, HttpStatus.CREATED);
	}
	
	// Only for Admin
	
	@GetMapping("/adm/auth/user/{userId}")
	public ResponseEntity<SolutionDTO> getSolutionByUser(@PathVariable Integer userId){
		SolutionDTO solution = this.solutionService.getSolutionByUser(userId);
		return new ResponseEntity<SolutionDTO>(solution, HttpStatus.OK);
	}
	
	
}
