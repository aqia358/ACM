package practice.day1.dp.visitor;

public class VisitorA implements Visitor{

	public void visit(ElementA a) {
		System.out.println("I am visitor a");
		a.work();
	}

	public void visit(ElementB b) {
		System.out.println("I am visitor a");
		b.work();
	}

}
