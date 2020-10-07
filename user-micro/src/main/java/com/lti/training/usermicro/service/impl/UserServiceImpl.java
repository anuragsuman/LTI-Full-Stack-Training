package com.lti.training.usermicro.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.training.usermicro.dto.LoginDto;
import com.lti.training.usermicro.dto.RegisterDto;
import com.lti.training.usermicro.dto.UserDetailDto;
import com.lti.training.usermicro.entity.User;
import com.lti.training.usermicro.repository.UserRepository;
import com.lti.training.usermicro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	// Dependency
	private UserRepository userRepository;

	@Autowired // optional
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetailDto register(RegisterDto registerDto) {
		// convert the DTO into entity
		// separate util package ( custom converter methods )
		// ModelMapper 
		User user = new User(null, registerDto.getName(), registerDto.getEmailId(), registerDto.getPassword());
		// to use repository layer to persist in database
		user = this.userRepository.save(user);
		// convert the entity into DTO
		UserDetailDto userDetailDto = new UserDetailDto(user.getId(), user.getName(), user.getEmailId());
		return userDetailDto;

	}

	@Override
	public UserDetailDto getUserDetail(Integer userId) {
		// fetch data from DB

		// java - 8
		// Optional<User>
		// Optional<User> userInfo = this.userRepository.findById(userId);
		// userInfo.ifPresent()
		User user = this.userRepository.findById(userId).orElse(new User());
		// Optional<User> user = Optional.of(user);

		// convert Entity into DTO
		UserDetailDto userDetailDto = 
				new UserDetailDto(user.getId(), user.getName(), user.getEmailId());
		return userDetailDto;
	}

	@Override
	public UserDetailDto login(LoginDto loginDto) {

		User user = this.userRepository.findByEmailIdAndPassword(loginDto.getEmailId(), loginDto.getPassword());
		
		if(user == null) {
			
		}

		// convert Entity into DTO
		UserDetailDto userDetailDto = 
				new UserDetailDto(user.getId(), user.getName(), user.getEmailId());

		return userDetailDto;
	}

}
