package cn.itcast;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MainTest {

	public static void main(String[] args) {
		String salt = BCrypt.gensalt();
		String hashpw = BCrypt.hashpw("123", salt);
		boolean checkpw = BCrypt.checkpw("123", hashpw);
		System.out.println(salt);
		System.out.println(hashpw);
		System.out.println(checkpw);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		boolean b = encoder.matches("123", "$2a$10$q37.QObA/FPLrwXMiBCkZextdr6mXRfpKQSfdjNz91DPKPel3lwRO");
		System.out.println(b);
	}

}
