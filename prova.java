import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Arquivo a1 = new Arquivo();
		int[][] arrays = a1.main();
		int[] array1 = arrays[0];
		int[] array2 = arrays[1];
		int[] array3 = arrays[2];

		Sorter s1 = new Sorter();

		//s1.bubble(array3);
		s1.selection(array2);
		//s1.insert(array3);
		}
}

class Arquivo{
		static int[] array1,array2,array3;
		private int[][] arrays;
		private int i;
		private String linha;
		private String[] numeros;
		private boolean state;
		private int size; //Apagar dps

	Arquivo(){
		size = 1000000;
		array1 = new int[size];
		array2 = new int[size];
		array3 = new int[size];
		arrays = new int[3][];
	}
	

	int[][] main(){
		state = true;
		File lista = new File("lista.txt"); //Cria o arquivo

		try{//Lê o arquivo se ele existir

			Scanner s1 = new Scanner(lista);

			if(s1.hasNextLine()){
				linha = s1.nextLine();
				numeros = linha.split(",");
				for(i=0;i<size;i++){
					array1[i] = Integer.valueOf(numeros[i]);}
					arrays[0] = array1;}
			if(s1.hasNextLine()){
				linha = s1.nextLine();
				numeros = linha.split(",");
				for(i=0;i<size;i++){
					array2[i] = Integer.valueOf(numeros[i]);}
					arrays[1] = array2;}
			if(s1.hasNextLine()){
				linha = s1.nextLine();
				numeros = linha.split(",");
				for(i=0;i<size;i++){
					array3[i] = Integer.valueOf(numeros[i]);}
					arrays[2] = array3;}
		}
		catch(Exception e){System.out.println(e);}
		return arrays;
		}
	}

class Sorter{
	int i,z,temp;
	String tempo;
	int trocas = 0;
	void bubble(int[] array){
		long tempoInicial = System.nanoTime()/1000000;

		boolean trocou = false;
		int comp = 0;

		for(i=0;i<array.length-2;i++){
			for(z=0;z<array.length-2;z++){
				if(array[z]>array[z+1]){
					temp = array[z];
					array[z] = array[z+1];
					array[z+1] = temp;
					trocou = true;
					trocas++;

					}
				comp++;
				tempo = "Comparações: "+comp+" - "+"Mili:"+(System.nanoTime()/1000000-tempoInicial)+" Sec:"+(System.nanoTime()/1000000000-tempoInicial/1000)+" Min:"+((System.nanoTime()/1000000000-tempoInicial/1000)/60);
				tempo+=" Trocas: "+trocas+" Número na posição 1: "+array[0];
				System.out.println(tempo);
				}
			if(trocou==false){
				System.out.println("Lista ordenada."+"\n"+Arrays.toString(array));
				System.out.println(tempo);
				break;
				}
			comp++;
			}
	}

	void selection(int[] array){
		int comp = 0;
		long tempoInicial = System.nanoTime()/1000000; 
		int n = array.length; 
		int j = 0;
		for (int i = 0; i < n-1; i++){
			if(trocas == 0 && j >= n){break;}
			int min_idx = i; 
			for (j = i+1; j < n; j++){ 
				if (array[j] < array[min_idx]){
					trocas++;
					min_idx = j;}
				comp+=2;
			int temp = array[min_idx]; 
			array[min_idx] = array[i]; 
			array[i] = temp; 
			
			tempo = "Comparações: "+comp+" - "+"Mili:"+(System.nanoTime()/1000000-tempoInicial)+" Sec:"+(System.nanoTime()/1000000000-tempoInicial/1000)+" Min:"+((System.nanoTime()/1000000000-tempoInicial/1000)/60);
			tempo+=" Trocas: "+trocas+" Primeiro: "+array[0]+" "+j+"-"+n;
			System.out.println(tempo);
			}
		}
		
	} 

	void insert(int[] array){
		int comp = 0;
		long tempoInicial = System.nanoTime()/1000000; 
		int n = array.length;
		int trocas = 0;
		int j = 0;


        for (int i = 1; i < n; i++) {
        	if(trocas == 0 && j >= n){break;}
            int key = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > key) {
            	trocas++;
                array[j + 1] = array[j];
                j--;
            }
            comp++;
            array[j + 1] = key;

            tempo = "Comparações: "+comp+" - "+"Mili:"+(System.nanoTime()/1000000-tempoInicial)+" Sec:"+(System.nanoTime()/1000000000-tempoInicial/1000)+" Min:"+((System.nanoTime()/1000000000-tempoInicial/1000)/60);
			tempo+=" Trocas: "+trocas+" Primeiro: "+array[0]+" "+j+"-"+n;
			System.out.println(tempo);
        }
	}
}
