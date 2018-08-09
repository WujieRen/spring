package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *     a spring demo created with initialer.
 * </p>
 *
 * @author renwujie
 * @since 2018-08-09 15:25
 */
@RestController
public class Test {
    @GetMapping("/test")
    public String test() {
        return "<h1>test</h1>";
    }
}
