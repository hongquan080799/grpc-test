package com.abc.grpc.custom_anotation.monitor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAnotationImpl {
    @Autowired
    private MeterRegistry registry;


    @Around("@annotation(Monitor)")
    public Object monitor (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Monitor monitor = signature.getMethod().getAnnotation(Monitor.class);
        Timer requestLatency = Timer
                .builder(String.format("%s_%s_latency", monitor.type(), monitor.name()))
                .publishPercentileHistogram()
                .register(registry);
        Counter requestThroughput = registry.counter(String.format("%s_%s_counter", monitor.type(), monitor.name()));
        Timer.Sample sample = Timer.start();

        Object result = proceedingJoinPoint.proceed();

        sample.stop(requestLatency);
        requestThroughput.increment();
        return result;
    }
}
