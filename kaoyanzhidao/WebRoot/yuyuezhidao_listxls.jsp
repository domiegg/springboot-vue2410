<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="yuyuezhidaohsgb" scope="page" class="com.bean.YuyuezhidaoBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=yuyuezhidao.xls");
%>
<html>
  <head>
    <title>ԤԼָ��</title>
  </head>

  <body >
 <%
			String sql="select * from yuyuezhidao  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>��ʦ���</td>    <td align='center'>����</td>    <td align='center'>ԤԼ��</td>    <td  width='95' align='center'>ԤԼʱ��</td>    <td align='center'>��ϵ��ʽ</td>        <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=yuyuezhidaohsgb.getAllYuyuezhidao(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.jiaoshibianhao}</td>    <td>${u.xingming}</td>    <td>${u.yuyueren}</td>    <td>${u.yuyueshijian}</td>    <td>${u.lianxifangshi}</td>        <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=yuyuezhidao'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

