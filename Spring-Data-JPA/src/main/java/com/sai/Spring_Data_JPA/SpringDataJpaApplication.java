package com.sai.Spring_Data_JPA;

import com.sai.Spring_Data_JPA.model.College;
import com.sai.Spring_Data_JPA.repository.CollegeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		College college1 = context.getBean(College.class);
		College college2 = context.getBean(College.class);
//		College college3 = context.getBean(College.class);

		CollegeRepository collegeRepository = context.getBean(CollegeRepository.class);

		college1.setRollno(101);
		college1.setName("Satyam");
		college1.setGroup("MECH");

		college2.setRollno(102);
		college2.setName("Mani");
		college2.setGroup("CIVIL");

//		college3.setRollno(103);
//		college3.setName("Ramu");
//		college3.setGroup("CSE");

//		collegeRepository.save(college1);
//		collegeRepository.save(college2);
//		collegeRepository.save(college3);

		System.out.println(college1);
		System.out.println(college2);
//		System.out.println(college3);

//		System.out.println(collegeRepository.findAll());

//		Optional<College> o = collegeRepository.findById(103);
//		System.out.println(o.orElse(new College()));

//		System.out.println(collegeRepository.findByName("Ramu"));

//		collegeRepository.delete(college3);

	}

}
