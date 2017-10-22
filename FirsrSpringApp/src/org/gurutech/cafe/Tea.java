package org.gurutech.cafe;

public class Tea implements IHotDrink {
	
	public Tea() {
		System.out.println("tea class obj instantiated");
	}

	@Override
	public void prepareHotDrink() {
		
		System.out.println("Dear customer, we are preparing Tea for you");
	}

}
