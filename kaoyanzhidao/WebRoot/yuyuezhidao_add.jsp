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
		<TITLE>添加预约指导</TITLE>
	    

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
	document.location.href="yuyuezhidao_add.jsp?id=<%=id%>";
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
			<form action="addYuyuezhidao.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加预约指导</td>
						</tr>
						<tr ><td width="200">教师编号：</td><td><input name='jiaoshibianhao' type='text' id='jiaoshibianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.jiaoshibianhao.value='<%=connDbBean.readzd("jiaoshixinxi","jiaoshibianhao","id",request.getParameter("id"))%>';document.form1.jiaoshibianhao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("jiaoshixinxi","xingming","id",request.getParameter("id"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		<tr ><td width="200">预约人：</td><td><input name='yuyueren' type='text' id='yuyueren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		<tr ><td width="200">预约时间：</td><td><input name='yuyueshijian' type='text' id='yuyueshijian' value='<%=connDbBean.gettime()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd HH:mm:ss'})" style='width:120px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelyuyueshijian' /></td></tr>		<tr ><td width="200">联系方式：</td><td><input name='lianxifangshi' type='text' id='lianxifangshi' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabellianxifangshi' /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
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
 
 function checkform(){  
 
	var yuyueshijianobj = document.getElementById("yuyueshijian"); if(yuyueshijianobj.value==""){document.getElementById("clabelyuyueshijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入预约时间</font>";return false;}else{document.getElementById("clabelyuyueshijian").innerHTML="  "; } 	var lianxifangshiobj = document.getElementById("lianxifangshi"); if(lianxifangshiobj.value==""){document.getElementById("clabellianxifangshi").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系方式</font>";return false;}else{document.getElementById("clabellianxifangshi").innerHTML="  "; } 	var lianxifangshiobj = document.getElementById("lianxifangshi"); if(lianxifangshiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxifangshiobj.value)){document.getElementById("clabellianxifangshi").innerHTML=""; }else{document.getElementById("clabellianxifangshi").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
