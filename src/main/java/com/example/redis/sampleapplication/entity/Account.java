package com.example.redis.sampleapplication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

@Entity
public class Account  extends JdkSerializationRedisSerializer implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

	@Column
	private String name;
	
	@Column
	private String location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
