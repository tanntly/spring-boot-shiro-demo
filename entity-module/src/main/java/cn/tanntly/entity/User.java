package cn.tanntly.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column
    private String password;

    @Column
    private String roles;

    @Column
    private String prems;

}
