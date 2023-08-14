package com.javassem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.dao.ReplyDAO;
import com.javassem.domain.ReplyVO;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	ReplyDAO replyDAO;
	
	@PostMapping("/insert")
	public void insert(@RequestBody ReplyVO vo) {
		replyDAO.insertReply(vo);
	}
	
	@DeleteMapping("/delete/{rno}")
	public void delete(@PathVariable String rno) {
		replyDAO.deleteReply(rno);
	}
	
	@GetMapping("/selectAll")
	public List<ReplyVO> selectAll() {
		List<ReplyVO> list = replyDAO.selectAllReply();
		return list;
	}
	
}
