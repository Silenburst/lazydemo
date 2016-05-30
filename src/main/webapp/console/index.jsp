<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@taglib uri="/struts-tags" prefix="s" %> --%>
<%@ page language="java" import="com.newenv.cxf.security.CXFSecurityUtil" %>
<%  
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/communityFocus";
    if (request.getHeader("User-Agent").toString().contains("Mobile") && CXFSecurityUtil.isLogin()){
%>
	<jsp:forward page="mobileIndex.jsp" />
<%} %>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta name="description" content="Xenon Boostrap Admin Panel" />
		<meta name="author" content="" />
		<title>楼盘精耕系统</title>
		<link rel="stylesheet" href="<%=basePath%>/assets/css/bootstrap.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/fonts/linecons/css/linecons.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/fonts/fontawesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-core.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-forms.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-components.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/xenon-skins.css">
		<link rel="stylesheet" href="<%=basePath%>/assets/css/custom.css">
		<script src="<%=basePath%>/assets/js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
		var basepath = "<%=basePath%>";
		</script>
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
			<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
		
		<style>
			body{
				overflow:hidden;
			}
		</style>
		<script type="text/javascript">
		
			var mainTab_pagesTitle = [];
// 			mainTab_pagesTitle["首页"] = 1;
			var mainTab_pageNum = 1;
			var mainTab_curTab = "";
			var mainTab_needReload = false;	//是否需要重新加载本页数据
			var headerHeight = 110;
			
			$(function(){
				/**
				* 移除一个页签。
				*/
				$('#pageTab').on('click', ' li a .close', function() {
					var tabId = $(this).parents('li').children('a').attr('href');
					var title = $(this).parents('li').text();
					title = title.substring(0,title.length-1);
					if(tabId==mainTab_curTab){
						$(this).parents('li').prev().children('a').trigger("click");
					}
					$(this).parents('li').remove('li');
					$(tabId).remove();
					mainTab_pagesTitle[title] = null;
				});

				/**
				 *显示某个页签。
				 */
				$("#pageTab").on("click", "a", function(e) {
					var title = $(this).text();
					title = title.substring(0,title.length-1);
					if(mainTab_pagesTitle[title] && mainTab_pagesTitle[title]!=null){
						mainTab_curTab = $(this).attr('href');
						e.preventDefault();
						$(this).tab('show');
						
						if(mainTab_needReload){
							try{
								$("div.tab-pane:visible").find("iframe")[0].contentWindow.reloadPage();
							} catch (e){
								$("div.tab-pane:visible").find("iframe")[0].src = $("div.tab-pane:visible").find("iframe")[0].src;
							}
							mainTab_needReload = false;
						}
					}
				});
				
				$("#main-menu a.menuitem").click(function(){
					$("#main-menu a.menuitem").removeClass("active");
					$(this).addClass("active");
					addTab($(this).text(), $(this).attr("href"));
					return false;
				});
				
				//显示第一个菜单
// 				$("#main-menu li:eq(1)").addClass("opened");
// 				$("#main-menu a.menuitem:first").trigger("click");
				//refreshTab('首页','<%=path%>/console/HomePage.html');
				refreshTab('首页','<%=path%>/console/ver.jsp');
				$(window).resize(function() {
					resize();
				});
			});
			
			/**
			 * 根据长度截取先使用字符串，超长部分追加...
			 */
			function cutString(str, len) {
			    //length属性读出来的汉字长度为1
			    if(str.length*2 <= len) {
			        return str;
			    }
			    var strlen = 0;
			    var s = "";
			    for(var i = 0;i < str.length; i++) {
			        s = s + str.charAt(i);
			        if (str.charCodeAt(i) > 128) {
			            strlen = strlen + 2;
			            if(strlen >= len){
			                return s.substring(0,s.length-1) + "...";
			            }
			        } else {
			            strlen = strlen + 1;
			            if(strlen >= len){
			                return s.substring(0,s.length-2) + "...";
			            }
			        }
			    }
			    return s;
			}

		    //点击菜单新增选项卡zj
			function addTab(title,url){
				if(mainTab_pagesTitle[title] && mainTab_pagesTitle[title]!=null){
					$("#pageTab a[href='#page"+mainTab_pagesTitle[title]+"']").trigger("click");
				} else {
					mainTab_pageNum++;
					mainTab_pagesTitle[title] = mainTab_pageNum;
					$('#pageTab').append(
						$('<li data-menuId="' + getQueryString(url,"clickedTopMenuId") + '"><a href="#page' + mainTab_pageNum + '">'
						 + title +
						'<button class="close" style="position:relative;left:18px;top:-8px" type="button" ' +
						'title="关闭">×</button>' +
						'</a></li>'));
					$('#pageTabContent').append(
						$('<div class="tab-pane" id="page' + mainTab_pageNum +
						'"><iframe id="frameTab'+mainTab_pageNum+'" src="'+url+'" width="100%" style="height:'+getMainFrameHeight()+'px" frameborder="0" marginheight="0" marginwidth="0" border="0"></iframe></div>'));
			
					//$('#page' + mainTab_pageNum).tab('show');
					$("#pageTab a[href='#page"+mainTab_pageNum+"']").trigger("click");
				}
			}
		    
		    function showTab(title){
		    	$("#pageTab a[href='#page"+mainTab_pagesTitle[title]+"']").trigger("click");
		    }
		    
			function refreshTab(title, url){
				if(mainTab_pagesTitle[title] && mainTab_pagesTitle[title]!=null){
					var content_tab = '<iframe scrolling="auto" frameborder="0"  src="'+url+'"style="width:100%;height:'+getMainFrameHeight()+'px;"></iframe>';
					$("#page"+mainTab_pagesTitle[title]).html(content_tab);
					$("#pageTab a[href='#page"+mainTab_pagesTitle[title]+"']").trigger("click");
				} else {
					addTab(title,url);
				}
			}
			
			//刷新选项卡
		   function refreshs(url){
				refreshTab("系统菜单", url);
			}
			
			//获取url中的参数值
			function getQueryString(url, name) { 
				if(url.indexOf("?")){
					url = url.substr(url.indexOf("?")+1);
					var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
					var r = url.match(reg); 
					if (r != null) return unescape(r[2]); return ""; 
				}
				return "";
			   
			}

			//获取当前tab的menuId
			function getActiveTabMenuId(){
				return $("#pageTab li.active").attr("data-menuId");
			}
			
			function resize(){
				$(".pageTabContent iframe").height(getMainFrameHeight());
			}
			
			function getMainFrameHeight(){
				return $(document).height()-headerHeight;
			}
		</script>
	</head>

	<body class="page-body">
		<div class="page-container">
			<!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->

			<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
			<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
			<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
			<div class="sidebar-menu toggle-others fixed">
				<jsp:include page="../include/left.jsp"/>
			</div>
			<div class="main-content">
				<!-- User Info, Notifications and Menu Bar -->
				<jsp:include page="../include/top.jsp"/>
				
				<ul id="pageTab" class="nav nav-tabs tw-pe">
				
				</ul>
				<div id="pageTabContent" class="tab-content" style="margin:0;padding:0">
				
				</div>
				
				<!-- Main Footer -->
			</div>

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

<!-- Imported scripts on this page -->
<script src="<%=basePath%>/assets/js/xenon-widgets.js"></script>
<script src="<%=basePath%>/assets/js/devexpress-web-14.1/js/globalize.min.js"></script>
<script src="<%=basePath%>/assets/js/devexpress-web-14.1/js/dx.chartjs.js"></script>
<script src="<%=basePath%>/assets/js/toastr/toastr.min.js"></script>

<!-- Imported scripts on this page -->
<script src="<%=basePath%>/assets/js/jquery-ui/jquery-ui.js"></script>
<script src="<%=basePath%>/assets/js/tocify/jquery.tocify.min.js"></script>
<!-- JavaScripts initializations and stuff -->
<script src="<%=basePath%>/assets/js/xenon-custom.js"></script>
