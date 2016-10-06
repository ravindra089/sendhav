package com.sunilos.proj0.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sunilos.proj0.dto.TimeTableDTO;
import com.sunilos.proj0.service.TimeTableServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "File:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class TimeTableJunitTest {
	@Autowired
	private TimeTableServiceInt service;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd()throws Exception{
		TimeTableDTO dto=new TimeTableDTO();
		dto.setUserId(1l);
		dto.setCourseId(11l);
		dto.setCourseName("java");
		dto.setSubject("spring");
		dto.setDay("tuesday");
		dto.setFacultyName("raystec");
		dto.setTime("aa");
		service.add(dto);
		
		
	}
}
