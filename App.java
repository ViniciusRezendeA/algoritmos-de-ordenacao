import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int[] v = null;
        int op;

        System.out.println("Digite o tamanho do vetor: ");
        int n = scan.nextInt();

        System.out.println("Escolha como deseja que seja criado o vetor: ");
        System.out.println("1 - manualmente");
        System.out.println("2 - automaticamente");

        op = scan.nextInt();

        switch (op) {
            case 1:
                v = lerVetor(n, scan);
                break;

            case 2:
                v = gerarVetor(n);
                break;

            default:
                System.out.println("Incira um valor valido da próxima vez!");
                break;

        }

        System.out.println("Escolha o metodo de ordenação: ");
        System.out.println("1 - bouble");
        System.out.println("2 - insertion");
        System.out.println("3 - heap");
        System.out.println("4 - quick");

        op = scan.nextInt();

        switch (op) {
            case 1:
                boubleSort(v);
                imprimirVetor(v);
                break;

            case 2:
                insertionSort(v);
                imprimirVetor(v);
                break;

            case 3:
                heapSort(v);
                imprimirVetor(v);
                break;

            case 4:
                quickSort(v, 0, v.length - 1);
                imprimirVetor(v);
                break;

            default:
                System.out.println("Incira um valor valido da próxima vez!");
                break;
        }

        scan.close();

    }

    public static int[] insertionSort(int v[]) {
        for (int i = 1; i < v.length; i++) {
            int pos = i;
            for (int j = i - 1; j >= 0; j--) {
                System.out.println("vetor na posicao " + j + " maior que na posicao " + i);
                System.out.println("v[j]: " + v[j] + "\nv[i]: " + v[i]);

                if (v[i] >= v[j]) {
                    break;
                }

                pos = j;
            }

            if (pos == i)
                continue;

            int aux = v[i];

            for (int j = i - 1; j >= pos; j--) {
                v[j + 1] = v[j];
                imprimirVetor(v);
            }

            v[pos] = aux;

        }
        return v;
    }

    public static int[] boubleSort(int v[]) {
        int comp = 0;
        int troca = 0;

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length - i - 1; j++) {

                ++comp;

                if (v[j] > v[j + 1]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;

                    ++troca;
                }
            }
        }

        System.out.println("Comparações: " + comp);
        System.out.println("Trocas: " + troca);

        return v;
    }

    public static void imprimirVetor(int v[]) {

        System.out.print("[");
        for (int i = 0; i < v.length; i++) {
            if (i == v.length - 1) {
                System.out.print(v[i]);
                continue;
            }

            System.out.print(v[i] + ", ");
        }
        System.out.print("]");
    }

    public static int[] gerarVetor(int n) {
        Random random = new Random();

        int v[] = new int[n];

        for (int i = 0; i < v.length; i++) {
            v[i] = random.nextInt(0, 256);
        }

        return v;
    }

    public static int[] lerVetor(int n, Scanner scan) {
        int[] v = new int[n];

        System.out.println("Digite os " + n + " valores do vetor: ");

        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
        }

        System.out.println("O vetor gerado foi: ");
        imprimirVetor(v);

        return v;
    }

    private static void heapSort(int[] v) {
        for(int i = 1; i < v.length; i++)
            construirHeap(v, i);
            
            
        for (int i = 0; i < v.length - 1; i++) {
            swap(v, 0, v.length - 1 - i);
            //reconstruirHeap(v, 0, tam);
        }
        
        printHeap(v);
    }

    public static void construirHeap(int[] v, int tam) {
        for(int i = tam; i>=0 && v[i] > v[i/2]; i/=2) {
            swap(v, i, i/2);
        }
    }

    public static void reconstruirHeap(int[] v, int i, int tam) {

        // int filho1 = i*2 + 1;
        // int filho2 = filho1 + 1;
        // int maiorFilho;

        // if(filho2 < tam)
        //     maiorFilho = v[filho1] > v[filho2] ? filho1 : filho2;
        // else if(filho1 < tam)
        //     maiorFilho = filho1;
        // else

        // if(v[maiorFilho] > v[i]) {
        //     swap(v, i, maiorFilho);

        // }

    }

    private static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static void quickSort(int[] v, int esq, int dir) {
        int i = esq;
        int j = dir;
        int pivo = v[(esq+dir)/2];

        while(i<=j) {
            

            while (v[i] < pivo) {
                i++;
            }

            while (v[j] > pivo) {
                j--;
            }

            if(i <= j) {
                swap(v, i, j);
                i++;
                j--;
            }

        }

        if(esq < j)
            quickSort(v, esq, j);

        if(i < dir)
            quickSort(v, i, dir);
    }









    public static void printHeap(int[] arr) {
        int n = arr.length;
        int maxDigits = getMaxDigits(arr);

        int levels = (int) (Math.log(n) / Math.log(2)) + 1;
        int index = 0;

        for (int i = 0; i < levels; i++) {
            int elementsInLevel = (int) Math.pow(2, i);
            int spacing = (int) Math.pow(2, levels - i) - 1;
            int startOffset = (int) Math.pow(2, levels - i - 1) - 1;

            for (int j = 0; j < elementsInLevel; j++) {
                if (index >= n) break;

                // Print spaces before the number
                for (int k = 0; k < spacing; k++) {
                    System.out.print(" ");
                }

                // Print number
                System.out.print(String.format("%" + maxDigits + "d", arr[index++]));

                // Print spaces after the number
                for (int k = 0; k < spacing; k++) {
                    System.out.print(" ");
                }

                // Add additional spacing for numbers in the middle of the line
                if (j < elementsInLevel - 1) {
                    for (int k = 0; k < startOffset; k++) {
                        System.out.print(" ");
                    }
                }
                
            }

            System.out.println("\n");
        }
    }

    private static int getMaxDigits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            int digits = (int) Math.log10(num) + 1;
            if (digits > max) {
                max = digits;
            }
        }
        return max;
    }
    private static boolean isPowerOfTwo(int x) {
        return (x & (x - 1)) == 0;
    }
}

