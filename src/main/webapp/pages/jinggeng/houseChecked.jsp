<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ include file="../fenpai/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>精耕审核</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Xenon Boostrap Admin Panel" />
	<meta name="author" content="" />
	<title>销控管理</title>
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
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	<style>
	@media screen and (max-width: 1950px)
		{
			.table-responsive {
			    width: 100%;
			    margin-bottom: 13.5px;
			    overflow-y: hidden;
			    overflow-x: auto;
			    -ms-overflow-style: -ms-autohiding-scrollbar;
			    border: 1px solid #eeeeee;
			    -webkit-overflow-scrolling: touch;
			}
			.table-responsive > .table > thead > tr > th, .table-responsive > .table > tbody > tr > th, .table-responsive > .table > tfoot > tr > th, .table-responsive > .table > thead > tr > td, .table-responsive > .table > tbody > tr > td, .table-responsive > .table > tfoot > tr > td {
			    white-space: nowrap;
			}
		}
		.tabs-vertical-env .nav.tabs-vertical {
		    min-width: 70px;
		    width: 50px;
		}
		.nav > li a{
		    height: auto !important;
		   
		}
		.tabs-vertical-env .nav.tabs-vertical li > a{ word-wrap: break-word !important;white-space:inherit;}
		.nav > li > a {
		    padding-left: 5px !important;
		    padding-right: 5px !important;
		}
		.tabs-vertical-env .tab-content{ padding: 15px 30px;}
		.height800{max-height: 800px;  overflow-y: auto;}
		.select2-arrow{ margin-right: 0px !important;}
	</style>
</head>
<body class="page-body">
		<div class="page-container">
			<!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->

			<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
			<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
			<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
			<div class="main-content">
				<div class="page-title">
					<div class="breadcrumb-env pull-left">
						<ol class="breadcrumb bc-1">
							<li>
								<a href="#"><i class="fa-home"></i>首页</a>
							</li>
							<li>
								<a href="小区列表.html">业主资料</a>
							</li>
							<li class="active">
								<strong>人对户分派</strong>
							</li>
						</ol>

					</div>

				</div>
				<div class="panel panel-default">
					<div class="table-responsive-1150">
						<div class="panel-body" style="padding-top:0px;">
							<table class="table xuanze" style=" min-width: 1050px;">
								<tbody>
									<tr>
										<td>
											<span id="time"><i class="fa-caret-right"></i> 时间</span>
											<input type="hidden" id="timeCondition"/>
											<a href="#" onclick="chooseCondition('time',1,this);" class="active">今天</a>
											<a href="#" onclick="chooseCondition('time',2,this);">昨天</a>
											<a href="#" onclick="chooseCondition('time',3,this);">最近7天</a>
											<a href="#" onclick="chooseCondition('time',4,this);">最近30天</a>
										</td>
									</tr>
									<tr>
										<td>
											<span id="status"><i class="fa-caret-right"></i> 状态</span>
											<input type="hidden" id="statusCondition"/>
											<a href="#" onclick="chooseCondition('status','hhh',this);" class="active">全部</a>
											<a href="#" onclick="chooseCondition('status','接触期',this);">接触</a>
											<a href="#" onclick="chooseCondition('status','委托期',this);">委托</a>
											<a href="#" onclick="chooseCondition('status','了解需求',this);">了解需求</a>
											<a href="#" onclick="chooseCondition('status','客户需求',this);">客户需求</a>
											<a href="#" onclick="chooseCondition('status','合同洽谈',this);">合同洽谈</a>
										</td>
									</tr>
									<tr>
										<td>
											<span class="pull-left" style="line-height: 32px;"><i class="fa-caret-right"></i> 筛选</span>
											<div class="col-sm-4 col-md-4 col-lg-2">
												<!-- <div class="form-group">
													<div class="input-group input-group-sm input-group-minimal">
														<span class="input-group-addon">
															店组：
														</span>
														<input class="form-control" type="text" id="storeSelect" >
													</div>
												</div> -->
												<div class="input-group input-group-sm input-group-minimal">
													<span class="input-group-addon">
														店组：
													</span>
													<select class="form-control s2example" id="storeSelect" onchange="queryAgentForListPost();">
													
													</select>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 col-lg-2" >
												<!-- <div class="form-group">
													<div class="input-group input-group-sm input-group-minimal">
														<span class="input-group-addon">
															经纪人：
														</span>
														<input class="form-control" type="text" id="agentSelect" >
													</div>
												</div> -->
												<div class="input-group input-group-sm input-group-minimal">
													<span class="input-group-addon">
														经纪人：
													</span>
													<select class="form-control s2example" id="agentSelect">
													
													</select>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 col-lg-2" >
												<!-- <div class="form-group">
													<div class="input-group input-group-sm input-group-minimal">
														<span class="input-group-addon">
															楼盘名称：
														</span>
														<input class="form-control" type="text" id="lpxxSelect" >
													</div>
												</div> -->
												<div class="input-group input-group-sm input-group-minimal">
													<span class="input-group-addon">
														楼盘名称：
													</span>
													<select class="form-control s2example" id="lpxxSelect" onchange="querydzForListPost();">
													
													</select>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 col-lg-2">
												<!-- <div class="form-group">
													<div class="input-group input-group-sm input-group-minimal">
														<span class="input-group-addon">
															栋座：
														</span>
														<input class="form-control" type="text" id="dzSelect" >
													</div>
												</div> -->
												<div class="input-group input-group-sm input-group-minimal">
													<span class="input-group-addon">
														栋座：
													</span>
													<select class="form-control s2example" id="dzSelect" onchange="queryUnitForListPost();">
													
													</select>
												</div>
											</div>
											<div class="col-sm-4 col-md-4 col-lg-2">
												<!-- <div class="form-group">
													<div class="input-group input-group-sm input-group-minimal">
														<span class="input-group-addon">
															单元：
														</span>
														<input class="form-control" type="text" id="unitSelect" >
													</div>
												</div> -->
												<div class="input-group input-group-sm input-group-minimal">
													<span class="input-group-addon">
														单元：
													</span>
													<select class="form-control s2example" id="unitSelect">
													
													</select>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<div class="col-sm-6 col-md-6 col-lg-4">
												<div class="form-group">
													<div class="input-group input-group-minimal">
														<span class="input-group-addon red">时间：</span>
														<input type="text" class="form-control form_date" id="startTime">
														<span class="input-group-addon">-</span>
														<input type="text" class="form-control form_date" id="endTime">
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-4">
												<div class="form-group">
													<button class="btn btn-success" onclick="queryList(1)">查询</button>
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="panel">
					<div class="panel-heading">
						<h3 class="panel-title">审核列表</h3>
					</div>
					<div class="panel-body">
						<div class="table-responsive-1950">
							<table class="table table-bordered table-striped">
								<thead>
									<tr>
										<th class="col-cb middle-align text-center" width="50">
											<input type="checkbox" class="cbr" />
										</th>
										<th class="text-center">店组</th>
										<th class="text-center" >经纪人</th>
										<th class="text-center" >楼盘名称/栋/单元/房号</th>
										<th class="text-center" >楼盘等级</th>
										<th class="text-center" >跟进信息</th>
										<th class="text-center" >状态</th>
										<th class="text-center" >语音</th>
										<th class="text-center" >时间</th>
										<th class="text-center" >操作</th>
									</tr>
								</thead>
								<tbody id="lpjgInfoList">
								
								</tbody>
							</table>
						</div>
						<div class="pagination pull-right" id="lpjgInfoListPag">
								
						</div>
						<div style="clear: both;"></div>
					</div>
				</div>
				<!-- Main Footer -->
			</div>

		</div>

		<div class="go-up" style="position: fixed;right: 15px; bottom: 10px; z-index: 9999; background: #f7aa47;padding: 10px;filter:alpha(opacity=50);moz-opacity:0.5;opacity:0.5;">
			<a href="#" rel="go-top">
				<i class="fa-arrow-up" style="font-size: 3em;"></i>
			</a>
		</div>
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
<!-- Imported scripts on this page  xiala-->
<script src="<%=basePath%>/assets/js/xenon-custom.js"></script>

<script type="text/javascript">
	$('.form_date').datetimepicker({
		language: 'zh-CN',
		weekStart: 1,
		todayBtn: 1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
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
	});
</script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$("#timeCondition").val(1);
		queryList(1);
		queryLpxxForListPost();
		queryStoreForListPost();
	});
	
	function chooseCondition(id,value,obj){
		$("#"+id).parent().find("a").removeClass("active");
		$(obj).addClass("active");
		$("#"+id+"Condition").val(value);
	}
	
	function queryList(pageIndex){
		$("#lpjgInfoList").empty();
		var postParameter = new Object();
		var requestParameter = new Object();
		var pageInfo = new Object();
		pageInfo.page = pageIndex;
		requestParameter.timeStatus = $("#timeCondition").val();
		requestParameter.buildingIdStr = $("#lpxxSelect option:selected").attr("id");
		requestParameter.ldId = $("#dzSelect option:selected").attr("id");
		requestParameter.unitId = $("#unitSelect option:selected").attr("id");
		requestParameter.startTime = $("#startTime").val();
		requestParameter.endTime = $("#endTime").val();
		requestParameter.mdId = $("#storeSelect option:selected").attr("id");
		requestParameter.jjrId = $("#agentSelect option:selected").attr("id");
		requestParameter.status = $("#statusCondition").val();
		postParameter.pageInfo = pageInfo;
		postParameter.requestParameter = requestParameter;
		var dataJson = JSON.stringify(postParameter);
		
		var url = "<%=basePath%>/services/houseService/querylpjgInfoForList";
		
		var result = $.ajax({
			url : url,
			data : dataJson,
			dataType : "json",
			type : "POST",
			contentType : "application/json;charset=UTF-8",
			async : false
		});
		
		var resultArr = result.responseJSON.listJson.gridModel;
		var html = "";
		if(null == resultArr || typeof(resultArr) == "undefined"){
			
		}else{
			for(var i = 0;i< resultArr.length; i++){
				var resultData = resultArr[i];
				var flag = resultData.flag == 1 ? "有效":"无效";
				var department_name = resultData.department_name == null ? "":resultData.department_name;
				var belongername = resultData.belongername == null ? "":resultData.belongername;
				var lp_name = resultData.lp_name == null ? "":resultData.lp_name;
				var lpd_name = resultData.lpd_name == null ? "":resultData.lpd_name;
				var dy_name = resultData.dy_name == null ? "":resultData.dy_name;
				var fanghao = resultData.fanghao == null ? "":resultData.fanghao;
				var level = resultData.level == null ? "":resultData.level;
				var messages = resultData.messages == null ? "":resultData.messages;
				var href = '';
				if(resultData.flag == 1){
					href = '<a href="javascript:invalidHouse(\''+resultData.id+'\',\''+resultData.type+'\',\''+resultData.flag+'\')" class="btn btn-danger btn-xs">无效</a>';
				}else{
					href = '<a href="javascript:void(0)" class="btn btn-gray btn-xs">无效</a>';
				}
				
				html +='<tr><td class="col-cb middle-align text-center"><input type="checkbox" class="cbr" /></td>'+
				'<td class="middle-align text-center">'+department_name+'</td>'+
				'<td class="middle-align text-center">'+belongername+'</td>'+
				'<td class="middle-align text-center">'+lp_name+'/'+lpd_name+'/'+dy_name+'/'+fanghao+'</td>'+
				'<td class="middle-align text-center">'+level+'</td>'+
				'<td class="middle-align text-center">'+messages+'</td>'+
				'<td class="middle-align text-center">'+flag+'</td>'+
				'<td class="middle-align text-center"></td>'+
				'<td class="middle-align text-center">'+resultData.modifydate+'</td>'+
				'<td class="middle-align text-center">'+href+'</td></tr>';
			}
			$("#lpjgInfoList").append(html);
			page("lpjgInfoListPag",result.responseJSON.listJson.page,result.responseJSON.listJson.total,null,pageIndex,0);
		}
	}
	
	
	function queryLpxxForListPost(){
		$("#lpxxSelect").empty();
		var url = "<%=basePath%>/services/houseService/queryLpxxForListPost";
		var requestParameter = new Object();
		requestParameter.creatorId = "<%=prefId%>";
		var dataJson = JSON.stringify(requestParameter);
		var result =$.ajax({
			url : url,
			data : dataJson,
			type : "POST",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			async : false
		});
		
		var resultArr = result.responseJSON;
		var html ="<option id='-1'>请选择楼盘</option>";
		if(null == resultArr || typeof(resultArr) == "undefined"){
			
		}else{
			for(var i = 0;i<resultArr.length;i++){
				var resultData = resultArr[i];
				html += "<option id='"+resultData.id+"'>"+resultData.name+"</option>";
			}
		}
		$("#lpxxSelect").append(html);
	}
	
	function querydzForListPost(){
		$("#dzSelect").empty();
		var url = "<%=basePath%>/services/houseService/querydzForListPost";
		var requestParameter = new Object();
		requestParameter.buildingIdStr = $("#lpxxSelect option:selected").attr("id");
		var dataJson = JSON.stringify(requestParameter);
		var result =$.ajax({
			url : url,
			data : dataJson,
			type : "POST",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			async : false
		});
		
		var resultArr = result.responseJSON;
		var html ="<option id='-1'>请选择栋座</option>";
		if(null == resultArr || typeof(resultArr) == "undefined"){
			
		}else{
			for(var i = 0;i<resultArr.length;i++){
				var resultData = resultArr[i];
				html += "<option id='"+resultData.id+"'>"+resultData.lpd_name+"</option>";
			}
			
		}
		$("#dzSelect").append(html);
		$('#dzSelect').select2().select2();
		queryUnitForListPost();
		
	}
	
	function queryUnitForListPost(){
		$("#unitSelect").empty();
		var url = "<%=basePath%>/services/houseService/queryUnitForListPost";
		var requestParameter = new Object();
		requestParameter.ldId = $("#dzSelect option:selected").attr("id");
		var dataJson = JSON.stringify(requestParameter);
		var result =$.ajax({
			url : url,
			data : dataJson,
			type : "POST",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			async : false
		});
		
		var resultArr = result.responseJSON;
		var html ="<option id='hhh'>请选择单元</option>";
		if(null == resultArr || typeof(resultArr) == "undefined"){
			
		}else{
			for(var i = 0;i<resultArr.length;i++){
				var resultData = resultArr[i];
				html += "<option id='"+resultData.id+"'>"+resultData.dy_name+"</option>";
			}
			
		}
		$("#unitSelect").append(html);
		$('#unitSelect').select2().select2();
	}
	
	function queryStoreForListPost(){
		$("#storeSelect").empty();
		var url = "<%=basePath%>/services/houseService/queryStoreForListPost";
		var requestParameter = new Object();
		requestParameter.departmentId = "<%=departmentId%>";
		var dataJson = JSON.stringify(requestParameter);
		var result =$.ajax({
			url : url,
			data : dataJson,
			type : "POST",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			async : false
		});
		
		var resultArr = result.responseJSON;
		var html ="<option id='-1'>请选择店组</option>";
		if(null == resultArr || typeof(resultArr) == "undefined"){
			
		}else{
			for(var i = 0;i<resultArr.length;i++){
				var resultData = resultArr[i];
				html += "<option id='"+resultData.id+"'>"+resultData.department_name+"</option>";
			}
		}
		$("#storeSelect").append(html);
	}
	
	function queryAgentForListPost(){
		$("#agentSelect").empty();
		var url = "<%=basePath%>/services/houseService/queryAgentForListPost";
		var requestParameter = new Object();
		requestParameter.departmentId = $("#storeSelect option:selected").attr("id");
		var dataJson = JSON.stringify(requestParameter);
		var result =$.ajax({
			url : url,
			data : dataJson,
			type : "POST",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			async : false
		});
		
		var resultArr = result.responseJSON;
		var html ="<option id='-1'>请选择经纪人</option>";
		if(null == resultArr || typeof(resultArr) == "undefined"){
			
		}else{
			for(var i = 0;i<resultArr.length;i++){
				var resultData = resultArr[i];
				html += "<option id='"+resultData.id+"'>"+resultData.fullname+"</option>";
			}
		}
		$("#agentSelect").append(html);
		$('#agentSelect').select2().select2();
	}
	
	function queryLpxxForList(){
		var url = "<%=basePath%>/services/houseService/queryLpxxForList";
		$("#lpxxSelect").select2({
			minimumInputLength: 1,
			placeholder: '请输入楼盘名称搜索',
			ajax: {
				url: "<%=basePath%>/services/houseService/queryLpxxForList",
				type: "GET",
				dataType: 'json',
				quietMillis: 100,
				data: function(term, page) {
					return {
						"keyWord": term,
						"profileId" : 57
					};
				},
				results: function(data, page ) {
					return { results: data.result }
				}
			},
			formatResult: function(obj) { 
				return "<div class='select2-user-result'>" + obj.lp_name+"</div>";
			},
			formatSelection: function(obj) {
				return obj.lp_name;
				$("#lpxxSelect").val(obj.id);
			}
		}).on("change",function(e){
			
		});
	}
	
	function querydzForList(){
		$("#dzSelect").select2({
			minimumInputLength: 1,
			placeholder: '请输入栋座名称搜索',
			ajax: {
				url: "<%=basePath%>/services/houseService/querydzForList",
				type: "GET",
				dataType: 'json',
				quietMillis: 100,
				data: function(term, page) {
					return {
						"keyWord": term,
						"lpId" : $("#lpxxSelect").val()
					};
				},
				results: function(data, page ) {
					return { results: data.result }
				}
			},
			formatResult: function(obj) { 
				return "<div class='select2-user-result'>" + obj.lpd_name+"</div>";
			},
			formatSelection: function(obj) {
				return obj.lpd_name;
				$("#lpxxSelect").val(obj.id);
			}
		}).on("change",function(e){
			
		});
	}
	
	function queryUnitForList(){
		$("#unitSelect").select2({
			minimumInputLength: 1,
			placeholder: '请输入单元名称搜索',
			ajax: {
				url: "<%=basePath%>/services/houseService/queryUnitForList",
				type: "GET",
				dataType: 'json',
				quietMillis: 100,
				data: function(term, page) {
					return {
						"keyWord": term,
						"dzId" : $("#dzSelect").val()
					};
				},
				results: function(data, page ) {
					return { results: data.result }
				}
			},
			formatResult: function(obj) { 
				return "<div class='select2-user-result'>" + obj.dy_name+"</div>";
			},
			formatSelection: function(obj) {
				return obj.dy_name;
				$("#lpxxSelect").val(obj.id);
			}
		}).on("change",function(e){
			
		});
	}
	
	
	function queryStoreForList(){
		var html = "<div class='select2-user-result'>请选择店组</div>";
		$("#storeSelect").select2({
			minimumInputLength: 1,
			placeholder: '请输入店组名称搜索',
			ajax: {
				url: "<%=basePath%>/services/houseService/queryStoreForList",
				type: "GET",
				dataType: 'json',
				quietMillis: 100,
				data: function(term, page) {
					return {
						"keyWord": term,
						"departmentId" : 1
					};
				},
				results: function(data, page ) {
					return { results: data.result }
				}
			},
			formatResult: function(obj) { 
				return "<div class='select2-user-result'>" + obj.department_name+"</div>";
			},
			formatSelection: function(obj) {
				return obj.department_name;
				$("#storeSelect").val(obj.id);
			}
		}).on("change",function(e){
			
		});
	}
	
	
	function queryAgentForList(){
		$("#agentSelect").select2({
			minimumInputLength: 1,
			placeholder: '请输入经纪人名称搜索',
			ajax: {
				url: "<%=basePath%>/services/houseService/queryAgentForList",
				type: "GET",
				dataType: 'json',
				quietMillis: 100,
				data: function(term, page) {
					return {
						"keyWord": term,
						"storeId" : $("#storeSelect").val()
					};
				},
				results: function(data, page ) {
					return { results: data.result }
				}
			},
			formatResult: function(obj) { 
				return "<div class='select2-user-result'>" + obj.fullname+"</div>";
			},
			formatSelection: function(obj) {
				return obj.fullname;
				$("#agentSelect").val(obj.id);
			}
		}).on("change",function(e){
			
		});
	}
	
	function invalidHouse(lpjgId,type,flag){
		if(flag == 0){
			alert("已经设置为无效");
			return;
		}
		var url = "<%=basePath%>/services/houseService/invalidHouse";
		var requestParameter = new Object();
		requestParameter.lpjgId = lpjgId;
		requestParameter.type = type;
		var dataJson = JSON.stringify(requestParameter);
		var result = $.ajax({
			url : url,
			data : dataJson,
			type : "POST",
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			async : false
		});
		
		var resultData = $.parseJSON(result.responseText);
		if(resultData.result == 1){
			alert("设置成功");
		}else{
			alert("设置失败");
		}
		
		queryList(1);
	}
	
	function page(paginationId,page,total,historyPageIndex,pageIndex,flag){
		var paginationHtml = '<div style="float:right;" id="paginationId">' +
		'<input id="pageNum" name="pageNum" type="hidden" value="10">'+
		'<div id="macPageWidget"></div>' +
		'<div class="clearfix"></div>'+
		'<div class="clear"></div>'+
	 	'</div>';
		
		if(flag == 1){
			$("#paginationId").remove();
		}
	 	
	 	if($("#paginationId").length == 0){
	 		$("#"+paginationId).append(paginationHtml);
	 	}
	    // 分页.
		$('#macPageWidget').html(pagination(page, total));
	 	bindPageEvent(paginationId);
	    // 分页高亮.
		if(historyPageIndex==undefined || historyPageIndex==null){
			historyPageIndex = 1;
		}
		$("#macPageWidget li a[pagenum='"+pageIndex+"']").addClass("pageOpen");
	}
	
	var historyPageIndex;
	function bindPageEvent(func){
		var links = $("#macPageWidget li").find("a");
		$.each(links, function(i, link1){
			var link = $(link1);
			var pageNum = link.attr("pageNum");
			link.click(function(){
				jumpPage(pageNum);
			});
		});
	}
	
	function jumpPage(pageNum){
		queryList(pageNum);
	}
</script>