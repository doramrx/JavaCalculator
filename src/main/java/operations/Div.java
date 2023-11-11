package operations;

import intefaces.OperationInterface;

public class Div implements OperationInterface {
    @Override
    public int performCalculation(int n1, int n2) {
        if (n2 == 0) {
            return 0;
        }
        return n1 / n2;
    }
}
