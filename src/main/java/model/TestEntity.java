package model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class TestEntity {
	private Long id;
	private String name;
	
	public TestEntity() {}

	@Id
	@GeneratedValue
	@Column(name="ID", nullable = false)
	@NotNull
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
