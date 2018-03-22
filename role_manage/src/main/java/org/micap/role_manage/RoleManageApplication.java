package org.micap.role_manage;

import org.bson.types.ObjectId;
import org.micap.common.entity.Function;
import org.micap.common.entity.Role;
import org.micap.common.enums.Methods;
import org.micap.role_manage.repository.RoleDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class RoleManageApplication {


	public static void main(String[] args) {
		SpringApplication.run(RoleManageApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleDao roleDao){
		return args -> {
			roleDao.deleteAll().subscribe(null,null,()->{
				Role r1=new Role("User","Role de usuario",new Function[]{});
				Role r2=new Role("ADMIN","Role of Admin to Admintrate all Page",new Function[]{
						new Function(new ObjectId().toString(),"USER",new Methods[]{
								Methods.CREATE,
								Methods.DELETE,
								Methods.GET,
								Methods.UPDATE
						}),
						new Function(new ObjectId().toString(),"ROLE",new Methods[]{
								Methods.CREATE,
								Methods.DELETE,
								Methods.GET,
								Methods.UPDATE
						})
				});
				roleDao.insert(r1).subscribe(System.out::println);
				roleDao.insert(r2).subscribe(System.out::println);
			});
		};
	}
}
