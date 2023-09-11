package com.briz.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController 
{
@Autowired
PersonRepository prepo;

@RequestMapping("/test")
public String save()
{
	Person p=new Person();
	p.setAge(23);p.setCity("bokaro");p.setCountry("india");p.setName("abhay");
	prepo.save(p);
	return "<h1 style=color:red;>hello test</h1>";// valid syntax 
}

@RequestMapping("/all")
public List<Person> all() throws InterruptedException
{
	for(int x=0;x<=5;x++)
	{
		Thread.sleep(3000);
	System.out.println("hello");
	}
	return prepo.findAll();
}
@RequestMapping("/{id}")
public Person1 some(@PathVariable int id)
{
	return prepo.getDetailById(id);
}
@RequestMapping("/by/{name}")
public Person2 byint(@PathVariable String name)
{
	return prepo.getByName(name);
}
@RequestMapping("/by/new/{id}")
public Person3 byid(@PathVariable int id) // results are unique always
{
	return prepo.getDetailsById(id);
}
@RequestMapping("/del/{id}")
public void del(@PathVariable int id)
{
	prepo.deleteById(id);
}
}
