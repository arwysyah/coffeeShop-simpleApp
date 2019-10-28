package com.example.aplikasipemesanankopi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTelpon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telpon);
        //EditText
        final EditText nomor = (EditText) findViewById(R.id.tlp);
        Button dial = (Button) findViewById(R.id.call);
        dial.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View view) {
                //number = inputan dari tlp
                String toDial = "tel:" + nomor.getText().toString();
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
            }
        });
    }
}
