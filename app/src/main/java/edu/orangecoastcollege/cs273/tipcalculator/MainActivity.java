package edu.orangecoastcollege.cs273.tipcalculator;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

// Ethan Quach
// Just puttin' my name here for a little bit so I don't forget the header.

public class MainActivity extends AppCompatActivity {

    // Creating currency number formatting
    private static NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static NumberFormat percent = NumberFormat.getPercentInstance();

    // Associating controller with needed views
    private TextView amountTextView;
    private EditText amountEditText;
    private SeekBar percentSeekBar;
    private TextView percentTextView;
    private TextView tipAmountTextView;
    private TextView totalAmountTextView;

    // Associating controller with the needed model
    RestaurantBill currentBill = new RestaurantBill(0.0, 0.15);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting controller to widgets in app
        amountTextView = (TextView) findViewById(R.id.amountTextView);
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        tipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);

        // Initializing the views and their associated values
        currentBill.setTipPercent(percentSeekBar.getProgress() / 100.0);
        tipAmountTextView.setText(currency.format(currentBill.getTipAmount()));
        totalAmountTextView.setText(currency.format(currentBill.getTotalAmount()));

        // Defining a listener for the amountEditText widget
        amountEditText.addTextChangedListener(amountTextChangedListener);

        // Defining a listener for the percentSeekBar widget
        percentSeekBar.setOnSeekBarChangeListener(percentChangeListener);
    }

    private TextWatcher amountTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                double amount = charSequence.length() > 0 ?
                        Double.parseDouble(charSequence.toString()) / 100 : 0.0;
                currentBill.setAmount(amount);
            } catch (NumberFormatException e) {
                amountEditText.setText("");
            }

            // No exceptions; input is valid
            amountTextView.setText(currency.format(currentBill.getAmount()));
            updateViews();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Do nothing
        }
    };

    private SeekBar.OnSeekBarChangeListener percentChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            currentBill.setTipPercent(i / 100.0);

            percentTextView.setText(percent.format(currentBill.getTipPercent()));
            updateViews();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // Do nothing
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // Do nothing
        }
    };

    private void updateViews(){
        tipAmountTextView.setText(currency.format(currentBill.getTipAmount()));
        totalAmountTextView.setText(currency.format(currentBill.getTotalAmount()));
    }
}
