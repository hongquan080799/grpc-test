package com.abc.Client.monitor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.prometheus.client.Histogram;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class MonitorAnotationImpl {
    @Autowired
    private MeterRegistry registry;


    @Around("@annotation(Monitor)")
    public Object monitor (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Monitor monitor = signature.getMethod().getAnnotation(Monitor.class);
        Timer requestLatency = registry.timer(String.format("%s_%s_latency", monitor.type(), monitor.name()));
        Counter requestThroughput = registry.counter(String.format("%s_%s_counter", monitor.type(), monitor.name()));
        Long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        Long end = System.currentTimeMillis();
        long dur = end - start;
        requestLatency.record(dur, TimeUnit.MILLISECONDS);
        requestThroughput.increment();
        return result;
    }
}
