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

import com.cg.models.OrderDetails;
import com.cg.repository.OrderRepo;
import com.cg.services.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests 
{
    @Autowired
	private OrderService service;
    @MockBean
    private OrderRepo repo;
    
    @Test
	public void getUsersTest() {
		when(repo.findAll()).thenReturn(Stream.of(new OrderDetails(1,"Scross","Suv","Abhijeet","28/07/2022",7834224564l,"Jharkhand"),
				new OrderDetails(1,"Thar","Suv","Ankit","29/07/2022",7854424564l,"Banglore")).collect(Collectors.toList()));
		assertEquals(2, service.orderDetails().size());
	}
   
    @Test
	public void saveuserTest() {
		OrderDetails order = new OrderDetails(8,"Thar","Suv","Bijay","29/07/2022",7856424564l,"Banglore");
		when(repo.save(order)).thenReturn(order);
		assertEquals(order,service.addOrder(order));
	}
    
}
