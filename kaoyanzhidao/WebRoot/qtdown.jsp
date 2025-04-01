<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
	<table id="__01" width="950" height="123" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td><img src="qtimages/1_03_01.gif" width="950" height="13" alt=""></td>
          </tr>
          <tr>
            <td width="950" height="85" background="qtimages/1_03_02.gif"><table width="83%" height="19%" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td height="26" align="center">版权所有：考研指导平台 技术支持：xxxxxxxxxxxxx 开发日期：<%=connDbBean.getdate()%></td>
              </tr>
              <tr>
                <td height="24" align="center">最佳效果: 1024*768 或1440*900 或 1360*768 </td>
              </tr>
              <tr>
                <td height="24" align="center">备案号：xxxxx</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td><img src="qtimages/1_03_03.gif" width="950" height="25" alt=""></td>
          </tr>
        </table>	

