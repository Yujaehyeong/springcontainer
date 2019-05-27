package com.cafe24.springcontainer;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.cafe24.springcontainer.user.User;
import com.cafe24.springcontainer.user.User1;

public class ContainerTest {

	public static void main(String[] args) {
		testApplicationContext();
	}
	
	public static void testApplicationContext() {

	
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/user/applicationContext2.xml");
		
		User1 user1 = applicationContext.getBean(User1.class);
		System.out.println(user1.getName());
		
		// 오류 : 빈설정 id나 name 설정을 해야한다.
		// user = (User1) applicationContext.getBean("user1");
		// System.out.println(user.getName());
		
		
		// name으로 가져오기
		User user = (User)applicationContext.getBean("user");
		System.out.println(user);
		
		// id로 가져오기
		user = (User)applicationContext.getBean("usr");
		System.out.println(user);
		
		
		// 오류: 같은 타입의 빈이 2개이상 존재하면 타입으로 빈을 가져올 수 있다
//		user = applicationContext.getBean(User.class);
		
		User user2 = (User)applicationContext.getBean("usr2");
		System.out.println(user2);
		
		User user3 = (User)applicationContext.getBean("usr3");
		System.out.println(user3);
		
		User user4 = (User)applicationContext.getBean("usr4");
		System.out.println(user4);
		
		
		
		((ConfigurableApplicationContext)applicationContext).close();
	}

	public static void testBeanFactory() {

		BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext.xml"));

		// @Auto-Configuration(Scanning)인 경우
		// Bean의 id가 자동으로 만들어 진다. 클래스명을 소문자로 변환해서 만듬
		User1 user = (User1) beanFactory1.getBean("user1");
		System.out.println(user.getName());

		// XML Bean 설정인 경우에는 id가 자동으로 부여 되지 않는다.
		BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext2.xml"));

//		user = (User1)beanFactory2.getBean("User1");
//		System.out.println(user.getName());

		user = beanFactory2.getBean(User1.class);
		System.out.println(user.getName());

	}

}
