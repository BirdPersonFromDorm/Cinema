package com.example.demo.security;

import com.example.demo.Model.User;
import com.example.demo.Model.Role;
import com.example.demo.Model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class SecurityUser implements UserDetails {
    private String login;
    private String pwd;
    private List<GrantedAuthority> grantedAuthorityList;
    private boolean isActive;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(User user) {
        if (user.getStatus() == null) {
            user.setStatus(Status.ACTIVE);
        }
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                user.getStatus().equals(Status.ACTIVE),
                fromRoleToGrantedAuthority(user.getRoles())
        );
    }

    private static Set<GrantedAuthority> fromRoleToGrantedAuthority(Set<Role> roles) {
        return roles.stream()
                .map(x -> x.getRole().name())
                .map(x -> "ROLE_" + x)
                .map(x-> (GrantedAuthority) () -> x)
                .collect(Collectors.toSet());
    }
}