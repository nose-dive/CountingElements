/*
 * Reddit coding challenge #317 (Intermediate)
 * 
 * Count the number of each element in a chemical formula. Input:
 * 
 *   CCl2F2
 *   NaHCO3
 *   C4H8(OH)2
 *   PbCl(NH3)2(COOH)2
 * 
 *  Elements in brackets needs to be counted ()x number of times.
 * 
 * 
 * changes!!
 */

public class CountingElements {

	public static void main(String[] args) {
		
		ElementCounter EC = new ElementCounter();

		System.out.println(EC.countElements("CCl2F2"));
		System.out.println(EC.countElements("NaHCO3"));
		System.out.println(EC.countElements("C4H8(OH)2"));
		System.out.println(EC.countElements("PbCl(NH3)2(COOH)2"));
	}
}
