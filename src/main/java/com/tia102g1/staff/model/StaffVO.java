package com.tia102g1.staff.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "STAFF")
public class StaffVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAFFID", updatable = false)
	private Integer staffId;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@NotEmpty(message="員工姓名:請勿空白")
	@Pattern(regexp="^[\\u4e00-\\u9fa5]+$", message = "員工姓名:請輸入中文")
	@Column(name = "NAME")
	private String name;
	
	@NotEmpty(message="員工電話:請勿空白")
	@Pattern(regexp="^\\d{10}$", message = "員工電話:請輸入10碼手機號碼")
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "EMPLOYDT", updatable = false)
	private Date employDt;
	
	@Column(name = "LEAVEDT")
	private Date leaveDt;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@NotEmpty(message="請輸入員工編號")
	@Column(name = "CREATEDBY", updatable = false)
	private String createdBy;
	
	@Column(name = "DATECREATED", updatable = false)
	private Timestamp dateCreated;
	
	@Column(name = "LASTUPDATEDBY")
	private String lastUpdatedBy;
	
	@Column(name = "LASTUPDATED")
	private Timestamp lastUpdated;

	public StaffVO() {
		super();
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEmployDt() {
		return employDt;
	}

	public void setEmployDt(Date employDt) {
		this.employDt = employDt;
	}

	public Date getLeaveDt() {
		return leaveDt;
	}

	public void setLeaveDt(Date leaveDt) {
		this.leaveDt = leaveDt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
}
