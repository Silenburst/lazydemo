<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="Xenon Boostrap Admin Panel" />
<meta name="author" content="" />

<title>版本信息</title>

<link rel="stylesheet" href="<%=basePath%>/assets/css/fonts/linecons/css/linecons.css">
<link rel="stylesheet" href="<%=basePath%>/assets/css/fonts/fontawesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>/assets/css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-core.css">
<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-forms.css">
<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-components.css">
<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-skins.css">
<link rel="stylesheet" href="<%=basePath%>/assets/css/custom.css">
<link rel="stylesheet" href="<%=basePath%>/assets/css/shijianzhou.css">
<script src="<%=basePath%>/assets/js/jquery-1.11.1.min.js"></script>

</head>
<body class="page-body">
	<div class="page-container">
		<div class="main-content">
			<ul class="cbp_tmtimeline" id="result">
				<!-- <li>
					<time class="cbp_tmtime">
						<span>2016年4月27日</span><span>8:30</span>
					</time>
					<div class="cbp_tmicon timeline-bg-success">
						<i class="fa-location-arrow"></i>
					</div>
					<div class="cbp_tmlabel">
						<h3>v5.0.11</h3>
						<h2>
							新增功能： <br>1.数据读写分离，提高服务器响应速度； 
								   <br>2.电子合同系统对接法务部，支持相关业务流程；
						</h2>
					</div>
				</li>
				<li>
					<time class="cbp_tmtime">
						<span>2016年4月26日</span><span>12:30</span>
					</time>
					<div class="cbp_tmicon timeline-bg-success">
						<i class="fa-location-arrow"></i>
					</div>
					<div class="cbp_tmlabel">
						<h3>v5.0.10</h3>
						<h2>
							新增功能： <br>1.签约中心（大华）增加管辖门店 东塘东店；
						</h2>
					</div>
				</li>
				<li>
					<time class="cbp_tmtime">
						<span>2016年4月22日</span><span>10:00</span>
					</time>
					<div class="cbp_tmicon timeline-bg-success">
						<i class="fa-location-arrow"></i>
					</div>
					<div class="cbp_tmlabel">
						<h3>v5.0.9</h3>
						<h2>
							新增功能： <br>1.发短信服务器地址调整，接口调整；
						</h2>
					</div>
				</li> -->
				<!-- <li>
					<time class="cbp_tmtime">
						<span>2016年4月21日</span><span>12:00</span>
					</time>
					<div class="cbp_tmicon timeline-bg-success">
						<i class="fa-location-arrow"></i>
					</div>
					<div class="cbp_tmlabel">
						<h3>v5.0.8</h3>
						<h2>
							修改BUG： <br>1.BMS录成交合同，修复买卖合同的【填充】功能；
						</h2>
					</div>
				</li> -->
				<li>
					<time class="cbp_tmtime">
						<span>2016年5月26日</span><span>18:00</span>
					</time>
					<div class="cbp_tmicon timeline-bg-info">
						<i class="fa-location-arrow"></i>
					</div>
					<div class="cbp_tmlabel">
						<h3>v1.0.4</h3>
						<h2>
							更新内容：
									 <br>1、业主精耕了解需求期
									 <br>2、业主精耕客户带看期
									 <br>3、业主精耕合同洽谈期
						</h2>
					</div>
				</li>
				<li>
					<time class="cbp_tmtime">
						<span>2016年5月19日</span><span>21:00</span>
					</time>
					<div class="cbp_tmicon timeline-bg-info">
						<i class="fa-location-arrow"></i>
					</div>
					<div class="cbp_tmlabel">
						<h3>v1.0.3</h3>
						<h2>
							更新内容：
									 <br>1、版本支持楼盘精耕移动端。
									 <br>2、代码优化与梳理。
									 <br><br>-------------------------------
									 <br>版本修正：       <br>1、业主维护保存成功后，房屋详情的没有查询到业主信息
									 <br>2、分派中，第一个默认楼盘无法调出数据，需要点完其他楼盘，再点才出现！
									 <br>3、筛选条件未保存
									 <br>4、房屋详情，精耕人无法查看归属非自己的A盘核心信息
									 <br>5、给同一经纪人中，左边已被分派的房屋标红或者直接过滤掉
									 <br>6、点击业主精耕跟进内容后没有跳转到当前页面
									 <br>7、商圈经理被分派主营楼盘数据不对
									 <br>8、分派中，同一房间可以被一个经纪人重复分派N次，且没有提醒！！
									 <br>9、商圈经理进行分派，缺少经纪人，在人事系统查询看到有八九个经纪人
									 <br>10、分组队盘，删除该经纪人下的楼盘。操作记录描述有问题（删除该经纪人156500下所有房屋）
									 <br>11、 组队盘分派很多楼盘报错500
									 <br>12、把组队盘所有以分派的数据删除，但是销控页面还是有数据
									 <br>13、主营盘分派窗口，分派之后窗口没有关闭
									 <br>14、业主维护保存成功后，房屋详情的没有查询到业主信息
						</h2>
					</div>
				</li>
				<li>
					<time class="cbp_tmtime">
						<span>2016年5月6日</span><span>21:00</span>
					</time>
					<div class="cbp_tmicon timeline-bg-info">
						<i class="fa-location-arrow"></i>
					</div>
					<div class="cbp_tmlabel">
						<h3>v1.0.2</h3>
						<h2>
							更新内容：       <br>1.新增一房间多人精耕数字显示：销控或业主视图，如果存在一个房间多个经纪人精耕，在后面标注数量，直观提醒商圈经理；
									 <br>2.优化分派中楼盘报错500；
									 <br>3.优化分派弹窗：解决部分门店因分辨率低上下排版统一优化为左右排版；
									 <br>4.优化分派刷新：分派成功后系统自动刷新页面而不需要手动刷新；
									 <br>5.优化初始化报警状态：默认情况没有精耕房屋处于正常，只有精耕之后超过报警参数才开始报警！
									 <br>6.优化异常精耕同步刷新数：异常精耕中，精耕一次数字减1；
									 <br>7.解决主岗副岗切换权限问题：比如实习总监登录，切换到商圈经理没有商圈经理权限问题；
									 <br>8.解决委托期无法委托房源、房堪、钥匙；
									 <br>9.优化分派离职显示：商圈经理分派中，系统自动过滤离职经纪人！
									 <br><br>-------------------------------
									 <br>附加：目前系统包括以下功能模块：
									 <br>分派：商圈经理组队盘人对户分派、副总主营楼盘分派到店、总经理责任楼盘分派到人
									 <br>销控管理：查看自己所精耕范围销售视图（BMS数据）
									 <br>业主精耕：精耕自己所精耕范围楼盘房屋
									 <br>异常精耕：快速处理己所精耕报警异常房屋
									 <br>房屋详情：查看自己所精耕范围房屋维护信息
									 <br>精耕审核：商圈经理审核查看自己管辖经纪人作业情况

						</h2>
					</div>
				</li>
				<li>
					<time class="cbp_tmtime">
						<span>2016年2月26日</span><span>23:30</span>
					</time>
					<div class="cbp_tmicon timeline-bg-gray">
						<i class="fa-user"></i>
					</div>
					<div class="cbp_tmlabel empty">
						<span>开始</span>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<link rel="stylesheet" href="<%=basePath%>/assets/js/multiselect/css/multi-select.css">
	<script src="<%=basePath%>/assets/js/jquery-validate/jquery.validate.min.js"></script>
	<script src="<%=basePath%>/assets/js/inputmask/jquery.inputmask.bundle.js"></script>
	<script src="<%=basePath%>/assets/js/formwizard/jquery.bootstrap.wizard.min.js"></script>
	<script src="<%=basePath%>/assets/js/datepicker/bootstrap-datepicker.js"></script>
	<script src="<%=basePath%>/assets/js/multiselect/js/jquery.multi-select.js"></script>
	<script src="<%=basePath%>/assets/js/jquery-ui/jquery-ui.min.js"></script>
	<script src="<%=basePath%>/assets/js/selectboxit/jquery.selectBoxIt.min.js"></script>
	<script src="<%=basePath%>/assets/js/xenon-custom.js"></script>
</body>
</html>