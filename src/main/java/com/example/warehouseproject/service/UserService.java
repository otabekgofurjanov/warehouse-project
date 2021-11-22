package com.example.warehouseproject.service;

import com.example.warehouseproject.domain.User;
import com.example.warehouseproject.repository.UserRepository;
import com.example.warehouseproject.service.dto.UserDTO;
import com.example.warehouseproject.service.mapper.UserMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;

	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}

	public UserDTO save(UserDTO userDTO) {
		if (userDTO.getId() == null) {
			User user = userMapper.toEntity(userDTO);
			user = userRepository.save(user);
			return userMapper.toDto(user);
		}
		return null;
	}

	public UserDTO update(UserDTO userDTO) {
		User user = userMapper.toEntity(userDTO);
		user = userRepository.findByUserId(user.getId());
		if (user.getId() != null) {
			user.setFirstName(user.getFirstName());
			user.setLastName(user.getLastName());
			user.setPhoneNumber(user.getPhoneNumber());
			user.setCode(user.getCode());
			user.setActive(user.getActive());
			user = userRepository.save(user);
			return userMapper.toDto(user);
		}
		return null;
	}

	public Page<UserDTO> findAll(Pageable pageable) {
		return userRepository.findAll(pageable).map(userMapper::toDto);
	}

	public Optional<UserDTO> findOne(Long id) {
		if (id == null) {
			return null;
		}
		return userRepository.findById(id).map(userMapper::toDto);
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
