package integralmontecarlo;

import static java.lang.Math.sqrt;
import java.text.DecimalFormat;
import org.nfunk.jep.ParseException;

/**
 *
 * @author hernanbiondini
 */
public class MonteCarlo {

    public void monteCarloIntegralSimple(String funcion, double a, double b, int n) {
        System.out.println("Evaluando integral...");
        DecimalFormat fmt = new DecimalFormat("0.################");
        String resultadoParseo = "";
        double approx = 0.0;
        Parseador p;
        p = new Parseador();
        p.configuracion_1();
        p.agregarVariable("x", 0);
        try {
            resultadoParseo = p.parsearExpresion(funcion);
            if (resultadoParseo.equals("ok")) {
                double x;
                double fs = 0.0;
                double f2s = 0.0;
                double errest = 0.0;
                double sum = 0;
                for (int i = 0; i < n; i++) {
                    x = Math.random() * (b - a) + a;
                    p.agregarVariable("x", x);
                    sum += p.evaluarExpresionDouble();
                    fs = fs + p.evaluarExpresionDouble();
                    f2s = f2s + p.evaluarExpresionDouble() * p.evaluarExpresionDouble();
                }
                approx = (b - a) * sum / n;
                fs = fs / n;
                f2s = f2s / n;
                errest = (b - a) * sqrt((f2s - fs * fs) / n);
                System.out.println("\nMonte Carlo, integral: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
            } else {
                System.out.println(resultadoParseo);
            }
        } catch (ParseException ex) {
            System.out.println("ParseException " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }

    public void monteCarloIntegralDoble(String funcion, double a, double b, double c, double d, int n) {
        System.out.println("Evaluando integral doble...");
        DecimalFormat fmt = new DecimalFormat("0.################");
        String resultadoParseo = "";
        double approx = 0.0;
        Parseador p;
        p = new Parseador();
        p.configuracion_1();
        p.agregarVariable("x", 0);
        p.agregarVariable("y", 0);

        try {
            resultadoParseo = p.parsearExpresion(funcion);
            if (resultadoParseo.equals("ok")) {
                double x;
                double y;
                double sum = 0;
                double fs = 0.0;
                double f2s = 0.0;
                double errest = 0.0;
                for (int i = 0; i < n; i++) {
                    x = a + Math.random() * Math.abs(b - a);
                    y = c + Math.random() * Math.abs(d - c);
                    p.agregarVariable("x", x);
                    p.agregarVariable("y", y);
                    sum += p.evaluarExpresionDouble();
                    fs = fs + p.evaluarExpresionDouble();
                    f2s = f2s + p.evaluarExpresionDouble() * p.evaluarExpresionDouble();
                }
                approx = Math.abs(b - a) * Math.abs(d - c) * sum / n;
                
                fs = fs / n;
                f2s = f2s / n;
                errest = (b - a) * (d - c) * sqrt((f2s - fs * fs) / n);
                
                System.out.println("\nMonte Carlo, integral doble: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
            } else {
                System.out.println(resultadoParseo);
            }
        } catch (ParseException ex) {
            System.out.println("ParseException " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
    }
    
    public void monteCarloIntegralTriple(String funcion, double a, double b, double c, double d, double e, double f, int n) {
        System.out.println("Evaluando integral triple...");
        DecimalFormat fmt = new DecimalFormat("0.################");
        String resultadoParseo = "";
        double approx = 0.0;
        Parseador p;
        p = new Parseador();
        p.configuracion_1();
        p.agregarVariable("x", 0);
        p.agregarVariable("y", 0);
        p.agregarVariable("z", 0);

        try {
            resultadoParseo = p.parsearExpresion(funcion);
            if (resultadoParseo.equals("ok")) {
                double x;
                double y;
                double z;
                double sum = 0;
                double fs = 0.0;
                double f2s = 0.0;
                double errest = 0.0;
                for (int i = 0; i < n; i++) {
                    x = a + Math.random() * Math.abs(b - a);
                    y = c + Math.random() * Math.abs(d - c);
                    z = e + Math.random() * Math.abs(f - e);
                    p.agregarVariable("x", x);
                    p.agregarVariable("y", y);
                    p.agregarVariable("z", z);
                    sum += p.evaluarExpresionDouble();
                    fs = fs + p.evaluarExpresionDouble();
                    f2s = f2s + p.evaluarExpresionDouble() * p.evaluarExpresionDouble();
                }
                approx = Math.abs(b - a) * Math.abs(d - c) * Math.abs(f - e) * sum / n;
                
                fs = fs / n;
                f2s = f2s / n;
                errest = (b - a) * (d - c) * (f - e)* sqrt((f2s - fs * fs) / n);
                
                System.out.println("\nMonte Carlo, integral triple: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
            } else {
                System.out.println(resultadoParseo);
            }
        } catch (ParseException ex) {
            System.out.println("ParseException " + ex.getMessage());
        } catch (Exception ee) {
            System.out.println("Exception " + ee.getMessage());
        }
    }
}
