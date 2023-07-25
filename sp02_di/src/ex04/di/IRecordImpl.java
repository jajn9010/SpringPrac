package ex04.di;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IRecordImpl implements IRecord { // DTO

	private int kor, eng, com;

	@Override
	public int total() {
		return this.kor + this.eng + this.com;
	}

	@Override
	public float avg() {
		return total() / 3.f;
	}

}
