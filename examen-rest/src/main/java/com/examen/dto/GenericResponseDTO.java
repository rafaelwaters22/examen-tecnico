package com.examen.dto;

import java.io.Serializable;
import java.util.Date;

public class GenericResponseDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6112403925132301803L;
	private String transaccionId;
	private Date timeStamp;
	private int status;
	private Object data;
	public String getTransaccionId() {
		return transaccionId;
	}
	public void setTransaccionId(String transaccionId) {
		this.transaccionId = transaccionId;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
