package reflectionbasics;

public class Circle {

	private int radius;
	
	public Circle()
	{
		System.out.println("circle object created");
		
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		
		System.out.println("setter is geting called");
		this.radius = radius;
	}
	
	
}
