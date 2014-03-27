package practice.day1.dp.factory;

public class BmwCarAir extends CarAir {
	
	public void conditionOpen() {
		System.out.println("BMW air conticiton open");
	}

	public void conditionClose() {
		System.out.println("BMW air conticiton close");
	}

	@Override
	public void build() {
		System.out.println("a BMW has been built");
	}

	@Override
	public void sell() {
		System.out.println("BMW price is 999");
	}

}
