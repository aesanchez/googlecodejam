import java.util.Scanner;


public class StandingOvation {

	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		
		int T=input.nextInt();
		
		
		for(int j=1;j<=T;j++){
			int people=0;
			int invitados=0;
					
			String audience=input.next();
			
			for(int i=0;i<audience.length();i++){
				if(i<=people){
					people+=Integer.parseInt(audience.charAt(i)+"");
				}else{
					invitados+=i-people;
					people+=Integer.parseInt(audience.charAt(i)+"")+(i-people);
				}
			}
		System.out.println("Case #"+j+": "+invitados);
		}
		input.close();
	}

}