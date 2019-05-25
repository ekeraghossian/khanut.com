package com.khanut.gateway.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column
	private String name;
	@Column
	private String lastName;
	@Column(unique=true)
	private String email;
	@Column
	private String password;
	@Column
	private Integer active=1;
	@Column
	private boolean isLocked=false;
	@Column
	private boolean isExpired=false;
	@Column
	private boolean isEnabled=true;
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> role;
	
	public Customer() {
	}

	public Customer(Long customerId, String name, String lastName, String email, String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLoacked(boolean locked) {
        isLocked = locked;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
