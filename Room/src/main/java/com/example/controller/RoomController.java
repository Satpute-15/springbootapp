package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Member;
import com.example.sevice.RoomService;


@RestController
public class RoomController {
	
	@Autowired
	RoomService roomsevice;
	
	@GetMapping("/room")
	public List<Member> getMember(){
		List<Member> l1=roomsevice.getMember();
		return l1;
		}
	@PostMapping("/room")
	public String AddNewMember(@RequestBody Member mem) {
		String s=roomsevice.AddNewMember(mem);
		return s;
		
		
		//roomsevice.save(mem);
		}
	
	@GetMapping("/room/{name}")
	public List<Member> getMemberByName(@PathVariable String name){
		System.out.println("inside controler");
		List<Member> l2=roomsevice.getMemberByName(name);
		return l2;
		}
	@DeleteMapping("/room/{id}")
	public ResponseEntity<Object> deleteMember(@PathVariable int id) throws Exception {
		String s=roomsevice.deleteMember(id);
		return new ResponseEntity<Object>(s,HttpStatus.OK);
		}
	/*@PutMapping("/room")
	public void updateMemberDetails(@RequestBody Member mem) {
		Member m=roomRepo.getOne(mem.getMemId());
		m.setCity(mem.getCity());
		roomRepo.save(m);
	}*/
	@PutMapping("/room/{id}")
	public void updateMemberDetails(@PathVariable int id,@RequestBody Member mem) {
		roomsevice.updateMemberDetails(id, mem);
		
	}
}
