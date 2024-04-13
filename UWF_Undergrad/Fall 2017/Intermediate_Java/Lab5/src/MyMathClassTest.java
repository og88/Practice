import java.util.*;
public class MyMathClassTest
{
	public static void main(String arg[])
	{
		/*Creates MyMathClass for integers*/
		MyMathClass<Integer> pi = new MyMathClass<Integer>();
		ArrayList<Integer> I = new ArrayList<Integer>();
		/*add elements to list*/
		I.add(9);
		I.add(2);
		I.add(5);
		I.add(4);
		I.add(12);
		I.add(7);
			
		/*Creates MyMathClass for doubles*/
		MyMathClass<Double> pd = new MyMathClass<Double>();
		ArrayList<Double> D = new ArrayList<Double>();
		/*add elements to list*/
		D.add(2.0);
		D.add(6.0);
		D.add(8.0);
		D.add(12.0);
		D.add(2.0);
		D.add(17.0);
		
		/*Creates MyMathClass for long*/
		MyMathClass<Long> pl = new MyMathClass<Long>();
		ArrayList<Long> L = new ArrayList<Long>();
		/*add elements to list*/
		L.add((long) 12);
		L.add((long) 8);
		L.add((long) 14);
		L.add((long) 26);
		L.add((long) 15);
		L.add((long) 35);
		
		/*tests average and stardard deviations for each element*/
		System.out.printf("%.2f\n", pi.average(I));
		System.out.printf("%.2f\n", pi.standardDeviation(I));
		System.out.printf("%.2f\n", pd.average(D));
		System.out.printf("%.2f\n", pd.standardDeviation(D));
		System.out.printf("%.2f\n", pl.average(L));
		System.out.printf("%.2f\n", pl.standardDeviation(L));
		
		//Since the methods use typecasts, the use of strings should not affect the equations.
		//If the elemnts of the Strings are not proper, it could cause problems
}
}
