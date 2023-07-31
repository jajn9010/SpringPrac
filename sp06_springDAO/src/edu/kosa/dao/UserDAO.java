package edu.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.kosa.model.UserVO;

public abstract class UserDAO { // 추상클래스
	
	//DB 연결을 위한 추상 메소드
	public abstract Connection getConnection() throws Exception;
	
	//3. 사용(DML 명령어)
	
	//insert
	public void insert(UserVO vo) {
		String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "개의 DATA 입력 성공!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//selectAll
	public void seletAll() {
		String sql = "SELECT * FROM USERS";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("\n\tID\tName\tPWD");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pwd = rs.getString("password");
				System.out.println("\t" + id + "\t" + name + "\t" + pwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//selectById
	public void selectById(String id) {
		String sql = "SELECT * FROM USERS WHERE ID = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			System.out.println("\n\tID\tName\tPWD");
			if(rs.next()) {
				String id2 = rs.getString("id");
				String name = rs.getString("name");
				String pwd = rs.getString("password");
				System.out.println("\t" + id2 + "\t" + name + "\t" + pwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//update
	
	//delete
	
	//menu
	public void menu() {
		System.out.println("선택하세요 : \n1. Insert \n2. SelectAll \n3. SelectById \n4. Update \n5. Delete");
	}



}
