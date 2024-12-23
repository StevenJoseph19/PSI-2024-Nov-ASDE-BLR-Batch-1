package com.acme.kafka.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
//@EnableBatchProcessing
public class BatchConfig {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public BatchConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public Step step1() {
        List<String> data = Arrays.asList("Sample Data 1", "Sample Data 2", "Sample Data 3"); // Sample data to process
        final AtomicInteger index = new AtomicInteger(0); // To track current position in the list

        return new StepBuilder("csv-step", jobRepository)
                .<String, String>chunk(10, transactionManager)  // Use chunk size of 10
                .reader(() -> {
                    // Simulate reading data from the list
                    if (index.get() < data.size()) {
                        System.out.println("Reading: " + data.get(index.get()));
                        return data.get(index.getAndIncrement()); // Return next item in the list
                    } else {
                        return null; // End of input
                    }
                })
                .processor(item -> {
                    // Process the data (e.g., simple transformation)
                    System.out.println("Processing: " + item);
                    return item.toUpperCase(); // Example: Convert string to uppercase
                })
                .writer(items -> {
                    // Write the processed data
                    System.out.println("Writing:");
                    items.forEach(item -> System.out.println("Written item: " + item)); // Print each written item
                })
                .taskExecutor(taskExecutor()) // Optional: parallel processing
                .build();
    }


    @Bean
    public Job runJob() {
        return new JobBuilder("exampleJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1())
                .build();
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(4);
        taskExecutor.setMaxPoolSize(8);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
