package com.sadhwani.kubernetes.UserManagementService.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUsernameAndPassword(String username,String password);
    User save(User user);
}
