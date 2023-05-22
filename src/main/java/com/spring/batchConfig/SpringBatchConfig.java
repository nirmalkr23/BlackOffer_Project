package com.spring.batchConfig;


import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import com.spring.entity.BlackOffer;
import com.spring.repository.BlackOfferRepository;


@Configuration
@AllArgsConstructor
public class SpringBatchConfig {



   private BlackOfferRepository repo;


    @Bean
    public FlatFileItemReader<BlackOffer> reader() {
        FlatFileItemReader<BlackOffer> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("D:\\Spring\\BlackOffer_Project\\src\\main\\resources\\Data.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<BlackOffer> lineMapper() {
        DefaultLineMapper<BlackOffer> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("end_year","intensity","topic","region","city","country","relevance","likelihood");
        lineTokenizer.setIncludedFields(new int[] {0,3,5,9,14,15,16,20});

        BeanWrapperFieldSetMapper<BlackOffer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(BlackOffer.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;

    }

    @Bean
    public BlackOfferProcessor processor() {
        return new BlackOfferProcessor();
    }

    @Bean
    public RepositoryItemWriter<BlackOffer> writer() {
        RepositoryItemWriter<BlackOffer> writer = new RepositoryItemWriter<>();
        writer.setRepository(repo);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("csv-step",jobRepository).
                <BlackOffer, BlackOffer>chunk(10,transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public Job runJob(JobRepository jobRepository,PlatformTransactionManager transactionManager) {
        return new JobBuilder("importCustomers",jobRepository)
                .flow(step1(jobRepository,transactionManager)).end().build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

}
