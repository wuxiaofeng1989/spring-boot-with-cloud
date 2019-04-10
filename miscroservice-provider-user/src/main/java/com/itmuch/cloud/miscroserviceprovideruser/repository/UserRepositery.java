package com.itmuch.cloud.miscroserviceprovideruser.repository;

import com.itmuch.cloud.miscroserviceprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositery extends JpaRepository<User, Long>{
}
