<#assign ClassName = table.className>   
<#assign classNameLower = ClassName?uncap_first> 
package ${basepackage}.entity;



import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.Length;

import com.ruijie.common.persistence.IdEntity;
import com.ruijie.modules.sys.entity.User;

/**
 * 数据库实体类
 * @author yuzhongyuan
 * @version ${sys_time}
 */

@Entity
@Table(name = "${table.sqlName}")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ${ClassName} extends IdEntity<${ClassName}>{
	
	private static final long serialVersionUID = 1L;
	<@generateFields/>
	<@generateNotPkProperties/>

	
	
<#macro generateFields>

	//columns START
	<#list table.columns as column>
	<#if !(column.pk||column.columnNameLower=="createBy"||column.columnNameLower=="createDate"||column.columnNameLower=="updateBy"||column.columnNameLower=="updateDate"||column.columnNameLower=="remarks"||column.columnNameLower=="delFlag")>
    /**
     * ${column.columnAlias!}       db_column: ${column.sqlName} 
     */ 	
	private ${column.javaType} ${column.columnNameLower};
	</#if>
	</#list>
	//columns END
</#macro>

	public ${ClassName}(){
	}
	public ${ClassName}(String id){
		this();
		this.id = id;
	}


<#macro generateNotPkProperties>
	<#list table.columns as column>
	<#if !(column.pk||column.columnNameLower=="createBy"||column.columnNameLower=="createDate"||column.columnNameLower=="updateBy"||column.columnNameLower=="updateDate"||column.columnNameLower=="remarks"||column.columnNameLower=="delFlag")>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	</#if>
	</#list>
</#macro>

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
		<#list table.columns as column>
			<#if !(column.columnNameLower=="createBy"||column.columnNameLower=="createDate"||column.columnNameLower=="updateBy"||column.columnNameLower=="updateDate"||column.columnNameLower=="delFlag")>
			.append("${column.columnName}",get${column.columnName}())
			</#if>
		</#list>
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
		<#list table.pkColumns as column>
			<#if !table.compositeId>
			.append(get${column.columnName}())
			</#if>
		</#list>
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ${ClassName} == false) return false;
		if(this == obj) return true;
		${ClassName} other = (${ClassName})obj;
		return new EqualsBuilder()
			<#list table.pkColumns as column>
				<#if !table.compositeId>
			.append(get${column.columnName}(),other.get${column.columnName}())
				</#if>
			</#list>
			.isEquals();
	}
	

<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.ClassName>
	<#assign fkPojoClass = fkSqlTable.ClassName>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private Set ${fkPojoClassVar}s = new HashSet(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "${classNameLower}")
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.ClassName>
	<#assign fkPojoClass = fkSqlTable.ClassName>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	private ${fkPojoClass} ${fkPojoClassVar};
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
	<#list foreignKey.parentColumns?values as fkColumn>
		@JoinColumn(name = "${fkColumn}",nullable = false, insertable = false, updatable = false) <#if fkColumn_has_next>,</#if>
    </#list>
	})
	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>

}