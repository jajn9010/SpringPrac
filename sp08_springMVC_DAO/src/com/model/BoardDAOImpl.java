package com.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class BoardDAOImpl implements MemberDAO {

	@Autowired
	private MemberDAO boardMemberDAO;
	
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List memberById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean memberCheck(String id, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertMember(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
