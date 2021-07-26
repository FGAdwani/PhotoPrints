package com.trichain.photoprints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numberOfPrints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView outputTv = findViewById(R.id.outputTv);
        numberOfPrints = findViewById(R.id.numberOfPrints);
        Button mBtn = findViewById(R.id.mBtn);
        RadioGroup mRadioGroup = findViewById(R.id.mRadioGroup);


        mBtn.setOnClickListener(v -> {
            if (numberOfPrints.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter some number", Toast.LENGTH_SHORT).show();
            } else if (mRadioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please select the size", Toast.LENGTH_SHORT).show();
            } else {
                int totalUnits = Integer.parseInt(numberOfPrints.getText().toString());
                double priceInCents;
                if (mRadioGroup.getCheckedRadioButtonId() == R.id.firstPrint) {
                    priceInCents = 19;
                } else if (mRadioGroup.getCheckedRadioButtonId() == R.id.secondPrint) {
                    priceInCents = 49;
                } else {
                    priceInCents = 79;
                }

                double totalCost = totalUnits * priceInCents / 100;
                outputTv.setText("The order cost is $ " + totalCost);

            }
        });

    }

}