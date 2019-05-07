package com.vytenis.transfer.service;

import com.vytenis.transfer.converters.UserConverter;
import com.vytenis.transfer.dao.UserDao;
import com.vytenis.transfer.dto.User;
import com.vytenis.transfer.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return StreamUtils.createStreamFromIterator(userDao.findAll().iterator())
                .map(userConverter::convertFromEntity)
                .collect(Collectors.toList());
    }

    public User getUser(long id) {
        return userConverter.convertFromEntity(userDao.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Transactional
    public long addUser(User user) {
        UserEntity userEntity = userConverter.convertToEntity(user);
        userDao.save(userEntity);
        return userEntity.getId();
    }
}
