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
/**
 * @author Administrator
 *
 */
@Component
public class SellControlDao extends BaseService{
	
	@Autowired
	private DaoHelper daoHelper;
	@Autowired
	private UserDao userDao;
	
	public List<Record> querySCData(Integer bmid,Integer userid){
		List<Record> recordList = daoHelper.getRecordList("select * from xhj_lpxx limit 1");
		
		//如下四行
//		Sql sql = Sqls.create(sqlString);
//		sql.setCallback(Sqls.callback.record());
//		dao.execute(sql);
//		return sql.getObject(Map.class);
//		StringBuilder sql = new StringBuilder();
//		StringBuilder sqlCount = new StringBuilder();
//		sql.append("select lp.id,REPLACE(lp.LP_Name,' ',''),REPLACE(lp.address,' ',''),(select name from xhj_syscs_1 where id = lp.yongtu) yongtuname ");
//		sql.append(",(select count(1) from xhj_lpdong where lpid = lp.id) as dongtotal ");
//		sql.append(",(select count(1) from xhj_lpfanghao where lpid = lp.id and statuss = 1) as fanghaototal  ");
//		sql.append(" from xhj_lpxx lp where statuss > 0   ");
//		sql.append(" order by  checkDate desc,dongtotal desc ");
//		sqlCount.append("select count(1) from (").append(sql.toString()).append(") ss");
//		pageInfo = getEntitiesByPaginationWithSql(pageInfo, sql.toString(), sqlCount.toString(), DAOConstants.RELATIONAL);
		return recordList;
	}
	
	public List<Record> querySCLp(Integer bmid,Integer userid){
		StringBuffer sb = new StringBuffer();

		sb.append("SELECT DISTINCT l.id,l.lp_name FROM xhj_lpxx l INNER JOIN lpjg_assignment_loupan lap on  l.id=lap.lpid ");
		sb.append(" INNER JOIN  lpjg_assignment_room lar on    lar.lpid=lap.lpid  where l.cityid = ").append(SecurityUserHolder.getCityId());
		sb.append("  and l.statuss = 1  AND lap.flag = 1  AND lar.flag = 1 ");
		
		//登陆控制
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if(string.indexOf("商圈经理")!=-1)
		{
			sb.append(" and lar.mdid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}
		
		if(string.indexOf("门店")!=-1)
		{
			sb.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}
		
		if(string.indexOf("经纪人")!=-1)
		{
			sb.append(" and lar.userid = ").append(SecurityUserHolder.getUserId());
		}
		
		
		return daoHelper.getRecordList(sb.toString());
	}
	
	public List<Record> querySCDong(Integer lpid,Integer userid){
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT dz.id ,dz.lpd_name  ").append(" FROM xhj_lpxx lp,xhj_lpdong dz , xhj_lpdanyuan dy,lpjg_assignment_loupan lap,xhj_lpfanghao fh,lpjg_assignment_room lar ");
		sb.append(" where lp.id=dz.lpid and dz.id = dy.dzid and dy.id=fh.dyid AND fh.id=lar.fhid and lp.id=lap.lpid ");
		
		//登陆控制
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if(string.indexOf("商圈经理")>0)
		{
			sb.append(" and lar.mdid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}
		
		if(string.indexOf("门店")>0)
		{
			sb.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}
		
		if(string.indexOf("经纪人")>0)
		{
			sb.append(" and lar.userid = ").append(SecurityUserHolder.getUserId());
		}
		
		sb.append(" and lar.cityid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getCityId());
		sb.append(" and lp.statuss = 1  and lp.id =").append(lpid).append(" GROUP BY dz.id ");
		
//		-- 经纪人
//		SELECT l.lp_name,l.id FROM xhj_lpxx l,xhj_lpdong d,xhj_lpdanyuan dy,xhj_lpfanghao fh,lpjg_assignment_room lar 
//		where l.id=d.Lpid AND d.id=dy.dzid and dy.id=fh.DYID AND fh.id=lar.fhid and lar.userid=4 
		return daoHelper.getRecordList(sb.toString());
	}
	
	public List<Record> querySCDanyuan(Integer dzid,Integer userid){
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT dy.id ,dy.dy_name  ");
		sb.append(" FROM xhj_lpxx lp,xhj_lpdong dz , xhj_lpdanyuan dy,lpjg_assignment_loupan lap,xhj_lpfanghao fh,lpjg_assignment_room lar  ");
		sb.append("  where lp.id=dz.lpid and dz.id = dy.dzid and dy.id=fh.dyid AND fh.id=lar.fhid and lp.id=lap.lpid ");
		

		//登陆控制
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if(string.indexOf("商圈经理")>0)
		{
			sb.append(" and lar.mdid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}
		
		if(string.indexOf("门店")>0)
		{
			sb.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
		}
		
		if(string.indexOf("经纪人")>0)
		{
			sb.append(" and lar.userid = ").append(SecurityUserHolder.getUserId());
		}
		
		sb.append(" and lar.cityid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getCityId());
		sb.append(" and lp.statuss = 1  and dz.id =").append(dzid).append("  GROUP BY dz.id,dy.id ");
		return daoHelper.getRecordList(sb.toString());
	}
	
	/**
	 * 根据条件查询销控彩色列表
	 * @param pageInfo
	 * @param lpid
	 * @return
	 */
	public Map<String,Map<String,List<String>>> querySCTable(ConditionSC condition)
	{
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
		
		sqlscdanyuan.append("	select  lp.id,lpd.id as dzid ,CONCAT(lp.lp_name,'#',lpd.lpd_name,'(',dy.dy_name,')') as title ,dy.id as dyid ,MAX(lf.ceng) maxceng ");
		sqlscdanyuan.append("	,GROUP_CONCAT(DISTINCT CONCAT(CAST(lf.ceng AS CHAR),'#', CAST(lf.fwzt AS CHAR),'#',lf.fanghao)  ORDER BY LENGTH(lf.fanghao),lf.fanghao desc )as fhcount " );
		sqlscdanyuan.append(" from xhj_lpxx lp inner join xhj_lpdong lpd  on  lp.id = lpd.lpid ");
		sqlscdanyuan.append(" inner join xhj_lpdanyuan  dy on lpd.id = dy.dzid   ");
		sqlscdanyuan.append(" inner join xhj_lpfanghao lf  on  lf.dyid= dy.id");
		sqlscdanyuan.append(" inner join lpjg_assignment_room lar  on   lf.id=lar.fhid");
		sqlscdanyuan.append(" inner join lpjg_assignment_loupan lop  on  lop.lpid = lar.lpid " );
		sqlscdanyuan.append("	 where lp.statuss = 1 and lf.statuss = 1  and lar.flag = 1 ");
		sqlscdanyuan.append(" and lop.lpid = ").append(lpid);
		
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if(string.indexOf("商圈经理")>0)
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
		
		if(string.indexOf("门店")>0)
		{
			sqlscdanyuan.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
			
			if(null !=jingjiren && jingjiren !="" && jingjiren != "0" && !jingjiren.equals("0"))
			{
				sqlscdanyuan.append(" and lar.userid = ").append(jingjiren);
			}
		}
		
		if(string.indexOf("经纪人")>0)
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
			sqlscdanyuan.append(" and lf.fwzt  = ").append(statuss);
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
		
		sqlscdanyuan.append(" GROUP BY lf.dyid " );
		sqlscdanyuan.append("	ORDER BY lpd.lpd_name,dy.dy_name; " );
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
	 * @param pageInfo
	 * @param lpid
	 * @return
	 */
	public 	PageInfo querySCList(PageInfo pageInfo,ConditionSC condition)
	{
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
//		String bmid = condition.getBmid();
//		String mdid = condition.getMdid();
		String cityid = condition.getCityid();
		String statuss = condition.getStatuss();
		String panleixing = condition.getPanleixing();
		
		//--         INNER   JOIN xhj_housesourceforsaling hs on )  
		sqlCondition.append("  where   lp.statuss = 1 AND lar.flag = 1  and lp.id = ").append(lpid);
		//登陆控制
		List<Record> organizationName = userDao.getTitle(SecurityUserHolder.getUserId());
		String string = organizationName.toString();
		if(string.indexOf("商圈经理")>0)
		{
			sqlCondition.append(" and lar.mdid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
			if(null !=dianzu && dianzu !="" && dianzu != "0" && !dianzu.equals("0"))
			{
				sqlCondition.append(" and lar.bmid = ").append(dianzu);
			}
			
			if(null !=jingjiren && jingjiren !="" && jingjiren != "0" && !jingjiren.equals("0"))
			{
				sqlCondition.append(" and lar.userid = ").append(jingjiren);
			}
		}
		
		if(string.indexOf("门店")>0)
		{
			sqlCondition.append(" and lar.bmid = ").append(SecurityUserHolder.getCurrentUserLogin().getDepartment().getId());
			
			if(null !=jingjiren && jingjiren !="" && jingjiren != "0" && !jingjiren.equals("0"))
			{
				sqlCondition.append(" and lar.userid = ").append(jingjiren);
			}
		}
		
		if(string.indexOf("经纪人")>0)
		{
			sqlCondition.append(" and lar.userid = ").append(SecurityUserHolder.getUserId());
		}
		
		
		if(null !=biaoqian && biaoqian !=""  && biaoqian != "0" && !biaoqian.equals("0"))
		{
			//钥匙
			if(biaoqian.equals("1"))
			{
				sqlCondition.append(" and lf.keyid  = ").append(userid);
			}
			//房堪
			if(biaoqian.equals("2"))
			{
				sqlCondition.append(" and lf.surveyid  = ").append(userid);
			}
			//独家
			if(biaoqian.equals("3"))
			{
				sqlCondition.append(" and lf.delegateid  = ").append(userid);
			}
		}
<<<<<<< HEAD
=======
		//盘
		if(null !=panleixing && panleixing !="" && panleixing != "0" && !panleixing.equals("0"))
		{
			sqlCondition.append(" and lf.isencryption  = '").append(panleixing).append("'");
		}
>>>>>>> aa6433be91419cf20278114adc5d4e74917df3a7
		
		if(null !=statuss && statuss !="")
		{
			sqlCondition.append(" and lf.fwzt  = ").append(statuss);
		}
		
		if(null !=zhuangxiu && zhuangxiu !="" && zhuangxiu != "0" && !zhuangxiu.equals("0"))
		{
			sqlCondition.append(" and lf.DecorationStandard  = ").append(zhuangxiu);
		}
		
		if(null !=dzid && dzid !="" && dzid != "0" && !dzid.equals("0"))
		{
			sqlCondition.append(" and lpd.id = ").append(dzid);
		}
		
		if(null !=dyid && dyid !="" && dyid != "0" && !dyid.equals("0"))
		{
			sqlCondition.append(" and dy.id = ").append(dyid);
		}
		
//		if(null !=dianzu && dianzu !=""&& dianzu != "0" && !dianzu.equals("0"))
//		{
//			sqlCondition.append(" and lar.bmid = ").append(dianzu);
//		}
//		if(null !=mdid && mdid !="" && mdid != "0" && !mdid.equals("0"))
//		{
//			sqlCondition.append(" and lar.mdid = ").append(mdid);
//		}
		
		
		if(null !=cityid && cityid !="" && cityid != "0" && !cityid.equals("0"))
		{
			sqlCondition.append(" and lar.cityid = ").append(cityid);
		}
		
<<<<<<< HEAD
		sqlscdanyuan
				.append(" select  lp.id lpid,lpd.id dzid ,dy.id dyid ,lf.id fhid,lpd.lpd_name,dy.dy_name,lf.fwzt, ");
		sqlscdanyuan.append(
				"	CONCAT(lp.lp_name,'#',lpd.lpd_name,'(',dy.dy_name,')') as title,IFNULL((select name from xhj_syscs_1 where id = lf.leixing  LIMIT 1) ,'')usages , ");
		sqlscdanyuan.append("	CONCAT(IFNULL((select name from xhj_syscs_1 where id= lf.chaoxiang LIMIT 1),'无朝向'), ");
		sqlscdanyuan.append("	'/',IFNULL(CAST(lf.shi AS char),'0'),'室/',IFNULL(CAST(lf.ting AS char),'0'),'厅/', ");
		sqlscdanyuan.append("	IFNULL(CAST(lf.CQMJ AS char),'0'),'平米') as fangwu ,lp.bieming,lf.fanghao,lf.number, ");
		sqlscdanyuan.append(
				"(  SELECT img.imgpath FROM `xhj_lpfanghaoimg`  AS img WHERE img.statuss=1 AND img.fanghaoid=lf.id ORDER BY img.id LIMIT 1) as imagepath,");
		sqlscdanyuan.append(
				"	lf.keyid,lf.surveyid,IFNULL(lf.PropertyAddress,'') PropertyAddress,IFNULL(CAST(tup.fullname AS char),'无姓名记录') fullname ");
		sqlscdanyuan.append(
				"	,IFNULL(tup.tel,'无联系方式') tel,(select department_name FROM tbl_department where id = tup.tbl_department_id LIMIT 1) as departmentname, ");
		sqlscdanyuan.append("	IFNULL( IF( ");
		sqlscdanyuan.append(
				"	(SELECT h.id FROM  xhj_housesource h,xhj_housesourceforsaling hs WHERE h.id=hs.HouseSourceID AND lf.id=h.HouseNumberID  and hs.housesourcestatus>0 LIMIT 1) is NULL, ");
		sqlscdanyuan.append(
				"	(SELECT hs.totalprice FROM  xhj_housesource h,xhj_houseinfoforrenting hs  WHERE h.id=hs.HouseSourceID AND lf.id=h.HouseNumberID  and hs.housesourcestatus>0 LIMIT 1), ");
		sqlscdanyuan.append(
				"	(SELECT hs.price FROM  xhj_housesource h,xhj_housesourceforsaling hs  WHERE h.id=hs.HouseSourceID AND lf.id=h.HouseNumberID  and hs.housesourcestatus>0 LIMIT 1) ),0) Price, ");
		sqlscdanyuan.append("	IFNULL(CAST(lf.updatedate AS char),'无最新时间') refreshDate,  ");
		sqlscdanyuan.append(
				" (SELECT DISTINCT hfs.IsEncryption FROM xhj_housesource h INNER JOIN xhj_housesourceforsaling hfs ON h.id=hfs.housesourceid  WHERE hfs.housesourcestatus>0 AND h.housenumberid=lf.id ) AS saleIsEncryption,(SELECT DISTINCT hfs.IsEncryption FROM xhj_housesource h INNER JOIN xhj_houseinfoforrenting hfs ON h.id=hfs.housesourceid  WHERE hfs.housesourcestatus>0 AND h.housenumberid=lf.id ) AS rentIsEncryption ");
		sqlscdanyuan.append(
				"	from xhj_lpxx lp INNER JOIN  xhj_lpdong lpd ON lp.id = lpd.lpid   INNER JOIN xhj_lpdanyuan  dy ON lpd.id = dy.dzid    ");
		sqlscdanyuan.append(
				"	INNER JOIN xhj_lpfanghao lf ON dy.id=lf.DYID   INNER JOIN lpjg_assignment_room lar ON lf.id=lar.fhid  ");
		sqlscdanyuan.append("	INNER JOIN tbl_user_profile tup ON tup.id= lar.userid    ");
		sqlscdanyuan.append(sqlCondition.toString());
//		sqlCondition.append("	GROUP BY ss.lpid,ss.dzid,ss.dyid,ss.fhid  " );
		String sql = "select DISTINCT * from ("+sqlscdanyuan.toString()+" )ss where 1=1 ";
		if (null != panleixing && panleixing != "" && panleixing != "0" && !panleixing.equals("0")) {
			sql += " and (ss.saleisencryption = '"+panleixing+"' "+" or ss.rentisencryption = '"+panleixing+"')";
		}
		sql += " ORDER BY ss.lpd_name,ss.dy_name";
=======
		sqlscdanyuan.append(" select  lp.id lpid,lpd.id dzid ,dy.id dyid ,lf.id fhid,lpd.lpd_name,dy.dy_name,lf.fwzt, " );
		sqlscdanyuan.append("	CONCAT(lp.lp_name,'#',lpd.lpd_name,'(',dy.dy_name,')') as title,IFNULL((select name from xhj_syscs_1 where id = lf.leixing  LIMIT 1) ,'')usages , " );
		sqlscdanyuan.append("	CONCAT(IFNULL((select name from xhj_syscs_1 where id= lf.chaoxiang LIMIT 1),'无朝向'), " );
		sqlscdanyuan.append("	'/',IFNULL(CAST(lf.shi AS char),'0'),'室/',IFNULL(CAST(lf.ting AS char),'0'),'厅/', " );
		sqlscdanyuan.append("	IFNULL(CAST(lf.CQMJ AS char),'0'),'平米') as fangwu ,lp.bieming,lf.fanghao,lf.number, " );
		sqlscdanyuan.append("(  SELECT img.imgpath FROM `xhj_lpfanghaoimg`  AS img WHERE img.statuss=1 AND img.fanghaoid=lf.id ORDER BY img.id LIMIT 1) as imagepath,"); 
		sqlscdanyuan.append("	lf.keyid,lf.surveyid,IFNULL(lf.PropertyAddress,'') PropertyAddress,IFNULL(CAST(tup.fullname AS char),'无姓名记录') fullname " );
		sqlscdanyuan.append("	,IFNULL(tup.tel,'无联系方式') tel,(select department_name FROM tbl_department where id = tup.tbl_department_id LIMIT 1) as departmentname, " );
		sqlscdanyuan.append("	IFNULL( IF( " );
		sqlscdanyuan.append("	(SELECT h.id FROM  xhj_housesource h,xhj_housesourceforsaling hs WHERE h.id=hs.HouseSourceID AND lf.id=h.HouseNumberID  and hs.housesourcestatus>0 LIMIT 1) is NULL, " );
		sqlscdanyuan.append("	(SELECT hs.totalprice FROM  xhj_housesource h,xhj_houseinfoforrenting hs  WHERE h.id=hs.HouseSourceID AND lf.id=h.HouseNumberID  and hs.housesourcestatus>0 LIMIT 1), " );
		sqlscdanyuan.append("	(SELECT hs.price FROM  xhj_housesource h,xhj_housesourceforsaling hs  WHERE h.id=hs.HouseSourceID AND lf.id=h.HouseNumberID  and hs.housesourcestatus>0 LIMIT 1) ),0) Price, " );
		sqlscdanyuan.append("	IFNULL(CAST(lf.updatedate AS char),'无最新时间') refreshDate   " );
		sqlscdanyuan.append("	from xhj_lpxx lp INNER JOIN  xhj_lpdong lpd ON lp.id = lpd.lpid   INNER JOIN xhj_lpdanyuan  dy ON lpd.id = dy.dzid    " );
		sqlscdanyuan.append("	INNER JOIN xhj_lpfanghao lf ON dy.id=lf.DYID   INNER JOIN lpjg_assignment_room lar ON lf.id=lar.fhid  " );
		sqlscdanyuan.append("	INNER JOIN tbl_user_profile tup ON tup.id= lar.userid    " );
		sqlscdanyuan.append(sqlCondition.toString());
//		sqlCondition.append("	GROUP BY ss.lpid,ss.dzid,ss.dyid,ss.fhid  " );
		String sql = "select DISTINCT * from ("+sqlscdanyuan.toString()+" )ss  ORDER BY ss.lpd_name,ss.dy_name";
>>>>>>> aa6433be91419cf20278114adc5d4e74917df3a7
//		GROUP BY ss.lpid,ss.dzid,ss.dyid,ss.fhid 
//		List<Record> objsdanyuan = daoHelper.getRecordList(sql);
		pageInfo = super.getPagerjdo( sql, pageInfo);
		return pageInfo;
	}
}
