public class RewardValue {
    private final double cashValue;
    private final double milesValue;
    public static final double CONVERSION_RATE = 0.0035;

    public RewardValue(double value) {
        this(value, true); // Delegate to single constructor with flag
    }

    public RewardValue(double value, boolean isCashValue) {
        if (isCashValue) {
            this.cashValue = value;
            this.milesValue = value / CONVERSION_RATE;
        } else {
            this.milesValue = value;
            this.cashValue = value * CONVERSION_RATE;
        }
    }

    public double getCashValue() {
        return cashValue;
    }

    public double getMilesValue() {
        return milesValue;
    }
}
