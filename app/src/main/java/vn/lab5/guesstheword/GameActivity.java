package vn.lab5.guesstheword;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView txtSelectedWord;
    TextView txtScore;
    int score = 0;
    String[] words = {
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        txtSelectedWord = findViewById(R.id.txtSelectedWord);
        txtScore = findViewById(R.id.txtScore);
        getRandomWord();
        Button btnGotIt = findViewById(R.id.btnGotIt);
        Button btnSkip = findViewById(R.id.btnSkip);
        Button btnEndGame = findViewById(R.id.btnEndGame);
        btnEndGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finishFunc();
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (score > 0) {
                    getRandomWord();
                    minusScore();
                }
            }
        });
        btnGotIt.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getRandomWord();
                addScore();
            }
        });
    }

    void addScore(){
        score++;
        txtScore.setText(String.valueOf(score));
    }

    void finishFunc(){
        Intent intent = new Intent();
        intent.putExtra("finalScore", String.valueOf(score));
        setResult(RESULT_OK, intent);
        finish();
    }

    void minusScore(){
        score--;
        txtScore.setText(String.valueOf(score));
    }
    void getRandomWord(){
        txtSelectedWord.setText('"' + words[new Random().nextInt(words.length)] + '"' );
    }
}
