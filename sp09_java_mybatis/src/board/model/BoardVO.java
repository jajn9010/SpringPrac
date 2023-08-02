package board.model;

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
	
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", readcount=" + readcount + ", title=" + title + ", writer=" + writer
				+ ", content=" + content + ", regdate=" + regdate +"]";
	}
}
