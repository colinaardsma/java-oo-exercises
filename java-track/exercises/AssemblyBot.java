
public class AssemblyBot extends Robot{
	
	private String product;
	private int partCount;
	private int totalProductsBuilt;

	public AssemblyBot(String name, int xPos, int yPos, int speed, String orientation, String product, int partCount) {
		super(name, xPos, yPos, speed, orientation);
		this.product = product;
		this.partCount = partCount;
		this.totalProductsBuilt = 0;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPartCount() {
		return partCount;
	}

	public void setPartCount(int partCount) {
		this.partCount = partCount;
	}
	
	public String build(int number) {
		if(this.partCount == 0) {
			return "There are no parts left. The robot was unable to build any of the " + number + " " + this.product + " you requested.";
		} else if (number > this.partCount) {
			int unusedParts = number - this.partCount;
			int productsBuilt = number - unusedParts;
			this.partCount = 0;
			this.totalProductsBuilt += productsBuilt;
			return "There are only " + productsBuilt + " parts left. " + productsBuilt + " " + this.product + " have been built out of your request for " + number + ". You now have " + this.partCount + " parts left.";
		} else {
			this.partCount -= number;
			this.totalProductsBuilt += number;
			return number + " " + this.product + " have been built. You now have " + this.partCount + " parts left.";
		}
	}

	@Override
	public String toString() {
		return "Assembly bot " + this.name + " is facing " + this.orientation + " at (" + this.xPos + ", " + this.yPos + ") and moving at a speed of " + this.speed + ". It has built " + this.totalProductsBuilt + " " + this.product + " and has " + this.partCount + " ports left.";
	}

	public static void main(String[] args) {
		AssemblyBot ab = new AssemblyBot("Builder", 5, 12, 3, "N", "Buttons", 7000);
		System.out.println(ab);
		System.out.println(ab.build(42));
		System.out.println(ab);
	}

}
