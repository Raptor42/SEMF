import java.lang.Math;
import java.util.Scanner;

public class SEMF {

	// Constants
	private static final double m_p = 1.007825;
	private static final double m_n = 1.008665;
	private static final double a1 = 0.016910;
	private static final double a2 = 0.019110;
	private static final double a3 = 0.000763;
	private static final double a4 = 0.101750;
	private static final double a5 = 0.012000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter A (number of nucleons): ");
		int a = sc.nextInt();

		System.out.print("Enter Z (number of neutrons): ");
		int z = sc.nextInt();

		double mass = SEMF(a, z);

		System.out.println("Mass: " + mass);
	}

	private static double SEMF(int a, int z) {
		int n=a-z;
		double term1 = m_p*z;
		System.out.println("Term 1:" + term1);
		double term2 = m_n*n;
		System.out.println("Term 2:" + term2);
		double term3 = a1*a;
		System.out.println("Term 3:" + term3);
		double term4 = a2*Math.pow(a, (2.0/3));
		System.out.println("Term 4:" + term4);
		double term5 = a3*z*z*Math.pow(a, (-1.0/3));
		System.out.println("Term 5:" + term5);
		double term6 = a4*(z-(a/2.0))*(z-(a/2.0))*Math.pow(a, -1);
		System.out.println("Term 6:" + term6);
		double term7 = 0;

		if ( isEven(z) && isEven(n) ) {
			System.out.println("Z, N even");
			term7 = -a5*Math.pow(a, -0.5);
		} else if ( !(isEven(z)) && !(isEven(n)) ) {
			term7 = a5*Math.pow(a, -0.5);
			System.out.println("Z, N odd");
		} else {	
			System.out.println("A odd");
		}

		System.out.println("Term 7:" + term7);

		return term1 + term2 - term3 + term4 + term5 + term6 + term7;
	}

	private static boolean isEven(int val) {
		return ((val % 2) == 0);
	}
}