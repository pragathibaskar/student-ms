package com.cg.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.db.Stud;
import com.cg.modal.Result;
import com.cg.modal.Student;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
@RestController
public class StudentController {
	@Autowired
	private Stud stu;
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	private RestTemplate restTemplate;
	Result result =new Result();
	
	@GetMapping("/{id}")
	   Optional<Student> getById(@PathVariable("id") Long id)
	   {
		return stu.findById(id);
		   
	   }
	   @DeleteMapping("/{id}")
	   void deleteById(@PathVariable("id") Long id)
	   {
		   stu.deleteById(id);
	   }
	   @PostMapping("/post")
		Student recieve(@RequestBody Student s)
		{
		  stu.saveAndFlush(s);
		  return s;
			
		}
	   
	   @GetMapping("/get")
	   List<Student> getDetails()
	   {
		return  stu.findAll();
		   
	   }
	   @GetMapping("microservice/{id}")
	    public Result getSalary(@PathVariable Long id) {
			Application application = eurekaClient.getApplication("result-service");
	        InstanceInfo instanceInfo = application.getInstances().get(0);
	        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/"+ id;
	        Result result = restTemplate.getForObject(url, Result.class);
	                
			return result;
	    } 

}
