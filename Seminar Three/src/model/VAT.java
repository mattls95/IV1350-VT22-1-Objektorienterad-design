package model;

/**
 *  Represents different VAT rates
 */
public class VAT {
	private static final double VAT_Rate_25 = 0.25;
	private static final double VAT_Rate_12 = 0.12;
	private static final double VAT_Rate_6 = 0.06;

	/**
	 *  Represents a VAT rate of 25 %
	 *  @return the VAT the rate of 0.25
	 */
	public static double getVAT_Rate_25() {
		return VAT_Rate_25;
	}

	/**
	 *  Represents a VAT rate of 12 %
	 *  @return the VAT the rate of 0.12
	 */
	public static double getVAT_Rate_12() {
		return VAT_Rate_12;
	}

	/**
	 *  Represents a VAT rate of 6 %
	 *  @return the VAT the rate of 0.6
	 */
	public static double getVAT_Rate_6() {
		return VAT_Rate_6;
	}

}
