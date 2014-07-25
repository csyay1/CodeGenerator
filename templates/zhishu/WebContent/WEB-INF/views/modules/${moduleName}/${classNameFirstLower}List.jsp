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
	<title>${ClassName}管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${r"${ctx}"}/${urlPrefix}/">${table.tableAlias}列表</a></li>
		<shiro:hasPermission name="${permissionPrefix}:edit"><li><a href="${r"${ctx}"}/${urlPrefix}/form">${table.tableAlias}添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="${className}" action="${r"${ctx}"}/${urlPrefix}/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${r"${page.pageNo}"}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${r"${page.pageSize}"}"/>
		<label>名称 ：</label><form:input path="name" htmlEscape="false" maxlength="50" class="input-small"/>
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
	</form:form>
	<tags:message content="${r"${message}"}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr>
			<#list table.columns as column>
				<#if !(column.pk||column.columnNameLower=="createBy"||column.columnNameLower=="createDate"||column.columnNameLower=="updateBy"||column.columnNameLower=="updateDate"||column.columnNameLower=="remarks"||column.columnNameLower=="delFlag")>
			        <th>${column.columnAlias}</th>
				</#if>
	        </#list>
            <th>备注</th>
			<shiro:hasPermission name="${permissionPrefix}:edit"><th>操作</th></shiro:hasPermission>
		</tr></thead>
		<tbody>
		<c:forEach items="${r"${page.list}"}" var="${className}">
			<tr>
			<#list table.columns as column>
			<#if !(column.pk||column.columnNameLower=="createBy"||column.columnNameLower=="createDate"||column.columnNameLower=="updateBy"||column.columnNameLower=="updateDate"||column.columnNameLower=="remarks"||column.columnNameLower=="delFlag")>
		        <#if column.columnNameLower=="name">
		          <td><a href="${r"${ctx}"}/${urlPrefix}/form?id=${"${"+className+".id}"}">${"${"+className+"."}${column.columnNameLower}}</a></td>
		        <#else>
		          <td>${"${"+className+"."}${column.columnNameLower}}</td>
		        </#if>
			</#if>
	        </#list>
	            <td>${"${"+className+".remarks}"}</td>
				<shiro:hasPermission name="${permissionPrefix}:edit"><td>
    				<a href="${r"${ctx}"}/${urlPrefix}/form?id=${"${"+className+".id}"}">修改</a>
					<a href="${r"${ctx}"}/${urlPrefix}/delete?id=${"${"+className+".id}"}" onclick="return confirmx('确认要删除该${table.tableAlias}吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${r"${page}"}</div>
</body>
</html>

