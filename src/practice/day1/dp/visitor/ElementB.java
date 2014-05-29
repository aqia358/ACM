package practice.day1.dp.visitor;

public class ElementB implements Element{

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void work() {
		System.out.println("elementb is woring");
	}
}
