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

import com.cg.models.Washers;
import com.cg.repository.WasherRepo;
import com.cg.services.WasherService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WasherServiceTests 
{
    @Autowired
	private WasherService service;
    @MockBean
    private WasherRepo repo;
	@Test
    public void getWasherTest()
    {
    	when(repo.findAll()).thenReturn(Stream
				.of(new Washers(22, "Nithin","USA","12345"),
						new Washers(55,"UK","jack","12345")).collect(Collectors.toList()));
		assertEquals(2, service.getWashers().size());
	}
	
	@Test
	public void saveWasherTest() {
		Washers washer = new Washers(2, "Pranya","Pune","123456");
		when(repo.save(washer)).thenReturn(washer);
	}

	public void deleteWasherTest() {
		Washers washer = new Washers(1, "raju","Hyderabad","123456");	
		service.deleteWasher(1);
		verify(repo, times(1)).delete(washer);
	}
}
