package cn.binux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableApolloConfig
@SpringBootApplication
public class XbinStoreWebCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(XbinStoreWebCartApplication.class, args);
	}
}
