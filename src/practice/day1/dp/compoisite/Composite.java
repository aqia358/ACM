package practice.day1.dp.compoisite;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

	private List<Component> list = new ArrayList<Component>();
	
	public Composite(String name) {
		super(name);
	}

	@Override
	public void add(Component c) {
		list.add(c);
	}

	@Override
	public void remove(Component c) {
		list.remove(c);
	}

	@Override
	public void display(int depth) {
		System.out.println(buildString(name, depth));
		for(Component c : list){
			c.display(depth + 2);
		}
	}
}
