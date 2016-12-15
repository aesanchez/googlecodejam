import java.util.Scanner;

import Util.IOFileManager;


public class NewLotteryGame {

	public static void main(String[] args) {
		Scanner input=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\B-large-practice.in");
		int T=input.nextInt();
		input.nextLine();
		for(int t=1;t<=T;t++){
			int A=input.nextInt();
			int B=input.nextInt();
			int K=input.nextInt();
			int cant=0;
			for(int a=0;a<A;a++){
				for(int b=0;b<B;b++){
					int c=and(a,b);
					if(c<K){
						cant++;
					}
				}
			}
			System.out.println("Case #"+t+": "+cant);
		}
	}
	public static int and(int a,int b){
		int ans=0;
		String aS=Integer.toBinaryString(a);
		String bS=Integer.toBinaryString(b);
		int aIndex=aS.length()-1;
		int bIndex=bS.length()-1;
		int i=0;
		while(aIndex>=0 && bIndex>=0){
			if(aS.charAt(aIndex)=='1'&& bS.charAt(bIndex)=='1'){				
				ans+=Math.pow(2, i);
			}
			aIndex--;
			bIndex--;
			i++;
		}
		return ans;
	}

}
