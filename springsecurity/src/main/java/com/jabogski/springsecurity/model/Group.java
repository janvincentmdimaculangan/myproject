package com.jabogski.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newtable")
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String ticketnumber;
	private String storenumaber;
	private String storename;
	private String datereported;
	private String equipment;
	private String issue;
	private String datefixed;
	private String recomendation;
	private String status;
	
	
	public Group() {
	}
	public Group(long id, String ticketnumber, String storenumaber, String storename, String datereported,
			String equipment, String issue, String datefixed, String recomendation, String status) {
		
		this.id = id;
		this.ticketnumber = ticketnumber;
		this.storenumaber = storenumaber;
		this.storename = storename;
		this.datereported = datereported;
		this.equipment = equipment;
		this.issue = issue;
		this.datefixed = datefixed;
		this.recomendation = recomendation;
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTicketnumber() {
		return ticketnumber;
	}
	public void setTicketnumber(String ticketnumber) {
		this.ticketnumber = ticketnumber;
	}
	public String getStorenumaber() {
		return storenumaber;
	}
	public void setStorenumaber(String storenumaber) {
		this.storenumaber = storenumaber;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getDatereported() {
		return datereported;
	}
	public void setDatereported(String datereported) {
		this.datereported = datereported;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getDatefixed() {
		return datefixed;
	}
	public void setDatefixed(String datefixed) {
		this.datefixed = datefixed;
	}
	public String getRecomendation() {
		return recomendation;
	}
	public void setRecomendation(String recomendation) {
		this.recomendation = recomendation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}