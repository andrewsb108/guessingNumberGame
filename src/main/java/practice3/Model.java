package practice3;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private int maxBarrier;
    private int minBarrier;
    private int secretValue;

   private final int PRIMARY_MIN_BARRIER = 0;
   private final int PRIMARY_MAX_BARRIER = 100;

    private List<Integer> yourWay = new ArrayList<>();

    public void setSecretValue() {
        secretValue = (int) Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
        minBarrier = PRIMARY_MIN_BARRIER;
        maxBarrier = PRIMARY_MAX_BARRIER;
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

    public String setPrimaryBarrier(int minBarrier, int maxBarrier) {
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
        return minBarrier + " to " + maxBarrier;
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

    public int getPRIMARY_MIN_BARRIER() {
        return PRIMARY_MIN_BARRIER;
    }

    public int getPRIMARY_MAX_BARRIER() {
        return PRIMARY_MAX_BARRIER;
    }

    public List<Integer> getYourWay() {
        return yourWay;
    }
}
