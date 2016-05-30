package com.newenv.communityFocus.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import com.newenv.communityFocus.security.SecurityUserHolder;

@Table("lpjg_operation_log")
public class OperationLog {
	
	@Id
	private long id;//
	private long fhid ;//房号id
	private int operatorid;//
	private int bmid;//
	private String ipaddress;
	private Date operateDate;//
	private String message ;
	private int mdid ;
	private int type ;
	
	
	public OperationLog(){
		this.operatorid = SecurityUserHolder.getUserId();
		this.bmid = SecurityUserHolder.getDeptId();
		this.operateDate = new Date();
	}
	
	public OperationLog(Integer userId,Integer deptId){
		this.operatorid = userId;
		this.bmid = deptId;
		this.operateDate = new Date();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getFhid() {
		return fhid;
	}
	public void setFhid(long fhid) {
		this.fhid = fhid;
	}
	public int getOperatorid() {
		return operatorid;
	}
	public void setOperatorid(int operatorid) {
		this.operatorid = operatorid;
	}
	public int getBmid() {
		return bmid;
	}
	public void setBmid(int bmid) {
		this.bmid = bmid;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public java.util.Date getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(java.util.Date operateDate) {
		this.operateDate = operateDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMdid() {
		return mdid;
	}
	public void setMdid(int mdid) {
		this.mdid = mdid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	

	
}
