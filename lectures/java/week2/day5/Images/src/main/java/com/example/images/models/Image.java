package com.example.images.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="images")
public class Image {

//	Model gets "exported" to imageRepo

    // ==========================
    //        ATTRIBUTES
    // ==========================
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	@Size(min = 2, max = 200, message="Name must be at least 2 characters.")
	private String name;
	@NotNull
	private String url;
	@NotNull
	@Size(min = 2, max = 200, message="Category must be at least 2 characters.")
	private String category;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
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
	public Image(@NotNull @Size(min = 2, max = 200, message = "Name must be at least 2 characters.") String name,
			@NotNull String url,
			@NotNull @Size(min = 2, max = 200, message = "Category must be at least 2 characters.") String category) {
		super();
		this.name = name;
		this.url = url;
		this.category = category;
	}
    public Image() {}
    
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
