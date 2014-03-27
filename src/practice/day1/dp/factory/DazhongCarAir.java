package practice.day1.dp.factory;

public class DazhongCarAir extends CarAir{

	public void conditionOpen() {
		System.out.println("dazhong air condition open");
	}

	public void conditionClose() {
		System.out.println("dazhong air condition close");
	}

	@Override
	public void build() {
		System.out.println("a dazhong has been built");
	}

	@Override
	public void sell() {
		System.out.println("dazhong price is 88888");
	}

}
