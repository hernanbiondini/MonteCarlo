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


//        String funcion = "x";
//        double a = 0;
//        double b = 1;
//        int n = 1000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralSimple(funcion, a, b, n);


//        String funcion = "sin(x) + 1/3 sin(3x)";
//        double a = 0;
//        double b = 3.1416;
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralSimple(funcion, a, b, n);
        

//        String funcion = "sqrt(x)";
//        double a = 0;
//        double b = 4;
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralSimple(funcion, a, b, n);
        

//        String funcion = "4/(1+x^(2))";
//        double a = 0;
//        double b = 1;
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralSimple(funcion, a, b, n);


//        String funcion = "sqrt(x + sqrt(x))";
//        double a = 0;
//        double b = 1;
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralSimple(funcion, a, b, n);
        


//        String funcion = "x y";
//        double a = 1;
//        double b = 4;
//        double c = 0;
//        double d = 2;
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralDoble(funcion, a, b, c, d, n);


//        String funcion = " x^(2) + y^(2)";
//        double a = 0;
//        double b = 1;
//        double c = 0;
//        double d = 1;
//        int n = 5000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralDoble(funcion, a, b, c, d, n);
        

//        String funcion = " 2 x y";
//        double a = 0;
//        double b = 1;
//        double c = 0;
//        double d = 2;
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralDoble(funcion, a, b, c, d, n);


//        String funcion = " 4 - x^(2) - y^(2)";
//        double a = 0;
//        double b = 1.25; // 5/4
//        double c = 0;
//        double d = 1.25; // 5/4
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralDoble(funcion, a, b, c, d, n);
        
        
//        String funcion = " 8 x y z";
//        double a = 1;
//        double b = 2;
//        double c = 2;
//        double d = 3;
//        double e = 0;
//        double f = 1;
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralTriple(funcion, a, b, c, d, e, f, n);



//        String funcion = " 4 - x^(2) - y^(2) - z^(2)";
//        double a = 0;
//        double b = 0.9; // 9/10
//        double c = 0;
//        double d = 1;
//        double e = 0;
//        double f = 1.1; // 11/10
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralTriple(funcion, a, b, c, d, e, f, n);
        

//        String funcion = " sqrt(4 - x^(2) - y^(2) - z^(2))";
//        double a = 0;
//        double b = 0.9; // 9/10
//        double c = 0;
//        double d = 1;
//        double e = 0;
//        double f = 1.1; // 11/10
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralTriple(funcion, a, b, c, d, e, f, n);
        


//        String funcion = " 5 - x^(2) - y^(2) - z^(2) - u^(2)";
//        double a = 0;
//        double b = 0.8; // 4/5
//        double c = 0;
//        double d = 0.9; // 9/10
//        double e = 0;
//        double f = 1; 
//        double g = 0;
//        double h = 1.1; // 11/10
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralCuadruple(funcion, a, b, c, d, e, f, g, h, n);
        
//        String funcion = " sqrt(5 - x^(2) - y^(2) - z^(2) - u^(2))";
//        double a = 0;
//        double b = 0.8; // 4/5
//        double c = 0;
//        double d = 0.9; // 9/10
//        double e = 0;
//        double f = 1; 
//        double g = 0;
//        double h = 1.1; // 11/10
//        int n = 1000000;
//        MonteCarlo mc = new MonteCarlo();
//        mc.monteCarloIntegralCuadruple(funcion, a, b, c, d, e, f, g, h, n);


        String funcion = " sqrt(6 - x^(2) - y^(2) - z^(2) - u^(2) - w^(2))";
        double a = 0;
        double b = 0.7; // 7/10
        double c = 0;
        double d = 0.8; // 4/5
        double e = 0;
        double f = 0.9; // 9/10
        double g = 0;
        double h = 1; 
        double i = 0;
        double j = 1.1; // 11/10
        int n = 1000000;
        MonteCarlo mc = new MonteCarlo();
        mc.monteCarloIntegralQuintuple(funcion, a, b, c, d, e, f, g, h, i, j, n);
    }

}
