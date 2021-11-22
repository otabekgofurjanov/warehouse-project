package com.example.warehouseproject.service.mapper;

import com.example.warehouseproject.domain.User;
import com.example.warehouseproject.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface UserMapper extends EntityMapper<UserDTO, User> {

	default User fromId(Long id) {
		if (id == null) {
			return null;
		}

		User user = new User();
		user.setId(id);
		return user;
	}
}
