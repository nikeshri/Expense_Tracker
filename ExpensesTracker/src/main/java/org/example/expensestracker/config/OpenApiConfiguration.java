package org.example.expensestracker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Nikesh Mishra");
        myContact.setEmail("your.email@gmail.com");

        Info information = new Info()
                .title("Expenses Management and Tracker System")
                .version("1.0")
                .description("Nikesh Mishra")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }

}