package com.example.redis.sampleapplication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Post implements Serializable{

	private static final long serialVersionUID = -6178054163022548905L;

	  @Id
	  @GeneratedValue
	  private Integer id;
	    
	  @Column
	  private String title;
	    
	  @Column
	  private String content;
}
