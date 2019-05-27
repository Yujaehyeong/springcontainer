package config.user;

import org.springframework.context.annotation.Bean;

import com.cafe24.springcontainer.user.User;

public class UserConfig01 {

	@Bean //Bean을 리턴하는 메소드 명시
	public User user () {
		return new User();
		
	}
}
