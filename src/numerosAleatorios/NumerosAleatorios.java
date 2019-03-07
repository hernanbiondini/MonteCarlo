package numerosAleatorios;

/**
 *
 * @author hernan

* 
* 
public static double random()

Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0. Returned values are chosen pseudorandomly with (approximately) uniform distribution from that range.

When this method is first called, it creates a single new pseudorandom-number generator, exactly as if by the expression

    new java.util.Random()

This new pseudorandom-number generator is used thereafter for all calls to this method and is used nowhere else.

This method is properly synchronized to allow correct use by more than one thread. However, if many threads need to generate pseudorandom numbers at a great rate, it may reduce contention for each thread to have its own pseudorandom-number generator.

Returns:
    a pseudorandom double greater than or equal to 0.0 and less than 1.0.
 */




public class NumerosAleatorios {

    public static void main(String[] args) {
        int cont = 1;
        for (int i = 0; i < 100; i++) {
            System.out.println(" N - " + cont +": " +  Math.random());
            cont = cont +1;
        }

    }

}
