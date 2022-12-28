package ga.hariss.blogs.services;

import java.util.List;


import ga.hariss.blogs.payloads.UserDto;

public interface UserService {
	
    //create
	UserDto createUser(UserDto user);

	//update
	UserDto updateUser(UserDto user, Integer userId);
	
	// delete
	void deleteUser(Integer userId);
	
	//get single
	UserDto getUser(Integer userId);
	
	//get all
	List<UserDto> getAllUsers();
	

}
