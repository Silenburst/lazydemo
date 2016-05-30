package com.newenv.communityFocus.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newenv.communityFocus.base.BaseService;
import com.newenv.communityFocus.base.PageInfo;
import com.newenv.communityFocus.base.PostParameter;
import com.newenv.communityFocus.base.RequestParameter;
import com.newenv.communityFocus.dao.DaoHelper;
import com.newenv.communityFocus.dao.UserDao;
import com.newenv.communityFocus.security.SecurityUserHolder;
import com.newenv.communityFocus.util.StringUtils;
import com.newenv.communityFocus.vo.ResultFeedback;

@Component
@Path("/houseService")
public class HouseService extends BaseService {

	@Autowired
	private DaoHelper daoHelper;
	@Autowired
	private UserDao userDao;

	private PageInfo pageInfo;

	public PageInfo getPageInfo() {
		return pageInfo;
	}
	
	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	/**
	 * 跳转到房屋详情页
	 *
	 * @param houseNo
	 * @return void
	 */
	@GET
	@Produces({ "text/html" })
	@Path("/queryHouseDetail/{houseNo}")
	public void getHouseDetails(@PathParam("houseNo") String houseNo) {
		if (StringUtils.notEmpty(houseNo)) {
			List houseList = new ArrayList();
			Map house = new HashMap();
			StringBuffer sql = new StringBuffer();
			sql.append(
					" SELECT GROUP_CONCAT(t6.imagepath) as imagepath,t1.number,t1.id,t1.fh_name,t1.isencryption,t1.fanghao,t1.shi,t1.ting,t1.chu,t1.yang,t1.wei,t1.ceng,t1.totalfloor,t8.personid,t3.CreateDate,");
			sql.append(
					" t7.propertyinfo,t7.territoryinfo ,t7.propertynumber,t7.propertysize,t7.innersize,t7.propertyage,t7.codes,t7.facility,t7.marketaddress,t4.x,t4.y,");
			sql.append(" (SELECT qy_name FROM xhj_jcstress WHERE id = t4.StressID) AS qyName,");
			sql.append(" (SELECT sq_name FROM xhj_jcsq WHERE id = t4.sq_id) AS sqName,");
			sql.append(" (SELECT lpd_name FROM xhj_lpdong WHERE id = t7.dzid) AS buildingName,");
			sql.append(
					" (SELECT dy_name FROM xhj_lpdanyuan WHERE id = t7.dyid) AS dyName,(select name from lp_syscs_1 where id = t7.direction) chaoxiang,");
			sql.append(" t9.fullname,");
			sql.append(" (SELECT name FROM xhj_syscs_1 WHERE t7.PropertyInfo = id) AS PropertyInfo,");
			sql.append(" (SELECT name FROM xhj_syscs_1 WHERE t7.TerritoryInfo = id) AS TerritoryInfo,");
			sql.append(" t10.department_name,");

			sql.append(
					" (SELECT NAME FROM xhj_syscs_1 WHERE sid = 11 AND id = t7.purpose) AS useagename, '出售' AS type");
			sql.append(
					" FROM xhj_lpfanghao t1 LEFT JOIN xhj_housesource t2 ON t1.id = t2.HouseNumberID LEFT JOIN xhj_housesourceforsaling t3 ON t2.id = t3.HouseSourceID LEFT JOIN xhj_lpxx t4 ON t1.lpid = t4.id "
							+ " LEFT JOIN XHJ_SurveyOfHouse t5 ON t3.id = t5.saleorrentid left join XHJ_ImageOfSurvey t6 ON t5.id = t6.surveyid LEFT JOIN lpjg_info t7 ON t1.id = t7.fhid AND t7.creatorid = "+SecurityUserHolder.getUserId()
							+ " LEFT JOIN lpjg_relationship t8 ON t1.id = t8.fhid LEFT JOIN tbl_user_profile t9 ON t3.belongerid = t9.id LEFT JOIN tbl_department t10 ON t9.tbl_department_id = t10.id where 1=1 ");

			sql.append(" and t1.id = " + houseNo);
			sql.append("  GROUP BY t6.surveyid " );
			sql.append(" union all ");
			sql.append(
					" SELECT GROUP_CONCAT(t6.imagepath) as imagepath,t1.number,t1.id,t1.fh_name,t1.isencryption,t1.fanghao,t1.shi,t1.ting,t1.chu,t1.yang,t1.wei,t1.ceng,t1.totalfloor,t8.personid,t3.CreateDate,");
			sql.append(
					" t7.propertyinfo,t7.territoryinfo ,t7.propertynumber,t7.propertysize,t7.innersize,t7.propertyage,t7.codes,t7.facility,t7.marketaddress,t4.x,t4.y,");
			sql.append(" (SELECT qy_name FROM xhj_jcstress WHERE id = t4.StressID) AS qyName,");
			sql.append(" (SELECT sq_name FROM xhj_jcsq WHERE id = t4.sq_id) AS sqName,");
			sql.append(" (SELECT lpd_name FROM xhj_lpdong WHERE id = t7.dzid) AS buildingName,");
			sql.append(
					" (SELECT dy_name FROM xhj_lpdanyuan WHERE id = t7.dyid) AS dyName,(select name from lp_syscs_1 where id = t7.direction) chaoxiang,");
			sql.append(" t9.fullname,");
			sql.append(" (SELECT name FROM xhj_syscs_1 WHERE t7.PropertyInfo = id) AS PropertyInfo,");
			sql.append(" (SELECT name FROM xhj_syscs_1 WHERE t7.TerritoryInfo = id) AS TerritoryInfo,");
			sql.append(" t10.department_name,");

			sql.append(
					" (SELECT NAME FROM xhj_syscs_1 WHERE sid = 11 AND id = t7.purpose) AS useagename, '出租' AS type");
			sql.append(
					" FROM xhj_lpfanghao t1 LEFT JOIN xhj_housesource t2 ON t1.id = t2.HouseNumberID LEFT JOIN XHJ_HouseInfoForRenting t3 ON t2.id = t3.HouseSourceID LEFT JOIN xhj_lpxx t4 ON t1.lpid = t4.id"
							+ " LEFT JOIN XHJ_SurveyOfHouse t5 ON t3.id = t5.saleorrentid left join XHJ_ImageOfSurvey t6 on t5.id = t6.surveyid LEFT JOIN lpjg_info t7 ON t1.id = t7.fhid AND t7.creatorid = "+SecurityUserHolder.getUserId()+" LEFT JOIN lpjg_relationship t8 ON t1.id = t8.fhid "
							+ " LEFT JOIN tbl_user_profile t9 ON t3.belongerid = t9.id LEFT JOIN tbl_department t10 ON t9.tbl_department_id = t10.id where 1 = 1 ");

			sql.append(" and t1.id = " + houseNo);
			sql.append("  GROUP BY t6.surveyid " );
			System.out.println(sql.toString());
			houseList = this.daoHelper.getList(sql.toString());
			for (int i = 0; i < houseList.size(); i++) {
				house = (Map) houseList.get(i);
				String fullname = house.get("fullname") == null ? "" : house.get("fullname").toString();
				String imagePath = house.get("imagepath") == null ? "" : house.get("imagepath").toString();
				String[] imageArr = null;
				if (StringUtils.notEmpty(fullname)) {
					if (StringUtils.notEmpty(imagePath)) {
						imageArr = imagePath.split(",");
						house.put("imagepath", imageArr[0]);
					} else {
						house.put("imagepath", "");
					}
					break;
				} else {
					house.put("type", "");
				}
			}

			String createdate = house.get("createdate") == null ? ""
					: house.get("createdate").toString().substring(0, house.get("createdate").toString().length() - 2);
			house.put("createdate", createdate);
			super.setRequestAttribute("result", house);
			super.setRequestAttribute("userTitle", getUserTitle(SecurityUserHolder.getUserId()));
			super.setRequestAttribute("flag", judgeIsNotQueryCoreMessage(Integer.valueOf(house.get("id").toString()),SecurityUserHolder.getUserId()));
			super.forwardTo("/pages/jinggeng/houseDetail.jsp");
		}
	}

	@GET
	@Produces({ "text/html" })
	@Path("/houseChecked")
	public void houseChecked() {
		super.forwardTo("/pages/jinggeng/houseChecked.jsp");
	}

	/**
	 * 查询
	 *
	 * @param postParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/querylpjgInfoForList")
	public Response querylpjgInfoForList(PostParameter postParameter) {
		RequestParameter requestParameter = postParameter.getRequestParameter();
		List ownerList = new ArrayList();
		// 时间选项卡
		Integer timeStatus = requestParameter.getTimeStatus();
		// 经纪人Id
		String agentId = requestParameter.getJjrId();
		// 店组Id
		String outletId = requestParameter.getMdId();
		// 楼盘Id
		String buildingId = requestParameter.getBuildingIdStr();
		// 栋座Id
		String dzId = requestParameter.getLdId();
		// 单元Id
		String unitId = requestParameter.getUnitId();
		Integer type = requestParameter.getType();
		// 开始时间
		String startTime = requestParameter.getStartTime();
		// 结束时间
		String endTime = requestParameter.getEndTime();
		// 状态选项卡
		String status = requestParameter.getStatus();
		// 有效无效
		Integer flag = requestParameter.getFlag();
		// 有效无效
		String level = requestParameter.getLevel();
		Integer checkBmid = (null != requestParameter.getBmid())? requestParameter.getBmid():SecurityUserHolder.getDeptId();
		Integer creatorId = (null != requestParameter.getCreatorId())? requestParameter.getCreatorId():SecurityUserHolder.getUserId();
		StringBuffer sql = new StringBuffer();

		pageInfo = postParameter.getPageInfo();
		if (pageInfo == null) {
			pageInfo = new PageInfo();
			pageInfo.setPage(1);
		}

		// 设置行数.
		if (null != pageInfo.getRows()) {
			pageInfo.setRows(pageInfo.getRows());
		} else {
			pageInfo.setRows(10);
		}
		sql.append(" select *from (");
		sql.append(
				"SELECT t1.id,t1.creatorid AS creatorid,t5.id AS buildingid,t4.id AS dzid,t3.id AS dyid,t1.bmid,t1.stage,t2.fanghao,t3.dy_name,t4.lpd_name,t5.lp_name,(SELECT name FROM lp_syscs_1 WHERE id = t5.level) as level,(SELECT department_name FROM tbl_department WHERE t1.bmid = id) AS department_name,"
						+ "(SELECT fullname FROM tbl_user_profile WHERE id = t1.creatorid) AS belongerName,(SELECT tel FROM tbl_user_profile WHERE id = t1.creatorid) AS tel,'1' AS TYPE,t1.messages,t1.modifydate,t1.flag FROM lpjg_precise_update_record t1 "
						+ "LEFT JOIN xhj_lpfanghao t2 ON t1.fhid = t2.id LEFT JOIN xhj_lpdanyuan t3 ON t2.dyid = t3.id LEFT JOIN xhj_lpdong t4 ON t3.dzid = t4.id"
						+ " LEFT JOIN xhj_lpxx t5 ON t4.lpid = t5.id where 1=1 ");
		if (getUserTitle(creatorId) == 1) {
			sql.append(" and t1.mdid = " + checkBmid);
		} else if (getUserTitle(creatorId) == 2) {
			sql.append(" and t1.bmid = " + checkBmid);
		}
		sql.append(" union all ");
		sql.append(
				"SELECT t1.id,t1.creatorid AS creatorid,t5.id AS buildingid,t4.id AS dzid,t3.id AS dyid,t1.bmid,'接触期' AS stage,t2.fanghao,t3.dy_name,t4.lpd_name,t5.lp_name,(SELECT name FROM lp_syscs_1 WHERE id = t5.level) as level,(SELECT department_name FROM tbl_department WHERE t1.bmid = id) AS department_name,"
						+ "(SELECT fullname FROM tbl_user_profile WHERE id = t1.creatorid) AS belongerName,(SELECT tel FROM tbl_user_profile WHERE id = t1.creatorid) AS tel,'2' AS TYPE,CASE t1.contenttype WHEN '1' THEN '对方意向不明确' WHEN '2' THEN '对方咱没意向' WHEN '3' THEN '约定下次见面' END AS messages,t1.modifydate,t1.flag FROM lpjg_tel_update_record t1 "
						+ "LEFT JOIN xhj_lpfanghao t2 ON t1.fhid = t2.id LEFT JOIN xhj_lpdanyuan t3 ON t2.dyid = t3.id LEFT JOIN xhj_lpdong t4 ON t3.dzid = t4.id"
						+ " LEFT JOIN xhj_lpxx t5 ON t4.lpid = t5.id where 1=1 ");
		if (getUserTitle(creatorId) == 1) {
			sql.append(" and t1.mdid = " + checkBmid);
		} else if (getUserTitle(creatorId) == 2) {
			sql.append(" and t1.bmid = " + checkBmid);
		}
		sql.append(") t where 1=1 ");
		if (null != timeStatus) {
			if (timeStatus == 1) {
				sql.append(" and TO_DAYS(NOW()) - TO_DAYS(t.modifydate) = 0 ");
			} else if (timeStatus == 2) {
				sql.append(" and TO_DAYS(NOW()) - TO_DAYS(t.modifydate) = 1 ");
			} else if (timeStatus == 3) {
				sql.append(" and DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(t.modifydate) ");
			} else if (timeStatus == 4) {
				sql.append(" and DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(t.modifydate) ");
			}
		}

		if (StringUtils.notEmpty(buildingId) && !"-1".equals(buildingId)) {
			sql.append(" and t.buildingid = " + buildingId);
		}

		if (StringUtils.notEmpty(dzId) && !"-1".equals(dzId)) {
			sql.append(" and t.dzid = " + dzId);
		}

		if (StringUtils.notEmpty(unitId) && !"hhh".equals(unitId)) {
			sql.append(" and t.dyid = " + unitId);
		}

		if (StringUtils.notEmpty(startTime)) {
			sql.append(" and t.modifydate > '" + startTime + "'");
		}

		if (StringUtils.notEmpty(endTime)) {
			sql.append(" and t.modifydate < '" + endTime + "'");
		}

		if (StringUtils.notEmpty(agentId) && !"-1".equals(agentId)) {
			sql.append(" and t.creatorid = " + agentId);
		}

		if (StringUtils.notEmpty(outletId) && !"-1".equals(outletId)) {
			sql.append(" and t.bmid = " + outletId);
		}

		if (StringUtils.notEmpty(status) && !"hhh".equals(status)) {
			sql.append(" and t.stage = '" + status + "'");
		}
		
		if (StringUtils.notEmpty(level)) {
			sql.append(" and t.level = '" + level + "'");
		}
		
		if (null != flag) {
			sql.append(" and t.flag = '" + flag + "'");
		}
		sql.append(" order by t.modifydate desc ");

		System.out.println(sql.toString());
		pageInfo = super.getPagerjdo(sql.toString(), pageInfo);
		if (pageInfo.getGridModel().size() != 0) {
			List<Map> hashMapList = (List<Map>) pageInfo.getGridModel();
			for (int i = 0; i < hashMapList.size(); i++) {
				Map hashMap = hashMapList.get(i);
				if (null != hashMap.get("modifydate")) {
					hashMap.put("modifydate", hashMap.get("modifydate").toString().substring(0,
							hashMap.get("modifydate").toString().length() - 2));
				} else {
					hashMap.put("modifydate", "未知");
				}
			}
		}
		// 封装返回.
		ResultFeedback resultFeedback = new ResultFeedback();
		resultFeedback.setListJson(pageInfo);
		return Response.ok().entity(resultFeedback).build();
	}

	/**
	 * 查询业主信息
	 *
	 * @param postParameter
	 * @return Response
	 */
	@POST
	@Produces({ "application/json", "text/html; charset=UTF-8" })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryOwnerInfo")
	public Response queryOwerInfo(PostParameter postParameter) {
		RequestParameter requestParameter = postParameter.getRequestParameter();
		List ownerList = new ArrayList();
		Integer ownerId = requestParameter.getCreatorId();
		Integer fhId = requestParameter.getFhId();
		Integer type = (requestParameter.getType() == 0) ? getUserTitle(ownerId):requestParameter.getType();
		Integer bmId = (null == requestParameter.getBmid())?SecurityUserHolder.getDeptId():requestParameter.getBmid();
		StringBuffer sql = new StringBuffer();
		if (type == 0) {
			if (null != ownerId) {
				sql.append(
						"SELECT t6.Telephone AS mobilephone,t1.gender,t1.name AS fullname,(SELECT city_name FROM xhj_jccity WHERE id = t1.cityid) AS cityName,"
								+ "t1.workplace,(SELECT NAME FROM lp_syscs_1 WHERE id = t1.education)AS education,t1.birthday,"
								+ "(SELECT NAME FROM lp_syscs_1 WHERE id = t1.consumptionconcept) AS consumptionconcept,"
								+ "(SELECT NAME FROM lp_syscs_1 WHERE id = t1.nationality) AS nationality,t1.worktype,t2.OwnedHouseNumber,t2.delegatetype,"
								+ "t2.IsQualifiedToBuyHouse,t2.CommunicationStage,t2.TaxPaymentLimit,t2.SocialityInsurancePaymentLimit,"
								+ "t2.HousingFundRemainAmount,t2.HousingFundPaymentRatioOfMonth,t2.HousingFundPaymentAmountOfMonth,t2.HousingFundPaymentLimit,"
								+ "t2.IsFamiliarToCommunity,t2.transport,(SELECT NAME FROM lp_syscs_1 WHERE id = t3.CustomerLevel) AS CustomerLevel,"
								+ "(SELECT city_name FROM xhj_jccity WHERE id = t3.cityid) AS requireCity,"
								+ "(SELECT qy_name FROM xhj_jcstress WHERE id = t3.RegionID) AS qy_name,t3.requirement_point,t3.IsGroupCustomer,"
								+ "t3.deadline,t4.PayingType,t5.PayType "
								+ " FROM lpjg_personinfo t1 LEFT JOIN lpjg_customerinfo t2 ON t1.id = t2.personid LEFT JOIN lpjg_customerrequirement t3 ON t2.id = t3.CustomerID LEFT JOIN xhj_customerrequirementofbuy t4"
								+ " ON t2.id = t4.CustomerID LEFT JOIN xhj_customerrequirementofrent t5 ON t2.id = t5.CustomerID LEFT JOIN lpjg_communicator t6 ON t1.id = t6.personid and t6.relationtype = 1 where 1=1 ");
				sql.append(" and t1.id = " + ownerId);
				sql.append(" GROUP BY t1.id ");
				System.out.println(sql.toString());
				ownerList = this.daoHelper.getList(sql.toString());
				if (ownerList.size() > 0) {
					List<Map> hashMapList = (List<Map>) ownerList;
					Map hashMap = hashMapList.get(0);
					if (null != hashMap.get("birthday")) {
						hashMap.put("birthday", hashMap.get("birthday").toString().substring(0,
								hashMap.get("birthday").toString().length() - 11));
					} else {
						hashMap.put("birthday", "未知");
					}
				}
			}
			return Response.ok().entity(ownerList).build();
		} else {
			String sqlCount = "";
			pageInfo = postParameter.getPageInfo();
			if (pageInfo == null) {
				pageInfo = new PageInfo();
				pageInfo.setPage(1);
			}

			// 设置行数.
			pageInfo.setRows(10);
			/*
			 * sql.append(
			 * "SELECT t1.id,t1.name,t1.mobilephone,t1.wexin,t1.qq,t1.email,t4.modifydate,(SELECT fullname FROM tbl_user_profile WHERE id = t4.creatorid) AS fullname"
			 * +
			 * " FROM lpjg_personinfo t1 LEFT JOIN xhj_customerinfo t2 ON t1.id = t2.personid LEFT JOIN xhj_lpfanghao t3 ON t1.id = t3.yzid"
			 * +
			 * " LEFT JOIN lpjg_precise_update_record t4 ON t3.id = t4.fhid where 1=1 "
			 * ); sql.append(" AND t2.BeLongerID = " +
			 * SecurityUserHolder.getUserId());
			 */
			/*
			 * sql.append(
			 * "SELECT pr.id,pr.fhid , p.name,mobilePhone, p.weXin,p.qq,p.email, (SELECT fullname FROM tbl_user_profile WHERE id = pr.creatorid) AS fullname,"
			 * ); sql.append(
			 * " ( SELECT  fullname FROM tbl_user_profile  u WHERE u.id= pr.creatorid ) jjrname, pr.modifydate "
			 * ); sql.append(
			 * " FROM lpjg_precise_update_record pr ,lpjg_relationship  r, lpjg_personinfo  p "
			 * ); sql.append(" WHERE  pr.fhid = r.fhid AND r.personid = p.id ");
			 */
			sql.append(
					"SELECT p.id,pr.fhid,p.name,p.weXin,p.qq,p.email,(SELECT  fullname FROM tbl_user_profile WHERE id = pr.creatorid)  AS fullname,"
							+ "(SELECT fullname FROM tbl_user_profile u WHERE u.id = pr.creatorid) jjrname, GROUP_CONCAT(c.Telephone) AS mobilephone, pr.modifydate FROM "
							+ "lpjg_precise_update_record pr LEFT JOIN lpjg_relationship r ON pr.fhid = r.fhid AND pr.creatorid = r.userid LEFT JOIN lpjg_personinfo p ON r.personid = p.id "
							+ "LEFT JOIN lpjg_communicator c ON r.personid = c.personid WHERE 1=1 AND p.id IS NOT NULL AND pr.fhid = "+fhId);
			if (type == 1) {
				sql.append(" and pr.mdid = " + bmId);
			} else if (type == 2) {
				sql.append(" and pr.bmid = " + bmId);
			}
			sql.append(" GROUP BY p.id");
			sqlCount = "select count(*) as num from (" + sql.toString() + ") tbl ";
			System.out.println(sql.toString());
			pageInfo = super.getPagerjdo(sql.toString(), pageInfo);
			if (pageInfo.getGridModel().size() != 0) {
				List<Map> hashMapList = (List<Map>) pageInfo.getGridModel();
				for (int i = 0; i < hashMapList.size(); i++) {
					Map hashMap = hashMapList.get(i);
					if (null != hashMap.get("modifydate")) {
						hashMap.put("modifydate", hashMap.get("modifydate").toString().substring(0,
								hashMap.get("modifydate").toString().length() - 2));
					} else {
						hashMap.put("modifydate", "未知");
					}
				}
			}
			// 封装返回.
			ResultFeedback resultFeedback = new ResultFeedback();
			resultFeedback.setListJson(pageInfo);
			return Response.ok().entity(resultFeedback)
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON + ";charset=UTF-8").build();
		}
	}

	/**
	 * 查询跟进记录
	 *
	 * @param postParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryPreciseRecordForList")
	public Response queryPreciseRecordForList(PostParameter postParameter) {
		RequestParameter requestParameter = postParameter.getRequestParameter();

		pageInfo = postParameter.getPageInfo();
		if (pageInfo == null) {
			pageInfo = new PageInfo();
			pageInfo.setPage(1);
		}

		// 设置行数.
		if (null != pageInfo.getRows()) {
			pageInfo.setRows(pageInfo.getRows());
		} else {
			pageInfo.setRows(10);
		}
		Integer fhId = requestParameter.getFhId();
		StringBuffer sql = new StringBuffer();

		if (null != fhId) {
			sql.append(" select * from (");
			sql.append(" SELECT t1.fhid,t2.fullname,t2.tel,t1.messages,t1.flag,t3.department_name,t1.modifydate "
					+ " FROM lpjg_precise_update_record t1 LEFT JOIN tbl_user_profile t2 ON t1.creatorid = t2.id LEFT JOIN tbl_department t3 ON t1.bmid = t3.id where 1=1 ");

			sql.append(" and t1.fhid = '" + fhId + "'");
			sql.append(" union all ");
			sql.append(
					"SELECT t1.fhid,t2.fullname,t2.tel,CASE t1.contenttype WHEN '1' THEN '对方意向不明确' WHEN '2' THEN '对方咱没意向' WHEN '3' THEN '约定下次见面' END AS messages,t1.flag,t3.department_name,t1.modifydate FROM lpjg_tel_update_record t1 "
							+ "LEFT JOIN tbl_user_profile t2 ON t1.creatorid = t2.id LEFT JOIN tbl_department t3 ON t1.bmid = t3.id where 1=1 ");
			sql.append(" and t1.fhid = '" + fhId + "'");
			sql.append(" ) t order by t.modifydate desc ");
			System.out.println(sql.toString());
			pageInfo = super.getPagerjdo(sql.toString(), pageInfo);
			if (pageInfo.getGridModel().size() != 0) {
				List<Map> hashMapList = (List<Map>) pageInfo.getGridModel();
				for (int i = 0; i < hashMapList.size(); i++) {
					Map hashMap = hashMapList.get(i);
					if (null != hashMap.get("modifydate")) {
						hashMap.put("modifydate", hashMap.get("modifydate").toString().substring(0,
								hashMap.get("modifydate").toString().length() - 2));
					} else {
						hashMap.put("modifydate", "未知");
					}
				}
			}
		}
		// 封装返回.
		ResultFeedback resultFeedback = new ResultFeedback();
		resultFeedback.setListJson(pageInfo);
		return Response.ok().entity(resultFeedback).build();
	}

	/**
	 * 查询 操作记录
	 *
	 * @param postParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryOperationRecordForList")
	public Response queryOperationRecordForList(PostParameter postParameter) {
		RequestParameter requestParameter = postParameter.getRequestParameter();

		pageInfo = postParameter.getPageInfo();
		if (pageInfo == null) {
			pageInfo = new PageInfo();
			pageInfo.setPage(1);
		}

		// 设置行数.
		if (null != pageInfo.getRows()) {
			pageInfo.setRows(pageInfo.getRows());
		} else {
			pageInfo.setRows(10);
		}

		Integer fhId = requestParameter.getFhId();
		Integer creatorId = requestParameter.getCreatorId();
		StringBuffer sql = new StringBuffer();

		if (null != fhId) {
			sql.append(
					"SELECT t2.fullname,t3.department_name,t2.tel,t1.message,t1.operatedate,t1.fhid FROM lpjg_operation_log  t1 "
							+ "LEFT JOIN tbl_user_profile t2 ON t1.operatorid = t2.id LEFT JOIN tbl_department t3 ON t2.tbl_department_id = t3.id WHERE t1.type = 10 ");
			sql.append(" AND t1.fhid = '" + fhId + "' AND t1.operatorid = '" + (null != creatorId?creatorId:SecurityUserHolder.getUserId()) + "'");
			sql.append(" order by t1.operatedate desc");
			System.out.println(sql.toString());
			pageInfo = super.getPagerjdo(sql.toString(), pageInfo);
			if (pageInfo.getGridModel().size() != 0) {
				List<Map> hashMapList = (List<Map>) pageInfo.getGridModel();
				for (int i = 0; i < hashMapList.size(); i++) {
					Map hashMap = hashMapList.get(i);
					if (null != hashMap.get("operatedate")) {
						hashMap.put("operatedate", hashMap.get("operatedate").toString().substring(0,
								hashMap.get("operatedate").toString().length() - 2));
					} else {
						hashMap.put("operatedate", "未知");
					}
				}
			}
		}

		// 封装返回.
		ResultFeedback resultFeedback = new ResultFeedback();
		resultFeedback.setListJson(pageInfo);
		return Response.ok().entity(resultFeedback).build();
	}

	/**
	 * 查询房屋成交信息
	 *
	 * @param postParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryContractForList")
	public Response queryContractForList(PostParameter postParameter) {
		RequestParameter requestParameter = postParameter.getRequestParameter();

		Integer saleOrRent = requestParameter.getType();
		pageInfo = postParameter.getPageInfo();
		if (pageInfo == null) {
			pageInfo = new PageInfo();
			pageInfo.setPage(1);
		}

		// 设置行数.
		if (null != pageInfo.getRows()) {
			pageInfo.setRows(pageInfo.getRows());
		} else {
			pageInfo.setRows(10);
		}
		Integer fhId = requestParameter.getFhId();
		StringBuffer sql = new StringBuffer();
		if (saleOrRent == 1) {
			sql.append(" SELECT t2.id AS housesourceid,t4.contractnumber,t4.contractdate,t4.buyername,t4.sellername,"
					+ "(SELECT mobilephone FROM xhj_personinfo WHERE id = t4.buyerid) AS tel,t4.buyerpaycommissionamount,t1.source"
					+ " FROM xhj_lpfanghao t1 INNER JOIN xhj_housesource t2 ON t1.id = t2.housenumberid INNER JOIN xhj_houseinfoforrenting t3 "
					+ " ON t2.id = t3.housesourceid INNER JOIN xhj_contract t4 ON t3.id = t4.housesourceid WHERE 1=1 AND t4.businesstype>1 ");
			if (null != fhId) {
				sql.append(" and t1.id = '" + fhId + "'");
			}
		} else if (saleOrRent == 0) {
			sql.append(" SELECT t2.id AS housesourceid,t4.contractnumber,t4.contractdate,t4.buyername,t4.sellername,"
					+ "(SELECT mobilephone FROM xhj_personinfo WHERE id = t4.buyerid) AS tel,t4.buyerpaycommissionamount,t1.source "
					+ " FROM xhj_lpfanghao t1 INNER JOIN xhj_housesource t2 ON t1.id = t2.housenumberid INNER JOIN xhj_housesourceforsaling t3 "
					+ " ON t2.id = t3.housesourceid INNER JOIN xhj_contract t4 ON t3.id = t4.housesourceid WHERE 1=1 AND t4.businesstype>1 ");

			if (null != fhId) {
				sql.append(" and t1.id = '" + fhId + "'");
			}
		} else if (saleOrRent == 2) {
			sql.append(" SELECT t2.id AS housesourceid,t4.contractnumber,t4.contractdate,t4.buyername,"
					+ "(SELECT mobilephone FROM xhj_personinfo WHERE id = t4.buyerid) AS buyertel,t4.sellername,"
					+ "(SELECT mobilephone FROM xhj_personinfo WHERE id = t4.sellerpersonid) AS sellertel,"

					+ "(SELECT tel FROM tbl_user_profile WHERE id = t4.creatorid) AS creatortel,(SELECT fullname FROM tbl_user_profile WHERE id = t4.creatorid) AS creatorname,"
					+ "(SELECT department_name FROM tbl_user_profile t1 INNER JOIN tbl_department t2 ON t1.tbl_department_id =  t2.id WHERE t1.id = t4.creatorid) AS department_name,"
					+ " t4.buyerpaycommissionamount,t1.source,'出租' AS TYPE "
					+ " FROM xhj_lpfanghao t1 INNER JOIN xhj_housesource t2 ON t1.id = t2.housenumberid INNER JOIN xhj_houseinfoforrenting t3 "
					+ " ON t2.id = t3.housesourceid INNER JOIN xhj_contract t4 ON t3.id = t4.housesourceid WHERE 1=1 AND t4.businesstype>1 ");
			if(null != fhId) {
				sql.append(" and t1.id = '" + fhId + "'");
			}
			sql.append(" union all ");
			sql.append(" SELECT t2.id AS housesourceid,t4.contractnumber,t4.contractdate,t4.buyername,"
					+ "(SELECT mobilephone FROM xhj_personinfo WHERE id = t4.buyerid) AS buyertel,t4.sellername,"
					+ "(SELECT mobilephone FROM xhj_personinfo WHERE id = t4.sellerpersonid) AS sellertel,"
					+ "(SELECT tel FROM tbl_user_profile WHERE id = t4.creatorid) AS creatortel,(SELECT fullname FROM tbl_user_profile WHERE id = t4.creatorid) AS creatorname,"
					+ "(SELECT department_name FROM tbl_user_profile t1 INNER JOIN tbl_department t2 ON t1.tbl_department_id =  t2.id WHERE t1.id = t4.creatorid) AS department_name,"
					+ "t4.buyerpaycommissionamount,t1.source,'出售' AS TYPE "
					+ " FROM xhj_lpfanghao t1 INNER JOIN xhj_housesource t2 ON t1.id = t2.housenumberid INNER JOIN xhj_housesourceforsaling t3 "
					+ " ON t2.id = t3.housesourceid INNER JOIN xhj_contract t4 ON t3.id = t4.housesourceid WHERE 1=1 AND t4.businesstype>1 ");
			if(null != fhId) {
				sql.append(" and t1.id = '" + fhId + "'");
			}
			sql.append(" ORDER BY ContractDate DESC");
		}

		System.out.println(sql.toString());

		pageInfo = super.getPagerjdo(sql.toString(), pageInfo);
		if (pageInfo.getGridModel().size() != 0) {
			List<Map> hashMapList = (List<Map>) pageInfo.getGridModel();
			for (int i = 0; i < hashMapList.size(); i++) {
				Map hashMap = hashMapList.get(i);
				if (null != hashMap.get("contractdate")) {
					hashMap.put("contractdate", hashMap.get("contractdate").toString().substring(0,
							hashMap.get("contractdate").toString().length() - 2));
				} else {
					hashMap.put("contractdate", "未知");
				}
			}
		}
		// 封装返回.
		ResultFeedback resultFeedback = new ResultFeedback();
		resultFeedback.setListJson(pageInfo);
		return Response.ok().entity(resultFeedback).build();
	}

	/**
	 * 查询楼盘列表
	 *
	 * @param keyWord
	 * @param profileId
	 * @return Response
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryLpxxForList")
	public Response queryLpxxForList(@QueryParam("keyWord") String keyWord, @QueryParam("profileId") String profileId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		sql.append(
				"  SELECT DISTINCT(t1.lpid) as id,t2.lp_name FROM lpjg_assignment_loupan t1 LEFT JOIN xhj_lpxx t2 ON t1.lpid = t2.id WHERE 1=1  ");
		if (StringUtils.notEmpty(keyWord)) {
			sql.append(" AND t2.lp_name like '%" + keyWord + "%'");
		}

		if (StringUtils.notEmpty(profileId)) {
			sql.append(" AND t1.zjid = " + profileId);
			System.out.println(sql.toString());
			result = daoHelper.getList(sql.toString());
			hashMap.put("status", "ok");
			hashMap.put("result", result);
		} else {
			hashMap.put("status", "error");
		}

		return Response.ok().entity(hashMap).build();

	}

	/**
	 * 查询楼盘列表
	 *
	 * @param requestParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryLpxxForListPost")
	public Response queryLpxxForListPost(RequestParameter requestParameter) {
		Integer creatorId = (null != requestParameter.getCreatorId())? requestParameter.getCreatorId():SecurityUserHolder.getUserId();
		Integer checkBmid = (null != requestParameter.getBmid())? requestParameter.getBmid():SecurityUserHolder.getDeptId();
		Integer type = getUserTitle(creatorId);
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		if(type == 1){
			sql.append(
					"  SELECT DISTINCT(t1.lpid) as id,t2.lp_name as name FROM lpjg_assignment_loupan t1 LEFT JOIN xhj_lpxx t2 ON t1.lpid = t2.id WHERE 1=1  ");

			if (null != creatorId) {
				sql.append(" AND t1.mdid = " + checkBmid);
			}
		}else if(type == 2){
			sql.append(
					"  SELECT DISTINCT(t2.id) AS id,t2.lp_name as name FROM lpjg_assignment_room t1 LEFT JOIN xhj_lpxx t2 ON t1.lpid = t2.id where 1=1 ");

			if (null != creatorId) {
				sql.append(" AND t1.bmid = " + checkBmid);
			}
		}
		
		System.out.println(sql.toString());
		result = daoHelper.getList(sql.toString());
		return Response.ok().entity(result).build();

	}

	/**
	 * 查询栋座列表
	 *
	 * @param keyWord
	 * @param lpId
	 * @return Response
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/querydzForList")
	public Response querydzForList(@QueryParam("keyWord") String keyWord, @QueryParam("lpId") String lpId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT id,lpd_name FROM xhj_lpdong where 1=1 ");
		if (StringUtils.notEmpty(keyWord)) {
			sql.append(" AND lpd_name like '%" + keyWord + "%'");
		}
		if (StringUtils.notEmpty(lpId)) {
			sql.append(" AND lpid = " + lpId);
			System.out.println(sql.toString());
			result = daoHelper.getList(sql.toString());
			hashMap.put("status", "ok");
			hashMap.put("result", result);
		} else {
			hashMap.put("status", "error");
		}
		return Response.ok().entity(hashMap).build();

	}

	/**
	 * 查询栋座列表
	 *
	 * @param requestParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/querydzForListPost")
	public Response querydzForListPost(RequestParameter requestParameter) {
		String lpId = requestParameter.getBuildingIdStr();
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		sql.append(
				" SELECT t2.id,t2.lpd_name FROM lpjg_assignment_room t1 LEFT JOIN xhj_lpdong t2 ON t1.dzid = t2.id  WHERE  1=1 ");
		if (StringUtils.notEmpty(lpId)) {
			sql.append(" AND t1.lpid = " + lpId);
		}
		sql.append(" GROUP BY t1.dzid ");
		System.out.println(sql.toString());
		result = daoHelper.getList(sql.toString());
		return Response.ok().entity(result).build();

	}

	/**
	 * 查询单元列表
	 *
	 * @param keyWord
	 * @param dzId
	 * @return Response
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryUnitForList")
	public Response queryUnitForList(@QueryParam("keyWord") String keyWord, @QueryParam("dzId") String dzId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Map> result = new ArrayList<Map>();

		Map map = new HashMap<String, String>();
		map.put("id", "hhh");
		map.put("dy_name", "请选择单元");
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT id,dy_name FROM xhj_lpdanyuan where 1=1 ");
		if (StringUtils.notEmpty(keyWord)) {
			sql.append(" AND dy_name like '%" + keyWord + "%'");
		}
		if (StringUtils.notEmpty(dzId)) {
			sql.append(" AND dzid = " + dzId);
			System.out.println(sql.toString());
			result = daoHelper.getList(sql.toString());
			result.add(0, map);
			hashMap.put("status", "ok");
			hashMap.put("result", result);
		} else {
			hashMap.put("status", "error");
		}
		return Response.ok().entity(hashMap).build();

	}

	/**
	 * 查询单元列表
	 *
	 * @param requestParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryUnitForListPost")
	public Response queryUnitForListPost(RequestParameter requestParameter) {
		String dzId = requestParameter.getLdId();
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		sql.append(
				" SELECT t2.id,t2.dy_name FROM lpjg_assignment_room t1 LEFT JOIN xhj_lpdanyuan t2 ON t1.dyid = t2.id  WHERE 1=1 ");
		if (StringUtils.notEmpty(dzId)) {
			sql.append(" AND t1.dzid = " + dzId);
		}
		sql.append(" GROUP BY t1.dyid ");
		System.out.println(sql.toString());
		result = daoHelper.getList(sql.toString());
		return Response.ok().entity(result).build();

	}

	/**
	 * 查询店组列表
	 *
	 * @param keyWord
	 * @param departmentId
	 * @return Response
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryStoreForList")
	public Response queryStoreForList(@QueryParam("keyWord") String keyWord,
			@QueryParam("departmentId") String departmentId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		sql.append(" select id,department_name from tbl_department  where tbl_organization_id = 88  and flag=1 ");
		if (StringUtils.notEmpty(keyWord)) {
			sql.append(" AND department_name like '%" + keyWord + "%'");
		}
		if (StringUtils.notEmpty(departmentId)) {
			sql.append(" AND parent_id = " + departmentId);
			System.out.println(sql.toString());
			result = daoHelper.getList(sql.toString());
			hashMap.put("status", "ok");
			hashMap.put("result", result);
		} else {
			hashMap.put("status", "error");
		}
		return Response.ok().entity(hashMap).build();

	}

	/**
	 * 查询店组列表
	 *
	 * @param requestParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryStoreForListPost")
	public Response queryStoreForListPost(RequestParameter requestParameter) {
		Integer departmentId = requestParameter.getDepartmentId();
		Integer creatorId = (null != requestParameter.getCreatorId())? requestParameter.getCreatorId():SecurityUserHolder.getUserId();
		Integer type = getUserTitle(creatorId);
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		if(type == 1){
			sql.append(" select id,department_name from tbl_department  where tbl_organization_id = 88  ");
			if (null != departmentId) {
				sql.append(" AND parent_id = " + departmentId);
			}
		}else if(type == 2){
			sql.append(" SELECT t2.id,t2.department_name FROM tbl_user_profile t1 LEFT JOIN tbl_department t2 ON t1.tbl_department_id = t2.id where 1=1 ");
			if (null != creatorId) {
				sql.append(" AND t1.id = " + creatorId);
			}
		}
		
		System.out.println(sql.toString());
		result = daoHelper.getList(sql.toString());
		return Response.ok().entity(result).build();

	}

	/**
	 * 查询经纪人列表
	 *
	 * @param keyWord
	 * @param cityId
	 * @return Response
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryAgentForList")
	public Response queryAgentForList(@QueryParam("keyWord") String keyWord, @QueryParam("storeId") String storeId) {

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		sql.append(
				" select up.id,up.fullname from tbl_user_profile up, tbl_user_login ul ,tbl_position p, tbl_department d "
						+ " where up.id=ul.tbl_user_profile_id and p.tbl_user_id=ul.id and p.tbl_department_id=d.id ");
		if (StringUtils.notEmpty(keyWord)) {
			sql.append(" AND up.fullname like '%" + keyWord + "%'");
		}
		if (StringUtils.notEmpty(storeId)) {
			sql.append(" AND d.id = " + storeId);
			System.out.println(sql.toString());
			result = daoHelper.getList(sql.toString());
			hashMap.put("status", "ok");
			hashMap.put("result", result);
		} else {
			hashMap.put("status", "error");
		}
		return Response.ok().entity(hashMap).build();

	}

	/**
	 * 查询楼盘列表
	 *
	 * @param requestParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryAgentForListPost")
	public Response queryAgentForListPost(RequestParameter requestParameter) {
		Integer departmentId = requestParameter.getDepartmentId();
		List<Map> result = new ArrayList<Map>();

		StringBuffer sql = new StringBuffer();
		sql.append(
				" select up.id,up.fullname from tbl_user_profile up, tbl_user_login ul ,tbl_position p, tbl_department d "
						+ " where up.id=ul.tbl_user_profile_id and p.tbl_user_id=ul.id and p.tbl_department_id=d.id ");
		if (null != departmentId) {
			sql.append(" AND d.id = " + departmentId);
		}
		System.out.println(sql.toString());
		result = daoHelper.getList(sql.toString());
		return Response.ok().entity(result).build();
	}

	/**
	 * 查询登录用户是否为商圈经理 或者店组长
	 *
	 * @return Integer
	 */

	public Integer getUserTitle(Integer userId) {
		String titleName = "";
		Integer result = 0;
		List<Map> resultData = new ArrayList<Map>();
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select id,title_name from tbl_title where id   = (select tbl_title from tbl_user_profile where 1=1");
		sql.append(" and id= ").append(userId + ")");
		System.out.println(sql.toString());
		resultData = daoHelper.getList(sql.toString());
		if (resultData.size() > 0) {
			titleName = resultData.get(0).get("title_name") == null ? ""
					: resultData.get(0).get("title_name").toString();
		}
		if (titleName.indexOf("商圈经理") != -1) {
			result = 1;
		} else if (titleName.indexOf("门店经理") != -1) {
			result = 2;
		}
		return result;
	}

	/**
	 * 设置无效
	 *
	 * @param postParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/invalidHouse")
	public Response invalidHouse(RequestParameter requestParameter) {
		Map map = new HashMap();
		Integer result = 0;
		Integer lpjgId = requestParameter.getLpjgId();
		Integer type = requestParameter.getType();
		StringBuffer sql = new StringBuffer();
		if (null != lpjgId) {
			if (type == 1) {
				sql.append(" update lpjg_precise_update_record set flag = 0 where id = " + lpjgId);
			} else if (type == 2) {
				sql.append(" update lpjg_tel_update_record set flag = 0 where id = " + lpjgId);
			}
		}
		daoHelper.update(sql.toString());
		result = 1;
		map.put("result", result);
		return Response.ok().entity(map).build();
	}

	/**
	 * 跳转到房屋详情页
	 *
	 * @param houseNo
	 * @return Response
	 */
	@GET
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	@Path("/queryHouseDetailApp/{houseNo}/{creatorId}")
	public Response getHouseDetailsApp(@PathParam("houseNo") String houseNo,@PathParam("creatorId") Integer creatorId) {
		List<Map> result = new ArrayList<Map>();
		if (StringUtils.notEmpty(houseNo)) {
			List houseList = new ArrayList();
			Map house = new HashMap();
			StringBuffer sql = new StringBuffer();
			sql.append(
					" SELECT  t1.number,t4.lp_name,t3.price,t1.id,t1.fh_name,t1.isencryption,t1.fanghao,t1.shi,t1.ting,t1.chu,t1.yang,t1.wei,t1.ceng,t1.totalfloor,t8.personid,t3.CreateDate,t1.cqxz,t1.BuildingAgeID,t1.DecorationStandard,");
			sql.append(" ( SELECT GROUP_CONCAT(img.imgpath) FROM `xhj_lpfanghaoimg` AS img WHERE img.statuss=1 AND img.fanghaoid=t1.id ORDER BY img.id ) as imagepath,");
			sql.append(
					" t7.propertyinfo,t7.territoryinfo ,t7.propertynumber,t7.propertysize,t7.innersize,t7.propertyage,t7.codes,t7.facility,t7.marketaddress,t4.x,t4.y,");
			sql.append(" (SELECT qy_name FROM xhj_jcstress WHERE id = t4.StressID limit 1) AS qyName,");
			sql.append(" (SELECT sq_name FROM xhj_jcsq WHERE id = t4.sq_id limit 1) AS sqName,");
			sql.append(" (SELECT lpd_name FROM xhj_lpdong WHERE id = t7.dzid limit 1) AS buildingName,");
//			sql.append(" ( SELECT COUNT(1) FROM (SELECT  t6.id FROM xhj_housesource t2 INNER JOIN XHJ_HouseInfoForRenting t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 and t2.HouseNumberID = t1.id  UNION ALL  SELECT  t6.id  FROM xhj_housesource t2 INNER JOIN xhj_housesourceforsaling t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 and t2.HouseNumberID = t1.id ) s) as surveyNum,");
//			sql.append(" ( SELECT COUNT(1) FROM (  SELECT t5.id FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t2.HouseNumberID = t1.id  UNION ALL  SELECT t5.id FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t2.HouseNumberID = t1.id ) s) as keyNum,");
//			sql.append(" (  SELECT COUNT(1) FROM (  SELECT t5.id FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t2.HouseNumberID = t1.id  UNION ALL  SELECT t5.id FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t2.HouseNumberID = t1.id ) s) AS delegateNum,");
			sql.append("( SELECT  count(t6.id) FROM xhj_housesource t2 INNER JOIN XHJ_HouseInfoForRenting t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 AND t5.HosueType=2 and t2.HouseNumberID = t1.id  ) as rentsurveyid,");
			sql.append("( SELECT  count(t6.id) FROM xhj_housesource t2 INNER JOIN xhj_housesourceforsaling t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 AND t5.HosueType=1 and t2.HouseNumberID = t1.id  ) as salesurveyid,");

			sql.append("(SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t5.HouseType=2 AND t2.HouseNumberID = t1.id  ) as rentkeyid,");
			sql.append("(SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t5.HouseType=1 AND t2.HouseNumberID = t1.id ) as salekeyid,");
			sql.append(
					" ( SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t5.HouseType=2 AND t2.HouseNumberID = t1.id  ) AS rentdelegateNum,");
			sql.append(
					" ( SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t5.HouseType=1 AND t2.HouseNumberID = t1.id ) AS saledelegateNum,");
			sql.append
			(" (SELECT DISTINCT hfs.IsEncryption FROM xhj_housesource h INNER JOIN xhj_housesourceforsaling hfs ON h.id=hfs.housesourceid  WHERE hfs.housesourcestatus>0 AND h.housenumberid=t1.id limit 1) AS saleIsEncryption,(SELECT DISTINCT hfs.IsEncryption FROM xhj_housesource h INNER JOIN xhj_houseinfoforrenting hfs ON h.id=hfs.housesourceid  WHERE hfs.housesourcestatus>0 AND h.housenumberid=t1.id limit 1) AS rentIsEncryption,");
			//sql.append(" (SELECT count(1) FROM xhj_housesource h,xhj_exclusivedelegateinfo e where h.id=e.HouseSourceID and state=1 AND h.HouseNumberID=t1.id) as delegateNum,");
//			sql.append(" (SELECT count(1) FROM xhj_housesource h,xhj_surveyofhouse e where h.id=e.HouseSourceID and state=1 AND h.HouseNumberID=t1.id) as surveyNum,");
//			sql.append(" (SELECT count(1) FROM xhj_housesource h,xhj_keyinfo e where h.id=e.HouseSourceID and e.statuss = 1 AND h.HouseNumberID=t1.id) as keyNum,");
			sql.append(
					" (SELECT dy_name FROM xhj_lpdanyuan WHERE id = t7.dyid limit 1) AS dyName,(select name from lp_syscs_1 where id = t7.direction limit 1) chaoxiang,");
			sql.append(" t9.fullname,");
			sql.append(" (SELECT name FROM xhj_syscs_1 WHERE t7.PropertyInfo = id limit 1) AS PropertyInfo,");
			sql.append(" (SELECT name FROM xhj_syscs_1 WHERE t7.TerritoryInfo = id limit 1) AS TerritoryInfo,");
			sql.append(" t10.department_name,");

			sql.append(
					" (SELECT NAME FROM xhj_syscs_1 WHERE sid = 11 AND id = t7.purpose limit 1) AS useagename, '出售' AS type");
			sql.append(
					" FROM xhj_lpfanghao t1 LEFT JOIN xhj_housesource t2 ON t1.id = t2.HouseNumberID LEFT JOIN xhj_housesourceforsaling t3 ON t2.id = t3.HouseSourceID  LEFT JOIN xhj_lpxx t4 ON t1.lpid = t4.id "
							+ " LEFT JOIN XHJ_SurveyOfHouse t5 ON t3.id = t5.saleorrentid left join XHJ_ImageOfSurvey t6 ON t5.id = t6.surveyid LEFT JOIN lpjg_info t7 ON t1.id = t7.fhid  AND t7.creatorid = "+creatorId
							+ " LEFT JOIN lpjg_relationship t8 ON t1.id = t8.fhid LEFT JOIN tbl_user_profile t9 ON t3.belongerid = t9.id LEFT JOIN tbl_department t10 ON t9.tbl_department_id = t10.id where 1=1 ");

			sql.append(" and t1.id = " + houseNo);
			sql.append(" GROUP BY t6.surveyid " );
			sql.append(" union all ");
			sql.append(
					" SELECT  t1.number,t4.lp_name,t3.price,t1.id,t1.fh_name,t1.isencryption,t1.fanghao,t1.shi,t1.ting,t1.chu,t1.yang,t1.wei,t1.ceng,t1.totalfloor,t8.personid,t3.CreateDate,t1.cqxz,t1.BuildingAgeID,t1.DecorationStandard,");
			sql.append(" ( SELECT GROUP_CONCAT(img.imgpath) FROM `xhj_lpfanghaoimg` AS img WHERE img.statuss=1 AND img.fanghaoid=t1.id ORDER BY img.id ) as imagepath,");
			sql.append(
					" t7.propertyinfo,t7.territoryinfo ,t7.propertynumber,t7.propertysize,t7.innersize,t7.propertyage,t7.codes,t7.facility,t7.marketaddress,t4.x,t4.y,");
			sql.append(" (SELECT qy_name FROM xhj_jcstress WHERE id = t4.StressID limit 1) AS qyName,");
			sql.append(" (SELECT sq_name FROM xhj_jcsq WHERE id = t4.sq_id limit 1) AS sqName,");
			sql.append(" (SELECT lpd_name FROM xhj_lpdong WHERE id = t7.dzid limit 1) AS buildingName,");
//			sql.append(" ( SELECT COUNT(1) FROM (SELECT  t6.id FROM xhj_housesource t2 INNER JOIN XHJ_HouseInfoForRenting t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 and t2.HouseNumberID = t1.id  UNION ALL  SELECT  t6.id  FROM xhj_housesource t2 INNER JOIN xhj_housesourceforsaling t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 and t2.HouseNumberID = t1.id ) s) as surveyNum,");
//			sql.append(" ( SELECT COUNT(1) FROM (  SELECT t5.id FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t2.HouseNumberID = t1.id  UNION ALL  SELECT t5.id FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t2.HouseNumberID = t1.id ) s) as keyNum,");
//			sql.append(" (  SELECT COUNT(1) FROM (  SELECT t5.id FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t2.HouseNumberID = t1.id  UNION ALL  SELECT t5.id FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t2.HouseNumberID = t1.id ) s) AS delegateNum,");
			sql.append("( SELECT  count(t6.id) FROM xhj_housesource t2 INNER JOIN XHJ_HouseInfoForRenting t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 AND t5.HosueType=2 and t2.HouseNumberID = t1.id  ) as rentsurveyid,");
			sql.append("( SELECT  count(t6.id) FROM xhj_housesource t2 INNER JOIN xhj_housesourceforsaling t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 AND t5.HosueType=1 and t2.HouseNumberID = t1.id  ) as salesurveyid,");

			sql.append("(SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t5.HouseType=2 AND t2.HouseNumberID = t1.id  ) as rentkeyid,");
			sql.append("(SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t5.HouseType=1 AND t2.HouseNumberID = t1.id ) as salekeyid,");
			sql.append(
					" ( SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t5.HouseType=2 AND t2.HouseNumberID = t1.id  ) AS rentdelegateNum,");
			sql.append(
					" ( SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t5.HouseType=1 AND t2.HouseNumberID = t1.id ) AS saledelegateNum,");
			sql.append
			(" (SELECT DISTINCT hfs.IsEncryption FROM xhj_housesource h INNER JOIN xhj_housesourceforsaling hfs ON h.id=hfs.housesourceid  WHERE hfs.housesourcestatus>0 AND h.housenumberid=t1.id ) AS saleIsEncryption,(SELECT DISTINCT hfs.IsEncryption FROM xhj_housesource h INNER JOIN xhj_houseinfoforrenting hfs ON h.id=hfs.housesourceid  WHERE hfs.housesourcestatus>0 AND h.housenumberid=t1.id ) AS rentIsEncryption,");
			
//			sql.append(" (SELECT count(1) FROM xhj_housesource h,xhj_exclusivedelegateinfo e where h.id=e.HouseSourceID and state=1 AND h.HouseNumberID=t1.id) as delegateNum,");
//			sql.append(" (SELECT count(1) FROM xhj_housesource h,xhj_surveyofhouse e where h.id=e.HouseSourceID and state=1 AND h.HouseNumberID=t1.id) as surveyNum,");
//			sql.append(" (SELECT count(1) FROM xhj_housesource h,xhj_keyinfo e where h.id=e.HouseSourceID and e.statuss = 1  AND h.HouseNumberID=t1.id) as keyNum,");
			sql.append(
					" (SELECT dy_name FROM xhj_lpdanyuan WHERE id = t7.dyid limit 1) AS dyName,(select name from lp_syscs_1 where id = t7.direction limit 1) chaoxiang,");
			sql.append(" t9.fullname,");
			sql.append(" (SELECT name FROM xhj_syscs_1 WHERE t7.PropertyInfo = id limit 1) AS PropertyInfo,");
			sql.append(" (SELECT name FROM xhj_syscs_1 WHERE t7.TerritoryInfo = id limit 1) AS TerritoryInfo,");
			sql.append(" t10.department_name,");

			sql.append(
					" (SELECT NAME FROM xhj_syscs_1 WHERE sid = 11 AND id = t7.purpose limit 1) AS useagename, '出租' AS type");
			sql.append(
					" FROM xhj_lpfanghao t1 LEFT JOIN xhj_housesource t2 ON t1.id = t2.HouseNumberID LEFT JOIN XHJ_HouseInfoForRenting t3 ON t2.id = t3.HouseSourceID  LEFT JOIN xhj_lpxx t4 ON t1.lpid = t4.id"
							+ " LEFT JOIN XHJ_SurveyOfHouse t5 ON t3.id = t5.saleorrentid left join XHJ_ImageOfSurvey t6 on t5.id = t6.surveyid LEFT JOIN lpjg_info t7 ON t1.id = t7.fhid AND t7.creatorid = "+creatorId+" LEFT JOIN lpjg_relationship t8 ON t1.id = t8.fhid "
							+ " LEFT JOIN tbl_user_profile t9 ON t3.belongerid = t9.id LEFT JOIN tbl_department t10 ON t9.tbl_department_id = t10.id where 1 = 1 ");

			sql.append(" and t1.id = " + houseNo);
			sql.append(" GROUP BY t6.surveyid " );
			
			System.out.println(sql.toString());
			houseList = this.daoHelper.getList(sql.toString());
			for (int i = 0; i < houseList.size(); i++) {
				house = (Map) houseList.get(i);
				String fullname = house.get("fullname") == null ? "" : house.get("fullname").toString();
				String imagePath = house.get("imagepath") == null ? "" : house.get("imagepath").toString();
				String[] imageArr = null;
				if (StringUtils.notEmpty(fullname)) {
					imageArr = imagePath.split(",");
					house.put("imagepath", imageArr);
					break;
				} else {
					house.put("type", "");
				}
			}
			String createdate = house.get("createdate") == null ? ""
					: house.get("createdate").toString().substring(0, house.get("createdate").toString().length() - 2);
			house.put("createdate", createdate);
			result.add(house);
		}
		return Response.ok().entity(result).build();
	}
	
	/**
	 * 查询核心信息列表
	 *
	 * @param postParameter
	 * @return Response
	 */
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/queryCoreMessageList")
	public Response queryCoreMessageList(PostParameter postParameter) {
		RequestParameter requestParameter = postParameter.getRequestParameter();
		ResultFeedback resultFeedback = new ResultFeedback();
		Integer fhId = requestParameter.getFhId();
		boolean flag = judgeIsNotQueryCoreMessage(fhId,SecurityUserHolder.getUserId());
		if(flag){
			pageInfo = postParameter.getPageInfo();
			if (pageInfo == null) {
				pageInfo = new PageInfo();
				pageInfo.setPage(1);
			}

			// 设置行数.
			pageInfo.setRows(10);
			if(null != fhId){
				StringBuffer sql = new StringBuffer();
				sql.append(" SELECT * FROM xhj_lpxxport where fanghao = "+ fhId);
				System.out.println(sql.toString());
				pageInfo = super.getPagerjdo(sql.toString(), pageInfo);
				if (pageInfo.getGridModel().size() != 0) {
					List<Map> hashMapList = (List<Map>) pageInfo.getGridModel();
					for (int i = 0; i < hashMapList.size(); i++) {
						Map hashMap = hashMapList.get(i);
						if (null != hashMap.get("createdate")) {
							hashMap.put("createdate", hashMap.get("createdate").toString().substring(0,
									hashMap.get("createdate").toString().length() - 2));
						} else {
							hashMap.put("createdate", "未知");
						}
					}
				}
			}
			// 封装返回.
			resultFeedback.setListJson(pageInfo);
		}
		return Response.ok().entity(resultFeedback).build();
	}
	
	/**
	 * 检查经纪人是否存在异常的跟进
	 *
	 * @param requestParameter
	 * @return Response
	 */
	@POST
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	@Path("/judgeHosueOkOrError")
	public Response judgeHosueOkOrError(RequestParameter requestParameter) {
		Integer result = 0;
		List<Map> resultData = new ArrayList<Map>();
		StringBuffer sqlCondition = new StringBuffer();
		Integer creatorId = requestParameter.getCreatorId();
		Integer fhId = requestParameter.getFhId();
		Integer bmId = requestParameter.getBmid();
		if(null != creatorId ){
		List<Record> organizationName = userDao.getTitle(creatorId);
		String string = organizationName.toString();
		if (string.indexOf("商圈经理")!= -1){
			sqlCondition.append(" and mdid = ").append(bmId);
		}

		if (string.indexOf("门店") != -1) {
			sqlCondition.append(" and bmid = ").append(bmId);
		}

		if (string.indexOf("经纪人") != -1) {
			sqlCondition.append(" and creatorid = ").append(creatorId);
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM lpjg_precise_update_record where 1=1 ");
		if(null != fhId){
			sql.append(" and fhid = "+fhId);
		}
		sql.append(" and flag = 1 ");
		sql.append(" and statuss = 1 ");
		sql.append(sqlCondition);
		System.out.println(sql.toString());
		resultData = daoHelper.getList(sql.toString());
		if(resultData.size() > 0){
			result = 1;
		}
		}
		//result为0表示该经纪人名下没有异常的跟进，为1表示存在异常的跟进
		return Response.ok().entity(result).build();
	}
	
	public boolean judgeIsNotQueryCoreMessage(Integer fhId,Integer creatorId) {
		boolean flag = false;
		List<Map> list = new ArrayList<Map>();
		if (null != fhId && null != creatorId) {
			String sql = "SELECT hfs.IsEncryption,hfs.belongerid from xhj_housesource h INNER JOIN xhj_housesourceforsaling hfs on h.id=hfs.housesourceid  where hfs.housesourcestatus=1 and hfs.IsEncryption = 1 and h.housenumberid= "
					+ fhId;
			list = this.daoHelper.getList(sql.toString());
			if (list.size() > 0) {
				Map map = new HashMap();
				map = list.get(0);
				if(map.get("isencryption").toString().equals("1")){
					if(map.get("belongerid").toString().equals(creatorId.toString())){
						flag = true;
					}else{
						flag = false;
					}
				}else{
					flag = true;
				}
			}else{
				flag = true;
			}
		}
		return flag;
	}
}