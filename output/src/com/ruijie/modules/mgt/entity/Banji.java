package com.ruijie.modules.mgt.entity;



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
 * @version 2014-07-25
 */

@Entity
@Table(name = "mgt_banji")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Banji extends IdEntity<Banji>{
	
	private static final long serialVersionUID = 1L;

	//columns START
    /**
     * 班级编号       db_column: no 
     */ 	
	private java.lang.String no;
    /**
     * 名称       db_column: name 
     */ 	
	private java.lang.String name;
    /**
     * 年级       db_column: grade 
     */ 	
	private java.lang.String grade;
    /**
     * 年份       db_column: year 
     */ 	
	private java.sql.Timestamp year;
    /**
     * 类型       db_column: type 
     */ 	
	private java.lang.String type;
    /**
     * 所在学校       db_column: school_id 
     */ 	
	private java.lang.String schoolId;
	//columns END
	public java.lang.String getNo() {
		return this.no;
	}
	
	public void setNo(java.lang.String value) {
		this.no = value;
	}
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getGrade() {
		return this.grade;
	}
	
	public void setGrade(java.lang.String value) {
		this.grade = value;
	}
	public java.sql.Timestamp getYear() {
		return this.year;
	}
	
	public void setYear(java.sql.Timestamp value) {
		this.year = value;
	}
	public java.lang.String getType() {
		return this.type;
	}
	
	public void setType(java.lang.String value) {
		this.type = value;
	}
	public java.lang.String getSchoolId() {
		return this.schoolId;
	}
	
	public void setSchoolId(java.lang.String value) {
		this.schoolId = value;
	}

	
	

	public Banji(){
	}
	public Banji(String id){
		this();
		this.id = id;
	}



	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("No",getNo())
			.append("Name",getName())
			.append("Grade",getGrade())
			.append("Year",getYear())
			.append("Type",getType())
			.append("SchoolId",getSchoolId())
			.append("Remarks",getRemarks())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Banji == false) return false;
		if(this == obj) return true;
		Banji other = (Banji)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	


}