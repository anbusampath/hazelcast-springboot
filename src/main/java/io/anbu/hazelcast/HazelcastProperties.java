package io.anbu.hazelcast;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("hazelcast")
public class HazelcastProperties {

	private String username;
	private String password;
    private List<String> addresses;
}
