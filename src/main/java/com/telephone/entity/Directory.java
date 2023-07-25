package com.telephone.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Directory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long directoryId;

    private String name;

    private Long phone;
    
    private String email;

    public Directory() {
    }

    public Directory(Long directoryId, String name, Long phone, String email) {
        this.directoryId = directoryId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Directory( String name, Long phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Long getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(Long directoryId) {
        this.directoryId = directoryId;
    }

    public String getName() {
        return name;
    }

    public void setDirectoryName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
