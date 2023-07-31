package edu.kosa.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.kosa.dao_di.UserDAO;
import edu.kosa.model.UserVO;

public class MainEntry {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String config = "classpath:edu/kosa/dao_di/ctx.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		UserDAO dao = ctx.getBean("userDAO", UserDAO.class);
		
		dao.menu();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		switch (Integer.parseInt(br.readLine())) {
		case 1:
			UserVO vo = new UserVO();
			System.out.println("user id = ");
			vo.setId(br.readLine());
			System.out.println("user name = ");
			vo.setName(br.readLine());
			System.out.println("user password = ");
			vo.setPassword(br.readLine());
			
			dao.insert(vo);
			System.out.println(vo.getId() + "추가 성공");
			System.out.println("==========================================");
			break;

		case 2:
			dao.seletAll();
			break;
			
		case 3:
			System.out.println("찾을 아이디를 검색하세요.");
			String id = br.readLine();
			//dao.selectById(id);
			break;
			
		case 4:
			System.out.println("변경할 아이디를 입력하세요.");
			String id3 = br.readLine();
			UserVO vo2 = new UserVO();
			
			System.out.println("무엇을 변경하시겠습니까?");
			System.out.println("1. id \n2. name\n3.password");
			
			switch (Integer.parseInt(br.readLine())) {
			case 1:
				
				break;
			
			case 2:
				
				break;

			case 3:
				
				break;
			}
			break;
			
		case 5:
			System.out.println("삭제할 아이디를 입력하세요.");
			String id2 = br.readLine();
			dao.deleteById(id2);
			break;
		default:
			break;
		}
		
		/*
		UserDAO dao = new OracleUserDAOImpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dao.menu();
		switch (Integer.parseInt(br.readLine())) {
		case 1:
			UserVO vo = new UserVO();
			System.out.println("user id = ");
			vo.setId(br.readLine());
			System.out.println("user name = ");
			vo.setName(br.readLine());
			System.out.println("user password = ");
			vo.setPassword(br.readLine());
			
			dao.insert(vo);
			System.out.println(vo.getId() + "추가 성공");
			System.out.println("==========================================");
			break;

		case 2:
			dao.seletAll();
			break;
			
		case 3:
			System.out.println("찾을 아이디를 검색하세요.");
			String id = br.readLine();
			dao.selectById(id);
			break;
		default:
			break;
		}
		*/
		
	}
}
