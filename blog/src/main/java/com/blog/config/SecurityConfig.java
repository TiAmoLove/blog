package com.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
//使用之后放行静态资源会无效.
//@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		web.ignoring().antMatchers("static/**");
	}

	/**
	 * 从内存中创建两个用户用于做测试,测试权限
	 * 
	 * @param auth
	 * @throws Exception
	 */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/**
		 * 在内存中创建一个名为 "user" 的用户，密码为 "pwd"，拥有 "USER" 权限，密码使用BCryptPasswordEncoder加密
		 */

		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user")
				.password(new BCryptPasswordEncoder().encode("pwd")).roles("USER");
		/**
		 * 在内存中创建一个名为 "admin" 的用户，密码为 "pwd"，拥有 "USER" 和"ADMIN"权限
		 */
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin")
				.password(new BCryptPasswordEncoder().encode("pwd")).roles("USER", "ADMIN");
	}

	/**
	 * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限 匹配 "/admin" 及其以下所有路径，都需要 "ADMIN" 权限 登录地址为
	 * "/login"，登录成功默认跳转到页面 "/user" 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/user/**").hasRole("USER")
			.antMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll()
			.and()
			.formLogin().loginPage("/login").defaultSuccessUrl("/user")
			.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
		// 关闭CSRF跨域
		http.csrf().disable();
	}

	/**
	 * 声明加密方式的bean
	 * 
	 * @return BCryptPasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
