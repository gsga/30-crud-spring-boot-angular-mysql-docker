package gga.backend;

/*
Esta es la clase principal de la aplicación.
Vemos que solo tiene las anotaciones de SpringBoot.
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
