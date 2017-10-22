package org.gurutech.cafe;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Restaurant implements InitializingBean,DisposableBean{
	
	

	IHotDrink drink;
	//List restaurantWaitersList;
	//String greetCustomer;

	/*
	 * public Restaurant(IHotDrink drink) { super(); this.drink = drink; }
	 */
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
		
	}



	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init");
		
	}



	public Restaurant() {
		System.out.println("REstaurant class obj instantiated");
	}

	
	
	public void prepareTea() {
		/*System.out.println("All waiters list :: " + restaurantWaitersList);
		System.out.println(greetCustomer);*/
		/*if (restaurantWaitersList instanceof ArrayList) {
			System.out.println("restaurantWaitersList instanceof ArrayList :: ");
		}*/
		drink.prepareHotDrink();
	}
/*
	public void setGreetCustomer(String greetCustomer) {
		this.greetCustomer = greetCustomer;
	}

	public void setRestaurantWaitersList(List restaurantWaitersList) {
		this.restaurantWaitersList = restaurantWaitersList;
	}*/

	public void setDrink(IHotDrink drink) {
		this.drink = drink;
	}
	
	/*//@PostConstruct
	public void init1()
	{
		System.out.println("Res init");
	}
	
	//@PreDestroy
	public void destroy1()
	{
		System.out.println("Res destroy");
	}*/
	
	

}
