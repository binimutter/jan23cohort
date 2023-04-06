package com.example.crudappsession.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="categorys")
public class Category {
	
    // ==========================
    //        ATTRIBUTES
    // ==========================

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message="Must have a name")
	private String name;
	
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date updatedAt;
	
    // ==========================
    //        RELATIONSHIPS
    // ==========================
	
	@OneToMany(mappedBy="cat", fetch = FetchType.LAZY)
	private List<Sticker> stickers;
    
    // ==========================
    //        CONSTRUCTOR
    // ==========================
    public Category() {}
	public Category(@NotEmpty(message = "Must have a name") String name) {
		super();
		this.name = name;
	}
	
	
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
	public List<Sticker> getStickers() {
		return stickers;
	}
	public void setStickers(List<Sticker> stickers) {
		this.stickers = stickers;
	}
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
