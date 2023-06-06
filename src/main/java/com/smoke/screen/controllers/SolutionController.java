package com.smoke.screen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("/user/{userId}/submission")
	public ResponseEntity<SolutionDTO> postSolution(@RequestBody SolutionDTO solutionDto, @PathVariable Integer userId){
		SolutionDTO postSolution = this.solutionService.postSolution(solutionDto, userId);
		return new ResponseEntity<>(postSolution, HttpStatus.CREATED);
	}
}
