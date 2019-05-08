package com.launchcode.cheesemvc.Model.data;

import com.launchcode.cheesemvc.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Long> {

}
