<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yuyuezhidaohsgb" scope="page" class="com.bean.YuyuezhidaoBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yuyuezhidao.xls");
%>
<html>
  <head>
    <title>预约指导</title>
  </head>

  <body >
 <%
			String sql="select * from yuyuezhidao  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>教师编号</td>    <td align='center'>姓名</td>    <td align='center'>预约人</td>    <td  width='95' align='center'>预约时间</td>    <td align='center'>联系方式</td>        <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=yuyuezhidaohsgb.getAllYuyuezhidao(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.jiaoshibianhao}</td>    <td>${u.xingming}</td>    <td>${u.yuyueren}</td>    <td>${u.yuyueshijian}</td>    <td>${u.lianxifangshi}</td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=yuyuezhidao'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

