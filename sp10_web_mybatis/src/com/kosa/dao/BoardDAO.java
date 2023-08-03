package com.kosa.dao;

import java.util.List;
import java.util.Map;

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
	
	//detail
	public BoardVO detailList(int seq) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionFactory().openSession();
			return sqlSession.selectOne("dao.detailList", seq);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
	} // end detail
	
	//update
	public int update(BoardVO vo) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionFactory().openSession();
			int cnt = sqlSession.update("dao.update", vo);
			sqlSession.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
	}
	
	//전체 검색 조회 - 1
	public List<BoardVO> selectSearchList(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionFactory().openSession();
			return sqlSession.selectList("dao.selectSearch", map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
	}
	
	//전체 검색 조회 - 2
	public List<BoardVO> selectSearchList2(Map<String, String> map) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionFactory().openSession();
			return sqlSession.selectList("dao.selectSearch2", map);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
	}
	
	public int delete(int seq) {
		try {
			sqlSession = sqlSessionFactory.getSqlSessionFactory().openSession();
			int count = sqlSession.delete("dao.delete", seq);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
	}
}
