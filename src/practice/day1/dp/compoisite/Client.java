package practice.day1.dp.compoisite;

public class Client {

	public static void testComposite(){
		Composite root = new Composite("root");
		root.add(new Leaf("leaf a"));
		root.add(new Leaf("leaf b"));
		
		Composite comp = new Composite("x");
		comp.add(new Composite("leaf xa"));
		comp.add(new Composite("leaf xb"));
		root.add(comp);
		
		Composite comp2 = new Composite("xy");
		comp2.add(new Composite("leaf xya"));
		comp2.add(new Composite("leaf xyb"));
		comp.add(comp2);
		
		root.display(1);
	}
	
	public static void main(String[] args) {
		testComposite();
	}

}
