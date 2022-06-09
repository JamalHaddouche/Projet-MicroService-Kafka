package org.sid.customerservice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @ToString
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}

@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer,Long>{

}

//si nous voulons voir que les ids et les noms des clients on utilise les projections
@Projection(name = "projection1",types = Customer.class)
interface CustomerProjection {
    //on personalise les données que nous voulons retourner
    public Long getId();
    public String getName();
}
@SpringBootApplication
public class  CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.save(new Customer(null,"haddouche","hadouche@gmail.com"));
            customerRepository.save(new Customer(null,"Miloudi","miloudi@gmail.com"));
            customerRepository.save(new Customer(null,"Qarsis","qarsis@gmail.com"));
            customerRepository.save(new Customer(null,"akajdou3","akajdou3@gmail.com"));
            customerRepository.findAll().forEach(System.out::println);

        };
    }
}
