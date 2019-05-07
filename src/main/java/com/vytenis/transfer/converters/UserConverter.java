package com.vytenis.transfer.converters;

import com.vytenis.transfer.dto.User;
import com.vytenis.transfer.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements EntityConverter<UserEntity, User> {

    @Override
    public UserEntity convertToEntity(User user) {
        if (user == null) {
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setFullName(user.getFullName());
        return userEntity;
    }

    @Override
    public User convertFromEntity(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        User user = new User();
        user.setId(entity.getId());
        user.setFullName(entity.getFullName());
        return user;
    }
}
