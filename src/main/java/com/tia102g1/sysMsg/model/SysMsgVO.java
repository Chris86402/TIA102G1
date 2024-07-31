package com.tia102g1.sysMsg.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "SYSMSG")
public class SysMsgVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SYSMSGID")
	private Integer sysMsgId;
	
	@Column(name = "TYPE")
	private Integer type;
	
	@NotEmpty(message="系統訊息標題:請勿空白")
	@Pattern(regexp="^[\\u4e00-\\u9fa5\\u0041-\\u005a\\u0061-\\u007a\\u0030-\\u0039\\u0020-\\u002f\\u003a-\\u0040\\u005b-\\u0060\\u007b-\\u007e]{2,20}$", message = "系統訊息標題: 只能是中、英文、數字及標點符號 , 且長度必需在2到20之間")
	@Column(name = "MSGTITLE", unique = true)
	private String msgTitle;
	
	@NotEmpty(message="系統訊息內容:請勿空白")
	@Pattern(regexp="^[\\u4e00-\\u9fa5\\u0041-\\u005a\\u0061-\\u007a\\u0030-\\u0039\\u0020-\\u002f\\u003a-\\u0040\\u005b-\\u0060\\u007b-\\u007e]{2,150}$", message = "系統訊息內容: 只能是中、英文、數字及標點符號 , 且長度必需在2到150之間")
	@Column(name="MSGCONTENT", unique = true)
	private String msgContent;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;
	
	@Column(name = "LASTUPDATEDBY")
	private String lastUpdatedBy;
	
	@Column(name = "LASTUPDATED")
	private Timestamp lastUpdated;

	public SysMsgVO() {
	}

	public Integer getSysMsgId() {
		return sysMsgId;
	}

	public void setSysMsgId(Integer sysMsgId) {
		this.sysMsgId = sysMsgId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
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
