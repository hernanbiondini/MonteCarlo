package integralmontecarlo;

import static java.lang.Math.sqrt;
import java.text.DecimalFormat;
import org.nfunk.jep.ParseException;

/**
 *
 * @author hernanbiondini
 */
public class MonteCarlo {

    public Respuesta monteCarloIntegralSimple(String funcion, double a, double b, int n) {
        System.out.println("Evaluando integral...");
        Respuesta r = new Respuesta();
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
               
                r.setRespuesta(String.valueOf(approx));
                r.setEstimacionError(String.valueOf(errest));
                r.setRespuestaConsola("\nIntegral simple: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
               
                System.out.println("\nIntegral simple: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
            } else {
                System.out.println(resultadoParseo);
            }
        } catch (ParseException ex) {
            System.out.println("ParseException " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
        }
        return r;
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
                
                System.out.println("\nIntegral doble: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
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
                
                System.out.println("\nIntegral triple: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
            } else {
                System.out.println(resultadoParseo);
            }
        } catch (ParseException ex) {
            System.out.println("ParseException " + ex.getMessage());
        } catch (Exception ee) {
            System.out.println("Exception " + ee.getMessage());
        }
    }
    
    
    public void monteCarloIntegralCuadruple(String funcion, double a, double b, double c, double d, double e, double f, double g, double h, int n) {
        System.out.println("Evaluando integral cuádruple...");
        DecimalFormat fmt = new DecimalFormat("0.################");
        String resultadoParseo = "";
        double approx = 0.0;
        Parseador p;
        p = new Parseador();
        p.configuracion_1();
        p.agregarVariable("x", 0);
        p.agregarVariable("y", 0);
        p.agregarVariable("z", 0);
        p.agregarVariable("u", 0);

        try {
            resultadoParseo = p.parsearExpresion(funcion);
            if (resultadoParseo.equals("ok")) {
                double x;
                double y;
                double z;
                double u;
                double sum = 0;
                double fs = 0.0;
                double f2s = 0.0;
                double errest = 0.0;
                for (int i = 0; i < n; i++) {
                    x = a + Math.random() * Math.abs(b - a);
                    y = c + Math.random() * Math.abs(d - c);
                    z = e + Math.random() * Math.abs(f - e);
                    u = g + Math.random() * Math.abs(h - g);
                    p.agregarVariable("x", x);
                    p.agregarVariable("y", y);
                    p.agregarVariable("z", z);
                    p.agregarVariable("u", u);
                    sum += p.evaluarExpresionDouble();
                    fs = fs + p.evaluarExpresionDouble();
                    f2s = f2s + p.evaluarExpresionDouble() * p.evaluarExpresionDouble();
                }
                approx = Math.abs(b - a) * Math.abs(d - c) * Math.abs(f - e) * Math.abs(h - g) * sum / n;
                
                fs = fs / n;
                f2s = f2s / n;
                errest = (b - a) * (d - c) * (f - e)* (h - g) * sqrt((f2s - fs * fs) / n);
                
                System.out.println("\nIntegral cuádruple: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
            } else {
                System.out.println(resultadoParseo);
            }
        } catch (ParseException ex) {
            System.out.println("ParseException " + ex.getMessage());
        } catch (Exception ee) {
            System.out.println("Exception " + ee.getMessage());
        }
    }
    
    public void monteCarloIntegralQuintuple(String funcion, double a, double b, double c, double d, double e, double f, double g, double h, double i, double j, int n) {
        System.out.println("Evaluando integral quíntuple...");
        DecimalFormat fmt = new DecimalFormat("0.################");
        String resultadoParseo = "";
        double approx = 0.0;
        Parseador p;
        p = new Parseador();
        p.configuracion_1();
        p.agregarVariable("x", 0);
        p.agregarVariable("y", 0);
        p.agregarVariable("z", 0);
        p.agregarVariable("u", 0);
        p.agregarVariable("w", 0);

        try {
            resultadoParseo = p.parsearExpresion(funcion);
            if (resultadoParseo.equals("ok")) {
                double x;
                double y;
                double z;
                double u;
                double w;
                double sum = 0;
                double fs = 0.0;
                double f2s = 0.0;
                double errest = 0.0;
                for (int cont = 0; cont < n; cont++) {
                    x = a + Math.random() * Math.abs(b - a);
                    y = c + Math.random() * Math.abs(d - c);
                    z = e + Math.random() * Math.abs(f - e);
                    u = g + Math.random() * Math.abs(h - g);
                    w = i + Math.random() * Math.abs(j - i);
                    p.agregarVariable("x", x);
                    p.agregarVariable("y", y);
                    p.agregarVariable("z", z);
                    p.agregarVariable("u", u);
                    p.agregarVariable("w", w);
                    sum += p.evaluarExpresionDouble();
                    fs = fs + p.evaluarExpresionDouble();
                    f2s = f2s + p.evaluarExpresionDouble() * p.evaluarExpresionDouble();
                }
                approx = Math.abs(b - a) * Math.abs(d - c) * Math.abs(f - e) * Math.abs(h - g) * Math.abs(j - i) * sum / n;
                
                fs = fs / n;
                f2s = f2s / n;
                errest = (b - a) * (d - c) * (f - e)* (h - g) * (j - i) *sqrt((f2s - fs * fs) / n);
                
                System.out.println("\nIntegral quíntuple: '" + funcion + "'  con  " + n + " puntos: " + fmt.format(approx) + " Error: " + errest);
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
