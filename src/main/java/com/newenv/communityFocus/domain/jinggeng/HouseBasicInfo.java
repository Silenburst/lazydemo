package com.newenv.communityFocus.domain.jinggeng;

import java.io.Serializable;
import java.util.Date;


import org.nutz.dao.entity.annotation.Id;

//import java.util.Date;

import org.nutz.dao.entity.annotation.Table;

/**
 * @author hui.peng
 */
@Table("lpjg_info")
public class HouseBasicInfo implements Serializable{
/**
	 * 
	 */
	@Id
	private long id ;
	
	private static final long serialVersionUID = 1L;
	private long lpid  ;
	private long dzid ;
	private long dyid ; //danyuan id
	private long fhid ;//fanghao id
	
	private int mdid ; //门点id
	private int bmid ; //部门id
	
	
	
	private String marketAddress  ; //市场地址
	private int propertyInfo  ;//权属性质
	
	private String territoryInfo ;//国土性质
	
	private int propertyNumber ;//产权编码
	
	private double propertySize ; //产权面积
	
	private double  innerSize ;//室内面积
	
	private int  propertyAge ;//产权年限
	
	private String facility ; //配套设施
	
	
	private String codes ;//备案号
	
	private String purpose ;//备案号
	
	private int  creatorid ;//
	
	private int belongerid ; //归属人
	
	private Date createDate ;
	
	private int direction;
	
	
	private Date modifyDate ;
	 
	
	private int flag;
	
	private Integer stage;


	public long getLpid() {
		return lpid;
	}


	public void setLpid(long lpid) {
		this.lpid = lpid;
	}


	public long getDzid() {
		return dzid;
	}


	public void setDzid(long dzid) {
		this.dzid = dzid;
	}


	public long getDyid() {
		return dyid;
	}


	public void setDyid(long dyid) {
		this.dyid = dyid;
	}


	public long getFhid() {
		return fhid;
	}


	public void setFhid(long fhid) {
		this.fhid = fhid;
	}


	public int getMdid() {
		return mdid;
	}


	public void setMdid(int mdid) {
		this.mdid = mdid;
	}


	public int getBmid() {
		return bmid;
	}


	public void setBmid(int bmid) {
		this.bmid = bmid;
	}


	public String getMarketAddress() {
		return marketAddress;
	}


	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}


	public int getPropertyInfo() {
		return propertyInfo;
	}


	public void setPropertyInfo(int propertyInfo) {
		this.propertyInfo = propertyInfo;
	}


	public String getTerritoryInfo() {
		return territoryInfo;
	}


	public void setTerritoryInfo(String territoryInfo) {
		this.territoryInfo = territoryInfo;
	}


	public int getPropertyNumber() {
		return propertyNumber;
	}


	public void setPropertyNumber(int propertyNumber) {
		this.propertyNumber = propertyNumber;
	}


	public double getPropertySize() {
		return propertySize;
	}


	public void setPropertySize(double propertySize) {
		this.propertySize = propertySize;
	}


	public double getInnerSize() {
		return innerSize;
	}


	public void setInnerSize(double innerSize) {
		this.innerSize = innerSize;
	}


	public int getPropertyAge() {
		return propertyAge;
	}


	public void setPropertyAge(int propertyAge) {
		this.propertyAge = propertyAge;
	}


	public String getFacility() {
		return facility;
	}


	public void setFacility(String facility) {
		this.facility = facility;
	}


	public String getCodes() {
		return codes;
	}


	public void setCodes(String codes) {
		this.codes = codes;
	}


	public int getCreatorid() {
		return creatorid;
	}


	public void setCreatorid(int creatorid) {
		this.creatorid = creatorid;
	}


	public int getBelongerid() {
		return belongerid;
	}


	public void setBelongerid(int belongerid) {
		this.belongerid = belongerid;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getModifyDate() {
		return modifyDate;
	}


	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}


	public int getFlag() {
		return flag;
	}


	public void setFlag(int flag) {
		this.flag = flag;
	}


	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public Integer getStage() {
		return stage;
	}


	public void setStage(Integer stage) {
		this.stage = stage;
	}

}
