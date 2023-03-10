package examen;

<<<<<<< HEAD
import examen.Fraccion;

/**
 * Clase que contiene las variables, constructores y métodos necesarios para la creación de una fracción
 * @version 1.0
 * @author Antonio Navarro
 */
=======
// Clase que define una fracción
>>>>>>> branch 'master' of https://github.com/antonionavarro04/ExamenT3Entornos
public class Fraccion {
	// Numerador
	private int num;

	// Denominador
	private int den;

	// Constructor por defecto

	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;
		} else {
			this.den = den;
		}
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	// Constructor copia
	public Fraccion(final Fraccion fraccion) {
		num = fraccion.num;
		den = fraccion.den;
	}

	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int maxComunDivisor() {
		int numeradorAbs = Math.abs(num); // valor absoluto del numerador
		int denominadorAbs = Math.abs(den); // valor absoluto del denominador
		int resto;
		while (denominadorAbs != 0) {
			resto = numeradorAbs % denominadorAbs;
			numeradorAbs = denominadorAbs;
			denominadorAbs = resto;
		} return numeradorAbs;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int maxComDiv = maxComunDivisor();
		num = num / maxComDiv;
		den = den / maxComDiv;
	}

	// Método toString

	public String toString() {
		return num + "/" + den;

	}

	// suma de fracciones
	public Fraccion sumar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraccion.den;
		int cruce2 = den * fraccion.num;
		aux.num = cruce1 + cruce2;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	public Fraccion restar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraccion.den;
		int cruce2 = den * fraccion.num;
		aux.num = cruce1 - cruce2;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	public Fraccion multiplicar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.num;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	public Fraccion dividir(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.den;
		aux.den = den * fraccion.num;
		aux.simplificar();
		return aux;

	}

}