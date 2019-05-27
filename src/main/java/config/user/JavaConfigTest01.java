package config.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cafe24.springcontainer.user.User;


public class JavaConfigTest01 {

	public static void main(String[] args) {
		// 
		testUser01();
		testUser02();
	}

	public static void testUser01() {
		// 명시적인 방식 class명을 직접 입력해줌
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext(UserConfig01.class);
		
		User user = appCtx.getBean(User.class);
		
		System.out.println(user);
		
		((ConfigurableApplicationContext)appCtx).close();
	}
	
	
	public static void testUser02() {
		// 명시적인 방식 class명을 직접 입력해줌
		ApplicationContext appCtx = 
				new AnnotationConfigApplicationContext("config.user"); 
		// 패키지를 스캔해서 찾아내야하기 때문에 @Configuration 어노테이션을 명시해줘야함
		
		User user = appCtx.getBean(User.class);
		
		System.out.println(user);
		
		((ConfigurableApplicationContext)appCtx).close();
	}
}
