import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import Util.IOFileManager;


public class ProperShuffle {
	public static void main(String[]args){
		/*
		Scanner input=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\C-small-practice.in");
		int T=input.nextInt();input.nextLine();
		for(int i=1;i<=T;i++){
			int N=input.nextInt();input.nextLine();

		}
		 */
		int N=1000;
		ArrayList<String> list=new ArrayList<String>();
		ArrayList<Integer> cantidad=new ArrayList<Integer>();
		int[][] digits=new int[N][];
		for(int i=0;i<N;i++){
			digits[i]=new int[N];
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				digits[i][j]=0;
			}
		}
		int cant=10000;
		double percent=0.02;
		for(int i=0;i<cant;i++){
			if(i/(float)cant>percent){
				System.out.println("%"+percent);
				percent+=0.01;
			}
			int[] good=new int[N];
			int[] bad=new int[N];
			for(int k=0;k<N;k++){
				good[k]=k;
				bad[k]=k;
			}
			//good
			for(int k=0;k<N;k++){
				int p=randint(k,N-1);
				swap(good,k,p);
			}
			for(int k=0;k<N;k++){
				int p=randint(0,N-1);
				swap(bad,k,p);
			}
			for(int j=0;j<N;j++){
				digits[j][bad[j]]++;
			}
			String s="";
			for(int d:bad){
				s+=""+d;
			}
			if(!list.contains(s)){
				list.add(s);
				cantidad.add(0);
			}

			int index=list.indexOf(s);
			int aux=cantidad.get(index);
			aux++;
			cantidad.remove(index);
			cantidad.add(index,aux);				

		}
		for(int i=0;i<N;i++){
			System.out.println("DIGIT "+i);
			for(int j=0;j<N;j++){
				if(100*digits[i][j]/(float)cant>0.115)
					System.out.println(j+"="+100*digits[i][j]/(float)cant);
			}
			System.out.println();
		}
		/*	
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+"("+cantidad.get(i)+")  Error:");
			System.out.format("%.8f%n",Math.abs((1/6.0)-cantidad.get(i)/(float)cant));
		}
		*/


	}


	private static void swap(int[] array,int a,int b){
		int aux=array[a];
		array[a]=array[b];
		array[b]=aux;
	}
	private static int randint(int min,int max){
		Random rand=new Random();
		return rand.nextInt((max-min)+1)+min;
	}
}
