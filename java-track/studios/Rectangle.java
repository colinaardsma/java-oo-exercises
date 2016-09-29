
public class Rectangle {
	
	private Integer width;
	private Integer height;

	public Rectangle(Integer width, Integer height) {
		this.width = width;
		this.height = height;
	}
	
	public Integer getWidth() {
		return this.width;
	}
	
	public Integer getHeight() {
		return this.height;
	}
	
	public Boolean isSquare() {
		if (width == height) {
			return true;
		}
		return false;
	}
	
	public Integer area() {
		return this.width * this.height;
	}
	
	public Integer perimeter() {
		return (this.width * 2) + (this.height * 2);
	}
	
	public String areaCompare(Rectangle otherRect) {
		if (this.area() > otherRect.area()) {
			return "Your rectangle is larger";
		} else if (this.area() < otherRect.area()) {
			return "Your rectangle is smaller";
		}
		return "The rectangles are equal";
	}
	
	public Integer addWidth(Integer w) {
		this.width += w;
	}
	
	public Integer addHeight(Integer h) {
		this.height += h;
	}

	public static void main(String[] args) {
		Rectangle myRect = new Rectangle(9, 9);
		Rectangle yourRect = new Rectangle(9,47);
		System.out.println(myRect.isSquare());
		System.out.println(myRect.areaCompare(yourRect));

	}

}
