package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.repositories.UserRepository;

@SpringBootApplication
public class Week6NguyenChiCuongApplication {
    @Autowired
private UserRepository  userRepository;
    public static void main(String[] args) {
        SpringApplication.run(Week6NguyenChiCuongApplication.class, args);
    }
  @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
//            System.out.println(userRepository.existsUserByEmailAndPassword("a@gmail.com","123"));
            System.out.println(userRepository.findNameByEmail("abc@gmail.com"));
        };
    }
}

