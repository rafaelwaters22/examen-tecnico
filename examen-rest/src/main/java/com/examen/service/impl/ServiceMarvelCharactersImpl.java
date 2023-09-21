package com.examen.service.impl;

import java.util.Date;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.dto.ParametrosBusquedaDTO;
import com.examen.repository.HistoryRepository;
import com.examen.service.ConsumeServiciosMarvel;
import com.examen.service.ServiceMarvelCharacters;
import com.examen.util.Constants;
import com.examen.entity.History;

@Service
public class ServiceMarvelCharactersImpl implements ServiceMarvelCharacters {
	private static final Logger log= LoggerFactory.getLogger(ServiceMarvelCharactersImpl.class);
	@Autowired
	private ConsumeServiciosMarvel consumeServiciosMarvel;
	@Autowired
	private HistoryRepository historyRepository;
	@Override
	public JSONObject getCharactersMarvel(ParametrosBusquedaDTO parametros) {
		
		historyRepository.save(new History(Constants.NAME_CHARACTERS_MARVEL,new Date()));
		
			return consumeServiciosMarvel.getCharacters(parametros);
		
	}

	public JSONObject getCharactersMarvelById(int id) {
		historyRepository.save(new History(Constants.NAME_CHARACTERS_MARVEL_BY_ID,new Date()));
		return consumeServiciosMarvel.getCharacterById(id);
	}
	
	public List<History> getAllHistory(){
		return historyRepository.findAll();
	}
}
