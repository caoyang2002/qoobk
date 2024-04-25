package com.caoyang2002.qoobk.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决跨域请求的问题
 */
@Slf4j
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    public WebMvcConfiguration() {
        log.debug("创建配置类对象 WebMvcConfiguration");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true)
                .maxAge(3600);
    }
    /**
     * 解决 org.springframework.context.ApplicationContextException: Failed to start bean <br>
     * 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
     * 发现如果继承了 WebMvcConfigurationSupport，则在yml中配置的相关内容会失效。 需要重新指定静态资源
     * @param registry ResourceHandlerRegistry
     * @see <a href="https://www.mobaijun.com/posts/3051425539.html"></a>
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html", "doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}

