package ddd.model;

import javax.persistence.*;

@Entity // говорит о том , что данный класс является сущностью
@Table(name = "users", schema = "usersandroles") // указываем с какой табицей связан
public class User {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;

    @Column(name = "name_user")
    private String name_user;

    @Column(name = "email")
    private String email;

    @Column(name = "id_roles")
    private int id_roles;

    public String getEmail() {
        return email;
    }

    public int getId_user() {
        return id_user;
    }

    public int getId_roles() {
        return id_roles;
    }

    public String getName_user() {
        return name_user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setId_roles(int id_roles) {
        this.id_roles = id_roles;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
