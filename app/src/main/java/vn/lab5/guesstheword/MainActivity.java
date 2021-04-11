package vn.lab5.guesstheword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent();
                gameIntent.setClass(MainActivity.this,GameActivity.class);
                startActivityForResult(gameIntent, SECOND_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String returnString = data.getStringExtra("finalScore");
                TextView txt1 = findViewById(R.id.TextView);
                TextView txt2 = findViewById(R.id.TextView2);
                txt1.setText("Your High Score Is: ");
                txt2.setText(returnString);
                Button btnPlay = findViewById(R.id.btnPlay);
                btnPlay.setText("Play Again");
            }
        }
    }
}