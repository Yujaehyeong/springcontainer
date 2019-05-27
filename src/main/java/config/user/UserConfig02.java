package config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cafe24.springcontainer.user.User;

@Configuration
public class UserConfig02 {

	@Bean //Bean을 리턴하는 메소드 명시
	public User user () {
		return new User();
		
	}
	
}
