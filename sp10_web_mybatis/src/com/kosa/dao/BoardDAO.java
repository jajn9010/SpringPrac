package com.kosa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.kosa.config.SqlSessionFactoryService;
import com.kosa.model.BoardVO;

@Component
public class BoardDAO {
	private SqlSessionFactoryService sqlSessionFactory;
	private SqlSession sqlSession = null; //DML 처리 함수를 갖고 있다.
	
	//selectAll
	public List<BoardVO> selectAll() {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionFactory().openSession();
			return sqlSession.selectList("dao.selectAll");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
	}
	
	public int insert(BoardVO vo) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionFactory().openSession();
			sqlSession.insert("dao.insert", vo);
			sqlSession.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
	}
}
