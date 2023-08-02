package com.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		String sql = "SELECT * FROM USERMEMBER WHERE ID = ?";
		
		try {
			return this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<MemberVO>(), id);
			//return this.jdbcTemplate.queryForObject(sql, new Object[] {id}, MemberVO.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List memberById(String id) throws SQLException {
		String sql = "SELECT * FROM USERMEMBER WHERE ID = ?";
		return this.jdbcTemplate.queryForList(sql, id);
	}

	@Override
	public boolean memberCheck(String id, String pwd) throws SQLException {
		String sql = "SELECT * FROM USERMEMBER WHERE ID = ? AND PWD = ?";
		boolean flag = false;
		Object[] params = {id, pwd};
		
		if(this.jdbcTemplate.queryForList(sql, params).size() > 0) flag = true;
		
		return flag;
	}

	@Override
	public boolean insertMember(MemberVO vo) throws SQLException {
		String sql = "insert into usermember values (?, ?, ?, ?, ?)";
		boolean flag = false;
		Object[] params = {vo.getId(), vo.getName(), vo.getPwd(), vo.getEmail(), vo.getAge()};
		
		if(this.jdbcTemplate.update(sql, params) > 0) flag = true;
		
		return flag;
	}

}
