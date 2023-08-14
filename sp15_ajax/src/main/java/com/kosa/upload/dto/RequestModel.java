package com.kosa.upload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {
	
	private String name;
	private String fileName;
	private String uploadedFileName;
	private long fileSize;
	private String contentType;
	private String downlink;
}
