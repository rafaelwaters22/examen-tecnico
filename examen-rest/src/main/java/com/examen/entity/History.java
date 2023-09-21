package com.examen.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String serviceName;
	private Date dateConsult;
	
	
	public History() {
		super();
	}
	public History(String serviceName, Date dateConsult) {
		super();
		this.serviceName = serviceName;
		this.dateConsult = dateConsult;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Date getDateConsult() {
		return dateConsult;
	}
	public void setDateConsult(Date dateConsult) {
		this.dateConsult = dateConsult;
	}
	@Override
	public String toString() {
		return "History [id=" + id + ", serviceName=" + serviceName + ", dateConsult=" + dateConsult + "]";
	}
	
	
	
	
}
