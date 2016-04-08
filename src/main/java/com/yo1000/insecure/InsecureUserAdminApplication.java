package com.yo1000.insecure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

@SpringBootApplication
public class InsecureUserAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(InsecureUserAdminApplication.class, args);
	}

	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SignedSession signedSession() {
		return new SignedSession();
	}

	public static class SignedSession {
		private Map<String, Object> user;

		public Map<String, Object> getUser() {
			return user;
		}

		public void setUser(Map<String, Object> user) {
			this.user = user;
		}
	}
}
