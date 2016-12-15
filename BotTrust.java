import java.util.ArrayList;
import java.util.Scanner;

import Util.IOFileManager;


public class BotTrust {

	public static final String desktop="C:\\Users\\Trorik\\Desktop\\";

	public static void main(String[] args) {
		Scanner input=IOFileManager.IO(desktop+"A-small-practice.in");
		int T,N;
		T=input.nextInt();
		ArrayList<String> sequence=new ArrayList<String>();
		for(int t=1;t<=T;t++){
			N=input.nextInt();
			for(int k=0;k<N;k++){
				sequence.add(input.next()+" "+input.nextInt());
				System.err.println(sequence.get(sequence.size()-1));		
			}
			int resul=0;
			int indexO=0,indexB=0;
			int i=0;
			boolean done=false;
			while(i<sequence.size()){
				System.err.println(indexO+" "+indexB+" "+i);
				//Orange
				if(indexO>Integer.parseInt(sequence.get(next("O",i,sequence)).split(" ")[1])-1){
					indexO--;
				}else{
					if(indexO<Integer.parseInt(sequence.get(next("O",i,sequence)).split(" ")[1])-1){
						indexO++;
					}else{
						if(i==next("O",i,sequence)){
							done=true;
						}
					}
				}
				if(indexB>Integer.parseInt(sequence.get(next("B",i,sequence)).split(" ")[1])-1){
					indexB--;
				}else{
					if(indexB<Integer.parseInt(sequence.get(next("B",i,sequence)).split(" ")[1])-1){
						indexB++;
					}else{
						if(i==next("B",i,sequence)){
							done=true;
						}
					}
				}
				if(done){
					i++;
					done=false;
				}
				resul++;
			}
			System.out.println("Case #"+t+": "+resul);

		}

	}
	public static int next(String robot,int i, ArrayList<String>sequence){
		System.err.println(sequence.get(i).split(" ")[0].getClass());
		if(robot=="O") System.err.println("SI2");
		
		System.err.println(sequence.get(i).split(" ")[0]!=robot);
		System.err.println(sequence.get(i).split(" ")[0]==robot);
		while(sequence.get(i).split(" ")[0]!=robot){
			System.err.println(i);
			i++;
		}
		return i;
	}

}
