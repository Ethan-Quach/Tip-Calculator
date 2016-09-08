package edu.orangecoastcollege.cs273.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

// Ethan Quach
// Just puttin' my name here for a little bit so I don't forget the header.

public class MainActivity extends AppCompatActivity {

    // Associating controller with needed views
    private TextView AmountTextView;
    private EditText AmountEditText;
    private SeekBar PercentSeekBar;
    private TextView PercentTextView;
    private TextView TipAmountTextView;
    private TextView TotalAmountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting controller to widgets in app
        AmountTextView = (TextView) findViewById(R.id.amountTextView);
        AmountEditText = (EditText) findViewById(R.id.amountEditText);
        PercentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);
        PercentTextView = (TextView) findViewById(R.id.percentTextView);
        TipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        TotalAmountTextView = (TextView) findViewById(R.id.totalAmountTextView);
    }
}
