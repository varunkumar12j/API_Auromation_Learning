
public class DeleteDemo extends Parent{
	DeleteDemo(int a) {
		super(a);
	}

	public int a;
	
	public static void main(String[] args) {
		DeleteDemo var = new DeleteDemo(10);
		
		
		Parent parent = new Parent(10);
		parent.getA();
		
		//user
//		list
		
		//default
		 String[] varName = {"a","b"};
		 varName = new String[10];
		 varName[0]="a";
		 varName[1]="a";
		 varName[10]="a";
		
//		encapsulation
//		Inher
//		poly
//		abstraction

	}

}

class Parent{
	private int a;
	
//	public Parent() {
//		// TODO Auto-generated constructor stub
//	}
	Parent(int a) {
		this.a=a;
		getA();
	}
	
	public int getA() {
		return a;
	}
	
	public void setA(int b) {
		a=b;
	}
	
}

