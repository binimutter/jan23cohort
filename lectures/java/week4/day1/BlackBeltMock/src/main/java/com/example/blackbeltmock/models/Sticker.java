package com.example.blackbeltmock.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="stickers")
public class Sticker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Title is required!")
    @Size(min=3, max=30, message="Title must be between 2 and 30 characters")
	private String title;
	
	@NotBlank(message="Link URL is required!")
	private String link;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date updatedAt;
	
	
    // ==========================
    //        RELATIONSHIPS
    // ==========================
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User owner;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_likes", 
        joinColumns = @JoinColumn(name = "sticker_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> likers;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "sticker_categorys", 
        joinColumns = @JoinColumn(name = "sticker_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categorys;
	
	
	
	
	public Sticker() {}
	
	
    // ==========================
    //     GETTERS / SETTERS
    // ==========================
	
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
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


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public List<User> getLikers() {
		return likers;
	}


	public void setLikers(List<User> likers) {
		this.likers = likers;
	}


	public List<Category> getCategorys() {
		return categorys;
	}


	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
    
    
}
