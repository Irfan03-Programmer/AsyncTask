package com.example.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        startButton = findViewById(R.id.startButton);

        // Memulai AsyncTask saat tombol ditekan
        startButton.setOnClickListener(view -> new ExampleAsyncTask().execute());
    }

    // Inner class for AsyncTask
    private class ExampleAsyncTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Menampilkan teks loading di TextView
            resultTextView.setText("Loading...");
        }

        @Override
        protected String doInBackground(Void... voids) {
            // Simulasi tugas berat di latar belakang
            try {
                Thread.sleep(2000); // delay 2 detik untuk simulasi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data successfully retrieved!";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Menampilkan hasil setelah AsyncTask selesai
            resultTextView.setText(result);
        }
    }
}
