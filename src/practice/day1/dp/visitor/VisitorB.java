package practice.day1.dp.visitor;

public class VisitorB implements Visitor{

	public void visit(ElementA a) {
		System.out.println("I am visitor b");
		a.work();
	}

	public void visit(ElementB b) {
		System.out.println("I am visitor b");
		b.work();
	}

}
