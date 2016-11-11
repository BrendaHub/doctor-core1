<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<html>
<head>
	<title>行业表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
<script type="text/javascript">
function selcity(){
	
	debugger;
		$("#sel02").empty();
		$.ajax({
			url : "<c:url value='/a/res/bgResourceCategory/getID'/>",
			type : "POST",
			data : {
				id : $("#sel01").val()
			},
			success : function(data) {
				$("#sel02").val(data)
			}
		});
	}

</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/res/bgResourceCategory/">行业表列表</a></li>
		<li class="active"><a href="${ctx}/res/bgResourceCategory/form?id=${bgResourceCategory.id}">行业表<shiro:hasPermission name="res:bgResourceCategory:edit">${not empty bgResourceCategory.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="res:bgResourceCategory:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="bgResourceCategory" action="${ctx}/res/bgResourceCategory/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">行业名称：</label>
			<div class="controls">
				<form:input path="categoryname" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		
		<div class="control-group">
					<label class="control-label">行业分类</label>
					<div class="controls">
						<form:select path="fathercatid" id="sel01" class="input-xxlarge" style="width: 284px"  onChange="selcity()">
							<form:options items="${findFatherList}" itemLabel="categoryname" itemValue="id" htmlEscape="false" />
						</form:select>
					</div>
				</div>
		<div class="control-group">
			<label class="control-label">isorder：</label>
			<div class="controls" >
				<form:input path="isorder" htmlEscape="false" maxlength="11" id="sel02" 
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">0未启用1启用：</label>
			<div class="controls">
				<form:input path="isuse" htmlEscape="false" maxlength="11" value="1"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注</label>
			<div class="controls">
				<form:input path="remark" htmlEscape="false" maxlength="300"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">原始图片</label>
			<div class="controls">
				<form:input path="originalpicurl" htmlEscape="false" maxlength="300"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">放大图片</label>
			<div class="controls">
				<form:input path="bigpicurl" htmlEscape="false" maxlength="300"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">中等图片</label>
			<div class="controls">
				<form:input path="centerpicurl" htmlEscape="false" maxlength="300"
					class="input-xlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">缩小图片</label>
			<div class="controls">
				<form:input path="smallpicurl" htmlEscape="false" maxlength="300"
					class="input-xlarge " />
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="res:bgResourceCategory:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>