package io.anbu.hazelcast.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import lombok.Data;

@Data
@KeySpace("location")
public class Location implements Comparable<Location>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;
	private String description;

	public int compareTo(Location that) {
		return this.compareTo(that);
	}

}
