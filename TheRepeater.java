import java.util.Scanner;

import Util.IOFileManager;


public class TheRepeater {
	public static void main(String[]args){
		Scanner input=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\A-small-practice.in");
		int T=input.nextInt();
		input.nextLine();
		for(int t=0;t<T;t++){
			int N=input.nextInt();input.nextLine();
			StringBuilder[] words=new StringBuilder[N];
			for(int n=0;n<N;n++){
				words[n]=new StringBuilder(input.nextLine());
			}
			int[] ii=new int[N];
			boolean possible=true, finished=false;
			int[] ans={0};			
			while(possible && !finished){
				for(int i=0;i<N-1;i++){
					int j=0;
					int aux=0;
					while(j<N){
						if(ii[j]==words[j++].length())
							aux++;
					}
					if(aux==N){
						finished=true;
					}else{
						if(aux!=0){
							possible=false;
						}else{
							if(words[i].charAt(ii[i])!=words[i+1].charAt(ii[i+1]))
								possible=false;
						}
					}					
				}
				if(possible && !finished){
					int [] cantChar=new int[ii.length];
					int minIndex=minMoves(words,ii,cantChar,ans);
					move(words,ii,minIndex,cantChar);					
				}
			}
			System.out.print("Case #"+(t+1)+": ");
			if(finished){
				System.out.println(ans[0]);
			}else{
				System.out.println("Fegla Won");
			}
			
			
		}
	}
	private static int minMoves(StringBuilder[] words,int[] ii,int[]cantChar,int[] ans){
		int [] moves=new int[ii.length];//moves
		for(int i=0;i<words.length;i++){			
			int index=ii[i];
			StringBuilder s=words[i];
			char c=s.charAt(index);
			boolean stop=false;
			index++;
			cantChar[i]++;
			while(!stop && index<s.length()){
				if(s.charAt(index)==c){
					index++;
					cantChar[i]++;
				}else{
					stop=true;
				}					
			}			
		}
		for(int i=0;i<words.length;i++){
			for(int j=0;j<words.length;j++){
				if(j!=i){
					moves[i]+=Math.abs(cantChar[i]-cantChar[j]);
				}
			}
			
		}
		int minIndex=0;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<words.length;i++){
			if(moves[i]<min){
				minIndex=i;
				min=moves[i];
			}
		}
		ans[0]+=moves[minIndex];
		return minIndex;		
	}
	
	private static void move(StringBuilder[]words,int[] ii,int index,int[] cantChar){
		int chars=cantChar[index];
		char c=words[0].charAt(ii[0]);
		for(int i=0;i<words.length;i++){
			int difference=chars-cantChar[i];
			if(difference>0){
				//add
				for(int k=0;k<difference;k++){
					words[i].insert(ii[i], c);
				}
			}else{
				//substract
				for(int k=0;k<(-difference);k++){
					words[i].deleteCharAt(ii[i]);
				}
			}
			ii[i]+=chars;
		}
	}
}
