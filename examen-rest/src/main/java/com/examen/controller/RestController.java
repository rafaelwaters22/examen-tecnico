package com.examen.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examen.dto.GenericResponseDTO;
import com.examen.dto.ParametrosBusquedaDTO;
import com.examen.entity.History;
import com.examen.service.ServiceMarvelCharacters;
import com.examen.util.Constants;

@Controller
@CrossOrigin
public class RestController {
	private static final Logger log= LoggerFactory.getLogger(RestController.class);
	@Autowired
	private ServiceMarvelCharacters serviceMarvelCharacters;
	
	@GetMapping("/getCharacters")
	public ResponseEntity<GenericResponseDTO> getCharactersMarvel(
			@RequestParam(required=false) String name,
			@RequestParam(required=false) String nameStartsWith,
			@RequestParam(required=false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date modifiedSince,
			@RequestParam(required=false) Integer comics,
			@RequestParam(required=false) Integer series,
			@RequestParam(required=false) Integer events,
			@RequestParam(required=false) Integer stories,
			@RequestParam(required=false) String orderBy,
			@RequestParam(required=false) Integer limit,
			@RequestParam(required=false) Integer offset
			){
		
		log.info("Ejecutando busqueda marvel");
		ParametrosBusquedaDTO parametros=new ParametrosBusquedaDTO(name, nameStartsWith, modifiedSince, 
				comics, series, events, stories, orderBy, limit, offset);
		
		log.info("Parametros de busqueda:"+parametros.toString());
		try {
			GenericResponseDTO response= new GenericResponseDTO();
			response.setStatus(Constants.STATUS_SUCCESS);
			response.setTimeStamp(new Date());
			response.setTransaccionId(UUID.randomUUID().toString());
			JSONObject json= serviceMarvelCharacters.getCharactersMarvel(parametros);
			response.setData(json!=null?json.toMap():null);
			log.info("Response Data:"+response.getData());
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			log.error("No fue posible consultar a Marvel:"+e.getMessage());
			GenericResponseDTO response= new GenericResponseDTO();
			response.setStatus(Constants.STATUS_FAIL);
			response.setTimeStamp(new Date());
			response.setTransaccionId(UUID.randomUUID().toString());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
		
	}
	@GetMapping("/getCharacterById")
	public ResponseEntity<GenericResponseDTO> getCharactersMarvel(@RequestParam(required=true) Integer id){
		try {
			GenericResponseDTO response= new GenericResponseDTO();
			response.setStatus(Constants.STATUS_SUCCESS);
			response.setTimeStamp(new Date());
			response.setTransaccionId(UUID.randomUUID().toString());
			JSONObject json= serviceMarvelCharacters.getCharactersMarvelById(id);
			response.setData(json!=null?json.toMap():null);
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			log.error("No fue posible consultar a Marvel por ID:"+e.getMessage());
			GenericResponseDTO response= new GenericResponseDTO();
			response.setStatus(Constants.STATUS_FAIL);
			response.setTimeStamp(new Date());
			response.setTransaccionId(UUID.randomUUID().toString());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
	}
	@GetMapping("/getHistory")
	public ResponseEntity<GenericResponseDTO> getHistory(){
		try {
			List<History> listHistory=serviceMarvelCharacters.getAllHistory();
			GenericResponseDTO response= new GenericResponseDTO();
			response.setStatus(Constants.STATUS_SUCCESS);
			response.setTimeStamp(new Date());
			response.setTransaccionId(UUID.randomUUID().toString());
			response.setData(listHistory);
			return ResponseEntity.ok(response);
		}catch(Exception e) {
			log.error("No fue posible consultar el historial de consulta"+e.getMessage());
			GenericResponseDTO response= new GenericResponseDTO();
			response.setStatus(Constants.STATUS_FAIL);
			response.setTimeStamp(new Date());
			response.setTransaccionId(UUID.randomUUID().toString());
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
		}
	}
}
