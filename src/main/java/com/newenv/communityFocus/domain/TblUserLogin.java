package com.newenv.communityFocus.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * TblUserLogin entity. @author MyEclipse Persistence Tools
 */
@Table("tbl_user_login")
public class TblUserLogin implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -7640696707249251142L;
	private Integer id;
	private Integer tbl_User_profile_id;
	private String username;
	private String password;
	private Short status;
	private String registration_date;
	private Integer flag;
	private String ip;
	private Date loginTime;
	private Short updated;
	private Date regTime;
	private Short isAccountNonExpired;
	private Short isCredentialsNonExpired;
	private String openId;
	private Integer openIdActive;
	@Column("JOIN_TIME")
	private String joinTime;
	private String dataentryTime;
	private String tel;
	private String schoolOfGraduation;
	private String address;
	private String sex;
	private String identitycode;
	private String people;
	private String degree;
	private String originalProvince;

	// Constructors

	/** default constructor */
	public TblUserLogin() {
	}


	public Integer getTbl_User_profile_id() {
		return tbl_User_profile_id;
	}


	public void setTbl_User_profile_id(Integer tbl_User_profile_id) {
		this.tbl_User_profile_id = tbl_User_profile_id;
	}


	public String getRegistration_date() {
		return registration_date;
	}


	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}


	/** full constructor */
	public TblUserLogin(  String username,
			String password, Short status, String registrationDate,
			Integer flag, String ip, Date loginTime, Short updated,
			Date regTime, Short isAccountNonExpired,
			Short isCredentialsNonExpired, String openId, Integer openIdActive,
			String joinTime, String dataentryTime, String tel,
			String schoolOfGraduation, String address, String sex,
			String identitycode, String people, String degree,
			String originalProvince) {
		this.username = username;
		this.password = password;
		this.status = status;
		this.registration_date = registrationDate;
		this.flag = flag;
		this.ip = ip;
		this.loginTime = loginTime;
		this.updated = updated;
		this.regTime = regTime;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.openId = openId;
		this.openIdActive = openIdActive;
		this.joinTime = joinTime;
		this.dataentryTime = dataentryTime;
		this.tel = tel;
		this.schoolOfGraduation = schoolOfGraduation;
		this.address = address;
		this.sex = sex;
		this.identitycode = identitycode;
		this.people = people;
		this.degree = degree;
		this.originalProvince = originalProvince;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getRegistrationDate() {
		return this.registration_date;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registration_date = registrationDate;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public Short getUpdated() {
		return this.updated;
	}

	public void setUpdated(Short updated) {
		this.updated = updated;
	}
	public Date getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Short getIsAccountNonExpired() {
		return this.isAccountNonExpired;
	}

	public void setIsAccountNonExpired(Short isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public Short getIsCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	public void setIsCredentialsNonExpired(Short isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getOpenIdActive() {
		return this.openIdActive;
	}

	public void setOpenIdActive(Integer openIdActive) {
		this.openIdActive = openIdActive;
	}

	public String getJoinTime() {
		return this.joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	@Column("DATAENTRY_TIME")
	public String getDataentryTime() {
		return this.dataentryTime;
	}

	public void setDataentryTime(String dataentryTime) {
		this.dataentryTime = dataentryTime;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column("SCHOOL_OF_GRADUATION")
	public String getSchoolOfGraduation() {
		return this.schoolOfGraduation;
	}

	public void setSchoolOfGraduation(String schoolOfGraduation) {
		this.schoolOfGraduation = schoolOfGraduation;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdentitycode() {
		return this.identitycode;
	}

	public void setIdentitycode(String identitycode) {
		this.identitycode = identitycode;
	}

	public String getPeople() {
		return this.people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column("ORIGINAL_PROVINCE")
	public String getOriginalProvince() {
		return this.originalProvince;
	}

	public void setOriginalProvince(String originalProvince) {
		this.originalProvince = originalProvince;
	}
}