import java.util.Scanner;

import Util.IOFileManager;


public class RevangeOfThePancakes {
	public static final String desktop="C:\\Users\\Trorik\\Desktop\\";
	public static void main(String[] args) {
		Scanner input=IOFileManager.IO(desktop+"");
		int T=input.nextInt();
		for(int t=1;t<T;t++){			
			char[] pancakes=input.next().toCharArray();
			
			
			
		}
		

	}
	private static void flip(char[] pancakes,int i){
		char aux;
		for(int j=0;j<=i/2;j++){
			aux=pancakes[j];
			pancakes[j]=pancakes[i-j];
			pancakes[i-j]=aux;			
		}
		for(int j=0;j<=i;j++){
			if(pancakes[j]=='-'){
				pancakes[j]='+';
			}else{
				pancakes[j]='-';
			}
		}
	}

}
