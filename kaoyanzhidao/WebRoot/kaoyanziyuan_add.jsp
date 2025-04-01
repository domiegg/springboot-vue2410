<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>添加考研资源</TITLE>
	    

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="kaoyanziyuan_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addKaoyanziyuan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加考研资源</td>
						</tr>
						<tr ><td width="200">资源编号：</td><td><input name='ziyuanbianhao' type='text' id='ziyuanbianhao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelziyuanbianhao' /></td></tr>		<tr ><td width="200">资源名称：</td><td><input name='ziyuanmingcheng' type='text' id='ziyuanmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelziyuanmingcheng' /></td></tr>		<tr ><td width="200">文件：</td><td><input name='wenjian' type='text' id='wenjian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('wenjian')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">详细：</td><td><textarea name='xiangxi' cols='50' rows='5' id='xiangxi' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr ><td width="200">发布人：</td><td><input name='faburen' type='text' id='faburen' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>




<script language=javascript >  
function hsgcheck() {
		var ziyuanbianhao = $("#ziyuanbianhao").val();
		if(ziyuanbianhao==""||(ziyuanbianhao.length<6||ziyuanbianhao.length>12)){
			 $("#clabelziyuanbianhao").html("<font color=red>资源编号不能为空且长度在3～12位之间！</font>");
			 $("input[id=ziyuanbianhao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelziyuanbianhao").html("");
			$.ajax({
				url : "quchongKaoyanziyuan.do",
				type : "post",
				data : "ziyuanbianhao=" + ziyuanbianhao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelziyuanbianhao").html("<font color=red>资源编号已存在，请更换！</font>");
					$("input[id=ziyuanbianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelziyuanbianhao").html("系统异常，请检查错误！");
					$("input[id=ziyuanbianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var ziyuanbianhaoobj = document.getElementById("ziyuanbianhao"); if(ziyuanbianhaoobj.value==""){document.getElementById("clabelziyuanbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入资源编号</font>";return false;}else{document.getElementById("clabelziyuanbianhao").innerHTML="  "; } 	var ziyuanmingchengobj = document.getElementById("ziyuanmingcheng"); if(ziyuanmingchengobj.value==""){document.getElementById("clabelziyuanmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入资源名称</font>";return false;}else{document.getElementById("clabelziyuanmingcheng").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
