package ga.hariss.blogs.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ga.hariss.blogs.entities.User;
import ga.hariss.blogs.exceptions.ResourceNotFound;
import ga.hariss.blogs.payloads.UserDto;
import ga.hariss.blogs.repositories.UserRepository;
import ga.hariss.blogs.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.mapper.map(userDto, User.class);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEnable(true);
		User savedUser = this.userRepo.save(user);
		return this.mapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		User updatedUser = this.userRepo.save(user);
		return this.mapper.map(updatedUser, UserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		this.userRepo.delete(user);
	}

	@Override
	public UserDto getUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("User", userId));
		return this.mapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		return users.stream().map((user) -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

}
