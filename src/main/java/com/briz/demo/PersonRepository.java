package com.briz.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> 
{
Person1 getDetailById(int id);
Person2 getByName(String name);
//List<Person2> getByName(String name);

@Query("select new com.briz.demo.Person3(p.id,p.name,p.age,p.city) from person p where p.id=?1")
Person3 getDetailsById(int id);
List<Person> findByAge(int age);
}
