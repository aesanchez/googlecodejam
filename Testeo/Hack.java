package Testeo;

//Para testear tu código en nuestros servidores debes mantener la estructura expuesta abajo.
//Eres libre de crear nuevas funciones/procedimientos.
//Recuerda que el código que escribas podrá ser visto por las empresas a las que te postules.
class Hack
{
	// String lista[] = { "miel", "extraterrestre", "al", "automovil", "auto", "revestir" };
	// String alfabeto = "zyxwvutsrqponmlkjihgfedcba";
	public static void main(String[]args){
		String lista[] = { "miel", "extraterrestre", "al", "automovil", "auto", "revestir" };
		String alfabeto = "zyxwvutsrqponmlkjihgfedcba";
		lista=ordenar_extraterrestre(lista,alfabeto);
		for(String i:lista){
			System.out.print(i+" ");
		}
	}
	public static String[] ordenar_extraterrestre(String desordenadas[], String orden_alfabeto)
	{

		return merge(desordenadas,orden_alfabeto);
	}
	private static String[] merge(String[]a,String orden){
		int size=a.length;		
		if(size>1){
			int size1=size/2;
			int size2=size-size1;
			String[]a1=new String[size1];
			String[]a2=new String[size2];
			for(int i=0;i<size1;i++){
				a1[i]=a[i];
			}
			for(int i=0;i<size2;i++){
				a2[i]=a[i+size1];
			}
			a1=merge(a1,orden);
			a2=merge(a2,orden);
			

			int i1=0,i2=0;
			for(int i=0; i<size;i++){
				if(i1<size1){
					if(i2<size2){
						if(comparador(orden,a1[i1],a2[i2])){
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
	//return true if s1<s2
	private static boolean comparador(String orden,String s1, String s2){
		boolean result=true;
		int i=0;
		while(result && i<s1.length() && i<s2.length()){
			if(orden.indexOf(s1.charAt(i)) > orden.indexOf(s2.charAt(i))){
				result=false;
				i--;
			}else{
				if(orden.indexOf(s1.charAt(i)) < orden.indexOf(s2.charAt(i))){
					i--;
					break;				
				}
			}
			i++;
		}
		if((i==s1.length() || i==s2.length())&&(s1.length()>s2.length())){
			result=false;
		}
		return result;        
	}





}

//La función main() será ejecutada en nuestros servidores llamando a la expuesta arriba.