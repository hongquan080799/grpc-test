package com.abc.Client;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class StartupRunner {
    @Autowired
    private RestClient restClient;
    @Autowired
    private GrpcClient grpcClient;
    private Scanner scanner = new Scanner(System.in);

    public void run() throws JsonProcessingException {
       while(true) {
           System.out.println("*************MENU*************");
           System.out.println("1. Send rest api test");
           System.out.println("2. Send grpc test");
           System.out.println("0. Exit");
           System.out.println("*************END**************");
           System.out.println("Enter your option : ");
           int option = scanner.nextInt();
           switch (option) {
               case 1: {
                   for (int i = 0; i< 10; i++) {
                       restClient.sendTest();
                   }
                   break;
               }
               case 2: {
                   for (int i = 0; i< 10; i++) {
                       grpcClient.sendTest();
                   }
                   break;
               }
               case 0: {
                   return;
               }
           }
       }
    }

    public StartupRunner()   {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                run();
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
