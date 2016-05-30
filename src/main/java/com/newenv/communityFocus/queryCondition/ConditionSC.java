package com.newenv.communityFocus.queryCondition;

import com.newenv.communityFocus.base.PageInfo;

public class ConditionSC {
	private String cityid;
	private String lpid;
	private String dzid;
	private String dyid;
	private String biaoqian;
	private String dianzu;
	private String jingjiren;
	private String zhuangxiu;
	private String userid;
	private String bmid;
	private String mdid;
	private String statuss;
	private String panleixing;
	private Integer type;
	private Integer shi;
	private Integer saleOrRent;
	private String lpName;
	private Integer isNotOk;
	private String creatorId;
	private String loginUserDeptId;
	private PageInfo pageInfo;// 分页信息

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	/**
	 * //getExclusive独家//key钥匙//Surery 房堪 select * from xhj_keyinfo;--钥匙 select
	 * * from xhj_surveyofhouse; select * from xhj_exclusivedelegateinfo where
	 * type=240;--独家
	 */

	public String getStatuss() {
		return statuss;
	}

	public String getPanleixing() {
		return panleixing;
	}

	public void setPanleixing(String panleixing) {
		this.panleixing = panleixing;
	}

	public void setStatuss(String statuss) {
		this.statuss = statuss;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getBmid() {
		return bmid;
	}

	public void setBmid(String bmid) {
		this.bmid = bmid;
	}

	public String getMdid() {
		return mdid;
	}

	public void setMdid(String mdid) {
		this.mdid = mdid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBiaoqian() {
		return biaoqian;
	}

	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}

	public String getZhuangxiu() {
		return zhuangxiu;
	}

	public void setZhuangxiu(String zhuangxiu) {
		this.zhuangxiu = zhuangxiu;
	}

	public String getDianzu() {
		return dianzu;
	}

	public void setDianzu(String dianzu) {
		this.dianzu = dianzu;
	}

	public String getJingjiren() {
		return jingjiren;
	}

	public void setJingjiren(String jingjiren) {
		this.jingjiren = jingjiren;
	}

	public String getLpid() {
		return lpid;
	}

	public void setLpid(String lpid) {
		this.lpid = lpid;
	}

	public String getDzid() {
		return dzid;
	}

	public void setDzid(String dzid) {
		this.dzid = dzid;
	}

	public String getDyid() {
		return dyid;
	}

	public void setDyid(String dyid) {
		this.dyid = dyid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getShi() {
		return shi;
	}

	public void setShi(Integer shi) {
		this.shi = shi;
	}

	public Integer getSaleOrRent() {
		return saleOrRent;
	}

	public void setSaleOrRent(Integer saleOrRent) {
		this.saleOrRent = saleOrRent;
	}

	public String getLpName() {
		return lpName;
	}

	public void setLpName(String lpName) {
		this.lpName = lpName;
	}

	public Integer getIsNotOk() {
		return isNotOk;
	}

	public void setIsNotOk(Integer isNotOk) {
		this.isNotOk = isNotOk;
	}
	
	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getLoginUserDeptId() {
		return loginUserDeptId;
	}

	public void setLoginUserDeptId(String loginUserDeptId) {
		this.loginUserDeptId = loginUserDeptId;
	}
}
