package com.example.demo.config;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;


@Configuration
@EnableElasticsearchRepositories(basePackages = "" )
@ComponentScan(basePackages = "")
public class Config extends AbstractElasticsearchConfiguration{

    @Override
    public RestHighLevelClient elasticsearchClient() {
        return null;
    }
}
