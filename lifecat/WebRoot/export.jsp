<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%><html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt'%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- 下载数据库 --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Export to Excel</title>
</head>
<body>
	<%
		System.out.println("执行输出excel 1");
		System.out.println("执行输出excel 2");
		
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "inline; filename="
				+ "excel.xls");
	%>
	
	<table align="left" border="1">
		<thead>
			<tr>
				<th>用户账号</th>
				<th>用户名</th>
				<th>图片描述</th>
				<th>上传时间</th>
				<th>图片路径</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${dcs}" var="c">

				<tr>
					<td>${c.user_id }</td>
					<td>${c.user_name }</td>
					<td>${c.image_description }</td>
					<td>${c.image_date }</td>
					<td>${c.image_path }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

</body>
</html>