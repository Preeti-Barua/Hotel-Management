package reflectionbasics;

import java.lang.reflect.Method;


//tomat code
public class Test {
	
	public static void main(String[] args) {
	
		Circle c =new Circle();
		
		
	}
	
	
	
	

	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		
		//take A class and show it to the mirror how.
				Class c = A.class;
				
				//if you are looking for scrap whose input
				//argument is an integer then second argument
				//will not be null we would have given something
			
				
		//then ask mirror questions on A..
		try {
			Method m = c.getDeclaredMethod("scrap", null);
			System.out.println("great scrap exists in A class");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			System.out.println("no such function");
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//thru C i am sking is there a method called scrp
		//in the class A.
		
		
		
		
		
		
		
		
		
		

	}

}
