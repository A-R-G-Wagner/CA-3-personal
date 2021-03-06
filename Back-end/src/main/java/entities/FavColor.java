/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alex Wagner
 */
@Entity
@Table(name = "favColors")
public class FavColor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "fav_color", length = 25)
    private String color;

    @OneToMany(mappedBy = "color", cascade = CascadeType.PERSIST)
    private List<User> userList;

    public FavColor(String color) {
        this.color = color;
        this.userList = new ArrayList<>();
    }
    
    public FavColor(){
        
    }

    public String getFavColor() {
        return color;
    }

    public void setFavColor(String color) {
        this.color = color;
    }

    public void AddUser(User user) {
        this.userList.add(user);
        if (user != null) {
            user.setFavColor(this);
        }
    }

}
