package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.view.InputView.InputPrice;


public class Issue {
    public int count;
    public List<Integer> userLotto;

    public Issue() {
        int userPrice = InputPrice();
        if (!Check1000(userPrice)) {
            throw new IllegalArgumentException("[ERROR] 구매 가격이 1,000원 단위가 아닙니다.");
        }
        this.count = CountLotto(userPrice);
        this.userLotto = IssueLotto(count);
    }

    private int CountLotto(int userPrice) {
        int count = userPrice/1000;
        return count;
    }

    private boolean Check1000(int userPrice) {
        if (userPrice%1000 == 0) {
            return true;
        }
        return false;
    }

    public List<Integer> IssueLotto(int count) {
        List<Integer> userLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
        return userLotto;
    }
}
