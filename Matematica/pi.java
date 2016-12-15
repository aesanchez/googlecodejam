package Matematica;

import java.util.Scanner;

public class pi {
	public static void main (String[]args){
		Scanner in=new Scanner(System.in);
		System.out.println("Ingresar la cantidad de terminos a utilizar para calcular pi");
		long s=in.nextLong();
		double pi=0;
		for(int i=0;i<s;i++){
			pi+=(Math.pow(-1, i))/(2*i+1);
		}
		System.out.println("Pi="+pi*4);
	}
}
