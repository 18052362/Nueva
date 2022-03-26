




import java.util.Scanner;
 

public class Acertijo {
	static int[][] arr2 = new int[3][3];//= { { 1, 2, 3 }, { 8, 0, 4 }, { 7, 6, 5 } };
	static int aaa;		// Se usa para registrar el número de pasos en movimiento
	static int bbb=5;	// Se usa para registrar la profundidad

	public static void main(String[] args) {
		int[][] arr1 = new int[3][3];	// Definir una matriz bidimensional
		System.out.println("Ingrese la matriz final (reemplace el espacio con 0) (ingrese por línea):");
		Scanner input = new Scanner(System.in);		// Crear función de entrada de teclado
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int ss =input.nextInt();
				arr2[i][j] = ss; 
			}
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Estado final:");
		shuchu(arr2);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Por favor ingrese la matriz que se va a juzgar (el espacio se reemplaza por 0) (ingrese por línea):");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int ss =input.nextInt();
				arr1[i][j] = ss; 
			}
		}
		System.out.println("La matriz que ingresó:");
		shuchu(arr1);
		System.out.println(" ");
		yidong(arr1, 1, 0);	// Llamar a la función de movimiento
		System.out.println("..................................................");
		System.out.println("no pude encontrarlo");
		input.close();
	}

	public static void shuchu(int a[][]) { // Genera una matriz bidimensional

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean panduan(int a[][], int b[][]) { // Determine si el contenido de dos matrices bidimensionales es igual
		boolean esta = true;

		for (int i = 0; i < a.length && esta == true; i++) {
			for (int j = 0; j < a[i].length && esta == true; j++) {
				if (a[i][j] != b[i][j]) {
					esta = false;

				}
			}
			
		}
		return esta;
	}
	public static void jieshu() { // función final
		aaa++;	// Mover pasos
		System.out.println("jieshu");
		System.out.println("Compartido" + aaa +"paso" );
		System.exit(0);
	}

	public static int[][] zuoyi(int a2[][]) { // restaurar la función de desplazamiento a la izquierda
	
		int[][] a1 = a2;
		int n1=0;
		int n2=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a1[i][j] == 0) {
					
					n1 = i;// Mover la fila donde se encuentra la cuadrícula
					n2 = j;// Mover la columna donde se encuentra la cuadrícula
				}
			}
		}
		int t1 = a1[n1][n2 + 1];
		a1[n1][n2 + 1] = a1[n1][n2];
		a1[n1][n2] = t1;
		return a1;
	}
	public static int[][] shangyi(int a2[][]) { // Restaurar la función de subir
		int[][] a1 = a2;
		int n1=0;
		int n2=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a1[i][j] == 0) {
					
					n1 = i;// Mover la fila donde se encuentra la cuadrícula
					n2 = j;// Mover la columna donde se encuentra la cuadrícula
				}
			}
		}
		int t1 = a1[n1 + 1][n2];
		a1[n1 + 1][n2] = a1[n1][n2];
		a1[n1][n2] = t1;
		return a1;
	}
	public static int[][] youyi(int a2[][]) { // restaurar la función de desplazamiento a la derecha
		int[][] a1 = a2;
		int n1=0;
		int n2=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a1[i][j] == 0) {
					
					n1 = i;// Mover la fila donde se encuentra la cuadrícula
					n2 = j;// Mover la columna donde se encuentra la cuadrícula
				}
			}
		}
		int t1 = a1[n1][n2 - 1];
		a1[n1][n2 - 1] = a1[n1][n2];
		a1[n1][n2] = t1;
		return a1;
	}
	public static int[][] xiayi(int a2[][]) { // Restaurar la función de bajar
		int[][] a1 = a2;
		int n1=0;
		int n2=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a1[i][j] == 0) {
					n1 = i;// Mover la fila donde se encuentra la cuadrícula
					n2 = j;// Mover la columna donde se encuentra la cuadrícula
				}
			}
		}
		int t1 = a1[n1 - 1][n2];
		a1[n1 - 1][n2] = a1[n1][n2];
		a1[n1][n2] = t1;
		return a1;
	}
	public static void yidong(int a[][], int s, int x) {

		aaa++;	// Mover pasos
		int[][] ar2 = a;	// La matriz pasada
		int q = s;		//profundidad
		int c=x;		// Se usa para determinar en qué dirección no puede moverse (1, no puede moverse hacia la derecha 2, no puede moverse hacia abajo 3, no puede moverse hacia la izquierda 4, no puede moverse hacia arriba)
		System.out.println("Sección"+ aaa +"paso"+ ":");
		System.out.println("Profundidad: " + q);
		shuchu(ar2);
		if (q == bbb) {
			System.out.println("*********************************");
			System.out.println("Alcanza la profundidad establecida");
			System.out.println("*********************************");
		} else {
			int num1 = -1;
			int num2 = -1;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (a[i][j] == 0) {

						num1 = i;// Mover la fila donde se encuentra la cuadrícula
						num2 = j;// Mover la columna donde se encuentra la cuadrícula
					}
				}
			}
			int pan = c;
			int o = num2 - 1;
			// System.out.println(o);
			if (o < 0 || pan == 1) {		// Desplazar a la izquierda
				System.out.println("");
			} else {
				
				System.out.println("Mover hacia la izquierda:");
				pan = 3;
				int t1 = ar2[num1][num2 - 1];
				ar2[num1][num2 - 1] = ar2[num1][num2];
				ar2[num1][num2] = t1;
				boolean aa = panduan(ar2, arr2);
				if (aa == true) {
					System.out.println("right");
					jieshu();
				}
				else {
					yidong(ar2,q+1,pan);
					pan=c;
					ar2=zuoyi(ar2);		// Llamar a la función de restauración de desplazamiento a la izquierda
					System.out.println("reducción:");
					shuchu(ar2);
					System.out.println(" ");
				}
			}
			if (num1 - 1 < 0 || pan == 2) {		//Ascender
				System.out.println("");
			} else {
				
				System.out.println("Ascender:");
				pan = 4;
				int t1 = ar2[num1 - 1][num2];
				ar2[num1 - 1][num2] = ar2[num1][num2];
				ar2[num1][num2] = t1;
				boolean aa = panduan(ar2, arr2);
				if (aa == true) {
					System.out.println("right");
					jieshu();
				}
				else {
					yidong(ar2,q+1,pan);
					pan=c;
					ar2=shangyi(ar2);		// Llamar a la función de restauración
					System.out.println("reducción:");
					shuchu(ar2);
					System.out.println(" ");
				}
			}
			if (num2 + 1 > 2 || pan == 3) {		// Desplazar a la derecha
				System.out.println("");
			} else {
				
				System.out.println("Moverse a la derecha:");
				pan = 1;
				int t1 = ar2[num1][num2 + 1];
				ar2[num1][num2 + 1] = ar2[num1][num2];
				ar2[num1][num2] = t1;
				boolean aa = panduan(ar2, arr2);
				if (aa == true) {
					System.out.println("right");
					jieshu();
				}
				else {
					yidong(ar2,q+1,pan);
					pan=c;
					ar2=youyi(ar2);		// Llamar a la función de restauración de cambio a la derecha
					System.out.println("reducción:");
					shuchu(ar2);
					System.out.println(" ");
				}
			}
			if (num1 + 1 > 2 || pan == 4) {		//Mover hacia abajo
				System.out.println("");;
			} else {
				
				System.out.println("Mover hacia abajo:");
				pan = 2;
				int t1 = ar2[num1 + 1][num2];
				ar2[num1 + 1][num2] = ar2[num1][num2];
				ar2[num1][num2] = t1;
				boolean aa = panduan(ar2, arr2);
				if (aa == true) {
					System.out.println("right");
					jieshu();
				}
				else {
					yidong(ar2,q+1,pan);
					pan=c;
					ar2=xiayi(ar2);		// Llamar a la función de restauración de movimiento hacia abajo
					System.out.println("reducción:");
					shuchu(ar2);
					System.out.println(" ");
				}
			
			}

		}
	}
}
