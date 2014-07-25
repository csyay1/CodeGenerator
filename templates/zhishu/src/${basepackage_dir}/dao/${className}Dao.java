<#assign ClassName = table.className>   
<#assign classNameLower = ClassName?uncap_first>
<#assign actionExtension = "action">

package ${basepackage}.dao;



import org.springframework.stereotype.Repository;

import com.ruijie.common.persistence.BaseDao;
import com.ruijie.common.persistence.Parameter;
import ${basepackage}.entity.${ClassName};

/**
 * 数据库操作类
 * @author yuzhongyuan
 * @version ${sys_time}
 */

@Repository
public class ${ClassName}Dao extends BaseDao<${ClassName}> {
	
}
