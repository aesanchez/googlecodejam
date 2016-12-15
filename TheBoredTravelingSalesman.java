import java.util.ArrayList;
import java.util.Scanner;

import Util.IOFileManager;


public class TheBoredTravelingSalesman {

	public static void main(String[] args) {
		Scanner in=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\C-small-practice.in");
		int T=in.nextInt();in.nextLine();
		for(int t=1;t<T;t++){
			int N=in.nextInt();
			int M=in.nextInt();
			in.nextLine();
			int[] zip=new int[N+1];
			for(int i=0;i<N;i++)
				zip[i]=Integer.parseInt(in.nextLine());
			ArrayList<Integer>[] graph=new ArrayList[N+1];
			for(int i=0;i<N+1;i++)
				graph[i]=new ArrayList<Integer>();
			int min=Integer.MAX_VALUE;
			for(int i=0;i<M;i++){
				int x1=in.nextInt();
				int x2=in.nextInt();
				int aux=Math.min(x1, x2);
				if(aux<min)
					min=aux;
				graph[x1].add(x2);
				graph[x2].add(x1);
			}
			
			
		}
	}

}
