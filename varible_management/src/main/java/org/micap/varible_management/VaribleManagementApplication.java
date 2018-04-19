package org.micap.varible_management;

import org.bson.types.ObjectId;
import org.micap.common.entity.Variable;
import org.micap.varible_management.repository.VariableDaoMongo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VaribleManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(VaribleManagementApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner commandLineRunner(VariableDaoMongo variableDaoMongo){
		return args -> {
			variableDaoMongo.deleteAll().subscribe(null,null,()->{
				variableDaoMongo.insert(
						new Variable(
								"GENDER",
								"These are the genres considered to be registered",
								new String[]{
										"FEMALE",
										"MALE"
								}
						)
				).subscribe(System.out::print);
				variableDaoMongo.insert(
						new Variable(
								"METHODS",
								"These are the mothods used to determinate the crud operations",
								new String[]{
										"CREATE",
										"READ",
										"UPDATE",
										"DELETE"
								}
						)
				).subscribe(System.out::print);

			});
		};
	}*/
}
