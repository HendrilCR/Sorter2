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
		//s1.selection(array2);
		s1.insert(array3);
		//s1.ordenarMergeSort(array1);
		//s1.heapSort(array3);
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
	int comp;
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
				
				}
			if(trocou==false){
				tempo = "Comparações: "+comp+" - "+"Mili:"+(System.nanoTime()/1000000-tempoInicial)+" Sec:"+(System.nanoTime()/1000000000-tempoInicial/1000)+" Min:"+((System.nanoTime()/1000000000-tempoInicial/1000)/60);
				tempo+=" Trocas: "+trocas+" Número na posição 1: "+array[0];
				System.out.println("Lista ordenada.");
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
			}
		}
		tempo = "Comparações: "+comp+" - "+"Mili:"+(System.nanoTime()/1000000-tempoInicial)+" Sec:"+(System.nanoTime()/1000000000-tempoInicial/1000)+" Min:"+((System.nanoTime()/1000000000-tempoInicial/1000)/60);
		tempo+=" Trocas: "+trocas+" Primeiro: "+array[0]+" "+j+"-"+n;
		System.out.println(tempo);
		
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

            
        }
        tempo = "Comparações: "+comp+" - "+"Mili:"+(System.nanoTime()/1000000-tempoInicial)+" Sec:"+(System.nanoTime()/1000000000-tempoInicial/1000)+" Min:"+((System.nanoTime()/1000000000-tempoInicial/1000)/60);
		tempo+=" Trocas: "+trocas+" Primeiro: "+array[0]+" "+j+"-"+n;
		System.out.println(tempo);
	}


	void ordenarMergeSort(int[] numeros) {
		long tempoInicial = System.nanoTime()/1000000; 
	    if (numeros.length > 1) {
	    comp++;
	      int inicio = 0;
	      int fim = numeros.length - 1;
	      ordenarMergeSort(numeros, inicio, fim);

	    }
	    tempo = "Comparações: "+comp+" - "+"Mili:"+(System.nanoTime()/1000000-tempoInicial)+" Sec:"+(System.nanoTime()/1000000000-tempoInicial/1000)+" Min:"+((System.nanoTime()/1000000000-tempoInicial/1000)/60);
		tempo+=" Trocas: "+trocas+" Primeiro: "+numeros[0];
		System.out.println(tempo);
	  }

	void ordenarMergeSort(int[] numeros, int inicio, int fim) {
	    if (inicio < fim) {
	    	comp++;
	      int meio = (inicio + fim) / 2;
	      ordenarMergeSort(numeros, inicio, meio);
	      ordenarMergeSort(numeros, meio + 1, fim);
	      mesclar(numeros, inicio, meio, fim);
	    }
	  }

	void mesclar(int[] numeros, int inicio, int meio, int fim) {
	    int tamanhoEsquerda = meio - inicio + 1;
	    int tamanhoDireita = fim - meio;
	    int[] esquerda = new int[tamanhoEsquerda];
	    int[] direita = new int[tamanhoDireita];
	    trocas++;
	    System.arraycopy(numeros, inicio, esquerda, 0, tamanhoEsquerda);
	    System.arraycopy(numeros, meio + 1, direita, 0, tamanhoDireita);

	    int indiceEsquerda = 0, indiceDireita = 0, indiceAtual = inicio;
	    while (indiceEsquerda < tamanhoEsquerda && indiceDireita < tamanhoDireita) {
	    	comp++;
	      if (esquerda[indiceEsquerda] <= direita[indiceDireita]) {
	      	comp++;
	        numeros[indiceAtual] = esquerda[indiceEsquerda];
	        indiceEsquerda++;
	      } else {
	        numeros[indiceAtual] = direita[indiceDireita];
	        indiceDireita++;
	      }
	      indiceAtual++;
	    }

	    while (indiceEsquerda < tamanhoEsquerda) {
	    	comp++;
	      numeros[indiceAtual] = esquerda[indiceEsquerda];
	      indiceEsquerda++;
	      indiceAtual++;
	    }
	    while (indiceDireita < tamanhoDireita) {
	    	comp++;
	      numeros[indiceAtual] = direita[indiceDireita];
	      indiceDireita++;
	      indiceAtual++;
	    }
	  }

	void heapSort(int[] arr) {
	long tempoInicial = System.nanoTime()/1000000; 
    if (arr == null || arr.length == 0) {

        return;
    }

    for (int i = arr.length / 2 - 1; i >= 0; i--) {
        heapify(arr, i, arr.length);
    }

    for (int i = arr.length - 1; i > 0; i--) {
    	trocas++;
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        heapify(arr, 0, i);
    	}
    comp++;
    tempo = "Comparações: "+comp+" - "+"Mili:"+(System.nanoTime()/1000000-tempoInicial)+" Sec:"+(System.nanoTime()/1000000000-tempoInicial/1000)+" Min:"+((System.nanoTime()/1000000000-tempoInicial/1000)/60);
	tempo+=" Trocas: "+trocas;
	System.out.println(tempo);
	}

	void heapify(int[] arr, int i, int n) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < n && arr[left] > arr[largest])
        largest = left;

    if (right < n && arr[right] > arr[largest])
        largest = right;

    if (largest != i) {
        int swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;
        heapify(arr, largest, n);
    }
}

}