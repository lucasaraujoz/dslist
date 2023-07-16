package com.devsuperior.dlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dlist.dto.GameListDTO;
import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.entities.GameList;
import com.devsuperior.dlist.repositories.GameListRepository;

@Service
public class GameListService {
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly= true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll(); // vai receber Game porem tem q entregar um DTO
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList(); // trás o dado reduzido 
		return dto;
	}
}
