import intefaces.OperationInterface;
import operations.Div;
import operations.Mul;
import operations.Sub;
import operations.Sum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private OperationInterface operation;

    @Test
    @DisplayName("Should calculate sum operation correctly.")
    void calculateSum() {
        this.operation = new Sum();
        int result = this.operation.performCalculation(12, 7);

        Assertions.assertEquals(19, result);
    }

    @Test
    @DisplayName("Should calculate sub operation correctly.")
    void calculateSub() {
        this.operation = new Sub();
        int result = this.operation.performCalculation(6, 8);

        Assertions.assertEquals(-2, result);
    }

    @Test
    @DisplayName("Should calculate mul operation correctly.")
    void calculateMul() {
        this.operation = new Mul();
        int result = this.operation.performCalculation(0, 6);

        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Should calculate div operation correctly.")
    void calculateDiv() {
        this.operation = new Div();
        int result1 = this.operation.performCalculation(10, 5);
        int result2 = this.operation.performCalculation(10, 0);

        Assertions.assertEquals(2, result1);
        Assertions.assertEquals(0, result2);
    }
}
