package fitlife.data.cl.servicios.model;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@RestController
public class test {

    @GetMapping("/hola")
    public String holaTonotos() {
        return "Hola Tonoto";
    }
    
}
