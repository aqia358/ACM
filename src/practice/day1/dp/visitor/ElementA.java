package practice.day1.dp.visitor;

public class ElementA implements Element{

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void work() {
		System.out.println("elementa is working");
	}
}
