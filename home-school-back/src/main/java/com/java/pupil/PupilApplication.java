package com.java.pupil;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.java.pupil.mapper")
@SpringBootApplication
public class PupilApplication {

	public static void main(String[] args) {
		SpringApplication.run(PupilApplication.class, args);
	}
}
