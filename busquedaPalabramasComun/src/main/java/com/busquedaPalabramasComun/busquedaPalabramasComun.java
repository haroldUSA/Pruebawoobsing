package com.busquedaPalabramasComun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class busquedaPalabramasComun {							//Usar commandlinerunner permite vaciar la base de datos tras cada ejecución

	public static void main(String[] args) {
		SpringApplication.run(busquedaPalabramasComun.class, args);
	}
}
