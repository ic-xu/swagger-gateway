package com.example.gateway.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: NewMeanning
 * @create: 2020-12-24 16:56
 **/
@Slf4j
@Component
@Primary
@AllArgsConstructor
public class SwaggerResourceConfig implements SwaggerResourcesProvider {

    /**
     * 网关路由
     */
    private final RouteLocator routeLocator;

    /**
     * 网关应用名称
     */
    @Value("${spring.application.name}")
    private String self;

    @Autowired
    public SwaggerResourceConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    /**
     * swagger2默认的url后缀
     */
    private static final String SWAGGER2_URL = "/v2/api-docs";



    /**
     * 网关应用名称
     */
    @Value("${spring.application.name}")
    private String gatewayName;

    /**
     * 获取 Swagger 资源
     */
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<String> routeHosts = new ArrayList<>();
        // 1. 获取路由Uri 中的Host=> 服务注册则为服务名=》app-service001
        routeLocator.getRoutes()
                .filter(route -> route.getUri().getHost() != null)
                .filter(route -> !gatewayName.equals(route.getUri().getHost()))
                .subscribe(route -> routeHosts.add(route.getUri().getHost()));
        // 2. 创建自定义资源
        for (String routeHost : routeHosts) {
            // 后台访问添加服务名前缀
            String serviceUrl = "/" + routeHost + SWAGGER2_URL;
            // 创建Swagger 资源
            SwaggerResource swaggerResource = new SwaggerResource();
            // 设置访问地址
            swaggerResource.setUrl(serviceUrl);
            // 设置名称
            swaggerResource.setName(routeHost);

            swaggerResource.setSwaggerVersion("3.0.0");
            resources.add(swaggerResource);
        }
        return resources;
    }
}
