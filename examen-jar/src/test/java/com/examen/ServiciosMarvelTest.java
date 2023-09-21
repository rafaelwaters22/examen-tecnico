package com.examen;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.examen.dto.ParametrosBusquedaDTO;
import com.examen.exception.ExamenJarException;
import com.examen.service.ConsumeServiciosMarvel;
import com.examen.service.impl.ConsumeServiciosMarvelImpl;

@ExtendWith(MockitoExtension.class)
public class ServiciosMarvelTest {

	private ConsumeServiciosMarvel consumeServiciosMarvel;
	

	@Test
	public void test() throws ExamenJarException {
		consumeServiciosMarvel= new ConsumeServiciosMarvelImpl();
		ParametrosBusquedaDTO parametros= new ParametrosBusquedaDTO();
		parametros.setName("Wolverine");
		JSONObject json= consumeServiciosMarvel.getCharacters(parametros);
		System.out.println(json);
		assertNotNull(json);
	}
	
	@Test
	public void test2() throws ExamenJarException {
		consumeServiciosMarvel= new ConsumeServiciosMarvelImpl();
		JSONObject json= consumeServiciosMarvel.getCharacterById(1009150);
		System.out.println(json);
		assertNotNull(json);
	}

}
