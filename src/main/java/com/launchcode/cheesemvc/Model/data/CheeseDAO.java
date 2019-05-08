package com.launchcode.cheesemvc.Model.data;

import com.launchcode.cheesemvc.Model.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CheeseDAO extends CrudRepository<Cheese, Integer> {
    //custom Query methods go in here

    default void deleteMany(int[] cheeseIDs){

        for(int cheeseID : cheeseIDs){
            delete(cheeseID);
        }
    }
}
