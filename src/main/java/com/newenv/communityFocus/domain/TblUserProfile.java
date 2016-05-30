package com.newenv.communityFocus.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Table;

/**
 * TblUserProfile entity. @author MyEclipse Persistence Tools
 */
@Table("tbl_user_profile")
public class TblUserProfile implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -2266661033245858251L;
	private Integer id;
	private String fullname;
	private String sex;
	private String tel;
	private String address;
	private Short status;
	private Short isNetAgent;
	private Integer people;
	private Integer marrital_status;
	private Integer original_province;
	private Integer health_status;
	private Integer political_status;
	private Date join_time;
	private Integer highest_education;
	private Integer degree;
	private String school_of_graduation;
	private String major;
	private String hobbies;
	private Short updated;
	private Date dataentry_time;
	private String identityCode;
	private Date time_of_graduation;
	private Integer account_property;
	private String home_tel;
	private String height;
	private String weight;
	private Integer blood_type;
	private Integer technology_name;
	private Integer technology_level;
	private Integer job_type;
	private Integer job_qualifications;
	private String residence_address;
	private String remarks;
	private Integer source;
	private Integer code_type;
	private Integer checked;
	private Integer formal;
	private Integer stop;
	private Integer operatorid;
	private Integer tbl_department_id;
	private Integer tbl_title_level;
	private Integer tbl_title;
	private Short is_main;
	private Date actual_date;
	private Date check_date;
	private Date birthday;
	private String img_url;
	private String uuid;
	private Integer iszhuanz;
	private Short IS_NET_AGENT;
	private Integer isdiaopei;

	// Constructors

	public TblUserProfile(Integer id, String fullname, String sex, String tel,
			String address, Short status, Short isNetAgent, Integer people,
			Integer marrital_status, Integer original_province,
			Integer health_status, Integer political_status, Date join_time,
			Integer highest_education, Integer degree,
			String school_of_graduation, String major, String hobbies,
			Short updated, Date dataentry_time, String identityCode,
			Date time_of_graduation, Integer account_property, String home_tel,
			String height, String weight, Integer blood_type,
			Integer technology_name, Integer technology_level,
			Integer job_type, Integer job_qualifications,
			String residence_address, String remarks, Integer source,
			Integer code_type, Integer checked, Integer formal, Integer stop,
			Integer operatorid, Integer tbl_department_id,
			Integer tbl_title_level, Integer tbl_title, Short is_main,
			Date actual_date, Date check_date, Date birthday, String img_url,
			String uuid, Integer iszhuanz, Short iS_NET_AGENT, Integer isdiaopei) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.sex = sex;
		this.tel = tel;
		this.address = address;
		this.status = status;
		this.isNetAgent = isNetAgent;
		this.people = people;
		this.marrital_status = marrital_status;
		this.original_province = original_province;
		this.health_status = health_status;
		this.political_status = political_status;
		this.join_time = join_time;
		this.highest_education = highest_education;
		this.degree = degree;
		this.school_of_graduation = school_of_graduation;
		this.major = major;
		this.hobbies = hobbies;
		this.updated = updated;
		this.dataentry_time = dataentry_time;
		this.identityCode = identityCode;
		this.time_of_graduation = time_of_graduation;
		this.account_property = account_property;
		this.home_tel = home_tel;
		this.height = height;
		this.weight = weight;
		this.blood_type = blood_type;
		this.technology_name = technology_name;
		this.technology_level = technology_level;
		this.job_type = job_type;
		this.job_qualifications = job_qualifications;
		this.residence_address = residence_address;
		this.remarks = remarks;
		this.source = source;
		this.code_type = code_type;
		this.checked = checked;
		this.formal = formal;
		this.stop = stop;
		this.operatorid = operatorid;
		this.tbl_department_id = tbl_department_id;
		this.tbl_title_level = tbl_title_level;
		this.tbl_title = tbl_title;
		this.is_main = is_main;
		this.actual_date = actual_date;
		this.check_date = check_date;
		this.birthday = birthday;
		this.img_url = img_url;
		this.uuid = uuid;
		this.iszhuanz = iszhuanz;
		IS_NET_AGENT = iS_NET_AGENT;
		this.isdiaopei = isdiaopei;
	}

	/** default constructor */
	public TblUserProfile() {
	}

	public Integer getMarrital_status() {
		return marrital_status;
	}

	public void setMarrital_status(Integer marrital_status) {
		this.marrital_status = marrital_status;
	}

	public Integer getOriginal_province() {
		return original_province;
	}

	public void setOriginal_province(Integer original_province) {
		this.original_province = original_province;
	}

	public Integer getHealth_status() {
		return health_status;
	}

	public void setHealth_status(Integer health_status) {
		this.health_status = health_status;
	}

	public Integer getPolitical_status() {
		return political_status;
	}

	public void setPolitical_status(Integer political_status) {
		this.political_status = political_status;
	}

	public Date getJoin_time() {
		return join_time;
	}

	public void setJoin_time(Date join_time) {
		this.join_time = join_time;
	}

	public Integer getHighest_education() {
		return highest_education;
	}

	public void setHighest_education(Integer highest_education) {
		this.highest_education = highest_education;
	}

	public String getSchool_of_graduation() {
		return school_of_graduation;
	}

	public void setSchool_of_graduation(String school_of_graduation) {
		this.school_of_graduation = school_of_graduation;
	}

	public Date getDataentry_time() {
		return dataentry_time;
	}

	public void setDataentry_time(Date dataentry_time) {
		this.dataentry_time = dataentry_time;
	}

	public Date getTime_of_graduation() {
		return time_of_graduation;
	}

	public void setTime_of_graduation(Date time_of_graduation) {
		this.time_of_graduation = time_of_graduation;
	}

	public Integer getAccount_property() {
		return account_property;
	}

	public void setAccount_property(Integer account_property) {
		this.account_property = account_property;
	}

	public String getHome_tel() {
		return home_tel;
	}

	public void setHome_tel(String home_tel) {
		this.home_tel = home_tel;
	}

	public Integer getBlood_type() {
		return blood_type;
	}

	public void setBlood_type(Integer blood_type) {
		this.blood_type = blood_type;
	}

	public Integer getTechnology_name() {
		return technology_name;
	}

	public void setTechnology_name(Integer technology_name) {
		this.technology_name = technology_name;
	}

	public Integer getTechnology_level() {
		return technology_level;
	}

	public void setTechnology_level(Integer technology_level) {
		this.technology_level = technology_level;
	}

	public Integer getJob_type() {
		return job_type;
	}

	public void setJob_type(Integer job_type) {
		this.job_type = job_type;
	}

	public Integer getJob_qualifications() {
		return job_qualifications;
	}

	public void setJob_qualifications(Integer job_qualifications) {
		this.job_qualifications = job_qualifications;
	}

	public String getResidence_address() {
		return residence_address;
	}

	public void setResidence_address(String residence_address) {
		this.residence_address = residence_address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getCode_type() {
		return code_type;
	}

	public void setCode_type(Integer code_type) {
		this.code_type = code_type;
	}

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}

	public Integer getFormal() {
		return formal;
	}

	public void setFormal(Integer formal) {
		this.formal = formal;
	}

	public Integer getStop() {
		return stop;
	}

	public void setStop(Integer stop) {
		this.stop = stop;
	}

	public Integer getTbl_department_id() {
		return tbl_department_id;
	}

	public void setTbl_department_id(Integer tbl_department_id) {
		this.tbl_department_id = tbl_department_id;
	}

	public Integer getTbl_title_level() {
		return tbl_title_level;
	}

	public void setTbl_title_level(Integer tbl_title_level) {
		this.tbl_title_level = tbl_title_level;
	}

	public Integer getTbl_title() {
		return tbl_title;
	}

	public void setTbl_title(Integer tbl_title) {
		this.tbl_title = tbl_title;
	}

	public Short getIs_main() {
		return is_main;
	}

	public void setIs_main(Short is_main) {
		this.is_main = is_main;
	}

	public Date getActual_date() {
		return actual_date;
	}

	public void setActual_date(Date actual_date) {
		this.actual_date = actual_date;
	}

	public Date getCheck_date() {
		return check_date;
	}

	public void setCheck_date(Date check_date) {
		this.check_date = check_date;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getIszhuanz() {
		return iszhuanz;
	}

	public void setIszhuanz(Integer iszhuanz) {
		this.iszhuanz = iszhuanz;
	}

	public Short getIS_NET_AGENT() {
		return IS_NET_AGENT;
	}

	public void setIS_NET_AGENT(Short iS_NET_AGENT) {
		IS_NET_AGENT = iS_NET_AGENT;
	}

	public Integer getIsdiaopei() {
		return isdiaopei;
	}

	public void setIsdiaopei(Integer isdiaopei) {
		this.isdiaopei = isdiaopei;
	}

	public String getWeight() {
		return weight;
	}

	public Integer getOperatorid() {
		return operatorid;
	}

	public Date getBirthday() {
		return birthday;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getIsNetAgent() {
		return this.isNetAgent;
	}

	public void setIsNetAgent(Short isNetAgent) {
		this.isNetAgent = isNetAgent;
	}

	public Integer getPeople() {
		return this.people;
	}

	public void setPeople(Integer people) {
		this.people = people;
	}

	public Integer getMarritalStatus() {
		return this.marrital_status;
	}

	public void setMarritalStatus(Integer marritalStatus) {
		this.marrital_status = marritalStatus;
	}

	public Integer getOriginalProvince() {
		return this.original_province;
	}

	public void setOriginalProvince(Integer originalProvince) {
		this.original_province = originalProvince;
	}

	public Integer getHealthStatus() {
		return this.health_status;
	}

	public void setHealthStatus(Integer healthStatus) {
		this.health_status = healthStatus;
	}

	public Integer getPoliticalStatus() {
		return this.political_status;
	}

	public void setPoliticalStatus(Integer politicalStatus) {
		this.political_status = politicalStatus;
	}

	public Date getJoinTime() {
		return this.join_time;
	}

	public void setJoinTime(Date joinTime) {
		this.join_time = joinTime;
	}

	public Integer getHighestEducation() {
		return this.highest_education;
	}

	public void setHighestEducation(Integer highestEducation) {
		this.highest_education = highestEducation;
	}

	public Integer getDegree() {
		return this.degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public String getSchoolOfGraduation() {
		return this.school_of_graduation;
	}

	public void setSchoolOfGraduation(String schoolOfGraduation) {
		this.school_of_graduation = schoolOfGraduation;
	}
	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getHobbies() {
		return this.hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Short getUpdated() {
		return this.updated;
	}

	public void setUpdated(Short updated) {
		this.updated = updated;
	}

	public Date getDataentryTime() {
		return this.dataentry_time;
	}

	public void setDataentryTime(Date dataentryTime) {
		this.dataentry_time = dataentryTime;
	}

	public String getIdentityCode() {
		return this.identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	public Date getTimeOfGraduation() {
		return this.time_of_graduation;
	}

	public void setTimeOfGraduation(Date timeOfGraduation) {
		this.time_of_graduation = timeOfGraduation;
	}

	public Integer getAccountProperty() {
		return this.account_property;
	}

	public void setAccountProperty(Integer accountProperty) {
		this.account_property = accountProperty;
	}

	public String getHomeTel() {
		return this.home_tel;
	}

	public void setHomeTel(String homeTel) {
		this.home_tel = homeTel;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public void setOperatorid(Integer operatorid) {
		this.operatorid = operatorid;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}