package practice.day1.dp.visitor;

public interface Element {
	public abstract void accept(Visitor visitor);
	
	public abstract void work();
}
