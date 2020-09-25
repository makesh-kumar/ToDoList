/**
 * 
 */
package com.todolist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.todolist.model.Signup;
import com.todolist.model.Tododata;

/**
 * 
 *@author Makesh Kumar
 * 
 */
public interface SignupRepository extends MongoRepository<Signup,Integer>{
//	boolean existByEmail(String email);
	Signup findByEmail(String tit);
}
