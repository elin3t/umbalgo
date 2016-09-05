//UMB Virtual - Ingenieria de Software - Semestre II - Algoritmica y Programacion
//Profesora: Brigitte Rodriguez Mendoza
//Estudiosos: Bairon Jose Garcia Mendoza
//			  Eliecer Urbano Daza Parra
//			  Jorge  Manuel  Galindo  Yanez
//		      Julian  David  Castaneda

//Programa que calcula el valor a pagar a 5 empleados, 
//el primero gana 2 millones, el segundo gana el 10% mas que el primero, 
//el tercero el 10% mas que el segundo, y asi sucesivamente hasta llegar al quinto. Se deben hacer tres rutinas.
//	 La primera, debe calcular el salario.
//	 La segunda, debe calcular el valor neto a pagar considerando descuentos como retencion en la fuente (puede ser 14%), seguro social y pension.
//	 La tercera, debe imprimir la informacion de cada empleado (salario, valor de la retencion en la fuente, valor del seguro social, valor pension, neto a pagar).

/* Se importan librerias*/ 
import java.text.DecimalFormat;

public class Nomina {

	public static void main(String[] args) {
		//multidimensional array para guardar [salario, retefuente, salud, pension ]
		Double[][] salarios = new Double [5][5];
		Double valsal = (double) 2000000;

		salarios[0][0] = valsal;
		for (int i = 1; i < 5; i++) {
			salarios[i][0] = calcula_salario(salarios[i-1][0]); 
		}
		for (int i = 0; i<salarios.length ; i++) {
			salarios[i][1] = calcula_retefuente(salarios[i][0]);
			salarios[i][2] = calcula_salud(salarios[i][0]);
			salarios[i][3] = calcula_pension(salarios[i][0]);
			Double salario_neto = calcula_salario_neto(salarios[i]);
			salarios[i][4] = salario_neto;
		}
		imprimir_info_salarios(salarios);

		return;
	}

	static void imprimir_info_salarios(Double[][] salarios){
		System.out.println("-------------------------------------------------------------");
		System.out.println("                         Salarios UMB                        ");
		System.out.println("-------------------------------------------------------------");
		System.out.println("|    Salario  |   Retefuente  | Salud   | Pension   |   Neto    |");
		for (int i =0; i<salarios.length; i++ ) {
			System.out.println(formatea_salario(salarios[i]));
		}
		System.out.println("-------------------------------------------------------------");
		return;
	}

	static String formatea_salario(Double[] salario) {
		DecimalFormat f = new DecimalFormat("'$'##,###,###.##");
		return ("| " + f.format(salario[0])+"  |  " + f.format(salario[1])+"    | " + f.format(salario[2])+"    | " + f.format(salario[3])+"    |  " + f.format(salario[4])+" |");
			
	}
	static double calcula_salario_neto(Double[] salario){
		return (double) (salario[0] - salario[1] - salario[2] - salario[3]);
	}

	static double calcula_salario(double salario){
		return (double) (salario * 1.1);
	}

	static double calcula_retefuente(double salario){
		return (double) (salario * 0.14);
	}

	static double calcula_salud(double salario){
		return (double) (salario * 0.085);
	}

	static double calcula_pension(double salario){
		return (double) (salario * 0.12);
	}

}
