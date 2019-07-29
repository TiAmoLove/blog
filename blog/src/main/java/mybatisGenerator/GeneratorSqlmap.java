package mybatisGenerator;

import java.io.File;
import java.util.*;
 
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 
 * @author zhou
 * 逆向工程代码生成器
 * 生成mapper.xml 和 mapper映射AND实体类
 * 根据配置文件生成:generatorConfig.xml
 *
 */
public class GeneratorSqlmap {
 
	public void generator() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		// 指定配置文件
		File configFile = new File("src/main/java/mybatisGenerator/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
 
	// 执行main方法以生成代码
	public static void main(String[] args) {
		try {
			GeneratorSqlmap generatorSqlmap = new GeneratorSqlmap();
			generatorSqlmap.generator();
			System.out.println("生成代码成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
