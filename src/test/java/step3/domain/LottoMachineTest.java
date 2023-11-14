package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {

    private static final int PAID_MONEY = 20_000;
    private static final List<Integer> WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);

    @Test
    @DisplayName("로또머신은 로또를 생성할 수 있다.")
    void create() {
        LottoMachine lottoMachine = new LottoMachine(PAID_MONEY, WINNING_NUMBERS);
        assertThat(lottoMachine.createLotto()).isInstanceOf(Lotto.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    @DisplayName("로또 구매금액은 PRICE_PER_LOTTO 보다 커야한다.")
    void paidMoneyAmountCheck(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine(input, WINNING_NUMBERS));
    }

    @Test
    @DisplayName("로또 구매금액은 PRICE_PER_LOTTO 로 나누어 떨어져야한다.")
    void paidMoneyUnitCheck() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine(1_001, WINNING_NUMBERS));
    }
}
