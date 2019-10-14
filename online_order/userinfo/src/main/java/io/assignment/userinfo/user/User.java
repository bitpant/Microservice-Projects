package io.assignment.userinfo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by Brijesh.Pant on 12-06-2019.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Size(min = 3)
    private String name;

    public User() {

    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
