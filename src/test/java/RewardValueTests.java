import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardValueTests {

    @Test
    void create_with_cash_value() {
        double cashValue = 100;
        RewardValue rewardValue = new RewardValue(cashValue);
        assertEquals(cashValue, rewardValue.getCashValue());
    }

    @Test
    void create_with_miles_value() {
        double milesValue = 10000; // Use double for miles to avoid precision issues
        RewardValue rewardValue = new RewardValue(milesValue);
        assertEquals(milesValue, rewardValue.getMilesValue());
    }


    @Test
    void convert_from_cash_to_miles() {
        double cashValue = 10000;
        double expectedMiles = cashValue / RewardValue.CONVERSION_RATE;
        RewardValue rewardValue = new RewardValue(cashValue);
        assertEquals(expectedMiles, rewardValue.getMilesValue(), 0.01); // Delta of 0.01 for tolerance
    }

    @Test
    void convert_from_miles_to_cash() {
        double milesValue = 10000;
        double expectedCash = milesValue * RewardValue.CONVERSION_RATE;
        RewardValue rewardValue = new RewardValue(milesValue, false); // Use constructor with flag for miles
        assertEquals(expectedCash, rewardValue.getCashValue());
    }
}
