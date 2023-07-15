package com.devsuperior.dlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.entities.Game;
import com.devsuperior.dlist.repositories.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll(); // vai receber Game porem tem q entregar um DTO
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); // trás o dado reduzido 
		return dto;
	}
}
