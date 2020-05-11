package com.asadeveloper.myrealtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class SendData extends AppCompatActivity {

    Button send;
    EditText nama, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);

        send = findViewById(R.id.btnSend);
        nama = findViewById(R.id.namalengkap);
        message = findViewById(R.id.pesan);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama = nama.getText().toString().trim();
                String getMessage = message.getText().toString().trim();

                AsyncHttpClient client = new AsyncHttpClient();
                RequestParams params = new RequestParams();
               params.put("nama", getNama);
               params.put("message", getMessage);

               client.post("http://192.168.1.10/myrealtime/send.php", params, new AsyncHttpResponseHandler(){

                   @Override
                   public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                   }

                   @Override
                   public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                   }
               });
            }
        });
    }
}
