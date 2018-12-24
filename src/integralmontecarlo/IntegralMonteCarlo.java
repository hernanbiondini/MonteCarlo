package integralmontecarlo;

import org.nfunk.jep.ParseException;

/**
 *
 * @author hernanbiondini
 */
public class IntegralMonteCarlo {

    public static void main(String[] args) {
//        try {
//            String resultadoParseo = "";
//            String resultadoEvaluacion = "";
//            Parseador p;
//            p = new Parseador();
//            p.configuracion_1();
//            p.agregarVariable("x", 2);
//            resultadoParseo = p.parsearExpresion("x^(2)");
//            if (resultadoParseo.equals("ok")) {
//                resultadoEvaluacion = p.evaluarExpresionString();
//                if (resultadoEvaluacion.equals("NaN")) {
//                    System.out.println("Ha ocurrido un error, verifique la entrada");
//                } else {
//                    System.out.println("Resultado: " + resultadoEvaluacion);
//                }
//            } else {
//                System.out.println(resultadoParseo);
//            }
//
//        } catch (ParseException pe) {
//            System.out.println("ParseException: " + pe.getMessage());
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//        }



//        String funcion = "x^(3)";
//        double a = 0;
//        double b = 1;
//        int n = 1000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarlo(funcion, a, b, n);
        
        String funcion = "x y";
        double a = 1;
        double b = 4;
        double c = 0;
        double d = 2;
        int n = 1000000;
        MonteCarlo mc = new MonteCarlo();
        mc.monteCarloIntegralDoble(funcion, a, b, c, d, n);
        
    }

}
