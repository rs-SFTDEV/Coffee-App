package com.example.android.coffeeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int quantity = 1;

       /**
     * This method is called when the order button is clicked.
     */
    public void increment (View view) {
        quantity++;
        display(quantity);
    }
    public void decrement (View view) {
        quantity--;
        display(quantity);
    }

    public void submitOrder(View view) {
                display(quantity);
        displayPrice(quantity *5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String sSelected = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, sSelected, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public  void displayPrice(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.price_text_view);
        quantityTextView.setText("" + number + "\nThank You \nYour Order Confirmed");
    }
}
