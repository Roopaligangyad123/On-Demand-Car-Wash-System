package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.models.Signup;
import com.cg.repository.UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests 
{
    @Autowired
	private UserService service;
    @MockBean
    private UserRepo repo;
    
    
    @Test
	   public void testUser() {
		   
	   }
		  @Test 
		  public void getUsersTest() { 
		       when(repo.findAll()).thenReturn(Stream
					  .of(new Signup(87,"nit","sam","S1234","S1234","123242" ,"nit@1234"),
					            new Signup(7,"jash","p","J2345","J2345","123242","jas@7865")).collect(Collectors.toList()));

					  assertEquals(2, service.getuser().size());
					  }
		  
		  
		@Test
		public void saveuserTest() {
			Signup user = new Signup(87,"jahn","b","J4567","J4567","612312421" ,"jahn@4321");
			when(repo.save(user)).thenReturn(user);
			assertEquals(user,service.addUser(user));
		}


		
		
		  @Test public void deleteUserTest(){ 
		  Signup user = new Signup(87,"jahn","boss","J4567","J4567", "612312421" ,"jahn@4321");
		  service.deleteUser(user); verify(repo,times(1)).delete(user);
		  
		  
		  }
		 
}
