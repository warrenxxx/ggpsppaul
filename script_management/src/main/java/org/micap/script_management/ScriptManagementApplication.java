package org.micap.script_management;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.time.LocalDateTime;

@SpringBootApplication
public class ScriptManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScriptManagementApplication.class, args);
    }

    @Autowired
    SolrOperations operations;

    @Bean
    CommandLineRunner commandLineRunner (CrudRepository repository){
        return args->{
            repository.save(
                    new Script("1",LocalDateTime.now(),LocalDateTime.now(),new String[]{"este es un mensaje","este es otro mensaje"})
            );
            repository.save(
                    new Script("2",LocalDateTime.now(),LocalDateTime.now(),new String[]{"este es un mensaje","este es otro mensaje"})
            );
            System.out.println(
                    repository.count()
            );

            repository.findById("1").map(e->{
                System.out.println(e);
               return e;
            });
            repository.findAll().forEach(System.out::println);
            operations.
        };
    }
}
interface ScriptDao extends CrudRepository<Script,String>{}


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@SolrDocument(collection = "persona")
class Script {
    private @Id
    String id;
    private @Indexed LocalDateTime start;
    private @Indexed LocalDateTime finish;
    private @Indexed String message[];

}
