<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<html>
<head>
<title>在线留言</title>
<LINK href="qtimages/style.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="950" height="1043" border="0" align="center" cellpadding="0" cellspacing="0" id="__01">
	<tr>
		<td><jsp:include page="qttop.jsp"></jsp:include></td>
	</tr>
	<tr>
		<td><table id="__01" width="950" height="735" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td valign="top" background="qtimages/1_02_01_06.gif"><jsp:include page="qtleft.jsp"></jsp:include></td>
            <td valign="top" style="background:url(qtimages/1_02_02_01_02_02_03.gif) repeat-y  right center; "><table id="__01" width="744" height="735" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td valign="top"><table id="__01" width="744" height="700" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="744" height="37" background="qtimages/1_02_02_02_01.gif"><table width="100%" height="17" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="21%" align="center" valign="middle"><strong>在线留言</strong></td>
                        <td width="61%">&nbsp;</td>
                        <td width="18%"><strong><a href="lybList.do">查看留言</a></strong></td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td><table id="__01" width="744" height="700" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="11" background="qtimages/1_02_02_02_02_01.gif">&nbsp;</td>
                        <td width="712" height="169" valign="top" bgcolor="#F0F4F7">
						
						<form action="addLiuyanban.do" name="form1" method="post">
						<table width="97%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#78BAEF" style="border-collapse:collapse">
						 
                            <tr>
                              <td width="12%">昵称：</td>
                              <td width="88%"><input name='cheng' type='text' id='cheng' value='' onblur='checkform()' /> <label id='clabelcheng' />
                                *</td>
                            </tr>
                            <tr>
                              <td>头像：</td>
                              <td><input name="xingbie" type="radio" value="1" checked>
                                  <img src="img/1.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="2">
                                  <img src="img/2.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="3">
                                  <img src="img/3.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="4">
                                  <img src="img/4.gif" width="64" height="71">
                                  <input type="radio" name="xingbie" value="5">
                                  <img src="img/5.gif" width="64" height="71"></td>
                            </tr>
                            <tr>
                              <td>QQ：</td>
                              <td><input name='QQ' type='text' id='QQ' value='' /></td>
                            </tr>
                            <tr>
                              <td>邮箱：</td>
                              <td><input name='youxiang' type='text' id='youxiang' value='' /> <label id='clabelyouxiang' />必需邮箱格式</td>
                            </tr>
                            <tr>
                              <td>手机：</td>
                              <td><input name='shouji' type='text' id='shouji' value='' /> <label id='clabelshouji' /> 必需手机格式</td>
                            </tr>
                            <tr>
                              <td>内容：</td>
                              <td><textarea name="neirong" cols="50" rows="10" id="neirong" onblur='checkform()'></textarea>
                                * <label id='clabelneirong' /> </td>
                            </tr>
                            <tr>
                              <td>&nbsp;</td>
                              <td> <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
                                  <input type="reset" name="Submit22" value="重置"  /></td>
                            </tr>
                         
                   </table>
		        </form>
						  </td>
                        <td width="21" background="qtimages/1_02_02_02_02_03.gif">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td><img src="qtimages/1_02_02_02_03.gif" width="744" height="8" alt=""></td>
                  </tr>
                </table></td>
              </tr>
              
              
            </table></td>
          </tr>
        </table></td>
	</tr>
	<tr>
		<td>
		<jsp:include page="qtdown.jsp"></jsp:include>
		</td>
	</tr>
</table>
</body>
</html>

<script language=javascript >  
 
 function checkform(){  
 
	var chengobj = document.getElementById("cheng"); if(chengobj.value==""){document.getElementById("clabelcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入昵称</font>";return false;}else{document.getElementById("clabelcheng").innerHTML="  "; } 
	var xingbieobj = document.getElementById("xingbie"); if(xingbieobj.value==""){document.getElementById("clabelxingbie").innerHTML="&nbsp;&nbsp;<font color=red>请输入性别</font>";return false;}else{document.getElementById("clabelxingbie").innerHTML="  "; } 
	var youxiangobj = document.getElementById("youxiang"); if(youxiangobj.value!=""){ if(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/.test(youxiangobj.value)){document.getElementById("clabelyouxiang").innerHTML=""; }else{document.getElementById("clabelyouxiang").innerHTML="&nbsp;&nbsp;<font color=red>必需邮箱格式</font>"; return false;}}  
    var shoujiobj = document.getElementById("shouji"); if(shoujiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(shoujiobj.value)){document.getElementById("clabelshouji").innerHTML=""; }else{document.getElementById("clabelshouji").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}  
    var neirongobj = document.getElementById("neirong"); if(neirongobj.value==""){document.getElementById("clabelneirong").innerHTML="&nbsp;&nbsp;<font color=red>请输入内容</font>";return false;}else{document.getElementById("clabelneirong").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  