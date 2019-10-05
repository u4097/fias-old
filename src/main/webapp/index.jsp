<%@ page import="java.util.Properties" %>
<%--
	Created by IntelliJ IDEA.
	User: dym
	Date: 29.11.12
	Time: 18:10
	To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
	<title>FIAS service</title>
</head>
<body>
<%
	Properties buildInfo = new Properties();
	buildInfo.load(this.getClass().getClassLoader().getResourceAsStream("hudsonBuild.properties"));
%>
build <%=buildInfo.get("build.number")%> rev.<%=buildInfo.get("build.svnRevision")%> (<%=buildInfo.get("build.user.id'")%>) <%=buildInfo.get("build.started")%>
</body>
</html>