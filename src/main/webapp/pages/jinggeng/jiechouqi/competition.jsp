<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!--竞争对手跟进-->
<div class="panel" id="jc_duishougenjin" style="display: none;">
	<!-- <div class="panel-heading">
		<h3 class="panel-title">该房间在系统中处于进行XX状态，但您可以按您精耕后的状态做下列操作</h3>
	</div> -->
	<div class="panel-body">
		<div class="form-group">
			<div class="row">
				<div class="col-sm-4 col-md-4 col-lg-3">
					<div class="form-group">
						<div class="input-group input-group-sm input-group-minimal">
							<span class="input-group-addon">
								需求：
							</span>
							<select class="form-control s2example" id="com_req">
								<option >已租</option>
								<option >已售</option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4 col-md-4 col-lg-3">
					<div class="form-group">
						<div class="input-group input-group-sm input-group-minimal">
							<span class="input-group-addon">
								价格：
							</span>
							<input type="text" class="form-control" id="com_price">
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-6 col-lg-3">
					<div class="form-group">
						<div class="input-group input-group-sm input-group-minimal">
							<span class="input-group-addon">
								租期：
							</span>
							<input class="form-input form_date col-lg-12 col-md-6 col-sm-6" placeholder="" id="com_startdate">
							<span class="input-group-addon">
								-
							</span>
							<input class="form-input form_date col-lg-12 col-md-6 col-sm-6" placeholder="" id="com_enddate">
						</div>
					</div>
				</div>
				<div class="col-sm-4 col-md-4 col-lg-3">
					<div class="form-group">
						<div class="input-group input-group-sm input-group-minimal">
							<span class="input-group-addon" >
								竞争公司：
							</span>
							<select class="form-control" id="company">
								<option value="1">公司1</option>
								<option value="2">公司2</option>
							</select>
						</div>
					</div>
				</div>
				<div class="col-md-12 col-sm-12">
					<div class="form-group">
						<div class="input-group input-group-minimal">
							<span class="input-group-addon">备注：</span>
							<textarea class="form-control" id="com_remark"></textarea>
						</div>
					</div>
				</div>
			</div>
			<button class="btn btn-secondary btn-icon btn-icon-standalone" id="competition_save" style="padding: 0px !important; margin-top: 10px;">
				<i class="fa-print"></i>
				<span onclick="saveCompetition()">确认</span>
			</button>
		</div>
	</div>
</div>


<script type="text/javascript">
function saveCompetition(){
		var params = new Object();
		params.fhid = $("#fanghao").val();
		params.requires = $("#com_req").val();
		params.price = $("#com_price").val();
		params.startdate = $("#com_startdate").val();
		params.enddate = $("#com_enddate").val();
		params.company = $("#company").val();
		params.remarks = $("#com_remark").val();
		params.stage = checkStage();
		var dataJson = JSON.stringify(params);
		$.ajax({
			url: "<%=basePath%>/services/refineService/saveCompetition",
			type : "POST",
			dataType : "json",
			data : dataJson ,
			contentType : "application/json;charset=UTF-8",
			async : false,
			success: function(data){
	 			alert("操作成功");
	 			window.location.href = "<%=basePath%>/services/refineService/mainPage/2/" + params.fhid  +"/" + idx;
	 		}
		})
	}
</script>				