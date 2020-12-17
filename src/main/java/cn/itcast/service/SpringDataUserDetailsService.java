package cn.itcast.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.itcast.dao.UserDao;
import cn.itcast.model.PermissionDto;
import cn.itcast.model.UserDto;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	// 根据账号查询用户信息
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto userDto = userDao.getUserByUserName(username);
		if (userDto == null) {
			return null;// spring security框架会帮我们抛异常，我们直接返回null即可
		}
		// 模拟从数据库查询的用户名和密码，封装成UserDetail对象返回
		List<PermissionDto> permission = userDao.getPermission(userDto.getId());
		List<String> collect = permission.parallelStream().map(a -> a.getCode()).collect(Collectors.toList());
		String[] array = new String[collect.size()];
		collect.toArray(array);
		UserDetails userDetails = User.withUsername(userDto.getUsername()).password(userDto.getPassword())
				.authorities(array).build();
		return userDetails;
	}
}
