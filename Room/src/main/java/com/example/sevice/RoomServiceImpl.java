package com.example.sevice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.repository.RoomRepository;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	@Autowired
	RoomRepository roomRepo;
	public List<Member> getMember(){
		
		return roomRepo.findAll();
		}
	public List<Member> getMemberByName( String name){
		System.out.println("inside controler");		
		return roomRepo.findByMemName(name);
		}
	public String deleteMember( int id) throws EmptyResultDataAccessException {
		try{roomRepo.deleteById(id);
		return "deleted";
		}
		catch(EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException(1);
		}
		}
	public void updateMemberDetails( int id, Member mem) {
		Member m=roomRepo.getOne(id);
		m.setMemName(mem.getMemName());
		m.setCity(mem.getCity());
		m.setContactNumber(mem.getContactNumber());
		roomRepo.save(m);
	}
	/*public String AddNewMember( Member mem) {
		if(mem.getMemId()!=roomRepo.getOne(mem.getMemId()).getMemId()) {
		Member m=new Member();
		m.setMemId(mem.getMemId());
		m.setMemName(mem.getMemName());
		m.setCompany(mem.getCompany());
		m.setCity(mem.getCity());
		m.setContactNumber(mem.getContactNumber());
		roomRepo.save(m);
		return "Mmber added successfully with id"+mem.getMemId();}
		else{
			return "Member Alredy exist with id "+mem.getMemId();
		}
		
	}*/
	@Override
	public String AddNewMember(Member mem) {
		if(!roomRepo.existsById(mem.getId())) {
		roomRepo.saveAndFlush(mem);
		return "Mmber added successfully with id"+mem.getId();
		}
		else{
			return "Member Alredy exist with id "+mem.getId();
		}
	}
}
