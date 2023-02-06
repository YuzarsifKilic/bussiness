package com.yuzarsif.business.repository;

import com.yuzarsif.business.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
