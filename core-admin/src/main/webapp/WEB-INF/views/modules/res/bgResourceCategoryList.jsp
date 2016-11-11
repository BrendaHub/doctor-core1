<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>行业表管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {

	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/res/bgResourceCategory/">行业表列表</a></li>
		<shiro:hasPermission name="res:bgResourceCategory:edit">
			<li><a href="${ctx}/res/bgResourceCategory/form">行业表添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="bgResourceCategory"
		action="${ctx}/res/bgResourceCategory/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
	</form:form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th class="sort-column name">行业名称</th>
				<th>添加时间</th>
				<th>修改时间</th>
				<shiro:hasPermission name="res:bgResourceCategory:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="bgResourceCategory">
				<tr>
					<td><a
						href="${ctx}/res/bgResourceCategory/form?id=${bgResourceCategory.id}">
							${bgResourceCategory.categoryname} </a></td>
					<td><fmt:formatDate value="${bgResourceCategory.addtime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${bgResourceCategory.updatetime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>

					<shiro:hasPermission name="res:bgResourceCategory:edit">
						<td><a
							href="${ctx}/res/bgResourceCategory/form?id=${bgResourceCategory.id}">修改</a>
							<a
							href="${ctx}/res/bgResourceCategory/delete?id=${bgResourceCategory.id}"
							onclick="return confirmx('确认要删除该行业表吗？', this.href)">删除</a></td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>