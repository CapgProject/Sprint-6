/*
 * Author: Priya Kumari
 */

package com.cg.otm.OnlineTestManagementRestful;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.test.context.junit4.SpringRunner;

import com.cg.otm.OnlineTestManagementRestful.dto.OnlineTest;
import com.cg.otm.OnlineTestManagementRestful.dto.Question;
import com.cg.otm.OnlineTestManagementRestful.dto.User;
import com.cg.otm.OnlineTestManagementRestful.exception.UserException;
import com.cg.otm.OnlineTestManagementRestful.service.OnlineTestService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OnlineTestManagementRestfulApplicationTests {
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Autowired
	OnlineTestService onlineTestService;
	
	OnlineTest test=new OnlineTest();
	User user=new User();
	Question question=new Question();
	

	@Test
	public void testAddUserUrl() {
		User user=restTemplate.getForObject("/adduser", User.class);
		assertThat(user);
	}
	@Test
	public void testAddTestUrl() {
		OnlineTest onlineTest=restTemplate.getForObject("/addtest", OnlineTest.class);
		assertThat(onlineTest);
	}
	@Test
	public void testAddQuestionUrl() {
		Question question=restTemplate.getForObject("/addquestionsubmit", Question.class);
		assertThat(question);
	}
	
	@Test
	public void testRemoveTestUrl() {
		OnlineTest onlineTest=restTemplate.getForObject("/removetestsubmit",OnlineTest.class);
		assertThat(onlineTest);
	}
	@Test
	public void testRemoveQuestionUrl() {
		Question question=restTemplate.getForObject("/removequestionsubmit",Question.class);
		assertThat(question);
	}
	
	@Test
	public void testUpdateUserUrl() {
		User user=restTemplate.getForObject("/updateuser",User.class);
		assertThat(user);
	}
	
	@Test
	public void testUpdateQuestionUrl() {
		Question question=restTemplate.getForObject("/updatequestionsubmit",Question.class);
		assertThat(question);
	}
	

	
	@Test
	public void checkUserData() {
		assertEquals(0, onlineTestService.getUsers().size());
	
	}
	
	@Test
	public void checkTestData() {
		assertEquals(0, onlineTestService.getTests().size());
	}
	
	@Test
	public void testAddTest() throws UserException {
			test.setIsdeleted(false);
			test.setTestId(Long.valueOf(10));
			test.setTestName("Java");
	        assertEquals(test,onlineTestService.addTest(test));
	}


	@Test
	public void testSearchUser() throws UserException{
		user.setUserId(Long.valueOf(5));
		user.setUserName("User1");
		user.setUserPassword("User1@123");
		User addedUser=onlineTestService.registerUser(user);
		assertEquals(addedUser,onlineTestService.searchUser(Long.valueOf(5)));
	}
	
	
}