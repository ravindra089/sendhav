package com.sunilos.proj0.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;

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

import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.service.RoleServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "File:src/main/webapp/WEB-INF/dispatcher-servlet.xml" })
public class RoleJunitTest {

	@Autowired
	private RoleServiceInt service;

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
	public void testAdd() throws Exception {
		RoleDTO dto = new RoleDTO();
		dto.setRoleName("college");
		dto.setRoleDescription("all university");
		dto.setCreatedBy("sendhav@gmail.com");
		dto.setModifiedBy("admin");
		dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		long pk = service.add(dto);
		dto = service.findByPK(pk);
	}

}
