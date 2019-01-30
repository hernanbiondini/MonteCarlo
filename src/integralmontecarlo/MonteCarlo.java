package integralmontecarlo;

import static java.lang.Math.sqrt;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import org.nfunk.jep.ParseException;

/**
 *
 * @author hernanbiondini
 */
public class MonteCarlo {

    private long ti = 0L;
    private long tt = 0L;

    public Respuesta monteCarloIntegralSimple(String funcion, double a, double b, int n) throws ParseException, Exception {
        System.out.println("Evaluando integral simple...");
        Respuesta r = new Respuesta();
        DecimalFormat fmt = new DecimalFormat("0.################");
        String resultadoParseo = "";
        double approx = 0.0;
        Parseador p;
        p = new Parseador();
        p.configuracion_1();
        p.agregarVariable("x", 0);
        String funcion2 = funcion;
        funcion = cambiarSimbolos(funcion);

        resultadoParseo = p.parsearExpresion(funcion);

        ti = System.currentTimeMillis();

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

            tt = System.currentTimeMillis() - ti;

            r.setRespuesta(String.valueOf(approx));
            r.setEstimacionError(String.valueOf(errest));
            r.setRespuestaConsola("\nIntegral simple: " + funcion2 + "  intervalos [" + a + "," + b + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");

            System.out.println("\nIntegral simple: " + funcion2 + "  intervalos [" + a + "," + b + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");
        } else {
            System.out.println(resultadoParseo);
            JOptionPane.showMessageDialog(null, resultadoParseo, "Error durante el análisis sintáctico: ", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }

    public Respuesta monteCarloIntegralDoble(String funcion, double a, double b, double c, double d, int n) throws ParseException, Exception {
        System.out.println("Evaluando integral doble...");
        Respuesta r = new Respuesta();
        DecimalFormat fmt = new DecimalFormat("0.################");
        String resultadoParseo = "";
        double approx = 0.0;
        Parseador p;
        p = new Parseador();
        p.configuracion_1();
        p.agregarVariable("x", 0);
        p.agregarVariable("y", 0);
        String funcion2 = funcion;
        funcion = cambiarSimbolos(funcion);

        resultadoParseo = p.parsearExpresion(funcion);

        ti = System.currentTimeMillis();

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

            tt = System.currentTimeMillis() - ti;

            r.setRespuesta(String.valueOf(approx));
            r.setEstimacionError(String.valueOf(errest));
            r.setRespuestaConsola("\nIntegral doble: " + funcion2 + "  intervalos [" + a + "," + b + "," + c + "," + d + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");

            System.out.println("\nIntegral doble: " + funcion2 + "  intervalos [" + a + "," + b + "," + c + "," + d + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");
        } else {
            System.out.println(resultadoParseo);
            JOptionPane.showMessageDialog(null, resultadoParseo, "Error durante el análisis sintáctico: ", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }

    public Respuesta monteCarloIntegralTriple(String funcion, double a, double b, double c, double d, double e, double f, int n) throws ParseException, Exception {
        System.out.println("Evaluando integral triple...");
        Respuesta r = new Respuesta();
        DecimalFormat fmt = new DecimalFormat("0.################");
        String resultadoParseo = "";
        double approx = 0.0;
        Parseador p;
        p = new Parseador();
        p.configuracion_1();
        p.agregarVariable("x", 0);
        p.agregarVariable("y", 0);
        p.agregarVariable("z", 0);
        String funcion2 = funcion;
        funcion = cambiarSimbolos(funcion);

        resultadoParseo = p.parsearExpresion(funcion);

        ti = System.currentTimeMillis();

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
            errest = (b - a) * (d - c) * (f - e) * sqrt((f2s - fs * fs) / n);

            tt = System.currentTimeMillis() - ti;

            r.setRespuesta(String.valueOf(approx));
            r.setEstimacionError(String.valueOf(errest));
            r.setRespuestaConsola("\nIntegral triple: " + funcion2 + "  intervalos [" + a + "," + b + "," + c + "," + d + "," + e + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");

            System.out.println("\nIntegral triple: " + funcion2 + "  intervalos [" + a + "," + b + "," + c + "," + d + "," + e + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "   Tiempo: " + tt + " milisegundos");
        } else {
            System.out.println(resultadoParseo);
            JOptionPane.showMessageDialog(null, resultadoParseo, "Error durante el análisis sintáctico: ", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }

    public Respuesta monteCarloIntegralCuadruple(String funcion, double a, double b, double c, double d, double e, double f, double g, double h, int n) throws ParseException, Exception {
        System.out.println("Evaluando integral cuádruple...");
        Respuesta r = new Respuesta();
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
        String funcion2 = funcion;
        funcion = cambiarSimbolos(funcion);

        resultadoParseo = p.parsearExpresion(funcion);

        ti = System.currentTimeMillis();

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
            errest = (b - a) * (d - c) * (f - e) * (h - g) * sqrt((f2s - fs * fs) / n);

            tt = System.currentTimeMillis() - ti;

            r.setRespuesta(String.valueOf(approx));
            r.setEstimacionError(String.valueOf(errest));
            r.setRespuestaConsola("\nIntegral cuádruple: " + funcion2 + "  intervalos [" + a + "," + b + "," + c + "," + d + "," + e + "," + g + "," + h +"]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");
            System.out.println("\nIntegral cuádruple: " + funcion2 + "  intervalos [" + a + "," + b + "," + c + "," + d + "," + e + "," + g + "," + h + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");
        } else {
            System.out.println(resultadoParseo);
            JOptionPane.showMessageDialog(null, resultadoParseo, "Error durante el análisis sintáctico: ", JOptionPane.ERROR_MESSAGE);
        }

        return r;
    }

    public Respuesta monteCarloIntegralQuintuple(String funcion, double a, double b, double c, double d, double e, double f, double g, double h, double i, double j, int n) throws ParseException, Exception {
        System.out.println("Evaluando integral quíntuple...");
        Respuesta r = new Respuesta();
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
        String funcion2 = funcion;
        funcion = cambiarSimbolos(funcion);

        resultadoParseo = p.parsearExpresion(funcion);

        ti = System.currentTimeMillis();

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
            errest = (b - a) * (d - c) * (f - e) * (h - g) * (j - i) * sqrt((f2s - fs * fs) / n);

            tt = System.currentTimeMillis() - ti;

            r.setRespuesta(String.valueOf(approx));
            r.setEstimacionError(String.valueOf(errest));
            r.setRespuestaConsola("\nIntegral quíntuple: " + funcion2 + "  intervalos [" + a + "," + b + "," + c + "," + d + "," + e + "," + g + "," + h + "," + i + "," + j + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");

            System.out.println("\nIntegral quíntuple: " + funcion2 + "  intervalos [" + a + "," + b + "," + c + "," + d + "," + e + "," + g + "," + h + "," + i + "," + j + "]  con  " + n + "  puntos: " + fmt.format(approx) + "  Error: " + errest + "  Tiempo: " + tt + " milisegundos");
        } else {
            System.out.println(resultadoParseo);
            JOptionPane.showMessageDialog(null, resultadoParseo, "Error durante el análisis sintáctico: ", JOptionPane.ERROR_MESSAGE);
        }
        return r;
    }

    private String cambiarSimbolos(String funcion) {
        String fun = "";
        fun = funcion.replace("π", "pi");
        fun = fun.replace("√", "sqrt");
        fun = fun.replace("sen", "sin");       
        fun = fun.replace("arcsen", "asin");
        fun = fun.replace("arccos", "acos");
        fun = fun.replace("arctan", "atan");      
        return fun;
    }

}
