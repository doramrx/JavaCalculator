package operations;

import intefaces.OperationInterface;

public class Sub implements OperationInterface {
    @Override
    public int performCalculation(int n1, int n2) {
        return n1 - n2;
    }
}
