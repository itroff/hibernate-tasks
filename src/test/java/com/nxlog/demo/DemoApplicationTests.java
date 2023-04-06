package com.nxlog.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import com.nxlog.demo.repositories.HibernateRepository;
import com.nxlog.demo.tasks.Task1;
import com.nxlog.demo.tasks.Task2;
import com.nxlog.demo.tasks.Task3;

@SpringBootTest
@ActiveProfiles("test")
class DemoApplicationTests {

	@Resource
	private HibernateRepository hibernateRepository;

	@Test
	void contextLoads() {
	}

	// Task1
	@Test
	void testStatic() {
		Assert.isTrue(!Task1.isCurrentVersionHigherOrEqual("0.1", "0.1.1"), "1");
		Assert.isTrue(Task1.isCurrentVersionHigherOrEqual("0.1.3", "0.1.3"), "1");
		Assert.isTrue(!Task1.isCurrentVersionHigherOrEqual("0.1", "0.1.3"), "1");
		Assert.isTrue(!Task1.isCurrentVersionHigherOrEqual("", "0.1.3"), "1");
		Assert.isTrue(Task1.isCurrentVersionHigherOrEqual("0.1.3", "0.1.03"), "1");
		Assert.isTrue(!Task1.isCurrentVersionHigherOrEqual("0.2.3", "0.1.03"), "1");
		Assert.isTrue(Task1.isCurrentVersionHigherOrEqual("0.1.3", "0.1.4"), "1");
		Assert.isTrue(Task1.isCurrentVersionHigherOrEqual("1.2.100", "1.12.1"), "1");
	}

	// Task2
	@Test
	void testThreads() {
		Task2.SynchroProcessor();
	}

	// Task3
	@Test
	void testStream() {
		Assert.isTrue(Task3.processList("123").size() == 1, "3");
	}

	// Task4-5
	@Test
	void testHibernate() {
		// test data in data.sql
		Assert.isTrue(hibernateRepository.getModulesIncludedInCompleteRoutes(1L).size() == 3, "4");
		// For task 5 replace @Lod with @Basic(fetch = FetchType.LAZY) on globalConfig field
	}

}
