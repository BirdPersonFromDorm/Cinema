package com.example.demo.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name = "role")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private Roles role;

    public enum Roles {
        Admin, Moderator, Vip, User;
    }
//
//    @ManyToMany(cascade=CascadeType.REFRESH, fetch = FetchType.LAZY)
//    @JoinTable(name = "user_role",
//            joinColumns = { @JoinColumn(name = "role_id")},
//            inverseJoinColumns = { @JoinColumn(name = "user_id")})
//    @JsonIgnoreProperties("roles")
//    private Set<User> users;

    @Override
    public int hashCode() {
        return Objects.hashCode(roleId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        return Objects.equals(roleId, other.getRoleId());
    }
}
