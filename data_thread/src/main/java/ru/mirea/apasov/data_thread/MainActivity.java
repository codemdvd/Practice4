package ru.mirea.apasov.data_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        final Runnable runn1 = new Runnable() {
            public void run() {
                tvInfo.setText("Привет");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                tvInfo.setText("Hello");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                tvInfo.setText("Salut");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (1>0) {
                        runOnUiThread(runn1);
                        TimeUnit.SECONDS.sleep(2);
                        tvInfo.postDelayed(runn3, 2);
                        TimeUnit.SECONDS.sleep(2);
                        tvInfo.post(runn2);
                        TimeUnit.SECONDS.sleep(2);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
