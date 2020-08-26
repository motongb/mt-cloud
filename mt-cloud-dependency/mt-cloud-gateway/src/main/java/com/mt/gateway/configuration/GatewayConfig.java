package com.mt.gateway.configuration;


import com.mt.gateway.hystrix.GatewayHystrix;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class GatewayConfig {

    private final GatewayHystrix gatewayHystrix;

    public GatewayConfig(GatewayHystrix gatewayHystrix) {
        this.gatewayHystrix = gatewayHystrix;
    }

    /**
     * 限流
     *
     * @return
     */
    @Bean
    public KeyResolver hostKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostString());
    }

    /**
     * 设置默认路由
     *
     * @param indexHtml
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> indexRouter(@Value("classpath:/META-INF/resources/doc.html") final Resource indexHtml) {
        return route(GET("/"), request -> ok().contentType(MediaType.TEXT_HTML).bodyValue(indexHtml))
                .andRoute(path("/defaultFallback").and(accept(MediaType.TEXT_PLAIN)), gatewayHystrix);
    }
}
