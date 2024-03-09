/*
 * File: TeamviewerApplication.java
 * Description: This file contains the main entry point for the Spring Boot application.
 * Author: Alexander D Spies
 * Date: 9 March 2024
 * 
 * This class initializes the Spring Boot application and starts the embedded Tomcat server.
 * It is annotated with @SpringBootApplication, which enables auto-configuration and component scanning.
 * 
 * Usage:
 * - Run this class to start the Spring Boot application.
 * - Ensure that the necessary dependencies and configurations are in place.
 * - Customize the main method if additional initialization logic is required.
 * 
 * For more information about Spring Boot and application setup, refer to the official documentation:
 * - Spring Boot: https://spring.io/projects/spring-boot
 */

 package com.teamviewercodingchallenge.teamviewer;

 import org.springframework.boot.SpringApplication;
 import org.springframework.boot.autoconfigure.SpringBootApplication;
 
 @SpringBootApplication
 public class TeamviewerApplication {
 
	 public static void main(String[] args) {
		 SpringApplication.run(TeamviewerApplication.class, args);
	 }
 
 }
 