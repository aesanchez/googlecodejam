import java.util.ArrayList;
public class InfiniteHouseOfPancakes {
	public static void main(String[] args) {
		ArrayList<Integer> pancakes=new ArrayList<Integer>();
		pancakes.add(8);
		pancakes.add(7);
		pancakes.add(9);
	
		int time=0;
		while(!pancakes.isEmpty()){
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.println(pancakes.toString());
			int max=maxArray(pancakes);
			int divMax=(int)Math.ceil(max/2);
			if(max>divMax+amountMax(pancakes,divMax)&&(max>2)){
				//split in two only the plates of pancakes that have more than divMax
				int i=0;
				while( i<pancakes.size()&&pancakes.get(i)<divMax){
					i++;
				}
				int num=pancakes.remove(i);
				int num1=(int)Math.ceil(num/2);
				int num2=num-num1;
				pancakes.add(num1);
				pancakes.add(num2);
				pancakes.toString();
			}else{//everyone eat
				int j=0;
				while(j<pancakes.size()){//remove item=0

					if(pancakes.get(j)-1==0){
						pancakes.remove(j);		
					}else{
						pancakes.set(j,pancakes.get(j)-1);
						j++;
					}
				}
			}
			time++;	
		}
		System.out.println(time);
		
	}
	
	public static int maxArray(ArrayList<Integer> a){
		int max=-1;
		for(Integer i:a){
			max=Math.max(i, max);
		}
		return max;
	}
	
	public static int amountMax(ArrayList<Integer> a, int x){
		int amount=-1;
		for(Integer i:a){
			if(i>x){
				amount++;
			}
		}
		return amount;
	}
	
}
