import Util.IOFileManager;
import java.util.Scanner;
public class MineSweeperMaster {
	public static void main(String[]args){
		Scanner s=IOFileManager.IO("C:\\Users\\Trorik\\Desktop\\C-large-practice.in", "C:\\Users\\Trorik\\Desktop\\C-output.txt");
		int T=s.nextInt();
		s.nextLine();
		for(int i=1;i<=T;i++){		
			int R=s.nextInt();
			int C=s.nextInt();
			int M=s.nextInt();
			s.nextLine();
			//System.out.println(R+" "+C+" "+M);
			boolean swapped=false;
			boolean possible=true;
			int free=(R*C)-M;

			if(R<C){//swap
				int aux=R;
				R=C;
				C=aux;
				swapped=true;
			}
			char[][] map=new char[R][C];
			for(int r=0;r<R;r++){
				for(int c=0;c<C;c++){
					map[r][c]='.';
				}
			}
			if(C>=3){				
				if((free<4)||(free==5)||(free==7)){
					//imposible
					possible=false;
				}else{
					int row=0;
					while(M>0){
						if(row==R-2){
							int aux=M/2;
							for(int l=0;l<aux;l++){
								map[row][l]='*';
								map[row+1][l]='*';
								M-=2;
							}								
						}else{
							if(M/C>0){//full row ***
								for(int k=0;k<C;k++){
									if((row==R-3 && k==C-3) && (M%2==0)){
										//do not put there a mine
										break;
									}else{
										map[row][k]='*';
										M--;
									}									
								}
							}else{
								int aux=C-2;//quantity avalible in that row;
								if(aux>M){
									aux=M;
								}
								for(int k=0;k<aux;k++){
									if((row==R-3 && k==C-3) && (M%2==0)){
										//do not put there a mine
									}else{
										map[row][k]='*';
										M--;
									}
								}
							}
							row++;		
						}

					}
					map[R-1][C-1]='c';
				}
			}else{//menor que 3
				if(C==2){
					if(M%2==0 && free>2){
						for(int r=0;r<M/2;r++){
							map[r][0]='*';
							map[r][1]='*';
						}
					}else{
						possible=false;
					}
					map[R-1][C-1]='c';
				}else{//C=1
					if(free>1){
						for(int r=0;r<M;r++){
							map[r][0]='*';
						}
						map[R-1][C-1]='c';
					}else{
						possible=false;
					}
				}
			}
			if(free==1){
				for(int r=0;r<R;r++){
					for(int c=0;c<C;c++){
						map[r][c]='*';
					}
				}
				map[0][0]='c';
				possible=true;
			}
			System.out.println("Case #"+i+":");
			if(possible){
				//print map
				if(swapped){
					for(int r=0;r<C;r++){
						for(int c=0;c<R;c++){
							System.out.print(map[c][r]);
						}
						System.out.println();
					}
				}else{
					for(int r=0;r<R;r++){
						for(int c=0;c<C;c++){
							System.out.print(map[r][c]);
						}
						System.out.println();
					}
				}
			}else{
				System.out.println("Impossible");
			}			
		}
	}
}
