package com.launchcode.cheesemvc.Model.data;

import com.launchcode.cheesemvc.Model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MenuDAO extends CrudRepository<Menu, Integer> {

}
