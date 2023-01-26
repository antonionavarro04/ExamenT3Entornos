package examen;

import examen.Fraccion;

/**
 * Clase que contiene las variables, constructores y métodos necesarios para la creación de una fracción
 * @version 1.0
 * @author Antonio Navarro
 */
public class Fraccion {
	/**
	 * Numerador de la fracción
	 */
	private int num;

	/**
	 * Denominador de la fracción
	 */
	private int den;

	/**
	 * Constructor que define una fracción con sus valores neutros 0/1
	 */
	public Fraccion() {
		num = 0;
		den = 1;

	}

	/**
	 * Constructor que define una fracción en base a dos parámetros, el denominador no podrá ser 0.
	 * La fracción se simplificará una vez creada
	 * @param num El numerador que se quiere aplicar en la fracción
	 * @param den El denominador que se quiere aplicar en la fracción
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracción simplificada
		simplificar();
	}

	/**
	 * Constructor que creara una copia de una fracción ya creada
	 * @param f fracción ya creada
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	/**
	 * Da valor al numerador de la fracción
	 * @param num Numerador que se quiere aplicar a la fracción
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * Metodo que devuelve el valor del numerador
	 * @return Valor del numerador
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Da valor al denominador de la fracción
	 * @param den Denominador que se quiere aplicar a la fracción
	 */
	public void setDen(int den) {
		this.den = den;
	}

	/**
	 * Método que devuelve el valor del denominador
	 * @return Valor del denominador
	 */
	public int getDen() {
		return den;
	}

	/**
	 * Calcula el máximo común divisor en base al algoritmo de Euclides
	 * @return Maximo común divisor de la fracción
	 */
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

	/**
	 * Método que simplifica una fracción en base a su mcd
	 */
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	/**
	 * Método que convierte la fracción en una cadena de texto
	 * @return Fracción convertida en cadena de texto
	 */
	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	/**
	 * Suma 2 fracciones
	 * @param f Fracción ya creada que se pasa como parámetro 
	 * @return Resultado de la suma de fracciones simplificada
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Resta 2 Fracciones
	 * @param f Fracción ya creada que se pasa como parámetro
	 * @return Resultado de la resta de fracciones simplificada
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Multiplica dos fracciones
	 * @param f Fracción ya creada pasada como parametro
	 * @return Resultado de la multiplicación de fracciones simplificada
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	/**
	 * Divide fracciones
	 * @param f Fracción ya creada pasada como parámetro
	 * @return Resultado de la división de fracciones simplificada
	 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
