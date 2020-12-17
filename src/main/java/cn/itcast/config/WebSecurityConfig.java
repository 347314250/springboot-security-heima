package cn.itcast.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings("all")
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// 用户信息查询
//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
//		manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
//		return manager;
//	}

	// 密码编译器
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();// 没有加密，只是普通字符串的比对
		return new BCryptPasswordEncoder();// 官方推荐的密码加密算法
	}

	@Autowired
	private UserDetailsService userDetailsService;

	// 安全拦截机制
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()// 屏蔽掉csrf限制
				.authorizeRequests()//
//				.antMatchers("/r/r1").hasAuthority("p1")//
//				.antMatchers("/r/r2").hasAuthority("p2")//
				.antMatchers("/r/**").authenticated()// 该路径下的必须经过认证
				.anyRequest().permitAll()// 除了上述的路径都不需要认证

				.and().formLogin().loginPage("/login-view")// 用户未登录时，访问任何资源都转跳到该路径，即登录页面
				.loginProcessingUrl("/login")// 登录表单form中action的地址，也就是处理认证请求的路径
				.successForwardUrl("/login-success")// 登录成功后访问的controller地址
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/myLogout")//
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)// 登录的时候创建session
				.and().rememberMe().rememberMeParameter("remember").tokenValiditySeconds(60 * 60 * 24)
				.userDetailsService(userDetailsService);
		// http.rememberMe().rememberMeParameter("remember");// 记住我，不需要每次都输入用户名和密码
		// SessionCreationPolicy.STATELESS;//不会创建session,分布式开发的时候，使用token的方式需要此种设置
	}

}
