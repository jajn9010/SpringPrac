package com.model;

import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {
	public MemberVO selectMemberById(String id) throws SQLException;
	public List memberById(String id) throws SQLException;
	
	public boolean memberCheck(String id, String pwd) throws SQLException;
	
	public boolean insertMember(MemberVO vo) throws SQLException;
}
