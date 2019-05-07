package com.vytenis.transfer.dao;

import com.vytenis.transfer.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserEntity, Long> {
}
