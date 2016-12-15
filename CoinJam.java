import java.util.Scanner;

import Util.IOFileManager;


public class CoinJam {
	public static final String desktop="C:\\Users\\Trorik\\Desktop\\";

	public static void main(String[] args) {
		Scanner input=IOFileManager.IO(desktop+"C-large");
		int T=input.nextInt();
		for(int t=1;t<=T;t++){
			System.out.println("Case #"+t+": ");
			int N=input.nextInt(); int J=input.nextInt();
			int j=0;
			int[] div=new int[11];
			StringBuilder s=new StringBuilder();
			s.append('1');
			for(int i=1;i<N-1;i++)s.append('0');
			s.append('1');
			StringBuilder fin=new StringBuilder();
			for(int i=0;i<N;i++)fin.append('1');
			boolean stop=false;
			
			while(!stop && j<J){
				System.err.println(s);
				int i=2;
				while(!stop && i<11){
					div[i]=(int)isNotPrime(conversion(s.toString(),i));
					if(div[i]==0) stop=true;
					i++;
				}
				if(!stop){
					j++;
					System.out.print(s);
					for(int x=2;x<11;x++) System.out.print(" "+div[x]);
					System.out.println();
				}
				stop=false;
				if((s.toString().equals(fin.toString()))){
					stop=true;
				}else{
					s=next(s);
				}				
			}
			
		}
		input.close();
	}
	private static StringBuilder next(StringBuilder s){
		long x=Long.parseLong(s.toString(),2);
		x++;x++;
		s=new StringBuilder(Long.toBinaryString(x));
		return s;		
	}
	private static long conversion(String s,int base){
		System.err.println(s+" "+base);
		long aux=0;
		for(int i=s.length()-1;i>=0;i--){
			String c=s.charAt(i)+"";
			if(c.equals("1"))aux+=Math.pow(base, s.length()-i-1);
		}
		System.err.println(aux);
		return aux;
	}
	//checks whether an int is prime or not.
	private static long isNotPrime(long n) {
	    if(n%2==0)return 2;
	    long top=(long)Math.sqrt(n)+1;
	    for(long i=3;i<top;i+=2) {
	        if(n%i==0)
	            return i;
	    }    
	    return 0;
	}

}
