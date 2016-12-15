import java.util.Scanner;

import Util.IOFileManager;

public class CookieClickerAlpha {
	public static void main(String[]args){
		Scanner input=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\B-large-practice.in", "C:\\Users\\Trorik\\Desktop\\B-large-practice.out");
		int T=input.nextInt();
		input.nextLine();
		for(int i=1;i<=T;i++){
			String s=input.nextLine();
			double C=Float.parseFloat(s.split(" ")[0]); //farm
			double F=Float.parseFloat(s.split(" ")[1]); //productivity
			double X=Float.parseFloat(s.split(" ")[2]); //goal
			double farms=0;
			double t_minimum=Float.MAX_VALUE;
			double t_farms=0;			
			while((X/(2+F*farms)+t_farms)<t_minimum){
				t_minimum=(X/(2.0+F*farms)+t_farms);
				t_farms+=C/(2.0+F*farms);
				farms++;
			}
			System.out.println("Case #"+i+": "+t_minimum);
		}
		
	}
}
