package com.example.aplikasipemesanankopi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    Button Web, Tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Web = (Button) findViewById(R.id.button1);
        Web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityWeb.class);
                startActivity(i);
            }
        });
        Tlp = (Button) findViewById(R.id.button2);
        Tlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ActivityTelpon.class);
                startActivity(i);
            }
        });
    }


    public void increment(View view) {
        //perintah tombol tambah
        if(quantity==100){
            Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }
    public void decrement(View view){
        //perintah tombol tambah
        if (quantity==1){
            Toast.makeText(this,"pesanan minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    public void Submitorder (View view){
        EditText nameEditText = (EditText) findViewById(R.id.edt_name);
        String name = nameEditText.getText().toString();
        Log.v("MainActivity", "Nama:" + name);
        CheckBox whippedcreamChekBox = (CheckBox) findViewById(R.id.WhippedCream_checkbox);
        boolean haswhippedcream = whippedcreamChekBox.isChecked();
        //mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haswhippedcream);

        CheckBox chocolateChekBox = (CheckBox) findViewById(R.id.Chocolate_checkbox);
        boolean haschocolate = chocolateChekBox.isChecked();
        //mengidentifikasi check
        Log.v("MainActivity","has whippedcream:"+haschocolate);
        int price = calculateprice(haswhippedcream, haschocolate);
        //memanggil method jumlah harga
        String pricemessage=createOrderSummary(price,name,haswhippedcream,haschocolate);


        displayMessage(pricemessage);
    }
    private int calculateprice ( boolean addwhipedcream, boolean addchocolate)
    {
        //jumlah pesanan * harga
        int harga =5000;

        if (addwhipedcream) {
            harga = harga + 1000;
            //harga tambahan toping
        }
        if (addchocolate) {
            harga = harga + 2000;
        }
        return quantity * harga;
    }
    private String createOrderSummary ( int price, String name,boolean addChocolate,
                                        boolean addWhippedCream)
    {
        //hasil pemesanan
        String pricemessage=" Nama = "+name;
        pricemessage+="\n Tambahkan Coklat =" +addWhippedCream;
        pricemessage+="\n Tambahkan Krim =" +addChocolate;
        pricemessage+="\n Jumlah Pemesanan =" +quantity;
        pricemessage+="\n Total = Rp " +price;
        pricemessage+="\n Terimakasih";
        return  pricemessage;
    }
    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(message);
    }
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_textview);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_textview);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

}
