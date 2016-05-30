package com.newenv.communityFocus.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newenv.communityFocus.base.BaseService;
import com.newenv.communityFocus.base.PageInfo;
import com.newenv.communityFocus.queryCondition.ConditionSC;
import com.newenv.communityFocus.security.SecurityUserHolder;
import com.newenv.communityFocus.util.StringUtils;

/**
 * @author chen. helix
 * @date 2016.03.15 楼盘精耕dao
 */
@Component
public class TraceDao extends BaseService {

	@Autowired
	private DaoHelper daoHelper;
	@Autowired
	private UserDao userDao;

	/**
	 * @author chen. helix
	 * @date 2016.04-07 楼盘跟进 楼盘精耕dao
	 */
	public void updateGenjing(String fhid, String stage, String creatorid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" update lpjg_precise_update_record set updatecount= updatecount+1 ");
		sb.append(" where flag = 1 and stage = '");
		sb.append("'").append(stage).append(" and creatorid = ").append(creatorid).append(" and fhid = ").append(fhid);
		// Person p = dao.fetch(Person.class,2);
		// P.SETAGE(32);
		// DAO.UPDATE(P)
		daoHelper.update(sb.toString());
	};

	public List<Record> isWeiTuoFangyuan(String fanghaoid, String houseType) {
		StringBuffer sb = new StringBuffer();
		Integer type = Integer.valueOf(houseType);
		if (type == 2) {
			sb.append(
					" select '租' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_houseinfoforrenting exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		if (type == 1) {
			sb.append(
					" select '售' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_housesourceforsaling exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		if (type == 0) {
			sb.append(
					" select '租' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_houseinfoforrenting exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 ");
			sb.append(" and fh.id = ").append(fanghaoid);
			sb.append(" union all ");
			sb.append(
					" select '售' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_housesourceforsaling exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		return daoHelper.getRecordList(sb.toString());
	};

	public List<Record> isWeiTuoYaoShi(String fanghaoid, String houseType) {
		StringBuffer sb = new StringBuffer();
		Integer type = Integer.valueOf(houseType);
		if (type == 2) {
											
			sb.append(
					" select '租' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_houseinfoforrenting exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN XHJ_KeyInfo info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 and info.HouseType=2 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		if (type == 1) {
			sb.append(
					" select '售' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_housesourceforsaling exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN XHJ_KeyInfo info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 and info.HouseType=1 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		if (type == 0) {
			sb.append(
					" select '租' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_houseinfoforrenting exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN XHJ_KeyInfo info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 and info.HouseType=2 ");
			sb.append(" and fh.id = ").append(fanghaoid);
			sb.append(" union all ");
			sb.append(
					" select '售' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_housesourceforsaling exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN XHJ_KeyInfo info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 and info.HouseType=1 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		return daoHelper.getRecordList(sb.toString());
	};

	public List<Record> isWeiTuoFangKan(String fanghaoid, String houseType) {
		StringBuffer sb = new StringBuffer();
		Integer type = Integer.valueOf(houseType);
		if (type == 2) {
			sb.append(
					" select '租' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_houseinfoforrenting exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN XHJ_SurveyOfHouse info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 and info.HosueType=2 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		if (type == 1) {
			sb.append(
					" select '售' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_housesourceforsaling exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN XHJ_SurveyOfHouse info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 and info.HosueType=1 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		if (type == 0) {
			sb.append(
					" select '租' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_houseinfoforrenting exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN XHJ_SurveyOfHouse info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 and info.HosueType=2 ");
			sb.append(" and fh.id = ").append(fanghaoid);
			sb.append(" union all ");
			sb.append(
					" select '售' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_housesourceforsaling exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN XHJ_SurveyOfHouse info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where  exc.HouseSourceStatus >0 and info.HosueType=1 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		return daoHelper.getRecordList(sb.toString());
	};

	public List<Record> isWeiTuoDuJia(String fanghaoid, String houseType) {
		StringBuffer sb = new StringBuffer();
		Integer type = Integer.valueOf(houseType);
		if (type == 2) {
			sb.append(
					" select '租' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_houseinfoforrenting exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN xhj_exclusivedelegateinfo info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where exc.HouseSourceStatus >0 and info.HouseType=2 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		if (type == 1) {
			sb.append(
					" select '售' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber  from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_housesourceforsaling exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN xhj_exclusivedelegateinfo info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where exc.HouseSourceStatus >0 and info.HouseType=1 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		if (type == 0) {
			sb.append(
					" select '租' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_houseinfoforrenting exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN xhj_exclusivedelegateinfo info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where exc.HouseSourceStatus >0 and info.HouseType=2 ");
			sb.append(" and fh.id = ").append(fanghaoid);
			sb.append(" union all ");
			sb.append(
					" select '售' as zushou,fh.id fanghaoid,fh.fanghao,fh.shi,fh.ting,fh.wei,h.lpid,exc.price,lp.lp_name,h.id houseSourceId,exc.id saleOrRentId,exc.houseTypeid,exc.houseType,exc.number housenumber  from xhj_lpfanghao fh ");
			sb.append(" INNER JOIN xhj_housesource h on h.housenumberid = fh.id  ");
			sb.append(" INNER JOIN xhj_housesourceforsaling exc on h.id  = exc.housesourceid  ");
			sb.append(" INNER JOIN xhj_exclusivedelegateinfo info  on exc.id  = info.saleOrRentid ");
			sb.append(" INNER JOIN xhj_lpxx lp ON lp.id = h.lpid");
			sb.append(" where exc.HouseSourceStatus >0 and info.HouseType=1 ");
			sb.append(" and fh.id = ").append(fanghaoid);
		}
		return daoHelper.getRecordList(sb.toString());
	};

	public List<Record> querySCLp(Integer bmid, Integer userid) {
		StringBuffer sb = new StringBuffer();

		sb.append(
				"SELECT DISTINCT l.id,l.lp_name FROM xhj_lpxx l INNER JOIN lpjg_assignment_loupan lap on  l.id=lap.lpid ");
		sb.append(" INNER JOIN  lpjg_assignment_room lar on    lar.lpid=lap.lpid  where l.cityid = ")
				.append(SecurityUserHolder.getCityId());
		sb.append("  and l.statuss = 1 AND lap.flag = 1  AND lar.flag = 1 ");

		// 登陆控制
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if (string.indexOf("商圈经理") != -1) {
			sb.append(" and lar.mdid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}

		if (string.indexOf("门店") != -1) {
			sb.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}

		if (string.indexOf("经纪人") != -1) {
			sb.append(" and lar.userid = ").append(SecurityUserHolder.getUserId());
		}

		return daoHelper.getRecordList(sb.toString());
	}

	public List<Record> querySCDong(Integer lpid, Integer userid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT dz.id ,dz.lpd_name  ").append(
				" FROM xhj_lpxx lp,xhj_lpdong dz , xhj_lpdanyuan dy,lpjg_assignment_loupan lap,xhj_lpfanghao fh,lpjg_assignment_room lar ");
		sb.append(" where lp.id=dz.lpid and dz.id = dy.dzid and dy.id=fh.dyid AND fh.id=lar.fhid and lp.id=lap.lpid ");

		// 登陆控制
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if (string.indexOf("商圈经理") > 0) {
			sb.append(" and lar.mdid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}

		if (string.indexOf("门店") > 0) {
			sb.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}

		if (string.indexOf("经纪人") > 0) {
			sb.append(" and lar.userid = ").append(SecurityUserHolder.getUserId());
		}

		sb.append(" and lar.cityid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getCityId());
		sb.append(" and lp.statuss = 1  and lp.id =").append(lpid).append(" GROUP BY dz.id ");

		// -- 经纪人
		// SELECT l.lp_name,l.id FROM xhj_lpxx l,xhj_lpdong d,xhj_lpdanyuan
		// dy,xhj_lpfanghao fh,lpjg_assignment_room lar
		// where l.id=d.Lpid AND d.id=dy.dzid and dy.id=fh.DYID AND
		// fh.id=lar.fhid and lar.userid=4
		return daoHelper.getRecordList(sb.toString());
	}

	public List<Record> querySCDanyuan(Integer dzid, Integer userid) {
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT dy.id ,dy.dy_name  ");
		sb.append(
				" FROM xhj_lpxx lp,xhj_lpdong dz , xhj_lpdanyuan dy,lpjg_assignment_loupan lap,xhj_lpfanghao fh,lpjg_assignment_room lar  ");
		sb.append("  where lp.id=dz.lpid and dz.id = dy.dzid and dy.id=fh.dyid AND fh.id=lar.fhid and lp.id=lap.lpid ");

		// 登陆控制
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if (string.indexOf("商圈经理") > 0) {
			sb.append(" and lar.mdid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}

		if (string.indexOf("门店") > 0) {
			sb.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}

		if (string.indexOf("经纪人") > 0) {
			sb.append(" and lar.userid = ").append(SecurityUserHolder.getUserId());
		}

		sb.append(" and lar.cityid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getCityId());
		sb.append(" and lp.statuss = 1  and dz.id =").append(dzid).append("  GROUP BY dz.id,dy.id ");
		return daoHelper.getRecordList(sb.toString());
	}

	/**
	 * 根据条件查询销控彩色列表
	 * 
	 * @param pageInfo
	 * @param lpid
	 * @return
	 */
	public Map<String, Map<String, List<String>>> querySCTable(ConditionSC condition) {
		StringBuilder sqlscdanyuan = new StringBuilder();
		String lpid = condition.getLpid();
		String dzid = condition.getDzid();
		String dyid = condition.getDyid();
		String dianzu = condition.getDianzu();
		String jingjiren = condition.getJingjiren();
		String biaoqian = condition.getBiaoqian();
		String zhuangxiu = condition.getZhuangxiu();
		String userid = condition.getUserid();
//		String bmid = condition.getBmid();
//		String mdid = condition.getMdid();
		String cityid = condition.getCityid();
		String statuss = condition.getStatuss();
		String panleixing = condition.getPanleixing();
		
//		sqlscdanyuan.append("	select  lp.id,lpd.id as dzid ,CONCAT(lp.lp_name,'#',lpd.lpd_name,'(',dy.dy_name,')') as title ,dy.id as dyid ,MAX(lf.ceng) maxceng ");
//		sqlscdanyuan.append("	,GROUP_CONCAT(DISTINCT CONCAT(CAST(lf.ceng AS CHAR),'#', CAST( IF((select statuss  from lpjg_precise_update_record  where fhid = lf.id and flag = 1 and creatorid=");
//		sqlscdanyuan.append(SecurityUserHolder.getUserId()).append(" and statuss =0 limit 1)=0,0,1) AS CHAR),'#',lf.fanghao)  ORDER BY LENGTH(lf.fanghao),lf.fanghao desc )as fhcount " );
////		sqlscdanyuan.append(" ,(select statuss from lpjg_precise_update_record   where fhid = lf.id and statuss = 1 ORDER BY  modifydate desc  limit 1  ) baojing ");
//		sqlscdanyuan.append(" from xhj_lpxx lp inner join xhj_lpdong lpd  on  lp.id = lpd.lpid ");
//		sqlscdanyuan.append(" inner join xhj_lpdanyuan  dy on lpd.id = dy.dzid   ");
//		sqlscdanyuan.append(" inner join xhj_lpfanghao lf  on  lf.dyid= dy.id");
//		sqlscdanyuan.append(" inner join lpjg_assignment_room lar  on   lf.id=lar.fhid");
//		sqlscdanyuan.append(" inner join lpjg_assignment_loupan lop  on  lop.lpid = lar.lpid " );
//		sqlscdanyuan.append("	 where lp.statuss = 1 and lf.statuss = 1   ");
//		sqlscdanyuan.append(" and lop.lpid = ").append(lpid);
		
		sqlscdanyuan.append("	SELECT aa.id , aa.dzid ,CONCAT(aa.lp_name,'#',aa.lpd_name,'(',aa.dy_name,')') AS title  , aa.dyid ,dyid ,MAX(aa.ceng) maxceng , ");
		sqlscdanyuan.append("	GROUP_CONCAT(DISTINCT CONCAT(CAST(aa.ceng AS CHAR),'#', CAST( IF((SELECT COUNT(1)  ");
		sqlscdanyuan.append(" FROM lpjg_precise_update_record  WHERE fhid = aa.fhid AND flag = 1 AND creatorid=");
		sqlscdanyuan.append(SecurityUserHolder.getUserId()).append("  AND statuss =1 LIMIT 1)=0,0,1) AS CHAR),'#',aa.fanghao,'#', CAST(aa.fhjg AS CHAR ))    )AS fhcount " );
		sqlscdanyuan.append(" FROM (  SELECT  lp.id,lpd.id AS dzid , lf.fanghao ,lf.ceng ,dy.id dyid , lp.lp_name,lpd_name , dy_name , ");
		sqlscdanyuan.append(" lf.id fhid , ");
		sqlscdanyuan.append(" (SELECT  COUNT(1) FROM lpjg_assignment_room r WHERE r.fhid = lf.id AND r.flag = 1 ) fhjg  ");
		sqlscdanyuan.append("   FROM xhj_lpxx lp INNER JOIN xhj_lpdong lpd    ");
		sqlscdanyuan.append("  ON  lp.id = lpd.lpid  INNER JOIN xhj_lpdanyuan  dy ON lpd.id = dy.dzid    INNER JOIN xhj_lpfanghao lf  ON    ");
		sqlscdanyuan.append(" lf.dyid= dy.id INNER JOIN lpjg_assignment_room lar  ON   lf.id=lar.fhid INNER JOIN lpjg_assignment_loupan lop   ON  lop.lpid = lar.lpid  ");
		sqlscdanyuan.append("	 where lp.statuss = 1 and lf.statuss = 1 AND lar.flag = 1  ");
		sqlscdanyuan.append(" and lop.lpid = ").append(lpid);
		
		
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if(string.indexOf("商圈经理")!=-1)
		{
			sqlscdanyuan.append(" and lar.mdid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
			
			if(null !=dianzu && dianzu !="" && dianzu != "0" && !dianzu.equals("0"))
			{
				sqlscdanyuan.append(" and lar.bmid = ").append(dianzu);
			}
			
			if(null !=jingjiren && jingjiren !="" && jingjiren != "0" && !jingjiren.equals("0"))
			{
				sqlscdanyuan.append(" and lar.userid = ").append(jingjiren);
			}
		}
		
		if(string.indexOf("门店")!=-1)
		{
			sqlscdanyuan.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
			
			if(null !=jingjiren && jingjiren !="" && jingjiren != "0" && !jingjiren.equals("0"))
			{
				sqlscdanyuan.append(" and lar.userid = ").append(jingjiren);
			}
		}
		
		if(string.indexOf("经纪人")!=-1)
		{
			sqlscdanyuan.append(" and lar.userid = ").append(SecurityUserHolder.getUserId());
		}
		
		
		if(null !=biaoqian && biaoqian !=""  && biaoqian != "0" && !biaoqian.equals("0"))
		{
			//钥匙
			if(biaoqian.equals("1"))
			{
				sqlscdanyuan.append(" and lf.keyid  = ").append(userid);
			}
			//房堪
			if(biaoqian.equals("2"))
			{
				sqlscdanyuan.append(" and lf.surveyid  = ").append(userid);
			}
			//独家
			if(biaoqian.equals("3"))
			{
				sqlscdanyuan.append(" and lf.delegateid  = ").append(userid);
			}
		}
		//盘
		if(null !=panleixing && panleixing !="" && panleixing != "0" && !panleixing.equals("0"))
		{
			sqlscdanyuan.append(" and lf.isencryption  = '").append(panleixing).append("'");
		}
		
		
		if(null !=statuss && statuss !="")
		{
			sqlscdanyuan.append(" and lf.id in ( select fhid from lpjg_precise_update_record where creatorid = ");
			sqlscdanyuan.append(SecurityUserHolder.getUserId()).append(" and flag = 1 and  stage = '").append(statuss).append("')");
		}
		
		if(null !=zhuangxiu && zhuangxiu !="" && zhuangxiu != "0" && !zhuangxiu.equals("0"))
		{
			sqlscdanyuan.append(" and lf.DecorationStandard  = ").append(zhuangxiu);
		}
		
		if(null !=dzid && dzid !="" && dzid != "0" && !dzid.equals("0"))
		{
			sqlscdanyuan.append(" and lpd.id = ").append(dzid);
		}
		
		if(null !=dyid && dyid !="" && dyid != "0" && !dyid.equals("0"))
		{
			sqlscdanyuan.append(" and dy.id = ").append(dyid);
		}
		
//		if(null !=dianzu && dianzu !=""&& dianzu != "0" && !dianzu.equals("0"))
//		{
//			sqlscdanyuan.append(" and lar.mdid = ").append(dianzu);
//		}
		
		
		if(null !=cityid && cityid !="" && cityid != "0" && !cityid.equals("0"))
		{
			sqlscdanyuan.append(" and lar.cityid = ").append(cityid);
		}
		
//		sqlscdanyuan.append(" GROUP BY lf.dyid " );
//		sqlscdanyuan.append("	ORDER BY lpd.lpd_name,dy.dy_name; " );
		
		sqlscdanyuan.append( " ) aa  GROUP BY dyid ORDER BY lpd_name,dy_name ");
		
		List<Record> objsdanyuan = daoHelper.getRecordList(sqlscdanyuan.toString());
		
		Map<String,Map<String,List<String>>> mapsfanghao  = new LinkedHashMap<String,Map<String,List<String>>>();
		if(null == objsdanyuan || objsdanyuan.size()<=0)
		{
			return null;
		}
		for ( Record record: objsdanyuan) {
//				Integer id =  record.getInt("id");
//				Integer dzid =  record.getInt("dzid");
			String title = record.getString("title");
//				Integer dyid = record.getInt("dyid");
			Integer maxceng = record.getInt("maxceng");
			String fhcount = record.getString("fhcount");
			
			//保存层-房号的数据
			Map<String,List<String>> mapsceng  = new LinkedHashMap<String,List<String>>();

			if(null ==fhcount || fhcount.length()<=0)
			{
				return null;
			}
			//当前单元的所有数据
			String[] fhs = fhcount.split(",");
			List<String> asList = Arrays.asList(fhs);
			
			if(null == fhcount || fhcount.length()<=0)
			{
				return null;
			}
			for (int i = maxceng; i >= 1; i--) {
				//当前ceng的所有数据
				List<String> fhlists = new ArrayList<String>();
//				List<String> asList2 = new ArrayList<String>();
				for (int j = 0; j < asList.size(); j++) {
					String fhzt = asList.get(j);
					if(fhzt.indexOf("#")<0)
					{
						continue;
					}
					String[] split = fhzt.split("#",2);
					Integer ceng = Integer.valueOf(split[0]);
					String  fanghao = split[1];
					if(ceng == i)
					{
						fhlists.add(fanghao);
					}
				}
				if(null != fhlists && fhlists.size() >0)
				{
					mapsceng.put(i+"F", fhlists);
				}
			}
			mapsfanghao.put(title, mapsceng);
		}
		return mapsfanghao;
	}

	/**
	 * 根据条件查询销控彩色列表
	 * 
	 * @param pageInfo
	 * @param lpid
	 * @return
	 */
	public PageInfo querySCList(PageInfo pageInfo, ConditionSC condition) {
		StringBuilder sqlscdanyuan = new StringBuilder();
		StringBuilder sqlCondition = new StringBuilder();

		String lpid = condition.getLpid();
		String dzid = condition.getDzid();
		String dyid = condition.getDyid();
		String dianzu = condition.getDianzu();
		String jingjiren = condition.getJingjiren();
		String biaoqian = condition.getBiaoqian();
		String zhuangxiu = condition.getZhuangxiu();
		String userid = condition.getUserid();
		String bmid = condition.getBmid();
		// String mdid = condition.getMdid();
		String cityid = condition.getCityid();
		String statuss = condition.getStatuss();
		String panleixing = condition.getPanleixing();
		Integer saleOrRent = condition.getSaleOrRent();
		Integer shi = condition.getShi();
		String lpName = condition.getLpName();
		Integer isNotOk = condition.getIsNotOk();
		String loginUserId = condition.getCreatorId();

		sqlCondition.append("  where   lp.statuss = 1   AND lar.flag = 1 AND lop.flag = 1");
		// -- INNER JOIN xhj_housesourceforsaling hs on )
		if (null != lpid && lpid != "" && !lpid.equals("")) {
			sqlCondition.append("  and lp.id = ").append(lpid);
		}
		// 登陆控制
		List<Record> organizationName = userDao.getTitle(StringUtils.notEmpty(loginUserId)? Integer.valueOf(loginUserId) : SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if (string.indexOf("商圈经理") > 0) {
			sqlCondition.append(" and lar.mdid = ").append(StringUtils.notEmpty(bmid)? bmid:SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
			if (null != dianzu && dianzu != "" && dianzu != "0" && !dianzu.equals("0")) {
				sqlCondition.append(" and lar.bmid = ").append(dianzu);
			}

			if (null != jingjiren && jingjiren != "" && jingjiren != "0" && !jingjiren.equals("0")) {
				sqlCondition.append(" and lar.userid = ").append(jingjiren);
			}
		}

		if (string.indexOf("门店") > 0) {
			sqlCondition.append(" and lar.bmid = ").append(StringUtils.notEmpty(bmid)? bmid:SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());

			if (null != jingjiren && jingjiren != "" && jingjiren != "0" && !jingjiren.equals("0")) {
				sqlCondition.append(" and lar.userid = ").append(jingjiren);
			}
		}

		if (string.indexOf("经纪人") > 0) {
			sqlCondition.append(" and lar.userid = ").append(StringUtils.notEmpty(loginUserId)? loginUserId : SecurityUserHolder.getUserId());
		}

		if (null != statuss && statuss != "") {
			sqlCondition.append(" and lf.id in ( select fhid from lpjg_precise_update_record where creatorid = ");
			sqlCondition.append(StringUtils.notEmpty(loginUserId)? loginUserId : SecurityUserHolder.getUserId()).append(" and flag= 1 and  stage = '").append(statuss)
					.append("') ");
		}

		if (null != zhuangxiu && zhuangxiu != "" && zhuangxiu != "0" && !zhuangxiu.equals("0")) {
			sqlCondition.append(" and lf.DecorationStandard  = ").append(zhuangxiu);
		}

		if (null != dzid && dzid != "" && dzid != "0" && !dzid.equals("0")) {
			sqlCondition.append(" and lpd.id = ").append(dzid);
		}

		if (null != dyid && dyid != "" && dyid != "0" && !dyid.equals("0")) {
			sqlCondition.append(" and dy.id = ").append(dyid);
		}

		if (null != cityid && cityid != "" && cityid != "0" && !cityid.equals("0")) {
			sqlCondition.append(" and lar.cityid = ").append(cityid);
		}

		if (null != shi) {
			sqlCondition.append(" and lf.shi = ").append(shi);
		}
		if (StringUtils.notEmpty(lpName)) {
			sqlCondition.append(" and lp.lp_name like '%" + lpName + "%'");
		}

		sqlscdanyuan.append(
				" select lp.id lpid,lpd.id dzid ,dy.id dyid ,lf.id fhid,lpd.lpd_name,dy.dy_name,lf.fwzt,(select name from xhj_syscs_1 where id = lf.b_type) btype");
		sqlscdanyuan.append(" ,CONCAT(lp.lp_name,'#',lpd.lpd_name,'(',dy.dy_name,')') as title ");
		sqlscdanyuan.append(
				" ,CONCAT(IFNULL((select name from xhj_syscs_1 where id= lf.chaoxiang),'无朝向'),'/',IFNULL(CAST(lf.shi AS char),'0'),'室/',IFNULL(CAST(lf.ting AS char),'0'),'厅/',IFNULL(CAST((SELECT propertysize FROM lpjg_info WHERE fhid = lf.id AND creatorid = tup.id ) AS char),'0'),'平米') as fangwu ,lp.bieming,lf.fanghao,lf.number,");
		sqlscdanyuan.append("( SELECT img.imgpath FROM `xhj_lpfanghaoimg`  AS img WHERE img.statuss=1 AND img.fanghaoid=lf.id ORDER BY img.id  LIMIT 1) as imagepath,"); 

		sqlscdanyuan.append("( SELECT  count(t6.id) FROM xhj_housesource t2 INNER JOIN XHJ_HouseInfoForRenting t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 and t5.HosueType=2 and t2.HouseNumberID = lf.id  ) as rentsurveyid,");
		sqlscdanyuan.append("( SELECT  count(t6.id) FROM xhj_housesource t2 INNER JOIN xhj_housesourceforsaling t3   ON t2.id = t3.HouseSourceID INNER JOIN XHJ_SurveyOfHouse t5  ON t3.id = t5.saleorrentid  INNER JOIN XHJ_ImageOfSurvey t6   ON t5.id = t6.surveyid  WHERE t5.state = 1 and t5.HosueType=1 and t2.HouseNumberID = lf.id  ) as salesurveyid,");

		sqlscdanyuan.append("(SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t5.HouseType=2 and t2.HouseNumberID = lf.id  ) as rentkeyid,");
		sqlscdanyuan.append("(SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_keyinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.statuss = 1 AND t5.HouseType=1 and t2.HouseNumberID = lf.id ) as salekeyid,");

		sqlscdanyuan.append(
				" IFNULL(lf.PropertyAddress,'') PropertyAddress,IFNULL(CAST(tup.fullname AS char),'无姓名记录') fullname ");
		sqlscdanyuan.append(
				" ,IFNULL(tup.tel,'无联系方式') tel,(select department_name FROM tbl_department where id = tup.tbl_department_id) as departmentname, ");
		sqlscdanyuan.append(" (SELECT COUNT(1) FROM lpjg_precise_update_record WHERE 1 = 1  AND creatorid = tup.id");
		sqlscdanyuan
				.append(" AND fhid = lf.id AND flag = 1 AND statuss = 1) as isNotOk, ");
		sqlscdanyuan.append(" (SELECT stage FROM lpjg_precise_update_record WHERE 1 = 1  AND creatorid = ");
		sqlscdanyuan.append(StringUtils.notEmpty(loginUserId)? loginUserId : SecurityUserHolder.getUserId())
				.append(" AND fhid = lf.id AND flag = 1 AND statuss = 1) as stage, ");
		sqlscdanyuan.append(" (select price  from lpjg_competitors where fhid = lf.id and creatorid = ");
		sqlscdanyuan.append(StringUtils.notEmpty(loginUserId)? loginUserId : SecurityUserHolder.getUserId()).append(" and flag = 1 ");
		sqlscdanyuan.append(
				" ) Price,(select modifydate from lpjg_precise_update_record  where fhid = lf.id  and creatorid = tup.id");
		sqlscdanyuan.append(
				" ORDER BY  modifydate desc  limit 1) refreshDate  ,(select requires  from lpjg_competitors  where fhid = lf.id and creatorid = tup.id ");
		sqlscdanyuan.append(" and flag = 1 ").append(")  requires ");
		sqlscdanyuan.append(
				" ,(select IFNULL(SUM(updatecount), 0) from lpjg_precise_update_record   where fhid = lf.id ");
		sqlscdanyuan.append(
				" ) updatecount  ,(select statuss  from lpjg_precise_update_record  where fhid = lf.id and creatorid=");
		sqlscdanyuan.append(StringUtils.notEmpty(loginUserId)? loginUserId : SecurityUserHolder.getUserId()).append(" and flag = 1 and statuss =1 limit 1)  statuss ");
		sqlscdanyuan.append(
				" ,(select count(creatorid) from lpjg_precise_update_record   where fhid = lf.id  ");
		sqlscdanyuan.append(" ) creatorcount ");
		sqlscdanyuan.append(" ,(select messages from lpjg_precise_update_record   where fhid = lf.id and creatorid = tup.id");
		sqlscdanyuan.append
				("  ORDER BY  modifydate desc  limit 1  ) messages,  ");
		sqlscdanyuan.append
		(" (SELECT DISTINCT hfs.IsEncryption FROM xhj_housesource h INNER JOIN xhj_housesourceforsaling hfs ON h.id=hfs.housesourceid  WHERE hfs.housesourcestatus>0 AND h.housenumberid=lf.id ) AS saleIsEncryption,(SELECT DISTINCT hfs.IsEncryption FROM xhj_housesource h INNER JOIN xhj_houseinfoforrenting hfs ON h.id=hfs.housesourceid  WHERE hfs.housesourcestatus>0 AND h.housenumberid=lf.id ) AS rentIsEncryption,");
		
		sqlscdanyuan.append(
				" ( SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN XHJ_HouseInfoForRenting t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t5.HouseType=2 AND t2.HouseNumberID = lf.id  ) AS rentdelegateNum,");
		sqlscdanyuan.append(
				" ( SELECT COUNT(1) FROM xhj_housesource t2  INNER JOIN xhj_housesourceforsaling t3  ON t2.id = t3.HouseSourceID  INNER JOIN xhj_exclusivedelegateinfo t5   ON t3.id = t5.saleorrentid  WHERE t5.state = 1 AND t5.HouseType=1 AND t2.HouseNumberID = lf.id ) AS saledelegateNum,");
		
		sqlscdanyuan.append(" (SELECT COUNT(1) FROM lpjg_competitors WHERE fhid = lf.id  AND flag=1 and creatorid = tup.id ) AS competitors ");
		sqlscdanyuan.append(
				"  from xhj_lpxx lp INNER JOIN  xhj_lpdong lpd ON lp.id = lpd.lpid   INNER JOIN xhj_lpdanyuan  dy ON lpd.id = dy.dzid    ");
		sqlscdanyuan.append(
				" INNER JOIN xhj_lpfanghao lf ON dy.id=lf.DYID   INNER JOIN lpjg_assignment_room lar ON lf.id=lar.fhid    ");
		sqlscdanyuan.append("  INNER JOIN lpjg_assignment_loupan lop  ON lop.lpid= lar.lpid  ");
		sqlscdanyuan.append("  INNER JOIN tbl_user_profile tup ON tup.id= lar.userid  ");
		// sqlscdanyuan.append(" where lp.statuss = 1 and lp.id = 4145 and
		// lar.bmid = 4 and lar.cityid = 1 ");
		sqlscdanyuan.append(sqlCondition.toString());
		// sqlCondition.append(" ORDER BY lpd.lpd_name,dy.dy_name " );
		String sql = "select DISTINCT * from (" + sqlscdanyuan.toString() + " )ss where 1=1 ";
		if (null != saleOrRent) {
			if (saleOrRent == 0) {
				sql += " and ss.requires = '已售'";
			} else if (saleOrRent == 1) {
				sql += " and ss.requires = '已租'";
			} else if (saleOrRent == -1) {

			} else {
				sql += " and ss.requires is null";
			}
		}
		
		if (null != biaoqian && biaoqian != "" && biaoqian != "0" && !biaoqian.equals("0")) {
			// 钥匙
			if (biaoqian.equals("1")) {
				sql += " and ss.salekeyid+ss.rentkeyid  >0 ";
			}
			// 房堪
			if (biaoqian.equals("2")) {
				sql += " and ss.salesurveyid+ss.rentsurveyid  > 0 ";
			}
			// 独家
			if (biaoqian.equals("3")) {
				sql += "  and ss.saledelegatenum+ss.rentdelegatenum  >0";
			}
		}
		if (null != isNotOk) {
			sql += " and ss.isnotok = 0";
		}
		// 盘
		if (null != panleixing && panleixing != "" && panleixing != "0" && !panleixing.equals("0")) {
			sql += " and (ss.saleisencryption = '"+panleixing+"' "+" or ss.rentisencryption = '"+panleixing+"')";
		}
		sql += " ORDER BY ss.lpd_name,ss.dy_name";
		// GROUP BY ss.lpid,ss.dzid,ss.dyid,ss.fhid
		// List<Record> objsdanyuan = daoHelper.getRecordList(sql);
		String sqlCount = "(" + sql + ") sss";
		pageInfo = super.getPagerjdo(sql, pageInfo);
		if (pageInfo.getGridModel().size() != 0) {
			List<Map> hashMapList = (List<Map>) pageInfo.getGridModel();
			for (int i = 0; i < hashMapList.size(); i++) {
				Map hashMap = hashMapList.get(i);
				if (null == hashMap.get("stage")) {
					hashMap.put("stage", "接触期");
				} 
			}
		}
		return pageInfo;
	}
	
	
	/**
	 * 根据条件查询销控彩色列表
	 * 
	 * @param pageInfo
	 * @param lpid
	 * @return
	 */
	public PageInfo queryErrorSCList(PageInfo pageInfo, ConditionSC condition) {
		StringBuilder sqlscdanyuan = new StringBuilder();
		StringBuilder sqlCondition = new StringBuilder();

		String lpid = condition.getLpid();
		String dzid = condition.getDzid();
		String dyid = condition.getDyid();
		String dianzu = condition.getDianzu();
		String jingjiren = condition.getJingjiren();
		String biaoqian = condition.getBiaoqian();
		String zhuangxiu = condition.getZhuangxiu();
		String userid = condition.getUserid();
		String bmid = condition.getBmid();
		// String mdid = condition.getMdid();
		String cityid = condition.getCityid();
		String statuss = condition.getStatuss();
		String panleixing = condition.getPanleixing();
		Integer saleOrRent = condition.getSaleOrRent();
		Integer shi = condition.getShi();
		String lpName = condition.getLpName();
		String loginUserId = condition.getCreatorId();

		// -- INNER JOIN xhj_housesourceforsaling hs on )
		if (null != lpid && lpid != "" && !lpid.equals("")) {
			sqlCondition.append("  where   lp.statuss = 1   AND lar.flag = 1 AND lop.flag = 1 and lp.id = ").append(lpid);
		}
		// 登陆控制
		List<Record> organizationName = userDao.getTitle(StringUtils.notEmpty(loginUserId)? Integer.valueOf(loginUserId) : SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if (string.indexOf("商圈经理") > 0) {
			sqlCondition.append(" and lar.mdid = ").append(StringUtils.notEmpty(bmid)? bmid : SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
			if (null != dianzu && dianzu != "" && dianzu != "0" && !dianzu.equals("0")) {
				sqlCondition.append(" and lar.bmid = ").append(dianzu);
			}

			if (null != jingjiren && jingjiren != "" && jingjiren != "0" && !jingjiren.equals("0")) {
				sqlCondition.append(" and lar.userid = ").append(jingjiren);
			}
		}

		if (string.indexOf("门店") > 0) {
			sqlCondition.append(" and lar.bmid = ").append(StringUtils.notEmpty(bmid)? bmid : SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());

			if (null != jingjiren && jingjiren != "" && jingjiren != "0" && !jingjiren.equals("0")) {
				sqlCondition.append(" and lar.userid = ").append(jingjiren);
			}
		}

		if (string.indexOf("经纪人") > 0) {
			sqlCondition.append(" and lar.userid = ").append(StringUtils.notEmpty(loginUserId)? loginUserId : SecurityUserHolder.getUserId());
		}

		if (null != biaoqian && biaoqian != "" && biaoqian != "0" && !biaoqian.equals("0")) {
			// 钥匙
			if (biaoqian.equals("1")) {
				sqlCondition.append(" and lf.keyid  = ").append(userid);
			}
			// 房堪
			if (biaoqian.equals("2")) {
				sqlCondition.append(" and lf.surveyid  = ").append(userid);
			}
			// 独家
			if (biaoqian.equals("3")) {
				sqlCondition.append(" and lf.delegateid  = ").append(userid);
			}
		}
		// 盘
		if (null != panleixing && panleixing != "" && panleixing != "0" && !panleixing.equals("0")) {
			sqlCondition.append(" and lf.isencryption  = '").append(panleixing).append("'");
		}

		if (null != statuss && statuss != "") {
			sqlCondition.append(" and lf.id in ( select fhid from lpjg_precise_update_record where creatorid = ");
			sqlCondition.append(StringUtils.notEmpty(loginUserId)? loginUserId : SecurityUserHolder.getUserId()).append(" and flag= 1 and  stage = '").append(statuss)
					.append("') ");
		}

		if (null != zhuangxiu && zhuangxiu != "" && zhuangxiu != "0" && !zhuangxiu.equals("0")) {
			sqlCondition.append(" and lf.DecorationStandard  = ").append(zhuangxiu);
		}

		if (null != dzid && dzid != "" && dzid != "0" && !dzid.equals("0")) {
			sqlCondition.append(" and lpd.id = ").append(dzid);
		}

		if (null != dyid && dyid != "" && dyid != "0" && !dyid.equals("0")) {
			sqlCondition.append(" and dy.id = ").append(dyid);
		}

		if (null != cityid && cityid != "" && cityid != "0" && !cityid.equals("0")) {
			sqlCondition.append(" and lar.cityid = ").append(cityid);
		}

		if (null != shi) {
			sqlCondition.append(" and lf.shi = ").append(shi);
		}
		if (StringUtils.notEmpty(lpName)) {
			sqlCondition.append(" and lp.lp_name like '%" + lpName + "%'");
		}

		sqlscdanyuan.append(
				"select lpd.lpd_name,lp.lp_name,dy.dy_name,lf.fanghao,lf.id fhid,");
		sqlscdanyuan.append(
				" (select department_name FROM tbl_department where id = tup.tbl_department_id) as departmentname, ");
		sqlscdanyuan.append(" (SELECT modifydate FROM lpjg_precise_update_record WHERE 1 = 1  AND creatorid = tup.id");
		sqlscdanyuan
				.append(" AND fhid = lf.id AND flag = 1 AND statuss = 1) as modifydate, ");
		sqlscdanyuan.append(" (SELECT COUNT(1) FROM lpjg_precise_update_record WHERE 1 = 1  AND creatorid = tup.id");
		sqlscdanyuan
				.append(" AND fhid = lf.id AND flag = 1 AND statuss = 1) as isNotOk ");
		sqlscdanyuan.append(
				"  from xhj_lpxx lp INNER JOIN  xhj_lpdong lpd ON lp.id = lpd.lpid   INNER JOIN xhj_lpdanyuan  dy ON lpd.id = dy.dzid    ");
		sqlscdanyuan.append(
				" INNER JOIN xhj_lpfanghao lf ON dy.id=lf.DYID   INNER JOIN lpjg_assignment_room lar ON lf.id=lar.fhid    ");
		sqlscdanyuan.append("  INNER JOIN lpjg_assignment_loupan lop  ON lop.lpid= lar.lpid  ");
		sqlscdanyuan.append("  INNER JOIN tbl_user_profile tup ON tup.id= lar.userid  ");
		// sqlscdanyuan.append(" where lp.statuss = 1 and lp.id = 4145 and
		// lar.bmid = 4 and lar.cityid = 1 ");
		sqlscdanyuan.append(sqlCondition.toString());
		// sqlCondition.append(" ORDER BY lpd.lpd_name,dy.dy_name " );
		String sql = "select DISTINCT * from (" + sqlscdanyuan.toString() + " )ss where 1=1 ";
		if (null != saleOrRent) {
			if (saleOrRent == 0) {
				sql += " and ss.requires = '出售'";
			} else if (saleOrRent == 1) {
				sql += " and ss.requires = '出租'";
			} else if (saleOrRent == -1) {

			} else {
				sql += " and ss.requires is null";
			}
		}
		sql += " and ss.isnotok != 0";
		sql += " ORDER BY ss.modifydate desc";
		// GROUP BY ss.lpid,ss.dzid,ss.dyid,ss.fhid
		// List<Record> objsdanyuan = daoHelper.getRecordList(sql);
		pageInfo = super.getPagerjdo(sql, pageInfo);
		if (pageInfo.getGridModel().size() != 0) {
			List<Map> hashMapList = (List<Map>) pageInfo.getGridModel();
			for (int i = 0; i < hashMapList.size(); i++) {
				Map hashMap = hashMapList.get(i);
				if (null == hashMap.get("stage")) {
					hashMap.put("stage", "接触期");
				} 
			}
		}
		return pageInfo;
	}

}
