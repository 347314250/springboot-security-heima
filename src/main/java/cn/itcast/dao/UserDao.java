package cn.itcast.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.itcast.model.PermissionDto;
import cn.itcast.model.UserDto;

@Mapper
public interface UserDao {

	public UserDto getUserByUserName(String username);

	public List<PermissionDto> getPermission(String userId);
}
