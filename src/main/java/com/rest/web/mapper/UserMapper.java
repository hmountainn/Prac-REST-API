package com.rest.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rest.web.model.User;

@Mapper
public interface UserMapper {
	
	@Insert("insert into user values(#{id},#{name},#{phone},#{address})")
	void PostUser(String id,
				  String name,
				  String phone,
				  String address);
	
	@Select("select * from user where id = #{id}")
	User getUser(String id);
	
	@Select("select * from user")
	List<User> getUserList();
	
	@Update("update user set name=#{name},phone=#{phone},address=#{address} where id=#{id}")
	void putUser(String id,
				 String name,
				 String phone,
				 String address);
	
	@Delete("delete from user where id=#{id}")
	void deleteUser(String id);
}
