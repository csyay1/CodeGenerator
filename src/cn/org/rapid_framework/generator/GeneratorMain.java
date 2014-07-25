package cn.org.rapid_framework.generator;



/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		GeneratorFacade g = new GeneratorFacade();
//		g.printAllTableNames();				//打印数据库中的表名称
		
		g.deleteOutRootDir();
		//删除生成器的输出目录

//		g.generateByTable("platform_use","templates/bootstrap_jfinal/template");	//通过数据库表生成文件,template为模板的根目录
//		g.generateByTable("templates","templates/bootstrap_jfinal/template");	//通过数据库表生成文件,template为模板的根目录
//		g.generateByTable("activities","templates/bootstrap_jfinal/template");	//通过数据库表生成文件,template为模板的根目录
//		g.generateByTable("activity_sign_in","templates/bootstrap_jfinal/template");	//通过数据库表生成文件,template为模板的根目录
		//g.generateByAllTable("templates/bootstrap_jfinal/template");	//自动搜索数据库中的所有表并生成文件,template为模板的根目录
//		g.generateByClass(Blog.class,"templattemplates/bootstrap_jfinal/templatee_clazz");
		g.generateByTable("mgt_banji","templates/zhishu");
		g.generateByTable("mgt_school","templates/zhishu");
		//hahahaah
		
//		g.deleteByTable("table_name", "template"); //删除生成的文件
		//打开文件夹
//		Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
//		Runtime.getRuntime().exec("nautilus "+GeneratorProperties.getRequiredProperty("outRoot"));
//		String cmd = "cp -rf "+GeneratorProperties.getRequiredProperty("outRoot")
//				+"/web/"+GeneratorProperties.getRequiredProperty("namespace")
//				+" /home/m618/Documents/ComputerScience/Java/jfinal/jfinal_demo/WebRoot/pages";
//		String copySource = "cp -rf "+GeneratorProperties.getRequiredProperty("outRoot")
//				+"/java_src/*"
//				+" /home/m618/Documents/ComputerScience/Java/jfinal/jfinal_demo/src";
		//Runtime.getRuntime().exec("nautilus "+GeneratorProperties.getRequiredProperty("outRoot"));
//		Runtime.getRuntime().exec(cmd);
//		Runtime.getRuntime().exec(copySource);
	}
}
