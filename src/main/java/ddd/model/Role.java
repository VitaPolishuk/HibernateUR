package ddd.model;

import javax.persistence.*;

@Entity // говорит о том , что данный класс является сущностью
@Table(name = "roles", schema = "usersandroles") // указываем с какой табицей связан
public class Role {
    @Id
    @Column(name = "id_roles")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_roles;

    @Column(name = "name_roles")
    private String name_roles;

    public int getId_roles() {
        return id_roles;
    }

    public void setId_roles(int id_roles) {
        this.id_roles = id_roles;
    }

    public String getName_roles() {
        return name_roles;
    }

    public void setName_roles(String name_roles) {
        this.name_roles = name_roles;
    }
}
