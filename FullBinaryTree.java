import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Util.IOFileManager;


public class FullBinaryTree {
	public static void main(String[]args){
		Scanner input=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\B-large-practice.in");
		int T=input.nextInt();input.nextLine();
		for(int i=1;i<=T;i++){
			System.err.println("("+i+"/"+T+")");
			int N=input.nextInt();input.nextLine();
			ArrayList<String> edges=new ArrayList<String>();
			for(int k=1;k<N;k++){
				edges.add(input.nextLine());
			}
			@SuppressWarnings("unchecked")
			ArrayList<Integer>[] graph=new ArrayList[N+1];
			for (int k = 1; k < N+1; ++k) {
                graph[k] = new ArrayList<Integer>();
            }
			for(String s:edges){
				int n1=Integer.parseInt(s.split(" ")[0]);
				int n2=Integer.parseInt(s.split(" ")[1]);
				graph[n1].add(n2);
				graph[n2].add(n1);
			}
			int min_deleted=Integer.MAX_VALUE;
			for(int k=1;k<=N;k++){
				//System.out.println(k);
				int[] deleted={0};
				boolean[] visited=new boolean[N+1];
				boolean[] del=new boolean[N+1];
				recorrer(graph,k,deleted,visited,del);
				if(deleted[0]<min_deleted){
					min_deleted=deleted[0];
				}
			}
			System.out.println("Case #"+i+": "+min_deleted);
		}
	}
	private static void recorrer(ArrayList<Integer>[] graph,int root,int[] deleted,boolean[] visited,boolean[] del){
		visited[root]=true;
		ArrayList<Integer> sons=new ArrayList<Integer>();
		for(Integer x: graph[root]){
			if(!visited[x] && !del[x])
				sons.add(x);
		}
		if(sons.size()==0){
			//balanced
		}else{
			if(sons.size()==2){
				//balanced
				recorrer(graph,sons.get(0),deleted,visited,del);
				recorrer(graph,sons.get(1),deleted,visited,del);
			}else{
				//n° sons=1
				if(sons.size()==1){
					delete(graph,sons.get(0),deleted,visited,del);
				}else{
					//n° sons>2
					for(Integer x:sons){						
						recorrer(graph,x,deleted,visited,del);
					}
					
					int[] min=new int[visited.length];
					for(int k=0;k<min.length;k++){
						min[k]=-1;
					}
					boolean[] visited1=new boolean[visited.length];
					visited1[root]=true;
					for(Integer x:sons){						
						int[] deleted1={0};						
						boolean[] del1=Arrays.copyOf(del, del.length);
						delete(graph,x,deleted1,visited1,del1);
						min[x-1]=deleted1[0];						
					}
	
					for(int x:toEliminate(min)){
						if(x!=-1){
							delete(graph,x+1,deleted,visited1,del);
						}
						
					}				
					
				}
			}
		}

	
	}

	private static void delete(ArrayList<Integer>[] graph,int num,int[] deleted,boolean[] visited,boolean []del){
		del[num]=true;
		deleted[0]++;
		ArrayList<Integer> sons=new ArrayList<Integer>();
		for(Integer x: graph[num]){
			if(!visited[x] && !del[x])
				sons.add(x);
		}
		for(Integer x:sons){
			delete(graph,x,deleted,visited,del);
		}
	}

	private static int[] toEliminate(int[] array){
		int[] aux=new int[array.length-2];
		int max1=Integer.MIN_VALUE, max2=Integer.MIN_VALUE;
		int i1=0; int i2=0;
		for(int k=0;k<array.length;k++){
			if(array[k]!=-1){
				if(array[k]>max1){
					max2=max1;
					max1=array[k];
					i2=i1;
					i1=k;	
				}else{
					if(array[k]>max2){
						max2=array[k];
						i2=k;
					}
				}
			}
		}
		int j=0;
		for(int k=0;k<array.length;k++){
			if(array[k]==-1){
				aux[j++]=-1;
			}else{
				if(k!=i1 && k!=i2)
					aux[j++]=k;
			}
			
		}
		return aux;
	}

}
