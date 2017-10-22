package org.gurutech.cafe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestaurantTestApp {

	public static void main(String[] args) {
		
		
		ApplicationContext context1= new ClassPathXmlApplicationContext("ApplicationContext.xml");
		((AbstractApplicationContext)context1).registerShutdownHook();
		
		Restaurant res = context1.getBean("res", Restaurant.class);
		//res.setGreetCustomer("Welcome to Our Cafe");
		res.prepareTea();
		
		/*Restaurant res1 = context1.getBean("res", Restaurant.class);
		res1.prepareTea();*/

	}

}
