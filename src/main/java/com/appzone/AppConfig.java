/**
Requirements:
	You are required to implement a web application that would allow users to login and post comments. The comments will first be approved by a moderator before they are published. The following screens should be delivered:
	- Login screen
	- Main screen with all comments published for normal users
	- Add comment screen for normal users
	- A screen for the moderator to approve newly added comments

Technologies that should be used:
	- Spring Boot
	- Spring Security (login using custom db ajax authentication)
	- Spring Data
	- JPA/Hibernate
	- MySQL or PostgreSQL
	- Activiti WF engine
	- AngularJS or jQuery for frontend
	- Maven

Application will support Smart Client architecture. The frontend should be completely separate from backend. Backend will expose Restful web services using Spring RestControllers. Frontend will consume the exposed web services

Deliverables:

	- Runnable JAR and a Maven project (i.e. source code).

Submission:

	- Open-source project on Github.
 */
package com.appzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hossam Youssef
 *
 */
@SpringBootApplication
public class AppConfig {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}
