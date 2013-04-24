class Inheritance{
	
	public Inheritance(){
		
		System.out.println("display inheritance constructor");
	}
	
	public void display(){
		
		System.out.println("display inheritance");
	
	}
}
class Inheritance1 extends Inheritance{
	
	public Inheritance1(){
		
		System.out.println("display inheritance1 constructor");
	display();
	}
	
	public void display1(){
		
		System.out.println("display1 inheritance1");
		
	}	
}

public class InheritanceDemo extends Inheritance1{

   public static void main(String[] args){
	
	new Inheritance1().display1();

}
	

}
