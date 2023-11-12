package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.LottoResultView;

import java.util.List;

import static java.util.stream.Collectors.toList;


public class Application {

    public static void main(String[] args) {
        Lottos lottos = new LottoMachine().createLottos(InputView.inputMoney());

        LottoResultView.printPurchaseComplete(lottos);

        //입력받은 당첨번호를 로또로 생성하기 위해 List<LottoNumber>로 변환
        List<LottoNumber> winningNumbers = InputView.inputWinningNumber()
                .stream()
                .map(LottoNumber::of)
                .collect(toList());
        Lotto winningNumbersLotto = new Lotto(winningNumbers);

        LottoResultView.printResultTest(new WinningLotto(winningNumbersLotto).winningInfos(lottos), lottos);
    }
}
