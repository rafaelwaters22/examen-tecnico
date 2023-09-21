package com.examen.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.examen.dto.ParametrosBusquedaDTO;
import com.examen.exception.ExamenJarException;
import com.examen.service.ConsumeServiciosMarvel;
import com.examen.util.Constants;

import reactor.core.publisher.Mono;

@Service
public class ConsumeServiciosMarvelImpl implements ConsumeServiciosMarvel {
	private WebClient client = WebClient.create();
	private String url;
	private String hash;
	private int ts;
	private String apikey;
	
public ConsumeServiciosMarvelImpl() throws ExamenJarException {
	try {
		String resourceName = "resources.properties"; 
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties p = new Properties();
		InputStream resourceStream = loader.getResourceAsStream(resourceName);
		    p.load(resourceStream);
		    url=p.getProperty(Constants.URL);
		    hash=p.getProperty(Constants.HASH);	 
		    ts=Integer.valueOf(p.getProperty(Constants.TS));
		    apikey=p.getProperty(Constants.APIKEY);	
	} catch (Exception e) {
		throw new ExamenJarException("No fue posible leer url, hash, apikey, ts del archivo properties");
	} 
}

	@Override
	public JSONObject getCharacters(ParametrosBusquedaDTO parametros)  {
		

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		if (StringUtils.isNotBlank(parametros.getName())) {
			params.set(Constants.NAME, parametros.getName());
		}
		if (StringUtils.isNotBlank(parametros.getNameStartsWith())) {
			params.set(Constants.NAME_STARTS_WITH, parametros.getNameStartsWith());
		}
		if (parametros.getModifiedSince() != null) {
			SimpleDateFormat fecha = new SimpleDateFormat(Constants.FORMAT_DATE);
			params.set(Constants.MODIFIED_SINCE, fecha.format(parametros.getModifiedSince()));
		}
		if (parametros.getComics() != null) {
			params.set(Constants.COMICS, parametros.getComics().toString());
		}
		if (parametros.getSeries() != null) {
			params.set(Constants.SERIES, parametros.getSeries().toString());
		}
		if (parametros.getEvents() != null) {
			params.set(Constants.EVENTS, parametros.getEvents().toString());
		}
		if (parametros.getStories() != null) {
			params.set(Constants.STORIES, parametros.getStories().toString());
		}
		if (StringUtils.isNotBlank(parametros.getOrderBy())) {
			params.set(Constants.ORDER_BY, parametros.getOrderBy());
		}
		if (parametros.getLimit() != null) {
			params.set(Constants.LIMIT, parametros.getLimit().toString());
		}

		if (parametros.getOffset() != null) {
			params.set(Constants.OFFSET, parametros.getOffset().toString());
		}

		
	      
		 

		Mono<String> result = client.get().uri(url,
				uriParams -> uriParams.queryParam(Constants.APIKEY, apikey).queryParam(Constants.TS, ts)
						.queryParam(Constants.HASH, hash).queryParams(params).build())
				.retrieve().bodyToMono(String.class);
		
		return new JSONObject(result.block());
	}

	@Override
	public JSONObject getCharacterById(int id) {
		Mono<String> result = client.get()
				.uri(url +"/"+ id,
						uriParams -> uriParams.queryParam(Constants.APIKEY, apikey)
								.queryParam(Constants.TS, ts).queryParam(Constants.HASH, hash).build())
				.retrieve().bodyToMono(String.class);
		return new JSONObject(result.block());
	}

}
