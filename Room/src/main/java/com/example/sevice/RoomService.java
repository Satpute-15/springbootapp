package com.example.sevice;

import java.util.List;

import com.example.model.Member;

public interface RoomService {
	public List<Member> getMember();
	public List<Member> getMemberByName( String name);
	public String deleteMember( int id) throws Exception;
	public void updateMemberDetails( int id, Member mem);
	public String AddNewMember( Member mem);
	
}
