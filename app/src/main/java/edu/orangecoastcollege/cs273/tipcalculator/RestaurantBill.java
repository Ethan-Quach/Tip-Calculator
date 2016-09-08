package edu.orangecoastcollege.cs273.tipcalculator;

public class RestaurantBill {
    private double mAmount;
    private double mTipPercent;
    private double mTipAmount;
    private double mTotalAmount;

    public RestaurantBill(double amount, double tipAmount) {
        mAmount = amount;
        mTipAmount = tipAmount;
        recalculateAmount();
    }

    public double getAmount() { return mAmount; }
    public double getTipPercent() { return mTipPercent; }
    public double getTipAmount() { return mTipAmount; }
    public double getTotalAmount() { return mTotalAmount; }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
        recalculateAmount();
    }
    public void setTipPercent(double mTipPercent) {
        this.mTipPercent = mTipPercent;
        recalculateAmount();
    }

    private void recalculateAmount() {
        mTipAmount = mAmount * mTipPercent;
        mTotalAmount = mAmount + mTipAmount;
    }
}
