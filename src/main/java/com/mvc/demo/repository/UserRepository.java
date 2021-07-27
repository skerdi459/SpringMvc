package com.mvc.demo.repository;

import com.mvc.demo.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface UserRepository extends CrudRepository<Users,Long> {
}
