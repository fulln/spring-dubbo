package com.fulln.entity.Security;

import com.fulln.emun.BasicEntityEnum;
import com.fulln.entity.BaseModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Transient;
import java.util.Collection;


public class userEmpEntity extends BaseModel  implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private BasicEntityEnum sex;
    private BasicEntityEnum permission;
    @Transient
    private boolean enabled;
    @Transient
    private Collection<GrantedAuthority> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public userEmpEntity(Long id, String username, String password, boolean enabled,Collection<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.authorities=authorities;
    }


    public userEmpEntity() {

    }

    public Collection<GrantedAuthority> getAuthorities() {
        return  this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "MyUserDetails [id=" + id + ", username=" + username
                + ", password=" + password + ", enabled=" + enabled
                + ", authorities="  + "]";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BasicEntityEnum getSex() {
        return sex;
    }

    public void setSex(BasicEntityEnum sex){
        this.sex = sex;
    }

    public BasicEntityEnum getPermission() {
        return permission;
    }

    public void setPermission(BasicEntityEnum permission) {
        this.permission = permission;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
