package com.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by borik on 11/23/2016.
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
