package sos.haruhi.dbframe.mybatis;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MyBatisPlusApp {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:postgresql://192.168.233.100:5432/jooq", "postgres", "postgres")

                .globalConfig(builder -> {
                    builder.author("shx") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            // 指定输出目录
                            .outputDir("S://src//main//java");
                })
                .packageConfig(builder -> {
                    builder.parent("sos.haruhi.dbframe") // 设置父包名
                            .moduleName("mybatis")// 设置父包模块名
                    // 设置mapperXml生成路径
                           .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "S://"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("users", "define_equip_type", "gather_report", "imp_data_detail") // 设置需要生成的表名
                            .addTablePrefix(""); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
