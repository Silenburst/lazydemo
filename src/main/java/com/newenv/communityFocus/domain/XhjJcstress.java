package com.newenv.communityFocus.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.nutz.dao.entity.annotation.Table;

@Table("xhj_jcstress")
public class XhjJcstress {

	// Fields

	private Integer id;

	private XhjJccity xhjJccity;

	private Integer cityId;

	private String qyName;

	private String number;

	private String x;

	private String y;

	private Date createDate;

	private Integer status;

	@SuppressWarnings("rawtypes")
	private Set xhjLpschools = new HashSet(0);

	@SuppressWarnings("rawtypes")
	private Set xhjJcsqs = new HashSet(0);

	public XhjJcstress(Integer id) {
		this.id = id;
	}

	public XhjJcstress() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public XhjJccity getXhjJccity() {
		return this.xhjJccity;
	}

	public void setXhjJccity(XhjJccity xhjJccity) {
		this.xhjJccity = xhjJccity;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getQyName() {
		return this.qyName;
	}

	public void setQyName(String qyName) {
		this.qyName = qyName;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@SuppressWarnings("rawtypes")
	public Set getXhjLpschools() {
		return this.xhjLpschools;
	}

	@SuppressWarnings("rawtypes")
	public void setXhjLpschools(Set xhjLpschools) {
		this.xhjLpschools = xhjLpschools;
	}

	@SuppressWarnings("rawtypes")
	public Set getXhjJcsqs() {
		return this.xhjJcsqs;
	}

	@SuppressWarnings("rawtypes")
	public void setXhjJcsqs(Set xhjJcsqs) {
		this.xhjJcsqs = xhjJcsqs;
	}

}