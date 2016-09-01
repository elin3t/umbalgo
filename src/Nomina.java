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

public class Nomina {

	public static void main(String[] args) {
		//multidimensional array para guardar [salario, retefuente, seguro, pension ]
		Double[][] salarios = new Double [5][4];
		Double retefuente = 0.0;
		Double salud = 0.0;
		Double seguro = 0.0;

		Double valsal = (double) 2000000;
		salarios[0][0] = valsal;
		System.out.println("Salario Empleado 1: " + valsal);
		for (int i = 1; i < 5; i++) {
		    
			valsal = calcula_salario(valsal); 
			salarios[i][0] = valsal;
			System.out.println("Salario Empleado " + (i+1) + ": " + valsal);
		    
		}
	}

	static double calcula_salario(double salario){
		double newsalario;
		newsalario = (double) (salario * 1.1);
		return newsalario;
	}

	static double calcula_retefuente(double salario){
		return salario*retefuente;
	}

}
