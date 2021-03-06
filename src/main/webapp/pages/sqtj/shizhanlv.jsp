<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ include file="../fenpai/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta name="description" content="Xenon Boostrap Admin Panel" />
		<meta name="author" content="" />
		<title>市占率</title>
		<link rel="stylesheet" href="<%=basePath%>/assets/css/fonts/linecons/css/linecons.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/fonts/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/fonts/elusive/css/elusive.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/bootstrap.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-core.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-forms.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-components.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-skins.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/custom.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/jingen.css">
		<script src="<%=basePath%>/assets/js/jquery-1.11.1.min.js"></script>
		<script src="<%=basePath%>/assets/js/pagination/pagination.js"></script>
		<script src="<%=basePath%>/assets/js/common/common.js"></script>
		<script src="<%=basePath%>/assets/js/echar/echarts.min.js"></script>
		
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
		<style>
			.nav.nav-tabs + .tab-content{ margin-bottom: 0px;}
		</style>
		<script type="text/javascript" src="<%=basePath%>/js/sqtj/shizhanlv.js"></script>
	</head>
	<div class='onsubing' style="display:block; width:100%; height:100%; background:#fff; position:fixed; z-index:99999; opacity:0.8;-moz-opacity:0.8; filter:alpha(opacity=80); ">
		<div class="text-center" style="position:absolute; top:20%; left:40%;">
			<img src="<%=basePath%>/images/loading.gif" width="176" height="220"/>
			<span>努力加载中....请稍等</span>
		</div>
	</div>
	<body class="page-body">
		<div class="page-container">
			<div class="main-content">
				<div class="page-title">
					<div class="breadcrumb-env pull-left">
						<ol class="breadcrumb bc-1">
							<li>
								<a href="../首页.html"><i class="fa-home"></i>首页</a>
							</li>
							<li>
								<a href="#">商圈统计</a>
							</li>
							<li class="active">
								<strong>市占率</strong>
							</li>
						</ol>
					</div>
				</div>
				<div class="panel">
					<div class="row" style="padding: 6px;  margin: 0px;">
						<div class="col-sm-4 col-md-4 col-lg-3">
							<div class="form-group">
								<div class="input-group input-group-sm input-group-minimal">
									<span class="input-group-addon">
										纵向参数指标：
									</span>
									<select class="form-control" id="szlType">
										<!-- <option value="1" selected>范围市占率</option> -->
										<option value="2">楼盘市占率</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-3">
							<div class="form-group">
								<div class="input-group input-group-sm input-group-minimal">
									<span class="input-group-addon">
										时间：
									</span>
									<input type="text" class="form_date form-control" id="dateTimeId">
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-8 col-lg-8">
							<div class="form-group">
								<div class="input-group input-group-sm input-group-minimal">
									<span class="input-group-addon">横向参数指标：</span>
									<span class="input-group-addon">
										区域：
									</span>
									<select class="form-control s2example" id="stressSelect" onchange="queryShangQuanForList('');">
									</select>
									<span class="input-group-addon">-</span>
									<span class="input-group-addon">
										商圈：
									</span>
									<select class="form-control s2example" id="shangQuanSelect-1" onchange="queryBuildingForList('shangQuanSelect-1')">
									</select>
									<span class="input-group-addon">-</span>
									<span class="input-group-addon">
										楼盘：
									</span>
									<select class="form-control s2example" id="buildingSelect-2">
									</select>
								</div>
							</div>
						</div>
						<div class="col-sm-4 col-md-4 col-lg-2">
							<div class="form-group">
								<button class="btn btn-secondary" onclick="queryLoad();">查询</button>
								<button class="btn btn-secondary" onclick="exportData();">导出</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel">
					<div class="table-responsive">
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th class="text-center">本店组/店/片区成交套数</th>
									<th class="text-center">上一级成交套数</th>
									<th class="text-center">本公司成交套数/房产局成交套数</th>
									<th class="text-center">相对市占率</th>
									<th class="text-center">绝对市占率</th>
								</tr>
							</thead>
							<tbody id="queryDiv1">
							</tbody>
						</table>
					</div>
					<div class="pagination pull-right" id="queryDiv1Page" style="display: none;">
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="panel">
					<div class="table-responsive">
						<div class="row" style="padding: 6px;  margin: 0px;">
							<div class="col-sm-4 col-md-4 col-lg-3">
								<div class="form-group">
									<div class="input-group input-group-sm input-group-minimal">
										<span class="input-group-addon">
											指标：
										</span>
										<select class="form-control" id="reportType" onchange="reloadReport();">
											<option value="1" selected>成交数</option>
											<option value="2">相对市占率</option>
											<option value="3">绝对市占率</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6">
				 			<div style="padding:10px;clear: both;">
					    		<div id="reportData1" style="height: 350px;width: 500px"></div>
					    	</div>
					    </div>
					    <div class="col-md-6">
				 			<div style="padding:10px;clear: both;">
					    		<div id="reportData2" style="height: 350px;width: 500px"></div>
					    	</div>
					    </div> 
					    <div style="clear: both;"></div>
					</div>
					<!-- <div class="table-responsive">
						<div class="row" style="padding: 6px;  margin: 0px;">
						<div class="col-sm-4 col-md-4 col-lg-3">
							<div class="form-group">
								<div class="input-group input-group-sm input-group-minimal">
									<span class="input-group-addon">
										指标：
									</span>
									<select class="form-control">
										<option value="1">成交数</option>
										<option value="2">相对市占率</option>
										<option value="3">绝对市占率</option>
									</select>
								</div>
							</div>
						</div>
					</div>
						饼状图和统计图
					</div> -->
				</div>
				<div class="panel">
					<div class="tab-content">
						<!-- <div class="tab-pane active" id="tab-01">
							<div class="table-responsive-1150">
								<div class="row" style="display: ; padding-top: 15px;">
									<div class="col-sm-12 col-md-8 col-lg-8">
										<div class="form-group">
											<div class="input-group input-group-minimal">
												<span class="input-group-addon">横向参数指标：</span>
												<select class="form-control s2example">
													<option>全部</option>
												</select>
												<span class="input-group-addon">-</span>
												<select class="form-control s2example">
													<option>全部</option>
												</select>
												<span class="input-group-addon">-</span>
												<select class="form-control s2example">
													<option>全部</option>
												</select>
												<span class="input-group-addon">-</span>
												<select class="form-control">
													<option selected>排序</option>
													<option>成交</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-4 col-md-4 col-lg-2">
										<div class="form-group">
											<button class="btn btn-secondary">查询</button>
											<button class="btn btn-secondary" onclick="jQuery('#modal-1').modal('show', {backdrop: 'fade'});">导出</button>
										</div>
									</div>
								</div>
							</div>
							<div class="panel">
								<div class="table-responsive">
									<table class="table table-bordered table-striped">
										<thead>
											<tr>
												<th class="text-center">总监</th>
												<th class="text-center">门店</th>
												<th class="text-center">楼盘</th>
												<th class="text-center">成交套数</th>
												<th class="text-center">本公司成交套数/房产局成交套数</th>
												<th class="text-center">相对市占率</th>
												<th class="text-center">绝对市占率</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="middle-align text-center">
													1
												</td>
												<td class="middle-align text-center">
													xxxx店组001
												</td>
												<td class="middle-align text-center">
													0/2400
												</td>
												<td class="middle-align text-center">
													0/2400
												</td>
												<td class="middle-align text-center">
													0/2400
												</td>
												<td class="middle-align text-center">
													0/2400
												</td>
												<td class="middle-align text-center">
													0/2400
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="pagination pull-right">
									放翻页
								</div>
							</div>
						</div> -->
						<div class="tab-pane active" id="tab-02">
							<div class="panel">
								<div class="table-responsive">
									<table class="table table-bordered table-striped">
										<thead>
											<tr>
												<th class="text-center">楼盘名</th>
												<th class="text-center">总监</th>
												<th class="text-center">门店</th>
												<th class="text-center">店组</th>
												<th class="text-center">成交套数</th>
												<th class="text-center">本公司成交套数/房产局成交套数</th>
												<th class="text-center">相对市占率</th>
												<th class="text-center">绝对市占率</th>
											</tr>
										</thead>
										<tbody id="queryDiv2">
										</tbody>
									</table>
								</div>
								<div class="pagination pull-right" id="queryDiv2Page">
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				</div>
				<!-- Main Footer -->
			</div>
		</div>
		<div class="go-up" style="position: fixed;right: 15px; bottom: 10px; z-index: 9999;">
			<a href="#" rel="go-top" style="font-size: 24px;">
				<i class="fa-angle-up"></i>
			</a>
		</div>
		<input type="hidden" id="loginUserCityId"/>
	</body>
</html>

<!-- Bottom Scripts -->
<script src="<%=basePath%>/assets/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/assets/js/TweenMax.min.js"></script>
<script src="<%=basePath%>/assets/js/resizeable.js"></script>
<script src="<%=basePath%>/assets/js/joinable.js"></script>
<script src="<%=basePath%>/assets/js/xenon-api.js"></script>
<script src="<%=basePath%>/assets/js/xenon-toggles.js"></script>
<script src="<%=basePath%>/assets/js/moment.min.js"></script>
<!-- Imported scripts on this page -->
<script src="<%=basePath%>/assets/js/devexpress-web-14.1/js/globalize.min.js"></script>
<script src="<%=basePath%>/assets/js/devexpress-web-14.1/js/dx.chartjs.js"></script>

<!-- Imported scripts on this page  xiala-->
<link rel="stylesheet" href="<%=basePath%>/assets/js/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet" href="<%=basePath%>/assets/js/select2/select2.css">
<link rel="stylesheet" href="<%=basePath%>/assets/js/select2/select2-bootstrap.css">
<link rel="stylesheet" href="<%=basePath%>/assets/js/multiselect/css/multi-select.css">
<script src="<%=basePath%>/assets/js/rwd-table/js/rwd-table.js"></script>
<script src="<%=basePath%>/assets/js/daterangepicker/daterangepicker.js"></script>
<script src="<%=basePath%>/assets/js/datepicker/bootstrap-datepicker.js"></script>
<script src="<%=basePath%>/assets/js/timepicker/bootstrap-timepicker.min.js"></script>
<script src="<%=basePath%>/assets/js/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="<%=basePath%>/assets/js/select2/select2.min.js"></script>
<script src="<%=basePath%>/assets/js/xenon-custom.js"></script>

<link rel="stylesheet" href="<%=basePath%>/assets/js/datepicker/bootstrap-datetimepicker.min.css">
<!-- Imported scripts on this page  xiala-->
<script type="text/javascript" src="<%=basePath%>/assets/js/datepicker/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=basePath%>/assets/js/datepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<!-- JavaScripts initializations and stuff -->
<script src="<%=basePath%>/assets/js/xenon-custom.js"></script>
<script src="<%=basePath%>/js/page.js"></script>

<script type="text/javascript">
	$('.form_date').datetimepicker({
		//$('.form_date').datetimepicker({ “form_datetime” 时分秒
		language: 'zh-CN',
		weekStart: 1,
		todayBtn: 0,
		autoclose: 1,
		todayHighlight: 2,
		startView: 3,
		minView: 3,
		format: 'yyyy-mm',
		forceParse: 0
	});
	$(".form_datetime").datetimepicker({
		format: 'yyyy-mm-dd:hh:ii',
		language: 'zh-CN',
	});
</script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".s2example").select2({
			placeholder: '请输入搜索条件...',
			allowClear: true
		}).on('select2-open', function() {
			// Adding Custom Scrollbar
			$(this).data('select2').results.addClass('overflow-hidden').perfectScrollbar();
		});
		$("#loginUserCityId").val("<%=cityId%>");
		queryDiv1();
		queryAllQuYuForList();
		loadReport();
		queryDiv2();
		$(".onsubing").css("display","none");
	});
	
</script>