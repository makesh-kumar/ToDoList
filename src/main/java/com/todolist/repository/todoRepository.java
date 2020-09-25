/**
 * 
 */
package com.todolist.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.todolist.model.Tododata;

/**
 * 
 *@author Makesh Kumar
 * 
 */
public interface todoRepository extends MongoRepository<Tododata,Integer>{
	
	 
//	List<User> findByName(String userName);

	/**
	 * @param city
	 * @return
	 */
//	@Query("{'Tododata.UserId':?0}")
	List<Tododata> findByUserId(String id);

	
	List<Tododata> findByTitle(String tit);
	
}
