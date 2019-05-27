package com.cafe24.springcontainer.user;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.user.UserConfig01;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=UserConfig01.class) // 테스트환경에서는 직접 클래스명을 명시해줘야함
public class UserTest { // 컨테이너 안에 생성이돼서 테스트를 할 수 있다.
	
	@Autowired //컨테이너 안에 생성이 되기 때문에 의존성 주입가능
	private User user;
	
	@Test
	public void testUser() {
		assertNotNull(user);
	}
	
	
}
