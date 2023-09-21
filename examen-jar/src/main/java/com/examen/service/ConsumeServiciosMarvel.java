package com.examen.service;

import java.util.Date;

import org.json.JSONObject;

import com.examen.dto.ParametrosBusquedaDTO;
import com.examen.exception.ExamenJarException;

public interface ConsumeServiciosMarvel {
	/**
	 * Método que búsca los personajes de marvel 
	 * @param parametros parametros de busqueda
	 * @return un objeto de tipo JSONObject con los resultados
	 */
	public JSONObject getCharacters(ParametrosBusquedaDTO parametros);
	/**
	 * Método que busca un personaje de marvel mediante su identicador
	 * @param id identificador del personaje
	 * @return retorna un objeto de tipo JSONObject con la información
	 */
	public JSONObject getCharacterById(int id);
}
