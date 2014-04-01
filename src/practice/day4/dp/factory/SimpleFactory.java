package practice.day4.dp.factory;

public class SimpleFactory {

	public static Car build(String name) throws Exception{
		return (Car) Class.forName(name).newInstance();
	}
}
