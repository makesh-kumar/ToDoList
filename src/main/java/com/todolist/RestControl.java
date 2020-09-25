/**
 * 
 */
package com.todolist;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.todolist.model.LoginData;
import com.todolist.model.Signup;
import com.todolist.model.Tododata;
import com.todolist.repository.SignupRepository;
import com.todolist.repository.todoRepository;


/**
 * 
 *@author Makesh Kumar
 * 
 */
@RestController
@CrossOrigin("*")
public class RestControl
{
	@Autowired
	todoRepository repo;
	@Autowired
	SignupRepository sgRepo;
	
	@GetMapping("/")
	public String tesdt() {
		return "Its working on slash- "+new Date();
	} 
	@GetMapping("/test")
	public String test() {
		return "Its working - "+new Date();
		

		
	}
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody Signup signup) {
		System.out.println("IN SINGUP "+signup);
		sgRepo.save(signup);
		return "SIGN UP SUCCESSFULL !";
	}
	
	
	@GetMapping("isUser/{userid}")
	public Signup isUser(@PathVariable String userid) {
		
		Signup s = sgRepo.findByEmail(userid);
		if(s == null) {System.out.println("No Such User");}
		else System.out.println("USER  FOUND LIKE "+userid);
		return s;
	}
	
	@PostMapping("/login")
	public Signup login(@RequestBody LoginData data) {
//		
		System.out.println("LLL"+data);
		Signup s = sgRepo.findByEmail(data.getEmail());
		if(s== null) {
			return null;
		}
		else {
			if(s.getPass().equals(data.getPassword())) {
				return s;
			}
			else {
				return null;
			}
		}
		
	}
	
	@PostMapping("/addData")
	public String addData(@RequestBody Tododata data) {
		System.out.println("CAME TO ADD");
		System.out.println(data);
		repo.save(data);
		return "Data Added";
	}
	
	@GetMapping("/getData/{id}")
	public List<Tododata> getData(@PathVariable String id){
		System.out.println(id);
		List<Tododata> list = repo.findByUserId(id);
		System.out.println(list);
		Collections.reverse(list); 
		return list;
	}
	
	@PostMapping("/deleteData")
	public String deleteData(@RequestBody Tododata data) {
		System.out.println("in delete "+data);
		repo.delete(data);
		return "Data Deleted";
	}
	
	@PostMapping("/updateProfile")
	public String updateProfile(@RequestBody Signup signup ) {
		System.out.println("** In update Profile "+signup);
		String email = signup.getEmail();
		String name = signup.getName();
		Signup s = sgRepo.findByEmail(email);
		System.out.println("##"+s);
		s.setName(name);
		sgRepo.save(s);
		return "Profile Updated";
	}
	
	@PostMapping("/changePassword")
	public String changePassword(@RequestBody Signup signup ) {
		System.out.println("** In Password "+signup);
		String email = signup.getEmail();
		String pass = signup.getPass();
		Signup s = sgRepo.findByEmail(email);
		System.out.println("##"+s);
		s.setPass(pass);
		s.setConpass(pass);
		sgRepo.save(s);
		return "Password Changed";
	}
	
	@GetMapping("/getNews")
	public Object getNews() {
		System.out.println("*** in get news ");
	    final String uri = "http://newsapi.org/v2/top-headlines?country=in&apiKey=072b62dc3937448f97f96d362878e22d";
	    RestTemplate restTemplate = new RestTemplate();
	     
//	    employee result = restTemplate.getForObject(uri, employee.class);
	    Object result = restTemplate.getForObject(uri, Object.class);
	     
//	    System.out.println(result);
	    return result;
	}
	
	@GetMapping("/getNewsOf/{category}")
	public Object getNewsOf(@PathVariable String category) {
		System.out.println("*** in get of news ");
	    final String uri = "http://newsapi.org/v2/top-headlines?country=in&category="+category+"&apiKey=072b62dc3937448f97f96d362878e22d";
	    RestTemplate restTemplate = new RestTemplate();
	    Object result = restTemplate.getForObject(uri, Object.class);
	     
//	    System.out.println(result);
	    return result;
	}
}
