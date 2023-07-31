package edu.kosa.util;

import java.sql.Connection;

//확장이 가능, 관계를 느슨하게 처리.
public interface ConnectionMaker {
	
	Connection makeConnection() throws Exception;
}
