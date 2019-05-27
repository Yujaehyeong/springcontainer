package com.cafe24.springcontainer.soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.soundsystem.CDPlayerConfig;

/*
 * Auto COnfiguration - Java Config
 * Component Sacnning ((@Component - Spring지원, @Named - Java지원), (@Autowired - Spring지원, @Inject - Java지원))
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class) // 테스트환경에서는 직접 클래스명을 명시해줘야함
public class CDPlayerJavaConfigTest { // 컨테이너 안에 생성이돼서 테스트를 할 수 있다.
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private CompactDisc cd;
	
	@Autowired
	private CDPlayer player;
	
	@Test
	public void testCdNull() {
		assertNotNull(cd);
	}
	
	@Test
	public void testPlayerNull() {
		assertNotNull(player);
	}
	
	@Test
	public void testPlay() {
		player.play();
		assertEquals("Playing 지구멸망 by 양승호", systemOutRule.getLog().replace("\r\n", "").replace("\n", ""));
	}
}
