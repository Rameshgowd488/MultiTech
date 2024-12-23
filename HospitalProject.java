//Hospital Project
package Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="JPA_Hospital")
@Data
public class Hospital {
	
	
	@Id
	@Column(name="DOC_ID")
	private Integer docId;
	@Column(name="DOC_NAME", length = 20)
	private String docName;
	@Column(name="DOC_DESG",length = 20)
	private String docDesg;
	@Column(name="DOC_SAL")
	private Double docSalary;
	
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocDesg() {
		return docDesg;
	}
	public void setDocDesg(String docDesg) {
		this.docDesg = docDesg;
	}
	public Double getDocSalary() {
		return docSalary;
	}
	public void setDocSalary(Double docSalary) {
		this.docSalary = docSalary;
	}
	
}

package com.repo;
import org.springframework.data.repository.CrudRepository;
import Entity.Hospital;
public interface IHospitalRepo extends CrudRepository<Hospital,Integer>{

}
package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repo.IHospitalRepo;
import Entity.Hospital;
import ch.qos.logback.core.property.CanonicalHostNamePropertyDefiner;
@Service("ilo")
public class HospitalServiceImpl  implements IHospitalService{
@Autowired 
private IHospitalRepo rep;
	@Override
	public String doctorinfo(Hospital h)
	{
		Hospital j=rep.save(h);
		return "DoctId:"+j.getDocId();
	}
}
package com.service;

import Entity.Hospital;

public interface IHospitalService {

	public String doctorinfo(Hospital h);
}

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.4.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>HospitalProject1</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>HospitalProject1</name>
	<description>Demo project for Spring Boot</description>
	<url/>
	<licenses>
		<license/>
	</licenses>
	<developers>
		<developer/>
	</developers>
	<scm>
		<connection/>
		<developerConnection/>
		<tag/>
		<url/>
	</scm>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<configuration>
					<annotationProcessorPaths>
						<path>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</path>
					</annotationProcessorPaths>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>

	</build>

</project>
-----------------------------------------------
spring.application.name=HealthCare
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/ram
spring.datasource.username=root
spring.datasource.password=123
# config JPA
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.idle-timeout=30000
spring.datasource.hikari.max-lifetime=600000
spring.datasource.hikari.connection-timeout=30000
------------------------------------------------------

package com.rm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.service.IHospitalService;

import Entity.Hospital;
@SpringBootApplication
public class HealthCareApplication {

	public static void main(String[] args) {
	ApplicationContext c=SpringApplication.run(HealthCareApplication.class, args);
	IHospitalService ch=c.getBean("ilo",IHospitalService.class);
	Hospital cj=new Hospital();
	cj.setDocId(123);
	cj.setDocName("Ramesh");
	cj.setDocDesg("RMP");
	cj.setDocSalary(900.00);
	String m=ch.doctorinfo(cj);
	System.out.println(m);
	}
}
--------------------------------------------------------------------------------------------------------------
