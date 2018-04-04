package com.fulln.security.Service.Impl;

import com.fulln.entity.Security.userEmpEntity;
import com.fulln.security.Service.myUserDetailsService;
import com.fulln.service.Security.UserAuthorwareService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class myUserDetailsServiceImpl implements myUserDetailsService {

    private static Logger log = Logger.getLogger(myUserDetailsServiceImpl.class);

    @Autowired
    private UserAuthorwareService userAuthorwareService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        userEmpEntity user = null;
        try {
            log.info("SecurityManagerSupport.loadUserByUsername.userName:" + userName);


            userEmpEntity userEntity = userAuthorwareService.loadUserEntity(userName);

            if (userEntity == null) {
                throw new UsernameNotFoundException("用户名没有找到");
            }
            if (userEntity.getPermission().getLabel().equals("ROLE_USER")) {
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                user = new userEmpEntity(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword(), true, authorities);
            }
        } catch (EmptyResultDataAccessException e) {
            log.debug("查询结果集为空:{}");
            throw new UsernameNotFoundException("用户名或密码不正确");
        }
        return user;//返回UserDetails的实现user不为空，则验证通过
    }

}