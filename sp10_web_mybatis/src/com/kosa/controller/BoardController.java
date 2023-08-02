package com.kosa.controller;

import java.io.IOException;
import java.util.List;

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
	}
	private void write(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setWriter(request.getParameter("writer"));
		vo.setContent(request.getParameter("content"));
		int result = dao.insert(vo);
		
		if(result == 1) {
			try {
				response.sendRedirect("board?cmd=list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.sendRedirect("/WEB-INF/views/error.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void writeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/writeForm.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAll();
		
		if(!list.isEmpty()) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request, response);
		} else {
			//response.sendRedirect("index.jsp");
			response.sendRedirect("/WEB-INF/views/error.jsp");
		}
	}
}
