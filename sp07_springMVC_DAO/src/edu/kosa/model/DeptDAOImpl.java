package edu.kosa.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DeptDAOImpl implements DeptDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate; //DML 명령 처리 클래스 - insert, update, delete, select
	
	@Override
	public List listDept() {
		String sql = "SELECT * FROM DEPT ORDER BY DEPTNO DESC";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public void insertDept(DeptDTO dto) {
		String sql = "INSERT INTO DEPT VALUES(?, ?, ?)";
		Object[] arr = {dto.getDeptno(), dto.getDname(), dto.getLoc()};
		
		this.jdbcTemplate.update(sql, arr);
	}

}
