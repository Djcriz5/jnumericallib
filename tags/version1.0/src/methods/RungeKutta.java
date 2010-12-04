package methods;
/**
 * <p>
 * Los Runge-Kutta no son s�lo un m�todo sino una importante familia de m�todos 
 * iterativos tanto impl�citos como expl�citos para aproximar las soluciones de 
 * ecuaciones diferenciales ordinarias (E.D.O�s), estas t�cnicas fueron desarrolladas 
 * alrededor de 1900 por los matematicos alemanes Carl David Tolm� Runge y Martin 
 * Wilhelm Kutta.
 * </p>
 * <p>
 * El cl�sico m�todo Runge-Kutta de cuarto orden
 * Un miembro de la familia de los m�todos Runge-Kutta es usado tan com�nmente que 
 * a menudo es referenciado como �RK4� o como �el m�todo Runge-Kutta�.
 * Definamos un problema de valor inicial como:
 * </p>
 * <br>
 * <img src="..\resources\rungeKutta1.png" > 
 * <br>
 * <p>
 * Entonces el m�todo RK4 para este problema est� dado por la siguiente ecuaci�n:
 * </p>
 * <br>
 * <img src="..\resources\rungeKutta2.png" > 
 * <br>
 * <p>
 * donde:
 * </p>
 * <br>
 * <img src="..\resources\rungeKutta3.png" > 
 * <br>
 * <br>
 * <img src="..\resources\rungeKutta4.png" > 
 * <br>
 * <br>
 * <img src="..\resources\rungeKutta5.png" > 
 * <br>
 * <br>
 * <img src="..\resources\rungeKutta6.png" > 
 * <br>
 * <p>
 * As�, el siguiente valor (yn+1) es determinado por el presente valor (yn) mas el 
 * producto del tama�o del intervalo (h) por una pendiente estimada. La pendiente 
 * es un promedio ponderado de pendientes: k1 es la pendiente al principio del 
 * intervalo; k2 es la pendiente en el punto medio del intervalo, usando k1 
 * para determinar el valor de y en el punto <img src="..\resources\rungeKutta7.png" > 
 * usando el m�todo de Euler
 * k3 es otra vez la pendiente del punto medio, pero ahora usando k2 para determinar el valor de y
 * k4 es la pendiente al final del intervalo, con el valor de y determinado por k3
 * Promediando las cuatro pendientes, se le asigna mayor peso a las pendientes en el punto medio:
 * </p>
 * <br>
 * <img src="..\resources\rungeKutta8.png" > 
 * <br>
 * <p>
 * Esta forma del m�todo de Runge-Kutta, es un m�todo de cuarto orden lo cual 
 * significa que el error por paso es del orden de O(h5), mientras que el error 
 * total acumulado tiene el orden O(h4).
 * </p>
 */

public class RungeKutta {

	private static final String METHOD_NAME = "RungeKutta";

	public double order4(Funcion2 f, double x0, double y0, double h) {
		double F1 = f.eval(x0, y0);
		double F2 = f.eval(x0 + 0.5 * h, y0 + 0.5 * h * F1);
		double F3 = f.eval(x0 + 0.5 * h, y0 + 0.5 * h * F2);
		double F4 = f.eval(x0 + h, y0 + h * F3);
		return y0 + (h * (F1 + 2 * (F2 + F3) + F4)) / 6;
	}

    public double[] tabulateOrder4(Funcion2 f, double x0, double y0, double xn, int n) {
        double[] table = new double[n+1];
        double h = (xn-x0)/n;
        table[0] = y0;
        for (int i = 0; i < n; i++) {
            y0 = order4(f,x0,y0, h);
            x0 += h;
            table[i+1] = y0;
        }
        return table;
    }
}
