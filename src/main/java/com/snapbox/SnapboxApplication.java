package com.snapbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javafx.application.Application;

@SpringBootApplication
public class SnapboxApplication {

	public static void main(String[] args) {
		Application.launch(JavaFxApplication.class, args);
	}

}
