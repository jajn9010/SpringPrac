package edu.kosa.dao_di;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;

import edu.kosa.model.UserVO;
import edu.kosa.util.ConnectionMaker;

public class UserDAO {
	
	@Autowired
	private ConnectionMaker connectionMaker;
	
	//3. DML 명령어 사용
	//insert
	public void insert(UserVO vo) {
		String sql = "INSERT INTO USERS(ID, NAME, PASSWORD) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connectionMaker.makeConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getPassword());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "개의 DATA 입력 성공!!!! connectionMaker");
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
			conn = connectionMaker.makeConnection();
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
	//update
	public void updateById(String id, UserVO vo) {
		String sql = "update users set id = ?, name = ?, password = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connectionMaker.makeConnection();
			pstmt = conn.prepareStatement(sql);
			
			
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
	
	//selectById
	
	//delete
	public void deleteById(String id) {
		String sql = "DELETE FROM USERS WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connectionMaker.makeConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "개의 아이디를 삭제하였습니다.");
			System.out.println(id + "를 삭제하였습니다.");
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
	
	//menu
	public void menu() {
		System.out.println("선택하세요 : \n1. Insert \n2. SelectAll \n3. SelectById \n4. Update \n5. Delete");
	}
}
