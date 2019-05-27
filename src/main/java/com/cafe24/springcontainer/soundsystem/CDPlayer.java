package com.cafe24.springcontainer.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {

	// 와이어링1
	// @Autowired
	private CompactDisc cd;

	public CDPlayer() {
	}

	// 와이어링2 생성자
//	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	// 와이어링3 set메소드
	@Autowired
	public void setCompactDisc(CompactDisc cd) {
		this.cd = cd;
	}

	// 와이어링4 일반 메소드
//	@Autowired
	public void insertCompactDisc(CompactDisc cd) {
		System.out.println("----->");
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}

}
