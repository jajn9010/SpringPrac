package board.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import board.controller.BoardDAO;
import board.model.BoardVO;

public class MainEntry {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("무엇을 하시겠습니까?");
		System.out.println("1.전체검색, 2.수정, 3.추가, 4.삭제");
		
		switch (Integer.parseInt(br.readLine())) {
		case 1:
			List<BoardVO> list = dao.selectAll();
			for(BoardVO board : list) System.out.println(board);
			break;

		case 2:
			vo.setTitle("제목");
			vo.setWriter("작성자");
			vo.setContent("내용");
			vo.setSeq(1);
			dao.update(vo);
			
			List<BoardVO> list2 = dao.selectAll();
			for(BoardVO board : list2) System.out.println(board);
			break;
			
		case 3:
			System.out.println("제목을 입력하세요.");
			String title = br.readLine();
			System.out.println("내용을 입력하세요.");
			String content = br.readLine();
			System.out.println("작성자을 입력하세요.");
			String writer = br.readLine();
			
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);
			dao.insert(vo);
			break;
		
		case 4:
			System.out.println("삭제할 번호를 입력하세요.");
			int seq = Integer.parseInt(br.readLine());
			dao.delete(seq);
			break;
		}
		
	}
}
