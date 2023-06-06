package com.smoke.screen.services;

import java.util.List;

import com.smoke.screen.payloads.SolutionDTO;

public interface SolutionService {

//	For User
	SolutionDTO postSolution(SolutionDTO solutionDto, Integer userId);
	
//	For Admin
	SolutionDTO getSolutionByUser(Integer userId);
	List<SolutionDTO> getAllSolutions();
//	Not needed in current perspective but implemented as in for further requirements
	SolutionDTO updateSolution(SolutionDTO solutionDto, Integer solutionId);
	void deleteSolution(Integer solutionId);
	SolutionDTO getSolutionById(Integer solutionId);
}
