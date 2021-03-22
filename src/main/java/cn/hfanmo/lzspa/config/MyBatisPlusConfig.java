package cn.hfanmo.lzspa.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author KasonZzz
 * @Description MyBatis-Plus插件    这里配mapperscan 启动类就不用配了
 * @Date 9:47 2020/7/22
 */
@Configuration
@MapperScan("cn.hfanmo.lzspa.mapper")
public class MyBatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }


}
