package practice3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Model {
    private int maxBarrier;
    private int minBarrier;
    private int secretValue;

    private List<Integer> yourWay = new ArrayList<>();

    public void secretValue() {
        secretValue = (int) Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
    }

    public boolean checkValue(int value) {
        yourWay.add(value);
        if (value == secretValue) {
            return false;
        } else if (value > secretValue) {
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
        return true;
    }

    public void setPrimaryBarrier(int minBarrier, int maxBarrier) {
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getSecretValue() {
        return secretValue;
    }

    public List<Integer> getYourWay() {
        return yourWay;
    }
}
