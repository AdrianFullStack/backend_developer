package com.adrianfullstack.erp.models;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import lombok.Data;

@Data
@Entity
@Table(name="clients")
public class Client {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idCli;
	private String nameCli;
	private String lastNameCli;
	private int ageCli;
	private Date dateCli;
	
	public Client() {}

	public String getIdCli() {
		return idCli;
	}
	
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
}
