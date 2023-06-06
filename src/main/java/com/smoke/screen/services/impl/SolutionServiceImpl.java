package com.smoke.screen.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoke.screen.entities.Solution;
import com.smoke.screen.entities.User;
import com.smoke.screen.exceptions.ResourceNotFoundException;
import com.smoke.screen.payloads.SolutionDTO;
import com.smoke.screen.repos.SolutionRepo;
import com.smoke.screen.repos.UserRepo;
import com.smoke.screen.services.SolutionService;

@Service
public class SolutionServiceImpl implements SolutionService {

	@Autowired
	private SolutionRepo solutionRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SolutionDTO postSolution(SolutionDTO solutionDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		Solution solution = this.dtoToSolution(solutionDto);
		solution.setUser(user);
		Solution savedSolution = this.solutionRepo.save(solution);
		return this.solutionToDto(savedSolution);
	}

	@Override
	public SolutionDTO getSolutionByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		Solution solution = this.solutionRepo.findByUser(user);
		return this.solutionToDto(solution);
	}

	@Override
	public List<SolutionDTO> getAllSolutions() {
		List<Solution> solutions = this.solutionRepo.findAll();
		List<SolutionDTO> solutionDtos = solutions.stream().map(solution -> this.solutionToDto(solution))
				.collect(Collectors.toList());
		return solutionDtos;
	}

	@Override
	public SolutionDTO updateSolution(SolutionDTO solutionDto, Integer solutionId) {
		Solution solution = this.solutionRepo.findById(solutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Solution", "Solution Id", solutionId));
		solution.setLangQ1(solutionDto.getLangQ1());
		solution.setLangQ2(solutionDto.getLangQ2());
		solution.setLangQ3(solutionDto.getLangQ3());
		solution.setSolutionQ1(solutionDto.getSolutionQ1());
		solution.setSolutionQ2(solutionDto.getSolutionQ2());
		solution.setSolutionQ3(solutionDto.getSolutionQ3());
		solution.setFlashCount(solutionDto.getFlashCount());
		solution.setTimeTaken(solutionDto.getTimeTaken());
		Solution updatedSolution = this.solutionRepo.save(solution);
		return this.solutionToDto(updatedSolution);
	}

	@Override
	public void deleteSolution(Integer solutionId) {
		Solution solution = this.solutionRepo.findById(solutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Solution", "Solution Id", solutionId));
		this.solutionRepo.delete(solution);
	}

	@Override
	public SolutionDTO getSolutionById(Integer solutionId) {
		Solution solution = this.solutionRepo.findById(solutionId)
				.orElseThrow(() -> new ResourceNotFoundException("Solution", "Solution Id", solutionId));
		return solutionToDto(solution);
	}

	public Solution dtoToSolution(SolutionDTO solutionDto) {
		Solution solution = this.modelMapper.map(solutionDto, Solution.class);
		return solution;
	}

	public SolutionDTO solutionToDto(Solution solution) {
		SolutionDTO solutionDto = this.modelMapper.map(solution, SolutionDTO.class);
		return solutionDto;
	}

}
