package com.auto;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 注释内容
 *
 * @author  weiminke
 * @version 2020年5月11日
 */
public class CodeGenerator {
    /**
     * 生成的Service 接口类名是否以I开头
     * <p>默认是以I开头</p>
     * <p>user表 -> IUserService, UserServiceImpl</p>
     */
    private static boolean serviceClassNameStartWithI = false;
    
	public static void main(String[] args) {
		
		String tableName="zx_info_content";
        String basePackge="com.hasbei.kq.zx";
        String author="weiminke";

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

     // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/hasbei_kq?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8");
        dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);
        
        
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath:"+projectPath);
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        if (!serviceClassNameStartWithI) {
        	gc.setServiceName("%sService");
        	gc.setServiceImplName("%sServiceImpl");
        }
        gc.setEntityName("%sPO");
        gc.setMapperName("%sDAO");
        
        mpg.setGlobalConfig(gc);
        
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(basePackge);
        pc.setEntity("model.po");
        //pc.setXml("po");
        pc.setMapper("dao");
        pc.setService("service");
        pc.setServiceImpl("service");
        mpg.setPackageInfo(pc);
        String xmlMapperPath="/src/main/java/"+(pc.getParent()+"."+pc.getMapper()).replace(".", "/")+"/";

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath +xmlMapperPath+ tableInfo.getEntityName().replace("PO", "") + "DAO" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        //是否启动lombok
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        
       
        // 策略配置

        strategy.setInclude(tableName);//需要自动生成的表名
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");

        strategy.setSuperMapperClass("com.hasbei.framework.dao.BaseDAO");
        strategy.setSuperServiceClass("com.hasbei.framework.service.BaseService");
        strategy.setSuperServiceImplClass("com.hasbei.framework.service.BaseServiceImpl");
        
        //strategy.setSuperEntityColumns("id");
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");// Entity公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");// Controller公共父类
        mpg.setStrategy(strategy);
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());//如果有此代码，即不使用默认的velocity模板，使用Freemarker模板
        mpg.execute();
    }
}
