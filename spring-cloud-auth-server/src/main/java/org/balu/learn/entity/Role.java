package org.balu.learn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="abv_role")
@Getter
@Setter
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Integer id;
	
	@Column(name="role_name", nullable=false, unique=true)
	private String name;
	
	@Column(name = "is_active")
	private boolean acitive = true;
	private String description;
	
}
