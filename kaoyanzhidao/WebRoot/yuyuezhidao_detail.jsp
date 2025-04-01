<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>预约指导详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  预约指导详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>教师编号：</td><td width='39%'>${yuyuezhidao.jiaoshibianhao}</td>     <td width='11%'>姓名：</td><td width='39%'>${yuyuezhidao.xingming}</td></tr><tr>     <td width='11%'>预约人：</td><td width='39%'>${yuyuezhidao.yuyueren}</td>     <td width='11%'>预约时间：</td><td width='39%'>${yuyuezhidao.yuyueshijian}</td></tr><tr>     <td width='11%'>联系方式：</td><td width='39%'>${yuyuezhidao.lianxifangshi}</td>     <td width='11%'>备注：</td><td width='39%'>${yuyuezhidao.beizhu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

