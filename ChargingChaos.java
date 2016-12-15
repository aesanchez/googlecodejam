import Util.IOFileManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class ChargingChaos {
	public static void main(String[]args){
		Scanner input=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\A-large-practice.in");
		int T=input.nextInt();
		input.nextLine();
		for(int i=1;i<=T;i++){
			//int N=input.nextInt();
			//int L=input.nextInt();
			input.nextLine();
			String[] outlets=input.nextLine().split(" ");
			String[] devices=input.nextLine().split(" ");

			int aux=match(outlets,devices,0,0,false);
			
			System.out.print("Case #"+i+": ");
			if(aux!=Integer.MIN_VALUE){
				System.out.println(aux);				
			}else{
				System.out.println("NOT POSSIBLE");
			}
		}
	}
	
	private static void flip(String[] ss, int index){
		for(int i=0;i<ss.length;i++){
			if(ss[i].charAt(index)=='1'){
				ss[i]=ss[i].substring(0, index)+"0"+ss[i].substring(index+1);
			}else{
				ss[i]=ss[i].substring(0, index)+"1"+ss[i].substring(index+1);
			}
		}
	
	}
	//imposible output=int.min
	//else n° of flips

	private static int match(String[] outlets, String[] devices,int flips,int index,boolean flipped){
		int aux=-1;
		if(index<outlets[0].length()){
			
			if(ones(outlets,index)==outlets.length/2.0 && !flipped){
				String[] outlets2=Arrays.copyOf(outlets,outlets.length);
				flip(outlets2,index);
				flipped=true;
				aux=match(outlets2,devices,flips+1,index,flipped);
			}
			
			ArrayList<String> outlets_array=new ArrayList<String>();
			for(String s:outlets){
				outlets_array.add(s.substring(0, index+1));
				
			}
			int x=0;
			while(!outlets_array.isEmpty() && outlets_array.contains(devices[x].substring(0, index+1))){
				outlets_array.remove(devices[x].substring(0, index+1));
				x++;
			}
			
			if(outlets_array.isEmpty()){
				flips=match(outlets,devices,flips,index+1,false);
			}else{//not empty
				if(!flipped){
					flipped=true;
					flips++;
					flip(outlets,index);
					flips=match(outlets,devices,flips,index,flipped);
				}else{
					flips=Integer.MIN_VALUE;
				}
			}
		}
		if(aux==-1 || aux==Integer.MIN_VALUE){
			return flips;
		}else{
			if(flips==Integer.MIN_VALUE)
				return aux;
			else
				return flips;
		}
		
	}
	private static int ones(String[] ss, int index){
		int ones=0;
		for(String s:ss){
			if(s.charAt(index)=='1')
				ones++;
		}
		return ones;
	}
}

