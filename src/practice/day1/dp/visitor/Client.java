package practice.day1.dp.visitor;

public class Client {

	public static void testVisitor(){
		ObjectStructure o = new ObjectStructure();
		o.attach(new ElementA());
		o.attach(new ElementB());
		
		Visitor a = new VisitorA();
		o.display(a);

		Visitor b = new VisitorB();
		o.display(b);
		
	}
	
	public static void main(String[] args) {
		testVisitor();
	}

}
