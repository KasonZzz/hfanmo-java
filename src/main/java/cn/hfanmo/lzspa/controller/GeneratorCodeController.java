package cn.hfanmo.lzspa.controller;


import cn.hfanmo.lzspa.pojo.common.GeneratorCode;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 代码生成器控制器
 */
@RestController
@RequestMapping("/generator")
@Api(value = "generatorcodecontroller", tags = "代码生成器")
public class GeneratorCodeController {

    @PostMapping(value = "/code")
    @ApiOperation(value = "代码生成", notes = "代码生成")
    public R generatorCode(@RequestBody GeneratorCode code) {
        String author = ObjectUtils.isEmpty(code.getAuthor()) ? "KasonZzz" : code.getAuthor();
        //1、全局配置
        GlobalConfig config = new GlobalConfig();
        //得到当前项目的路径
        String projectPath = System.getProperty("user.dir");
        config.setActiveRecord(true)//开启AR模式
                .setAuthor(author)//设置作者
                .setOutputDir(projectPath + "/src/main/java")//生成路径(一般在此项目的src/main/java下)
                .setFileOverride(true)//第二次生成会把第一次生成的覆盖掉
                .setOpen(false)//生成完毕后是否自动打开输出目录
                .setSwagger2(true)//实体属性 Swagger2 注解
                .setIdType(IdType.ASSIGN_ID)//主键策略
                .setFileOverride(false)//文件覆盖
                .setServiceName("%sService")//生成的service接口名字首字母是否为I，这样设置就没有I
                .setBaseResultMap(false)//生成resultMap
                .setBaseColumnList(false);//在xml中生成基础列

        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)//数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://47.117.116.96:3306/luzhou-spa?serverTimezone=UTC&characterEncoding=utf8&useUnicode=true&useSSL=true")
                .setUsername("root")
                .setPassword("root");

        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//开启全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)//表名映射到实体的命名策略(下划线到驼峰)
                //表字段映射属性名策略(未指定按naming)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix("t_")//表名前缀
                //.setSuperEntityClass("你自己的父类实体,没有就不用设置!")
                //.setSuperEntityColumns("id");//写于父类中的公共字段
                //.setSuperControllerClass("自定义继承的Controller类全称，带包名,没有就不用设置!")
                .setRestControllerStyle(true) //生成 @RestController 控制器
                .setEntityLombokModel(true)//使用lombok
                .setInclude(code.getTableName());//逆向工程使用的表

        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        if (!ObjectUtils.isEmpty(code.getPackageName())) {
            String packageName = code.getPackageName();
            packageConfig.setParent("cn.hfanmo.lzspa")//设置包名的parent
                    .setMapper("mapper" + "." + packageName)
                    .setService("service" + "." + packageName)
                    .setServiceImpl("service" + "." + packageName + ".impl")
                    .setController("controller" + "." + packageName)
                    .setEntity("pojo" + "." + packageName)
                    .setXml("mapper" + "." + packageName);//设置xml文件的目录
        } else {
            packageConfig.setParent("cn.hfanmo.lzspa")//设置包名的parent
                    .setMapper("mapper")
                    .setService("service")
                    .setServiceImpl("service.impl")
                    .setController("controller")
                    .setEntity("entity")
                    .setXml("mapper");//设置xml文件的目录
        }


        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        //6、执行
        autoGenerator.execute();

        return R.ok(null);
    }

}