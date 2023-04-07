package com.codingdojo.com.safetravels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name is required!")
    @Size(min=3, max=30, message="Name must be between 2 and 30 characters")
	private String name;
	
	@NotBlank(message="Vendor is required!")
    @Size(min=3, max=30, message="Vendor must be between 3 and 30 characters")
	private String vendor;
	
	@NotNull(message="needed")
	private Double amount;
	
	@NotNull
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    
    public Expense() {}
	
	public Expense(
			@NotBlank(message = "Name is required!") @Size(min = 3, max = 30, message = "Name must be between 2 and 30 characters") String name,
			@NotBlank(message = "Vendor is required!") @Size(min = 3, max = 30, message = "Vendor must be between 3 and 30 characters") String vendor,
			@NotNull(message = "needed") Double amount, @NotNull String description) {
		super();
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    

}
