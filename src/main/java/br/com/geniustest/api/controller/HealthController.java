package br.com.geniustest.api.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Health")
@RestController
public class HealthController {

    @GetMapping("/health")
    public String index() {
        return "OK";
    }

}
