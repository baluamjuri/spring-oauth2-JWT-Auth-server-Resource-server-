package org.balu.learn.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.balu.learn.entity.User;
import org.balu.learn.repository.UserDao;
import org.balu.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		
//		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		
		List<SimpleGrantedAuthority> authorities = user.getRoles()
													.stream()
													.map(role -> new SimpleGrantedAuthority(SPRING_ROLE_PREFIX+role.getName()))
													.collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(
														user.getUsername(), 
														user.getPassword(), 
														authorities);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
