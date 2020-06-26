package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Member;



@Repository
public interface RoomRepository extends JpaRepository<Member,Integer> {
	
public List<Member> findByMemName(String memName);
}
