package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Notification implements Serializable {
	private String notificationId;
	private Date createdAt;
	private Boolean seen;
	private String message;
}
