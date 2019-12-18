package com.adrianfullstack.erp.resources.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ClientVo {
	private String nameCli;
	private String lastNameCli;
	private int ageCli;
	private Date dateCli;
	private Date dateEndCli;
	
	
	public String getNameCli() {
		return nameCli;
	}
	public void setNameCli(String nameCli) {
		this.nameCli = nameCli;
	}
	public String getLastNameCli() {
		return lastNameCli;
	}
	public void setLastNameCli(String lastNameCli) {
		this.lastNameCli = lastNameCli;
	}
	public int getAgeCli() {
		return ageCli;
	}
	public void setAgeCli(int ageCli) {
		this.ageCli = ageCli;
	}
	public Date getDateCli() {
		return dateCli;
	}
	public void setDateCli(Date dateCli) {
		this.dateCli = dateCli;
	}
	public Date getDateEndCli() {
		return dateEndCli;
	}
	public void setDateEndCli(Date dateEndCli) {
		this.dateEndCli = dateEndCli;
	}
}
