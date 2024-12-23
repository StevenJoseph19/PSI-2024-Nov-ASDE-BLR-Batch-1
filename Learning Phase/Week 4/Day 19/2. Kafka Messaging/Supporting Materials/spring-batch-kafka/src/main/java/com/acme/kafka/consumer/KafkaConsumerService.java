package com.acme.kafka.consumer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @KafkaListener(topics = "batch-topic", groupId = "batch-consumer-group")
    public void listen(String message) throws Exception {
        System.out.println("Received message: " + message);
        jobLauncher.run(job, new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());
    }
}
