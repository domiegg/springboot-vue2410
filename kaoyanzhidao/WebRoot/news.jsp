<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<html>
<head>
<title>内容详细</title>
<LINK href="qtimages/style.css" type=text/css rel=stylesheet>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
 <%
  String lb=request.getParameter("lb");
  //String lb=new String(request.getParameter("lb").getBytes("8859_1"));
%>
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
                <td valign="top"><table id="__01" width="744" height="256" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="744" height="44" background="qtimages/1_02_02_01_01.gif"><table width="100%" height="17" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="31%" align="center" valign="middle"><strong><%=lb%></strong></td>
                        <td width="69%">&nbsp;</td>
                      </tr>
                    </table></td>
                  </tr>
                  <tr>
                    <td valign="top">
					
					
					  <table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#FA9090" class="newsline" style="border-collapse:collapse">
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                          <tr>
                            <td width="29" align="center"><%=i %></td>
                            <td width="428"><a href="xwtzDetail.do?id=${u.id}">${u.biaoti}</a></td>
                            <td width="74">被点${u.dianjilv}次</td>
                            <td width="146" align="center">${u.addtime}</td>
                          </tr>
                         </c:forEach>
                        </table>
                          <div align="center"><br>
                           <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="xwtzList.do?page=1&lb=<%=lb%>" >首页</a>
             <a href="xwtzList.do?page=${page.page-1}&lb=<%=lb%>"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xwtzList.do?page=${page.page+1}&lb=<%=lb%>">下一页</a>
			<a href="xwtzList.do?page=${page.totalPage}&lb=<%=lb%>">末页</a>		    </c:if>		
	</c:if>
	</div>
							
							
					  </td>
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