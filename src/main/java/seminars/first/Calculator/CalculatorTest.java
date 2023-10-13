package seminars.first.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    public static void main(String[] args) {
        assertThat(Calculator.calculatingDiscount(1000, 5)).isEqualTo(950);
        assertThat(Calculator.calculatingDiscount(555, 100)).isEqualTo(0);
        assertThat(Calculator.calculatingDiscount(120, 0)).isEqualTo(120);

        // Проверка исключений
        assertThatThrownBy(() -> {
            Calculator.calculatingDiscount(1000, 300);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            Calculator.calculatingDiscount(1000, -1);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            assertThat(Calculator.calculatingDiscount(-1000, 30));
            ;
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            assertThat(Calculator.calculatingDiscount(0, 30));
            ;
        }).isInstanceOf(IllegalArgumentException.class);
    }
}