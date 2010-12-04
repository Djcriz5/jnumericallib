package methods;

import exceptions.RaizNoEncontradaExcepcion;

/**
 * <p>
 * El m�todo de Newton (conocido tambi�n como el m�todo de Newton-Raphson o el
 * m�todo de Newton-Fourier) es un algoritmo eficiente para encontrar
 * aproximaciones de los ceros o ra�ces de una funci�n real.
 * </p>
 * <br>
 * <p>
 * El m�todo de Newton-Raphson es un m�todo abierto, en el sentido de que su
 * convergencia global no est� garantizada. La �nica manera de alcanzar la
 * convergencia es seleccionar un valor inicial lo suficientemente cercano a la
 * ra�z buscada. As�, se ha de comenzar la iteraci�n con un valor razonablemente
 * cercano al cero (denominado punto de arranque o valor supuesto). La relativa
 * cercan�a del punto inicial a la ra�z depende mucho de la naturaleza de la
 * propia funci�n; si �sta presenta m�ltiples puntos de inflexi�n o pendientes
 * grandes en el entorno de la ra�z, entonces las probabilidades de que el
 * algoritmo diverja aumentan, lo cual exige seleccionar un valor supuesto
 * cercano a la ra�z. Una vez se ha hecho esto, el m�todo linealiza la funci�n
 * por la recta tangente en ese valor supuesto. La abscisa en el origen de dicha
 * recta ser�, seg�n el m�todo, una mejor aproximaci�n de la ra�z que el valor
 * anterior. Se realizar�n sucesivas iteraciones hasta que el m�todo haya
 * convergido lo suficiente.
 * </p>
 * <p>
 * Sea f : [a, b] -> R funci�n derivable definida en el intervalo real [a, b].
 * Empezamos con un valor inicial x0 y definimos para cada n�mero natural n
 * </p>
 * <br>
 * <img alt="NewtonRaphson Formule" src="..\resources\NR.png" > <br>
 * <p>
 * Donde f ' denota la derivada de f. N�tese que el m�todo descrito es de
 * aplicaci�n exclusiva para funciones de una sola variable con forma anal�tica
 * o impl�cita cognoscible. Existen variantes del m�todo aplicables a sistemas
 * discretos que permiten estimar las ra�ces de la tendencia, as� como
 * algoritmos que extienden el m�todo de Newton a sistemas multivariables,
 * sistemas de ecuaciones, etc.
 * </p>
 */
public class NewtonRaphson{
	
	private static final String METHOD_NAME = "NewtonRaphson";
	

    /**
     * Este metodo encuentra la raiz de la funcion por medio de Newton Raphson
     *
     * @param f la funcion a la cual le queremos hayar la raiz
     * @param fderived la derivada de la funcion 
     * @param p0            punto de inicio. Debe ser lo mas cercano posible a la raiz
     * @param error         margen de error tolerado
     * @param maxIterations numero maximo de iteraciones permitidas
     * @return raiz de la funcion
     * @throws RaizNoEncontradaExcepcion en caso de que la raiz no haya podidod ser encontrada
     * o que la funcion no cumpla con las condiciones minimas necesarias
     */
    public static double findRoot(Funcion f, Funcion fderived, double p0, double error, int maxIterations)
            throws RaizNoEncontradaExcepcion {
        int iterations = 1;
        double p = p0;
        while (iterations < maxIterations) {
            //Xn+1 = Xn - f(x) / f'(x)
            double p1 = p - f.eval(p) / fderived.eval(p);
            if (Math.abs(f.eval(p1)) < error) {
                return p1;
            }
            p = p1;
            iterations++;
        }
        throw new RaizNoEncontradaExcepcion(METHOD_NAME);
    }
}
