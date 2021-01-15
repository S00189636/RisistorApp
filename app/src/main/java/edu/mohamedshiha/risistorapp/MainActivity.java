package edu.mohamedshiha.risistorapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner S_band1,S_band2,S_MultiPlier,S_Tolerance;
    TextView TV_ResistorValue, TV_TolerancePercentageResult,TV_ToleranceValue;
    ArrayList<BandChart> bandValues;
    ArrayList<ToleranceChart> ToleranceValues;
    private int band1, band2 ,multiplier,result ;
    String TolernceValueString,TolernceResult;
    double TolernceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        S_band1 = findViewById(R.id.S_Band1);
        S_band2 = findViewById(R.id.S_Band2);
        S_MultiPlier = findViewById(R.id.S_Multiplier);
        S_Tolerance = findViewById(R.id.S_Tolerance);
        TV_ResistorValue = findViewById(R.id.TV_ResistorValue);
        TV_TolerancePercentageResult = findViewById(R.id.TV_TolerancePercentageResult);
        TV_ToleranceValue = findViewById(R.id.TV_ToleranceValue);

        // make arraylist from enumn
       bandValues = new ArrayList<BandChart>();
       ToleranceValues = new ArrayList<ToleranceChart>();
       bandValues.addAll(0, Arrays.asList(BandChart.values()));
       ToleranceValues.addAll(0, Arrays.asList(ToleranceChart.values()));

       //set spinners adapters
       S_band1.setAdapter(new BandSpinnerAdapter(this, bandValues));
       S_band2.setAdapter(new BandSpinnerAdapter(this, bandValues));
       S_MultiPlier.setAdapter(new BandSpinnerAdapterMultiplier(this, bandValues));
       S_Tolerance.setAdapter(new ToleranceSpinnerAdapter(this, ToleranceValues));
       // add on select listener
        //when the item is selected Calculate result and display it using text view
       AddListners();
    }

    // will be triggered on item selected in spinner
    private void DoCalculate(int band1,int band2,int multiplier){
        result = ((band1 * 10) + band2 )* multiplier;
        TV_ResistorValue.setText(String.valueOf(result));
        TV_ToleranceValue.setText(TolernceValueString);
        //double max, min;
        double precentageResult = result *(TolernceValue/100);
        TolernceResult = String.valueOf(precentageResult);
        TV_TolerancePercentageResult.setText(" ± "+String.format("%.2f",precentageResult ));
    }


    private void AddListners() {
        S_band1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                band1 = bandValues.get(position).getValue();
                DoCalculate(band1,band2,multiplier);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        S_band2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                band2 = bandValues.get(position).getValue();
                DoCalculate(band1,band2,multiplier);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        S_MultiPlier.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                multiplier = (int) Math.pow(10,bandValues.get(position).getValue());
                DoCalculate(band1,band2,multiplier);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });

        S_Tolerance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TolernceValue =  ToleranceValues.get(position).getValue();
                TolernceValueString = ToleranceValues.get(position).getValueString();
                DoCalculate(band1,band2,multiplier);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }
}