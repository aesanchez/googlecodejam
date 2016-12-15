import java.util.Scanner;

import Util.IOFileManager;


public class CountingSheep {
	public static final String desktop="C:\\Users\\Trorik\\Desktop\\";
	public static void main(String[]args){
		Scanner input=IOFileManager.IO(desktop+"A-large");
		int T=input.nextInt();
		for(int t=1;t<=T;t++){
			boolean[] numbers=new boolean[10];
			System.out.print("Case #"+t+": ");
			int N=input.nextInt();
			if(N==0){
				System.out.println("INSOMNIA");
			}else{
				int aux=N;
				while(!isDone(numbers)){
					aux(Integer.toString(aux),numbers);
					aux+=N;
				}
				System.out.println(aux-N);				
			}
			
		}
	}
	private static boolean isDone(boolean[] numbers){
		boolean isDone=true;
		for(int i=0;i<numbers.length;i++){
			isDone=isDone&&numbers[i];
		}
		return isDone;
	}
	private static void aux(String number,boolean[] numbers){
		for(int i=0;i<number.length();i++){
			numbers[Integer.parseInt(number.charAt(i)+"")]=true;
		}
	}

}
