package com.softtech.case3.converter;

import com.softtech.case3.dto.UserDto;
import com.softtech.case3.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<UserDto> convertToUserDtoList(List<User> userList);

    UserDto convertToUserDto(User user);

    User convertToUser(UserDto userDto);
}
