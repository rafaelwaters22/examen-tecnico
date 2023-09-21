package com.examen.dto;

import java.io.Serializable;
import java.util.Date;

public class ParametrosBusquedaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2810140523390873288L;
	private String name;
	private String nameStartsWith;
	private Date modifiedSince;
	private Integer comics;
	private Integer series;
	private Integer events;
	private Integer stories;
	private String orderBy;
	private Integer limit; 
	private Integer offset;
	
	
	public ParametrosBusquedaDTO() {
		super();
	}
	public ParametrosBusquedaDTO(String name, String nameStartsWith, Date modifiedSince, Integer comics, Integer series,
			Integer events, Integer stories, String orderBy, Integer limit, Integer offset) {
		super();
		this.name = name;
		this.nameStartsWith = nameStartsWith;
		this.modifiedSince = modifiedSince;
		this.comics = comics;
		this.series = series;
		this.events = events;
		this.stories = stories;
		this.orderBy = orderBy;
		this.limit = limit;
		this.offset = offset;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameStartsWith() {
		return nameStartsWith;
	}
	public void setNameStartsWith(String nameStartsWith) {
		this.nameStartsWith = nameStartsWith;
	}
	public Date getModifiedSince() {
		return modifiedSince;
	}
	public void setModifiedSince(Date modifiedSince) {
		this.modifiedSince = modifiedSince;
	}
	public Integer getComics() {
		return comics;
	}
	public void setComics(Integer comics) {
		this.comics = comics;
	}
	public Integer getSeries() {
		return series;
	}
	public void setSeries(Integer series) {
		this.series = series;
	}
	public Integer getEvents() {
		return events;
	}
	public void setEvents(Integer events) {
		this.events = events;
	}
	public Integer getStories() {
		return stories;
	}
	public void setStories(Integer stories) {
		this.stories = stories;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	@Override
	public String toString() {
		return "ParametrosBusquedaDTO [name=" + name + ", nameStartsWith=" + nameStartsWith + ", modifiedSince="
				+ modifiedSince + ", comics=" + comics + ", series=" + series + ", events=" + events + ", stories="
				+ stories + ", orderBy=" + orderBy + ", limit=" + limit + ", offset=" + offset + "]";
	}
	
	
}
