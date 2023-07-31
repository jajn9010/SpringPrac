package edu.kosa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO { // model
	private String id, name, password;
}
