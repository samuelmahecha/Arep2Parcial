package com.example.ProxyApp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class ServiceProxy {

    private final AtomicInteger counter = new AtomicInteger(0);

    @Value("${backend.instance1.url}")
    private String backendInstance1;

    @Value("${backend.instance2.url}")
    private String backendInstance2;

    private String getNextInstance() {
        return counter.getAndIncrement() % 2 == 0 ? backendInstance1 : backendInstance2;
    }

    @GetMapping("/linearsearch")
    public String linearSearch(@RequestParam("list") String list, @RequestParam("value") String value) {
        String url = getNextInstance() + "/linearsearch?list=" + list + "&value=" + value;
        return new RestTemplate().getForObject(url, String.class);
    }

    @GetMapping("/binarysearch")
    public String binarySearch(@RequestParam("list") String list, @RequestParam("value") String value) {
        String url = getNextInstance() + "/binarysearch?list=" + list + "&value=" + value;
        return new RestTemplate().getForObject(url, String.class);
    }
}