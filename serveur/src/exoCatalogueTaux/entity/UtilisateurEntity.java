package exoCatalogueTaux.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name = "test.UTILISATEUR")
public class UtilisateurEntity implements Serializable {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id ;
    private String name;
    private String password;
    private boolean isConnected;

    public UtilisateurEntity(String name, String password) {
        this.name = name;
        this.password = password;
        this.isConnected = false;
    }


    public UtilisateurEntity() {
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
