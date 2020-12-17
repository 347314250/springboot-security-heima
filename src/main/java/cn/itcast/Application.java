package cn.itcast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * springboot的引导类
 *
 * exclude = DataSourceAutoConfiguration.class
 * */
@SpringBootApplication()
@MapperScan("cn.itcast.dao")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
