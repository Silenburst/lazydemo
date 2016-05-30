﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
response.sendRedirect("http://192.168.1.85:8084/communityFocus/sec/fedservlet/");
// 	response.sendRedirect(request.getContextPath()+"/sec/fedservlet");
%>
<%
	String path = request.getContextPath();
String rootpath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;


// 	String message = "";
	
// 	if (session.getAttribute("invalidClient")!=null){
// 		  message = session.getAttribute("invalidClient").toString();
// 	}
// 	if (session.getAttribute("weixinError")!=null){
// 		  message = session.getAttribute("weixinError").toString();
// 	}
// 	if (session.getAttribute("invalidLoginTime")!=null){
// 		  message = session.getAttribute("invalidLoginTime").toString();
// 	}
// 	if (session.getAttribute("verifyCodeWrong")!=null){
// 		  message = session.getAttribute("verifyCodeWrong").toString();
// 	}
// 	if (session.getAttribute("userInfoWrong")!=null){
// 		  message = session.getAttribute("userInfoWrong").toString();
// 	}
// 	 if (session.getAttribute("wrongpassword")!=null){
// 		  message = session.getAttribute("wrongpassword").toString();
// 	}
%>


<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="description" content="Xenon Boostrap Admin Panel" />
	<meta name="author" content="" />
	<title>用户登录-楼盘字典库</title>
	<link rel="stylesheet" href="<%=path%>/assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="<%=path%>/assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="<%=path%>/assets/css/bootstrap.css">
	<link rel="stylesheet" href="<%=path%>/assets/css/xenon-core.css">
	<link rel="stylesheet" href="<%=path%>/assets/css/xenon-forms.css">
	<link rel="stylesheet" href="<%=path%>/assets/css/xenon-components.css">
	<link rel="stylesheet" href="<%=path%>/assets/css/xenon-skins.css">
	<link rel="stylesheet" href="<%=path%>/assets/css/custom.css">
	<script src="<%=path%>/js/jquery-1.11.1.min.js"></script>
	<script src="<%=path%>/js/serializejson.js"></script>
	<script type="text/javascript">var basepath = '<%=rootpath%>';</script>
	<script type="text/javascript">
				function login()
				{
					alert("请使用单点登录...");
					return false;
// 					alert($("form[name='form']").serializeJson());
// 					alert($("form[name='form']").serialize());
				    var jsonb = {};
				    jsonb.username=$("#j_username").val();
				    jsonb.password=$("#j_password").val();
				    var url = basepath+"/services/securityUserHolder/login"+jsonb.username;

					$.ajax({
						dataType:'json',
	// 					data:$("form[name='usertest']").serialize(),
// 						data: JSON.stringify(jsonb), 
						type:"post",
						url:url,
						contentType : "application/json; charset=utf-8",
						success:function(data){
							alert(data);
							window.location.href=data;
						}
					})
				}
		</script>
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body class="page-body login-light">
	<div class="login-container" style="margin-top:150px">
		<div class="row">
			<div class="col-sm-6">
				<!-- Add class "fade-in-effect" for login form effect -->
				<form method="post" name="form" id="login" class="login-form fade-in-effect">
					
					<div class="login-header">
						<a href="javascript:void(0)" class="logo">
							<h2 class="title">楼盘精耕库</h2>
							<p>尊敬的用户，登录才能访问管理领域！</p>
						</a>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="username" id="j_username" autocomplete="off" placeholder="用户名" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="password" id="j_password" autocomplete="off" placeholder="密码"  />
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<select name="title" id="selectTitle" class="form-control"> -->
<!-- 							<option value="">职位切换</option> -->
<!-- 						</select> -->
<!-- 					</div> -->
<%-- 					<%if( message!=null){ %> --%>
<!-- 						<div class="form-group"> -->
<%-- 							<a> <%=message %></a> --%>
<!-- 						</div> -->
<%-- 					<%}%> --%>
					<div class="form-group">
						<button type="submit" class="btn btn-primary  text-left" onclick="login()" id="bnLogin">
							<i class="fa-lock"></i>
							登录
						</button>
						<button type="submit" class="btn" id="bnLogin">
							<a href="http://192.168.1.85:8084/communityFocus/sec/fedservlet/">单点登录</a>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Bottom Scripts -->
	<script src="<%=path%>/assets/js/bootstrap.min.js"></script>
	<script src="<%=path%>/assets/js/TweenMax.min.js"></script>
	<script src="<%=path%>/assets/js/resizeable.js"></script>
	<script src="<%=path%>/assets/js/joinable.js"></script>
	<script src="<%=path%>/assets/js/xenon-api.js"></script>
	<script src="<%=path%>/assets/js/xenon-toggles.js"></script>
	<script src="<%=path%>/assets/js/jquery-validate/jquery.validate.min.js"></script>
	<script src="<%=path%>/assets/js/toastr/toastr.min.js"></script>
	<!-- JavaScripts initializations and stuff -->
	<script src="<%=path%>/assets/js/xenon-custom.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($)
					{
// 						// Reveal Login form
// 						setTimeout(function(){ $(".fade-in-effect").addClass('in'); }, 1);
						
// 						$("#j_username").blur(function(){
// 							var theSelect = $("#selectTitle");
// 							theSelect.find("option").remove();
// 							var username = $("#j_username").val();
// 							if(username=="")return;
// 							$.ajax({
// 						        type: "POST",
<%-- 						        url: "<%=path%>/getTitle.action?userLogin.username="+username, --%>
// 						        dataType: "json",
// 						        success: function(titles){
// 								     var str ='';
// 								     for(var i=0;i<titles.length;i++){
// 								    	 str += '<option value='+titles[i][0]+'>'+titles[i][1]+'</option>';
// 								     }
// 								     theSelect.html(str); 
// 								}
// 						    });
// 						});
						

// 						function init(){
// 							if($("#j_username").val()!=""){
// 								$("#j_username").trigger("blur");
// 							}
// 						}
						
// 						var first = true;
// 						$("#j_username").change(function(){
// 							if(first){
// 								init();
// 								first=false;
// 							}
// 						});
						
// 						// Validation and Ajax action
// 						$("form#login").validate({
// 							rules: {
// 								"login.username": {
// 									required: true
// 								},
// 								"login.password": {
// 									required: true
// 								},
// 								"title": {
// 									required: true
// 								}
// 							},
// 							messages: {
// 								"login.username": {
// 									required: '请输入您的用户名。'
// 								},
// 								"login.password": {
// 									required: '请输入您的密码。'
// 								},
// 								"title": {
// 									required: '请选择岗位。'
// 								}
// 							},
// 						});
						
						$(document).keypress(function(event){
							if(event.which==13){
								$("#bnLogin").trigger("click");
							}
						});
					});
				</script>
</body>
</html>