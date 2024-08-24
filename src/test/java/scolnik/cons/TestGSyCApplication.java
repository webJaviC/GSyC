package scolnik.cons;

import org.springframework.boot.SpringApplication;

import cons.GSyCApplication;

public class TestGSyCApplication {

	public static void main(String[] args) {
		SpringApplication.from(GSyCApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
