package practice.day1.dp.compoisite;

public class Leaf extends Component{

	public Leaf(String name) {
		super(name);
	}

	@Override
	public void add(Component c) {
		System.out.println("this is leaf");
	}

	@Override
	public void remove(Component c) {
		System.out.println("this is leaf");
	}

	@Override
	public void display(int depth) {
		System.out.println(buildString(name, depth));
	}

}
