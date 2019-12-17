package io.anbu.hazelcast.domain;

import org.springframework.data.hazelcast.repository.HazelcastRepository;
import org.springframework.data.keyvalue.repository.KeyValueRepository;


public interface LocationRepository extends HazelcastRepository<Location, String>{

}
