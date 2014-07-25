<#assign ClassName = table.className>   
<#assign className = ClassName?uncap_first>
<#assign empty = "">  
<#assign urlPrefix = moduleName+"/"+className>
<#assign permissionPrefix = moduleName+":"+className>
<#assign containDateColumn = false>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>${className}管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
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
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${r"${ctx}"}/${urlPrefix}/">${table.tableAlias}列表</a></li>
		<li class="active"><a href="${r"${ctx}"}/${urlPrefix}/form?id=${"${"+className+".id}"}">${ClassName}<shiro:hasPermission name="${permissionPrefix}:edit">${r"${not empty "+className+".id?'修改':'添加'}"}</shiro:hasPermission><shiro:lacksPermission name="${permissionPrefix}:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="${className}" action="${r"${ctx}"}/${urlPrefix}/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<tags:message content="${r"${message}"}"/>
		<!-- 
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="200" class="required"/>
			</div>
		</div>
		 -->
		<#list table.columns as column>
			<#if !(column.pk||column.columnNameLower=="createBy"||column.columnNameLower=="createDate"||column.columnNameLower=="updateBy"||column.columnNameLower=="updateDate"||column.columnNameLower=="remarks"||column.columnNameLower=="delFlag")>
		    <div class="control-group">
				<label class="control-label">${column.columnAlias}:</label>
				<div class="controls">
					<form:input path="${column.columnNameLower}" htmlEscape="false" maxlength="200" class="required"/>
				</div>
		   </div>
			</#if>
	    </#list>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="${permissionPrefix}:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>


