package com.sangcx5.cttest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    TextView txtString;
    Button btn;
    private String URL = "https://jsonplaceholder.typicode.com/todos/1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        txtString = (TextView) findViewById(R.id.txtString);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendRequest();
            }
        });

    }

    public void sendRequest() {
        try {
            OkHttpHandler handler = new OkHttpHandler();

            String res = handler.execute(URL).get();
            txtString.setText(res);

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}