
$(function(){
	getSyscsParamByName2("装修标准","zhuangxiu");
	queryBM("dianzu");
	querySCLp();
	var totalbaojing = 0;
	
});

function condition()
{
	$("#dz").parent().find("a span").eq(0).html("<option value='0'>请选择栋座</option>");
	$("#dy").parent().find("a span").eq(0).html("<option value='0'>请选择单元</option>");
	$("#dz").val(0);
	$("#dy").val(0);
   $("#biaoqian").val(0);
   $("#dianzu").val(0);
   $("#jingjiren").val(0);
    $("#statussid").val('');
   $("#panleixing").val(0);
}

function querySCLp()
{
//	alert(departmentid+"||||"+userid);
	condition();
//	queryData();
//	 queryList();
	var url = basepath + "/services/traceServices/querySCLp/"+departmentid+"/"+userid;
	$.ajax({
		url:url,
// 		data:{"city":"1111"},
		dataType:"json",
		type:"GET",
		async:false,
		success:function(result)
		{
			var pHtml = '';
			if(null==result || result=="")
			{
				pHtml += '<li ><H1>无楼盘</H1></li> ';
				$("#allnull").html(pHtml);
			   $("#totalkongzhi").text(0);
			   $("#totaldaoqi").text(0);
			}else{
				$.each(result, function(i,lp){
					if(i == 0)
					{
						pHtml += '<li style="width:100px"  class="active"  ><a href="#v4-home'+lp.id+'" title="'+lp.lp_name+'" id="a'+lp.id+'"  onclick="querySCDong('+lp.id+',\''+lp.lp_name+'\')" data-toggle="tab" >'+lp.lp_name+'</a></li> ';
						querySCDong(lp.id,lp.lp_name);
					}else
					{
						pHtml += '<li style="width:100px" ><a href="#v4-home'+lp.id+'" title="'+lp.lp_name+'"  id="a'+lp.id+'" data-toggle="tab"  onclick="querySCDong('+lp.id+',\''+lp.lp_name+'\')">'+lp.lp_name+'</a></li> ';
					}
				});
				$("#ullp").html(pHtml);
			}
		}
	});
}


function querySCDong(lpid,lpName)
{
	$("#lpid").val(lpid);
	$("#totalloupan").text(lpName);
	condition();
	queryData();
//	queryList();
	
//	var departmentid = departmentid;
//	var userid = userid;
// 	$("#"+divHtml).parent().find("div a span").eq(0).html("请选择店组");
	var url = basepath + "/services/traceServices/querySCDong/lp/"+lpid+"/"+userid;
	$.ajax({
		url:url,
// 		data:{"city":"1111"},
		dataType:"json",
		type:"GET",
		async:true,
		success:function(result)
		{
				var pHtml = '<option value="0">请选择栋座</option>';
				$.each(result, function(i,dz){
					pHtml += '<option value="'+dz.id+'" >'+dz.lpd_name+'</option>';
				});
				$("#dz").html(pHtml);
		}
	});
}

//店组选择加载
function dianzuChoose(bmid)
{
	queryBMJL(bmid,"jingjiren");
	queryData();
//	queryList();
}
//标签状态选择加载
function statussChoose(statuss,obj)
{
	$("#statussid").parent().find("a").removeClass("active");
	$(obj).addClass("active");
	$("#statussid").val(statuss);
	queryData();
//	queryList();
}

function querySCDanyuan(dzid)
{
	$("#dy").parent().find("a span").eq(0).html("<option value='0'>请选择单元</option>");
	$("#dy").val("");
	queryData();
//	queryList();
//	var departmentid = departmentid;
//	var userid =userid;
	var url = basepath + "/services/traceServices/querySCDanyuan/dz/"+dzid+"/"+userid;
	$.ajax({
		url:url,
// 		data:{"city":"1111"},
		dataType:"json",
		type:"GET",
		async:true,
		success:function(result)
		{
				var pHtml = '<option value="0">请选择单元</option>';
				$.each(result, function(i,dy){
					pHtml += '<option value="'+dy.id+'">'+dy.dy_name+'</option>';
				});
				$("#dy").html(pHtml);
		}
	});
}


function queryData(){
		var lpid = $("#lpid").val();
	    var url = basepath+"/services/traceServices/querySCTable/";
//        $('.onsubing').css("display","block");//弹出提示框
	    
	    $("#scTable2").html("");
	    $("#scTable").html("");
		$(".gengduo").hide();
		$(".gengduodianji").val("查看更多");
//		$(".gengduodianji").html("查看更多");
	    var jsonb = {};
	    jsonb.lpid=lpid;
	    jsonb.zhuangxiu=$("#zhuangxiu").val();
	    jsonb.biaoqian=$("#biaoqian").val();
	    jsonb.dianzu=$("#dianzu").val();
	    jsonb.jingjiren=$("#jingjiren").val();
	    jsonb.dzid=$("#dz").val();
	    jsonb.dyid=$("#dy").val();
//	    jsonb.mdid=departmentid;
//	    jsonb.bmid="4";
	    jsonb.cityid = cityid;
	    jsonb.statuss = $("#statussid").val();
	    jsonb.panleixing = $("#panleixing").val();
	    
	    $.ajax({
	   		url:url,
		    dataType:'json',
	   		contentType : "application/json; charset=utf-8",
		    data:	JSON.stringify(jsonb), 
		    type:"POST",
			beforeSend: function () {
		        // 禁用按钮防止重复提交
//		        $(this).attr("disabled", true);
//		        $('.onsubing').css("display","block");//弹出提示框
		    },success: function(data){
// 				$("#scTable").html("");
				if(null != data && data !="{}" && JSON.stringify(data).length !=2 && data !="")
				{
// 				    String value= jsonObject.getString(key);
					//第几个表格
					var i = 0;
					//样式为3 6 12 
					var table3 = 0;//
					var table6 = 0;
					var table12 = 0;
					var columnsCount = 0;
					//销控颜色标记时，隐藏更多数据控制
					var total = 0;
					//统计到期和空置的总数
				   for(var key in data)
					{
				   		var classcols= 0;
				        var sHtml = "";
//						alert("lpKey是:" + key);
//						alert("lp对应的值是:" + data[key]);
				        var loupan = key;
						var dataceng = data[key];
				       sHtml+='<div class="col-md-3 col-lg-3"   id="tablediv'+i+'">'
							+'			<div  class="color-box">'
							+'				<table  class="table table-bordered table-bordered-xiaokong table-striped text-center middle-align" >'
							+'					<thead>'
							+'						<tr>'
							+'							<td colspan="100" title="'+loupan+'" onclick="">'+(loupan.length>=22?(loupan.substring(0,22)+".."):loupan)+'</td>'
							+'						</tr>'
							+'					</thead>'
							+'					<tbody>';
							if(null == dataceng)
							{
								continue;
							}
							
							var maxfhtotal = 0;
						    for(var keyceng in dataceng)
							{
//								alert("cengKey是:" + keyceng);
//								alert("ceng对应的值是:" + dataceng[keyceng]);
						    	var ceng = keyceng;
								var datafanghao = dataceng[keyceng];
								 sHtml+='<tr><td width="50">'+ceng+'</td>';
								 
								 maxtotalfanghao = datafanghao.length;
								 if(maxfhtotal  < maxtotalfanghao)
								 {
									 maxfhtotal = maxtotalfanghao;
								 }
								if(null != datafanghao && datafanghao.length > 0)
								{
									var tablelength = 0;
									var wufangyuanshu = 0;

									for(var j=0;j<datafanghao.length;j++)
									{
										var keyfanghao =  datafanghao[j];
										if(keyfanghao.indexOf("#")<0)
										{
											continue;
										}
										var fanghaodata  = keyfanghao.split("#");
										var baojing		   = fanghaodata[0];
										var fanghao = fanghaodata[1];
										var jgcount= fanghaodata[2];
										if(baojing==1){
											totalbaojing++;
											sHtml+='<td  class="text-left color-00" style="width:100px"><span class="">';
										} else if(baojing==0){
											sHtml+='<td  class="text-left color-01" style="width:100px"><span >';
										}
										if(jgcount >= 2){
											sHtml+=fanghao+'(' + jgcount + '个)</span></td>';
										}else{
											sHtml+=fanghao+'</span></td>';
										}										
										tablelength+=fanghao.length;
									}
//									wufangyuanshu = maxtotalfanghao - datafanghao.length;
//									if(wufangyuanshu>0)
//									{
//										for(wi = 0 ; wi < wufangyuanshu ; wi++){
//											sHtml+='<td  class="text-left"><span   class="btn btn-white btn-xs">[无房源]</span></td>';
//											tablelength+='无房源'.length;
//										}
//									}
								}
								classcols = 3;
								if((tablelength>=12 && tablelength<20)||maxfhtotal>=4)
								{
									classcols = 6;
								}
								if(tablelength>=20 || maxfhtotal>=8)
								{
									classcols = 12;
								}
								sHtml+='</tr>';
						    }
						sHtml+='					</tbody>'
						+'				</table>'
						+'			</div>'
						+'		</div>';
			       		 
			       		 if(columnsCount+classcols>12){
			       		 	$("#scTable").append("<div class='clearfix' style='margin-top: 20px'></div>");
			       		 	columnsCount = 0;
			       		 	total=1;
			       		 }
			       		 
			       		 if(total ==1)
			       		 {
			       			 $("#scTable2").append(sHtml);
			       		 }else
			       		 {
			       			 $("#scTable").append(sHtml);
			       		 }
			       		 
 			       		 columnsCount = columnsCount + classcols;
			       		if(classcols==3)
						{
							table12 = 0;
							table3++;
						}
			       		if(classcols==6)
						{
							$("#tablediv"+i).removeClass("col-md-3");
							$("#tablediv"+i).addClass("col-md-6");
							table12=0;
							table6++;
						}
						 if(classcols==12)
						{
							$("#tablediv"+i).removeClass("col-md-3");
							$("#tablediv"+i).addClass("col-md-12");
							table12 ++;
							table6 = 0;
							table3 = 0;
						}
						classcols = 0;
			       		 i++;
					}
				   $("#totalbaojing").text(totalbaojing);
				   
				}else
				{
					 $("#totalbaojing").text(0);
				}
		     },
		    complete: function () {
				i = 0;
				table3 = 0;//一行4
				table6 = 0;
				table12 = 0;
				columnsCount = 0;
				total = 0;
		    },
		    error: function (data) {
		        console.info("error: " + data.responseText);
		        $("#scTable").html("数据异常，请稍候重试，如遇问题请联系楼盘字典研发部");
//	        	$('.onsubing').css("display","none");//弹出提示框
		    }
	    });

	    totalbaojing = 0;
	    queryList();
	};
	