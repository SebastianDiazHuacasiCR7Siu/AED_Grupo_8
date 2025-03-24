package InterfacesClasesGenericas;

public class OperacionesMatBDouble implements Operable<Double> {
    @Override
    public Double suma(Double operando1, Double operando2) {
        return operando1 + operando2;
    }

    @Override
    public Double resta(Double operando1, Double operando2) {
        return operando1 - operando2;
    }

    @Override
    public Double producto(Double operando1, Double operando2) {
        return operando1 * operando2;
    }

    @Override
    public Double division(Double operando1, Double operando2) {
        if (operando2 == 0) throw new ArithmeticException("División por cero no permitida");
        return operando1 / operando2;
    }

    @Override
    public Double potencia(Double base, Double exponente) {
        return Math.pow(base, exponente);
    }

    @Override
    public Double raizCuadrada(Double operando) {
        return Math.sqrt(operando);
    }

    @Override
    public Double raizCubica(Double operando) {
        return Math.cbrt(operando);
    }
}
