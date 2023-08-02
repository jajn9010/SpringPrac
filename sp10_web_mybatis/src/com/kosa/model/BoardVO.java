package com.kosa.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private int seq, readcount;
	private String title, writer, content;
	private Date regdate;
	
	private String searchCondition;
	private String searchKeyword;
	
	BoardVO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", readcount=" + readcount + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", regdate=" + regdate +"]";
	}
}
