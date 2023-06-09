package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

//This app displays an order form to add coffee
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This method is called when the order button is clicked
    public void submitOrder(View view){
        int price = calculatePrice();
        String orderSummary = createOrderSummary(price);
        displayMessage(orderSummary);
    }

    //This method displays the given quantity value on the screen
    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + number);
    }

    //This method displays the given text on the screen
    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    //This method calculates the price
    private int calculatePrice(){
        int price = quantity * 5;
        return price;
    }

    //This methods displays the summary
    private String createOrderSummary(int pr){
        String summary = "Name : Adarsh Suman";
        summary = summary + "\nQuantity : " + quantity;
        summary = summary + "\nTotal : ₹" + pr;
        summary = summary + "\nThank You!!!";
        return  summary;
    }

    //This method displays the given price on the screen
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    //This method is called when plus (+) button is clicked
    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }

    //This method is clicked when minus (-) button is clicked
    public void decrement(View view){
        quantity = quantity - 1;
        display(quantity);
    }
}