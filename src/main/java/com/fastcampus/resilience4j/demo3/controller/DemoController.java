package com.fastcampus.resilience4j.demo3.controller;

import com.fastcampus.resilience4j.demo3.support.DemoFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Martin
 * @since 2021/03/04
 */
@RestController
@RequiredArgsConstructor
public class DemoController {
    private final DemoFeignClient demoFeignClient;

    @CircuitBreaker(name = "demo", fallbackMethod = "fallback")
//    @TimeLimiter(name="demo", fallbackMethod = "fallback")
    @GetMapping("/test")
    public String demo() {
        return demoFeignClient.remote();
    }

    public String fallback(Throwable th) {
        System.out.println(">>> fallback");
        return "Circuit Error";
    }
}
