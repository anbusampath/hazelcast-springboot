package io.anbu.hazelcast;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.SSLConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.security.Credentials;
import com.hazelcast.security.UsernamePasswordCredentials;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableConfigurationProperties(HazelcastProperties.class)
@RequiredArgsConstructor
public class ClientConfiguration {
	
	private final HazelcastProperties properties;

	@Bean
	public HazelcastInstance hazelcastInstance() {

		ClientConfig clientConfig = new ClientConfig();
		
		Credentials credentials = new UsernamePasswordCredentials(properties.getUsername(), properties.getPassword());
		clientConfig.setCredentials(credentials);
		
		ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
		networkConfig.setAddresses(properties.getAddresses());
		
		SSLConfig sslConfig = new SSLConfig();
		sslConfig.setEnabled(true);
		sslConfig.setProperty("trustStore", new File("truststore.jks").getAbsolutePath());
				
		networkConfig.setSSLConfig(sslConfig); 
		
		return HazelcastClient.newHazelcastClient(clientConfig);
	}
	
}