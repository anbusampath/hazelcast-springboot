package io.anbu.hazelcast.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;

@EnableHazelcastRepositories(basePackages = {"io.anbu.hazelcast.domain"})
@Configuration
public class Config {

}
