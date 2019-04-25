package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "country_master")
public class CountryMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cm_Id")
	private Integer countryId;

	@Column(name = "cm_country_name")
	private String countryName;

	@Column(name = "cm_created_by")
	private Long createdBy;

	@Column(name = "cm_created_date")
	private Date createdDate;

	@Column(name = "cm_modify_by")
	private Long modifyBy;

	@Column(name = "cm_modify_date")
	private Date modifyDate;

	/*
	 * @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "account_id") private Account account;
	 */

	@PrePersist
	protected void onCreate() {
		createdDate = new Date();
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@PreUpdate
	protected void onUpdate() {
		modifyDate = new Date();
	}
}
