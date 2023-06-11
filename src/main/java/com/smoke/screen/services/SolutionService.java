package com.smoke.screen.services;

import java.util.List;

import com.smoke.screen.payloads.SolutionDTO;

public interface SolutionService {

//	For User
	SolutionDTO createSolution(SolutionDTO solutionDto, Integer userId);
	
//	For Admin
	SolutionDTO getSolutionByUser(Integer userId);
	List<SolutionDTO> getAllSolutions();
	void deleteSolution(Integer solutionId);
	
//	Not needed in current perspective but implemented as in for further requirements
	SolutionDTO updateSolution(SolutionDTO solutionDto, Integer solutionId);
	SolutionDTO getSolutionById(Integer solutionId);
}
