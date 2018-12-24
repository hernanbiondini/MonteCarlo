package integralmontecarlo;

import org.nfunk.jep.JEP;
import org.nfunk.jep.ParseException;

/**
 *
 * @author hernanbiondini
 */
public class Parseador {

    private JEP myParser = null;

    public Parseador() {
        this.myParser = new JEP();
    }

    public JEP getMyParser() {
        return myParser;
    }

    public void setMyParser(JEP myParser) {
        this.myParser = myParser;
    }

    public void configuracion_1() {
        myParser.setImplicitMul(true);
        this.agregarFuncionesYConstantesStandar();
    }

    public void agregarVariable(String variable, double valor) {
        myParser.addVariable(variable, valor);
    }

    public void agregarFuncionesYConstantesStandar() {
        myParser.addStandardFunctions(); 
        myParser.addStandardConstants(); 
    }

    public String parsearExpresion(String expresion) throws ParseException {
        String resultado = "ok";
        myParser.parseExpression(expresion);
        if (myParser.hasError()) {
            System.out.println("Error durante el análisis sintáctico");
            System.out.println(myParser.getErrorInfo());
            resultado = "Error durante el análisis sintáctico: " + myParser.getErrorInfo();
        }
        return resultado;
    }

    public String evaluarExpresionString() {
        String resultado = "";
        resultado = String.valueOf(myParser.getValue());
        if (myParser.hasError()) {
            System.out.println("Error durante la evaluación");
            System.out.println(myParser.getErrorInfo());
            resultado = "Error durante la evaluación: " + myParser.getErrorInfo();
        }
        return resultado;
    }

    public double evaluarExpresionDouble() {
        double resultado = 0.0;
        resultado = myParser.getValue();
        return resultado;
    }
}
