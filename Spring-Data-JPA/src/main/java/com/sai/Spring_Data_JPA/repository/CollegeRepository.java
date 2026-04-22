package com.sai.Spring_Data_JPA.repository;

import com.sai.Spring_Data_JPA.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {

//    @Query("SELECT c FROM College c where c.nane = ?") // This line Optional in spring data jpa
    List<College> findByName(String name);
}
