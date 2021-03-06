package com.newenv.communityFocus.domain;

import java.sql.Timestamp;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * XhjLpxx entity. @author MyEclipse Persistence Tools
 */
@Table("xhj_lpxx")
public class XhjLpxx implements java.io.Serializable {

	private static final long serialVersionUID = 4256065369367969811L;
	// Fields
	private Integer id;
	private Integer cityId;
	private Integer stressId;
//	@Column("sq_id")
	private Integer sqId;
//	@Column("lp_name")
	private String lpName;
	private String bieMing;
	private Double x;
	private Double y;
	private String z;
//	@Column("lp_py")
	private String lpPy;
	private Integer yongTu;
	private String yongTouName;
	private String address;
	private Integer housNumber;
//	@Column("kaiFa")
	private String kaiFa;
	private String kaiFaPhone;
	private String wysx;
	private Integer hjs;
//	@Column(jdbcType="longvarchar","More")
	private String more;
	private Integer djs;
//	@Column("lp_tag")	//城市ID
	private String lpTag;
	private String img;
	private Double rjl;
	private Double lhl;
//	@Column("sum_jz")
	private Double sumJz;
//	@Column("sum_zd")
	private Double sumZd;
//	@Column(jdbcType="longvarchar","BeiZ")
	private String beiZ;
//	@Column(jdbcType="longvarchar","p_num")
	private String PNum;
	private String bianH;
	private String xzgx;
	@Column("JieDao")
	private String jieDao;
//	@Column("RenChe")
	private Integer renChe;
//	@Column("af_system")
	private String afSystem;
//	@Column("JZSJ")
	private String jzsj;

//	@Column("SGDW")
	private String sgdw;
//	@Column("XSDL")
	private String xsdl;
//	@Column("lp_jiangx")
	private String lpJiangX;

//	@Column("UserID")
	private Integer userId;
//	@Column("DepartmentID")
	private Integer departmentId;
//	@Column("r_time")
	private Date RTime;
//	@Column("X_Time", length = 19)
	private Timestamp XTime;
//	@Column("Statuss")
	private Integer statuss;
//	@Column("IsEnd")
	private Integer isEnd;
//	@Column("PropertySupporting")
	private String propertySupporting;
//	@Column("QQ")
	private Long qq;
//	@Column("RoomRate")
	private String roomRate;
//	@Column("Level")
	private String level;
//	@Column("IsDispersion")
	private Short isDispersion;
	@Column("BuildingAge")
	private String buildingAge;
//	@Column("CheckStatus")
	private Integer checkStatus;

//	@Column("CheckDate")
	private Date checkDate;
//		@Column("CheckRemark")
	private String checkRemark;
//	@Column("CheckerID")
	private Integer checkerId;
	@Column("RequestRemark")
	private String requestRemark;
//	@Column(jdbcType="longvarchar","DzRemark")
	private String dzRemark;
//	@Column("oldid")
	private Integer oldid;
//	@Column("PropertyAddress")
	private String propertyAddress;
	
	private Integer countryid;	//国家
	private Integer provinceid;	//省份
//	@Column("l_type")
	private Integer ltype;
//	@Column("avg_price")
	private Double avgPrice;
	public Integer getLtype() {
		return ltype;
	}

	public void setLtype(Integer ltype) {
		this.ltype = ltype;
	}

	// Constructors
	
	@Column("link_location")
	private Integer linkLocAtion;
	
	@Column("rzhs")
	private Integer rzhs;
	
	@Column("months")
	private String months;
	
	@Column("years")
	private String years;
	
	@Column("PropertyAge")
	private Integer	propertyAge;
	
	@Column("PropertyInfo")
	private Integer propertyInfo;
	
	@Column("air_supply")
	private Integer airSupply;
	
	@Column("heating_way")
	private Integer heatingWay;
	
	@Column("water_supply")
	private String waterSupply;
	
	@Column("power_supply")
	private Integer powerSupply;
	
	@Column("configuration")
	private Integer	configuration;
	
	@Column("community_safety")
	private Integer	communitySafety;
	
	@Column("materials")
	private Integer	materials;
	
	@Column("brand")
	private Integer	brand;
	
	@Column("facades_processing")
	private Integer	facadesProcessing;
	
	@Column("BuildingType")
	private Integer	buildingType;
	
	@Column("opening_price")
	private Float openingPrice;
	
	@Column("price")
	private Float price;
	
	@Column("opening_avg_price")
	private Float openingAvgPrice;

	
	@Column("end_complete")
	private String endComplete;
	
	@Column("leixing")
	private String leixing;
	
	@Column("building_structure")
	private Integer buildingStructure;
	@Column("pinyin")
	private String pinyin;
	private Integer gatherers;
	
	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Integer getGatherers() {
		return gatherers;
	}

	public void setGatherers(Integer gatherers) {
		this.gatherers = gatherers;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	/** default constructor */
	public XhjLpxx() {
	}

	/** minimal constructor */
	public XhjLpxx(String lpName) {
		this.lpName = lpName;
	}

	
	public Double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column("CityID")
	public Integer getCityId() {
		return this.cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Column("StressID")
	public Integer getStressId() {
		return this.stressId;
	}

	public void setStressId(Integer stressId) {
		this.stressId = stressId;
	}

	@Column("SQ_ID")
	public Integer getSqId() {
		return this.sqId;
	}

	public void setSqId(Integer sqId) {
		this.sqId = sqId;
	}

	@Column("LP_Name")
	public String getLpName() {
		return this.lpName;
	}

	public void setLpName(String lpName) {
		this.lpName=lpName;
	}

	@Column("BieMing")
	public String getBieMing() {
		return this.bieMing;
	}

	public void setBieMing(String bieMing) {
		this.bieMing = bieMing;
	}

	@Column("X")
	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	@Column("Y")
	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	@Column("Z")
	public String getZ() {
		return this.z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	@Column("LP_PY")
	public String getLpPy() {
		return this.lpPy;
	}

	public void setLpPy(String lpPy) {
		this.lpPy = lpPy;
	}

	@Column("YongTu")
	public Integer getYongTu() {
		return this.yongTu;
	}

	public void setYongTu(Integer yongTu) {
		this.yongTu = yongTu;
	}

	@Column("Address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column("HousNumber")
	public Integer getHousNumber() {
		return this.housNumber;
	}

	public void setHousNumber(Integer housNumber) {
		this.housNumber = housNumber;
	}

	public String getKaiFa() {
		return this.kaiFa;
	}

	public void setKaiFa(String kaiFa) {
		this.kaiFa = kaiFa;
	}

	@Column("KaiFaPhone")
	public String getKaiFaPhone() {
		return this.kaiFaPhone;
	}

	public void setKaiFaPhone(String kaiFaPhone) {
		this.kaiFaPhone = kaiFaPhone;
	}

	@Column("Wysx")
	public String getWysx() {
		return this.wysx;
	}

	public void setWysx(String wysx) {
		this.wysx = wysx;
	}

	@Column("HJS")
	public Integer getHjs() {
		return this.hjs;
	}

	public void setHjs(Integer hjs) {
		this.hjs = hjs;
	}

	public String getMore() {
		return this.more;
	}

	public void setMore(String more) {
		this.more = more;
	}

	@Column("DJS")
	public Integer getDjs() {
		return this.djs;
	}

	public void setDjs(Integer djs) {
		this.djs = djs;
	}

	@Column("LP_Tag")
	public String getLpTag() {
		return this.lpTag;
	}

	public void setLpTag(String lpTag) {
		this.lpTag = lpTag;
	}

	@Column("Img")
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column("RJL")
	public Double getRjl() {
		return this.rjl;
	}

	public void setRjl(Double rjl) {
		this.rjl = rjl;
	}

	@Column("LHL")
	public Double getLhl() {
		return this.lhl;
	}

	public void setLhl(Double lhl) {
		this.lhl = lhl;
	}

	@Column("Sum_JZ")
	public Double getSumJz() {
		return this.sumJz;
	}

	public void setSumJz(Double sumJz) {
		this.sumJz = sumJz;
	}

	@Column("Sum_ZD")
	public Double getSumZd() {
		return this.sumZd;
	}

	public void setSumZd(Double sumZd) {
		this.sumZd = sumZd;
	}
	public String getBeiZ() {
		return this.beiZ;
	}

	public void setBeiZ(String beiZ) {
		this.beiZ = beiZ;
	}

	public String getPNum() {
		return this.PNum;
	}

	public void setPNum(String PNum) {
		this.PNum = PNum;
	}

	@Column("BianH")
	public String getBianH() {
		return this.bianH;
	}

	public void setBianH(String bianH) {
		this.bianH = bianH;
	}

	@Column("XZGX")
	public String getXzgx() {
		return this.xzgx;
	}

	public void setXzgx(String xzgx) {
		this.xzgx = xzgx;
	}


	public String getJieDao() {
		return this.jieDao;
	}

	public void setJieDao(String jieDao) {
		this.jieDao = jieDao;
	}


	public Integer getRenChe() {
		return this.renChe;
	}

	public void setRenChe(Integer renChe) {
		this.renChe = renChe;
	}


	public String getAfSystem() {
		return this.afSystem;
	}

	public void setAfSystem(String afSystem) {
		this.afSystem = afSystem;
	}


	public String getJzsj() {
		return this.jzsj;
	}

	public void setJzsj(String jzsj) {
		this.jzsj = jzsj;
	}

	public String getSgdw() {
		return this.sgdw;
	}

	public void setSgdw(String sgdw) {
		this.sgdw = sgdw;
	}


	public String getXsdl() {
		return this.xsdl;
	}

	public void setXsdl(String xsdl) {
		this.xsdl = xsdl;
	}

	
	public String getLpJiangX() {
		return this.lpJiangX;
	}

	public void setLpJiangX(String lpJiangX) {
		this.lpJiangX = lpJiangX;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}


	public Date getRTime() {
		return this.RTime;
	}

	public void setRTime(Date RTime) {
		this.RTime = RTime;
	}

	public Timestamp getXTime() {
		return this.XTime;
	}

	public void setXTime(Timestamp XTime) {
		this.XTime = XTime;
	}

	public Integer getStatuss() {
		return this.statuss;
	}

	public void setStatuss(Integer statuss) {
		this.statuss = statuss;
	}


	public Integer getIsEnd() {
		return this.isEnd;
	}

	public void setIsEnd(Integer isEnd) {
		this.isEnd = isEnd;
	}


	public String getPropertySupporting() {
		return this.propertySupporting;
	}

	public void setPropertySupporting(String propertySupporting) {
		this.propertySupporting = propertySupporting;
	}


	public Long getQq() {
		return this.qq;
	}

	public void setQq(Long qq) {
		this.qq = qq;
	}


	public String getRoomRate() {
		return this.roomRate;
	}

	public void setRoomRate(String roomRate) {
		this.roomRate = roomRate;
	}


	public Short getIsDispersion() {
		return this.isDispersion;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void setIsDispersion(Short isDispersion) {
		this.isDispersion = isDispersion;
	}


	public String getBuildingAge() {
		return this.buildingAge;
	}

	public void setBuildingAge(String buildingAge) {
		this.buildingAge = buildingAge;
	}


	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}


	public String getCheckRemark() {
		return this.checkRemark;
	}

	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}


	public Integer getCheckerId() {
		return this.checkerId;
	}

	public void setCheckerId(Integer checkerId) {
		this.checkerId = checkerId;
	}


	public String getRequestRemark() {
		return this.requestRemark;
	}

	public void setRequestRemark(String requestRemark) {
		this.requestRemark = requestRemark;
	}

	public String getDzRemark() {
		return this.dzRemark;
	}

	public void setDzRemark(String dzRemark) {
		this.dzRemark = dzRemark;
	}


	public Integer getOldid() {
		return this.oldid;
	}

	public void setOldid(Integer oldid) {
		this.oldid = oldid;
	}


	public String getPropertyAddress() {
		return this.propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public Integer getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}


	public String getYongTouName() {
		return yongTouName;
	}

	public void setYongTouName(String yongTouName) {
		this.yongTouName = yongTouName;
	}


	public Integer getLinkLocAtion() {
		return linkLocAtion;
	}

	public void setLinkLocAtion(Integer linkLocAtion) {
		this.linkLocAtion = linkLocAtion;
	}

	public Integer getRzhs() {
		return rzhs;
	}

	public void setRzhs(Integer rzhs) {
		this.rzhs = rzhs;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public Integer getPropertyAge() {
		return propertyAge;
	}

	public void setPropertyAge(Integer propertyAge) {
		this.propertyAge = propertyAge;
	}

	public Integer getPropertyInfo() {
		return propertyInfo;
	}

	public void setPropertyInfo(Integer propertyInfo) {
		this.propertyInfo = propertyInfo;
	}

	public Integer getAirSupply() {
		return airSupply;
	}

	public void setAirSupply(Integer airSupply) {
		this.airSupply = airSupply;
	}

	public Integer getHeatingWay() {
		return heatingWay;
	}

	public void setHeatingWay(Integer heatingWay) {
		this.heatingWay = heatingWay;
	}

	public String getWaterSupply() {
		return waterSupply;
	}

	public void setWaterSupply(String waterSupply) {
		this.waterSupply = waterSupply;
	}

	public Integer getPowerSupply() {
		return powerSupply;
	}

	public void setPowerSupply(Integer powerSupply) {
		this.powerSupply = powerSupply;
	}


	public Integer getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Integer configuration) {
		this.configuration = configuration;
	}

	public Integer getCommunitySafety() {
		return communitySafety;
	}

	public void setCommunitySafety(Integer communitySafety) {
		this.communitySafety = communitySafety;
	}

	public Integer getMaterials() {
		return materials;
	}

	public void setMaterials(Integer materials) {
		this.materials = materials;
	}

	public Integer getBrand() {
		return brand;
	}

	public void setBrand(Integer brand) {
		this.brand = brand;
	}

	public Integer getFacadesProcessing() {
		return facadesProcessing;
	}

	public void setFacadesProcessing(Integer facadesProcessing) {
		this.facadesProcessing = facadesProcessing;
	}

	public Integer getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(Integer buildingType) {
		this.buildingType = buildingType;
	}

	public Float getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(Float openingPrice) {
		this.openingPrice = openingPrice;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getOpeningAvgPrice() {
		return openingAvgPrice;
	}

	public void setOpeningAvgPrice(Float openingAvgPrice) {
		this.openingAvgPrice = openingAvgPrice;
	}

	public String getEndComplete() {
		return endComplete;
	}

	public void setEndComplete(String endComplete) {
		this.endComplete = endComplete;
	}

	public Integer getBuildingStructure() {
		return buildingStructure;
	}

	public void setBuildingStructure(Integer buildingStructure) {
		this.buildingStructure = buildingStructure;
	}	
	
}