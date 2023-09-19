package com.geupjo.koreantiger.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiHealthCheck {

    @GetMapping("/check/health")
    public ApiResponse check() {
        String success = "success";
        return ApiResponse.success(success);
    }
}
