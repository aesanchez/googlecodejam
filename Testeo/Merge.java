package Testeo;

public class Merge {
	public static void main(String[]args){
		int[] array={6,8,45,8,0,27,0,2,98,3,89,65,32,5,2,4};
		array=merge(array);
		for(int i:array){
			System.out.print(i+" ");
		}
	
	}
	public static int[] merge(int[]a){
		int size=a.length;
		if(size>1){
			int size1=size/2;
			int size2=size-size1;
			int[]a1=new int[size1];
			int[]a2=new int[size2];
			for(int i=0;i<size1;i++){
				a1[i]=a[i];
			}
			for(int i=0;i<size2;i++){
				a2[i]=a[i+size1];
			}
			a1=merge(a1);
			a2=merge(a2);
			int i1=0,i2=0;
			for(int i=0; i<size;i++){
				if(i1<size1){
					if(i2<size2){
						if(a1[i1]<a2[i2]){
							a[i]=a1[i1];
							i1++;
						}else{
							a[i]=a2[i2];
							i2++;
						}
					}else{
						a[i]=a1[i1];
						i1++;
					}
				}else{
					a[i]=a2[i2];
					i2++;
				}
			}
		}else{
			//size=1
		}		
		return a;
	}
}
