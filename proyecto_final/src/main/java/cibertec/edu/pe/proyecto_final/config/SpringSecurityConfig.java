package cibertec.edu.pe.proyecto_final.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**", "/images/**", "/css/**", "/js/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/", "classpath:/static/images/", "classpath:/static/css/",
				"classpath:/static/js/");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests()
				.requestMatchers(HttpMethod.GET, "/webjars/**","/js/**", "/css/**", "/images/**","/","/login", "/public/**").permitAll()
				.requestMatchers("/registration").permitAll()
				//.requestMatchers("/user/").permitAll()
				//.requestMatchers("/lista_usuarios/").hasAnyRole("ADMIN", "JEFE_PRESTAMISTA", "PRESTAMISTA", "PRESTATARIO")
				//.requestMatchers("/index").hasAnyRole("ADMIN", "JEFE_PRESTAMISTA", "PRESTAMISTA", "PRESTATARIO")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/jefe/**").hasRole("JEFE_PRESTAMISTA")
				.requestMatchers("/prestamista/**").hasRole("PRESTAMISTA")
				.requestMatchers("/prestatario/**").hasRole("PRESTATARIO")
				.anyRequest().authenticated()
				.and().formLogin()
				.loginPage("/login").permitAll()
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/index/", true).and()
				.logout().invalidateHttpSession(true).clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().and()
				.exceptionHandling().accessDeniedPage("/access_denied");

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
