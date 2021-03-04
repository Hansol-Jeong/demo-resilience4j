package com.fastcampus.resilience4j.demo3.support;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Martin
 * @since 2021/03/04
 */
@FeignClient(name = "demo", url = "http://localhost:8040")
public interface DemoFeignClient {
    @GetMapping("/remote")
    String remote();
}
