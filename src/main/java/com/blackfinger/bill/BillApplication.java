package com.blackfinger.bill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blackfinger.bill.dao")
public class BillApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillApplication.class, args);
	}

}
