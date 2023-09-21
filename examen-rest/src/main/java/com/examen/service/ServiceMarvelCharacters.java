package com.examen.service;

import java.util.List;

import org.json.JSONObject;

import com.examen.dto.ParametrosBusquedaDTO;
import com.examen.entity.History;

public interface ServiceMarvelCharacters {
	public JSONObject getCharactersMarvel(ParametrosBusquedaDTO parametros);
	public JSONObject getCharactersMarvelById(int id);
	public List<History> getAllHistory();
}
