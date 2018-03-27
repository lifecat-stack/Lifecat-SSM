<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="include/header.jsp"%>
<%@include file="include/top.jsp"%>

<script>
	$(function() {
		$("#textarea").val("${newc.description}");
		$("#editForm").submit(function() {
			if (!checkEmpty("name", "课程描述")) {
				alert("课程描述不能为空！");
				return false;
			}

			return true;
		});
	});
</script>

<%-- 上传照片 --%>

<div class="container">
	<div class="table-responsive">
		<h2>编辑照片描述</h2>
		<form method="post" id="editForm" action="admin_course_update">
			<div class="form-group">
				<textarea class="form-control" rows="3" id="textarea" name="name"
					id="name"></textarea>
				<input type="hidden" name="id" value="${newc.cno}">
			</div>

			<button type="submit" class="btn btn-primary btn-md btn-block">提交</button>
		</form>
	</div>
</div>


<%@include file="include/footer.jsp"%>