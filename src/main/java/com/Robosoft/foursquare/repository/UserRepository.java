package com.Robosoft.foursquare.repository;

import com.Robosoft.foursquare.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
