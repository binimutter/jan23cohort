package com.example.javagrades.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="students")
public class Student {
	
//	Used by Repo - exported to Repo

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
//	@Size(min = 2, max = 200, message="FirstName must be at least 2 characters.")
	private String firstName;
	
	@NotBlank
//	@Size(min = 2, max = 200, message="LastName must be at least 2 characters.")
	private String lastName;
	
	@NotNull(message="needed")
	private Integer age;
	
	@NotNull
	private Integer	studentId;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date updatedAt;
	
	
    // ==========================
    //        RELATIONSHIPS
    // ==========================
	
	@OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Bio bio;
	
    @OneToMany(mappedBy="theStudent", fetch = FetchType.LAZY)
    private List<Grade> grades;
	
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    
    public Student() {}
    
// For one-one on the 1st one side constructor won't change but getters and setters will
    
	public Student(@NotEmpty String firstName, @NotBlank String lastName, @NotNull(message = "needed") Integer age,
			@NotNull Integer studentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.studentId = studentId;
	}
	
	
	public List<Grade> getGrades() {
		return grades;
	}
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	public Bio getBio() {
		return bio;
	}
	public void setBio(Bio bio) {
		this.bio = bio;
	}
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
