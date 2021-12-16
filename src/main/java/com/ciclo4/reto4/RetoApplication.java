package com.ciclo4.reto4;


import com.ciclo4.reto4.interfaces.InterfaceOrder;
import com.ciclo4.reto4.interfaces.InterfaceSupplements;
import com.ciclo4.reto4.interfaces.InterfaceUser;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class RetoApplication implements CommandLineRunner {
	@Autowired
	private InterfaceSupplements interfaceSupplements;
	@Autowired
	private InterfaceUser interfaceUser;
	@Autowired
	private InterfaceOrder interfaceOrder;
	public static void main(String[] args) {
		SpringApplication.run(RetoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
                SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		interfaceSupplements.deleteAll();
		interfaceUser.deleteAll();
		interfaceOrder.deleteAll();
	}

}