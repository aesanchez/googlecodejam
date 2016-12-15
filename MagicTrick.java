
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import Util.IOFileManager;

public class MagicTrick {
	public static void main(String[]args){
		Scanner input=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\A-small-practice.in", "C:\\Users\\Trorik\\Desktop\\output-file.txt");
		int T= input.nextInt();
		input.nextLine();
		for(int i=1; i<=T;i++){
			List<Integer> possible_numbers=new ArrayList<Integer>();
			int row=input.nextInt();
			input.nextLine();
			List<Integer> firstRow=new ArrayList<Integer>();
			for(int k=1;k<=4;k++){
				String aux=input.nextLine();
				if(row==k){
					String[] numbers=aux.split(" ");
					for(String s : numbers){
						firstRow.add(Integer.parseInt(s));
					}
				}
			}
			//again
			row=input.nextInt();
			input.nextLine();
			for(int k=1;k<=4;k++){
				String aux=input.nextLine();
				if(row==k){
					String[] numbers=aux.split(" ");
					for(String s : numbers){
						int x=Integer.parseInt(s);
						if(firstRow.contains(x)){
							possible_numbers.add(x);
						}
					}
				}
			}

			System.out.print("Case #"+i+": ");
			if(possible_numbers.size()==0){
				System.out.println("Volunteer cheated!");
			}else{
				if(possible_numbers.size()==1){
					System.out.println(possible_numbers.get(0));
				}else{
					System.out.println("Bad magician!");
				}

			}
		}//for T
		input.close();


	}
}
