package InterfacesClasesGenericas;

public class OperacionesMatBInteger implements Operable<Integer> { //Método específico

    @Override
    public Integer suma(Integer operando1, Integer operando2) {
        return operando1 + operando2;
    }

    @Override
    public Integer resta(Integer operando1, Integer operando2) {
        return operando1 - operando2;
    }

    @Override
    public Integer producto(Integer operando1, Integer operando2) {
        return operando1 * operando2;
    }

    @Override
    public Integer division(Integer operando1, Integer operando2) {
        if (operando2 == 0) throw new ArithmeticException("División por cero no permitida");
        return operando1 / operando2;
    }

    @Override
    public Integer potencia(Integer base, Integer exponente) {
        return (int) Math.pow(base, exponente);
    }

    @Override
    public Double raizCuadrada(Integer operando) {
        return Math.sqrt(operando);
    }
    
    @Override
    public Double raizCubica(Integer operando) {
        return Math.cbrt(operando);
    }
    
}

