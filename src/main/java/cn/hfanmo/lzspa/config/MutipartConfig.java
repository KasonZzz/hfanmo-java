package cn.hfanmo.lzspa.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 * @author : KasonZzz
 * @className :  MutipartConfig
 * @packege :  cn.hfanmo.lzspa.config
 * @description :
 * @date :2021/1/17 11:43
 */
@Configuration
public class MutipartConfig {


    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //指定文件代销
        factory.setMaxFileSize(DataSize.parse("20MB"));
        /// 设定上传文件大小
        factory.setMaxRequestSize(DataSize.parse("100MB"));
        return factory.createMultipartConfig();
    }
}