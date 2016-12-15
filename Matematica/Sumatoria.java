package Matematica;
import java.math.BigDecimal;
import java.util.Scanner;
public class Sumatoria {
	public static void main(String []args){
		Scanner in=new Scanner(System.in);
		BigDecimal resul=new BigDecimal("0.0");
		int n=in.nextInt();
		for(int k=0;k<n;k++){
			resul=resul.add(new BigDecimal(1.0/Math.pow(2, k)));
		}
		System.out.println(resul);
	}
}
