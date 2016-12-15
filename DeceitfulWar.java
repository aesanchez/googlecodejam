import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import Util.IOFileManager;
public class DeceitfulWar {
	public static void main(String[]args){
		Scanner input=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\D-large-practice.in","C:\\Users\\Trorik\\Desktop\\D-large-practice.out");
		int T=input.nextInt(); input.nextLine();
		for(int i=1;i<=T;i++){
			int N=input.nextInt(); input.nextLine();
			ArrayList<Float> naomi1=new ArrayList<Float>();
			ArrayList<Float> ken1=new ArrayList<Float>();			
			String[] ns=input.nextLine().split(" ");
			String[] ks=input.nextLine().split(" ");
			for(int j=0;j<N;j++){
				naomi1.add(Float.parseFloat(ns[j]));
				ken1.add(Float.parseFloat(ks[j]));
			}
			ken1.sort(new Comparator<Float>(){
				public int compare(Float f1, Float f2){
					return f1.compareTo(f2);
				}
			});
			naomi1.sort(new Comparator<Float>(){
				public int compare(Float f1, Float f2){
					return f1.compareTo(f2);
				}
			});
			ArrayList<Float> ken2=new ArrayList<Float>(ken1);
			int war=0;
			int deceitful=0;
			//war start
			for(int j=0;j<N;j++){
				//ken tries to win with the smallest value possible(but bigger than naomi's)
				//if he cant win, he uses the smallest one to lose.
				int k=0;
				while(k<ken1.size() && naomi1.get(j)>ken1.get(k)){
					k++;
				}
				if(k==ken1.size()){//no bigger number found
					war++;
					ken1.remove(0);
				}else{
					ken1.remove(k);
				}
			}			
			//end war
			//deceitful start
			for(int j=0;j<N;j++){
				//ken2[j]
				int k=0;
				while(k<naomi1.size() && ken2.get(j)>naomi1.get(k)){
					k++;
				}
				if(k==naomi1.size()){//no bigger number found
					naomi1.remove(0);
				}else{
					naomi1.remove(k);
					deceitful++;
				}
				
			}
			//deceitful end
			System.out.println("Case #"+i+": "+deceitful+" "+war);
			
		}
	}
}
