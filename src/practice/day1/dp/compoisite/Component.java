package practice.day1.dp.compoisite;

public abstract class Component {

	protected String name;
	
	public Component(String name){
		this.name = name;
	}
	
	public abstract void add(Component c);
	public abstract void remove(Component c);
	public abstract void display(int depth);
	
	public String buildString(String str ,int num){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < num; ++i)
			sb.append('-');
		sb.append(str);
		return sb.toString();
	}
}
