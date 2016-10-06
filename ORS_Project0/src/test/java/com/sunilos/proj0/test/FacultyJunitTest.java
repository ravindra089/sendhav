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

import com.sunilos.proj0.dto.FacultyDTO;
import com.sunilos.proj0.service.FacultyServiceInt;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "File:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class FacultyJunitTest {
@Autowired
private FacultyServiceInt service;
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
	public void testfindByPk()throws Exception{
		FacultyDTO  dto=new FacultyDTO();
		dto.setId(1l);
		dto.setFacultyName("aa");
		long pk=service.add(dto);
		dto=service.findByPK(1l);
		
		
		
	}

}
