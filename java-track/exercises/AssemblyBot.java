
public class AssemblyBot extends Robot{
	
	private String product;
	private int partCount;

	public AssemblyBot(String name, int xPos, int yPos, int speed, String orientation, String product, int partCount) {
		super(name, xPos, yPos, speed, orientation);
		this.product = product;
		this.partCount = partCount;
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
		this.partCount -= number;
		return number + " " + this.product + " have been built. You now have " + this.partCount + " parts left.";
	}

	@Override
	public String toString() {
		return "AssemblyBot [product=" + product + ", partCount=" + partCount + ", name=" + name + ", xPos=" + xPos
				+ ", yPos=" + yPos + ", speed=" + speed + ", orientation=" + orientation + "]";
	}

	public static void main(String[] args) {
		AssemblyBot ab = new AssemblyBot("Builder", 5, 12, 3, "N", "Buttons", 7000);
		System.out.println(ab);
		System.out.println(ab.build(4));
	}

}
