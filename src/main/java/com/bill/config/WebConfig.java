package com.bill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     *  默認解析器，當請求中未包含該語系，則預設使用默認的語系
     *  當前默認為TAWAIN
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver s = new SessionLocaleResolver();
        s.setDefaultLocale(Locale.TAIWAN);
        return s;
    }

    /**
     * 默認攔截器，其中lang為語系切換的參數
     */
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor l = new LocaleChangeInterceptor();
        l.setParamName("lang");
        return l;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
