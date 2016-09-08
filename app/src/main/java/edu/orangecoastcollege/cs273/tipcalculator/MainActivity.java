package edu.orangecoastcollege.cs273.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

// Ethan Quach
// Just puttin' my name here for a little bit so I don't forget the header.

public class MainActivity extends AppCompatActivity {

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

        // Defining a listener for the amountEditText widget
        amountEditText.addTextChangedListener(amountTextChangedListener);
    }

    private TextWatcher amountTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                double amount = Double.parseDouble(charSequence.toString()) / 100;
                currentBill.setAmount(amount);
            } catch (NumberFormatException e) {
                amountEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Do nothing
        }
    };
}
