import java.lang.Math;

public class Fraction {

	private Integer numerator;
	private Integer denominator;
	
	public Fraction(Integer numerator, Integer denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Integer getNumerator() {
		return this.numerator;
	}

	public Integer getDenominator() {
		return this.denominator;
	}

	public Fraction add(Fraction otherFraction) {
		Integer numer = this.numerator + otherFraction.getNumerator();
		Integer denom = this.denominator + otherFraction.getDenominator();
		Fraction newFraction = new Fraction(numer, denom);
		return newFraction;
	}
	
	public Fraction multiply(Fraction otherFraction) {
		Integer numer = this.numerator * otherFraction.getNumerator();
		Integer denom = this.denominator * otherFraction.getDenominator();
		Fraction newFraction = new Fraction(numer, denom);
		return newFraction;
	}

	public Fraction reciprocal() {
		Fraction newFraction = new Fraction(this.denominator, this.numerator);
		return newFraction;
	}
	
	public Fraction simplify() {
		for (Integer i = Math.max(this.denominator, this.numerator); i > 0 ; i--) {
			if (this.denominator % i == 0 && this.numerator % i == 0) {
				Integer numer = this.numerator / i;
				Integer denom = this.denominator / i;
				Fraction newFraction = new Fraction(numer, denom);
				return newFraction;
			}
		}
		return null;
	}
	
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
	
	public static void main(String[] args) {
		Fraction fractionOne = new Fraction(2, 8);
		Fraction fractionTwo = new Fraction(12, 21);
		System.out.println(fractionOne.add(fractionTwo));
		System.out.println(fractionTwo.simplify());

	}

}
