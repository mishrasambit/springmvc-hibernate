package com.speed.mixer.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by sambit on 2/10/2017.
 */
@Entity
@Table(name="employee")
public class Emp {
    @Id
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Column(name="firstName", nullable=false)
    private String firstName;

    @NotEmpty
    @Column(name="lastName", nullable=false)
    private String lastName;

    @NotEmpty
    @Column(name="email", nullable=false)
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Emp))
            return false;
        Emp other = (Emp) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id
                + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + "]";
    }

}
