<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>考研资源详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  考研资源详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>资源编号：</td><td width='39%'>${kaoyanziyuan.ziyuanbianhao}</td>     <td width='11%'>资源名称：</td><td width='39%'>${kaoyanziyuan.ziyuanmingcheng}</td></tr><tr>     <td width='11%'>文件：</td><td width='39%'><a href="${kaoyanziyuan.wenjian}">点此下载</a></td>     <td width='11%'>详细：</td><td width='39%'>${kaoyanziyuan.xiangxi}</td></tr><tr>     <td width='11%'>发布人：</td><td width='39%'>${kaoyanziyuan.faburen}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

