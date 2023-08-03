package com.kosa.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosa.dao.BoardDAO;
import com.kosa.model.BoardVO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@WebServlet("/board")
public class BoardController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");

		String cmd = request.getParameter("cmd");
		System.out.println("cmd : " + cmd);
		
		if(cmd.equals("list")) {
			list(request, response);
		}
		if(cmd.equals("writeForm")) {
			writeForm(request, response);
		}
		if(cmd.equals("write")) {
			write(request, response);
		}
		if(cmd.equals("detail")) {
			detail(request, response);
		}
		if(cmd.equals("update")) {
			update(request, response);
		}
		if(cmd.equals("searchForm")) {
			searchForm(request, response);
		}
		if(cmd.equals("search")) {
			search(request, response);
		}
		if(cmd.equals("search2")) {
			search2(request, response);
		}
		if(cmd.equals("delete")) {
			delete(request, response);
		}
		
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		int seq = Integer.parseInt(request.getParameter("seq"));
		int result = dao.delete(seq);
		
		if(result > 0) {
			response.sendRedirect("board?cmd=list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}

	private void search2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> map = new HashMap<String, String>();

		map.put("writer", request.getParameter("writer"));
		map.put("content", request.getParameter("content"));
		map.put("title", request.getParameter("title"));
		map.put("keyvalue", request.getParameter("keyvalue"));
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList2(map);
		
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", request.getParameter("column"));
		map.put("keyvalue", request.getParameter("keyvalue"));
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectSearchList(map);
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}

	private void searchForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/WEB-INF/views/searchList.jsp").forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		
		int result = dao.update(vo);
		
		if(result > 0) {
			response.sendRedirect("board?cmd=list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}

	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		int seq = Integer.parseInt(request.getParameter("seq"));
		vo = dao.detailList(seq);
		
		if(vo != null) {
			request.setAttribute("dto", vo);
			request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}
	
	private void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		int result = dao.insert(vo);
		
		if(result == 1) {
			response.sendRedirect("board?cmd=list");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}

	private void writeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();
		
		if(list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
		} else {
			//response.sendRedirect("index.jsp");
			request.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(request, response);
		}
	}
}
