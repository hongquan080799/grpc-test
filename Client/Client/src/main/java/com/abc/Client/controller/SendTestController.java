package com.abc.Client.controller;

import com.abc.Client.GrpcClient;
import com.abc.Client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class SendTestController {
    @Autowired private RestClient restClient;
    @Autowired private GrpcClient grpcClient;
    @GetMapping("/rest-api")
    public void sendTestRestAPI(@RequestParam("requestNum") int rqNum, @RequestParam("thread") int thread) {
        ExecutorService executorService = Executors.newFixedThreadPool(thread);
        for(int i = 0; i < rqNum; i++) {
            executorService.execute(() -> {
                restClient.sendTest();
            });
        }
    }
    @GetMapping("/grpc")
    public void sendTestGrpc(@RequestParam("requestNum") int rqNum, @RequestParam("thread") int thread) {
        ExecutorService executorService = Executors.newFixedThreadPool(thread);
        for(int i = 0; i < rqNum; i++) {
            executorService.execute(() -> {
                grpcClient.sendTest();
            });
        }
    }
    @GetMapping("/test-all")
    public void sendTestAll(@RequestParam("requestNum") int rqNum, @RequestParam("thread") int thread) {
        ExecutorService executorServiceRest = Executors.newFixedThreadPool(thread);
        for(int i = 0; i < rqNum; i++) {
            executorServiceRest.execute(() -> {
                restClient.sendTest();
            });
        }
        ExecutorService executorServiceGrpc = Executors.newFixedThreadPool(thread);
        for(int i = 0; i < rqNum; i++) {
            executorServiceGrpc.execute(() -> {
                grpcClient.sendTest();
            });
        }
    }
}
