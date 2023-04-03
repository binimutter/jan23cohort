package com.codingdojo.com.burgertracker.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="burgers")
public class Burger {

	// ==========================
    //        ATTRIBUTES
    // ==========================
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String name;
	
	@NotNull
	@Size(min = 2, max = 200)
	private String restaurant;
	
	@NotNull
	@Min(1)
	@Max(5)
	private Integer rating;
	
	@NotNull
	private String notes;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    // ==========================
    //        CONSTRUCTOR
    // ==========================
    
    public Burger(@NotNull @Size(min = 2, max = 200) String name, @NotNull @Size(min = 2, max = 200) String restaurant,
    		@NotNull @Min(1) @Max(5) Integer rating, String notes) {
    	this.name = name;
    	this.restaurant = restaurant;
    	this.rating = rating;
    	this.notes = notes;
    }
    
    public Burger() {}
    
    // ==========================
    //     GETTERS / SETTERS
    // ==========================
    
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
    public String getRestaurant() {
    	return restaurant;
    }
    public void setRestaurant(String restaurant) {
    	this.restaurant = restaurant;
    }
    public Integer getRating() {
    	return rating;
    }
    public void setRating(Integer rating) {
    	this.rating = rating;
    }
    public String getNotes() {
    	return notes;
    }
    public void setNotes(String notes) {
    	this.notes = notes;
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
