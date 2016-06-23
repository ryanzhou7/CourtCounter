package com.ryanzhou.company.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final String LOG_TAG = this.getClass().getSimpleName();
    public final int ERROR_CHAR_FROM_INCREMENT_BUTTON_TEXT = 0;
    public final int RESET_SCORE_INT = 0;
    public final String ERROR_PARSE_INT_MESSAGE = "Button text does not contain int score";
    protected TextView textViewTeam1Score;
    protected TextView textViewTeam2Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTeam1Score = (TextView) findViewById(R.id.textView_team1);
        textViewTeam2Score = (TextView) findViewById(R.id.textView_team2);
        String startingScore = getResources().getString(R.string.score_starting_point);
        textViewTeam2Score.setText( startingScore );
        textViewTeam1Score.setText( startingScore );
    }

    public void incrementTeam1(View view){
        char parseResult = parseScoreNumberFrom( ((Button)view).getText().toString() );
        int incrementPoints = Character.getNumericValue(parseResult);
        if( parseResult != ERROR_CHAR_FROM_INCREMENT_BUTTON_TEXT) {
            int currentScore = Integer.valueOf( textViewTeam1Score.getText().toString() );
            textViewTeam1Score.setText( String.valueOf(currentScore + incrementPoints) );
        }
        else
            Log.e(LOG_TAG, ERROR_PARSE_INT_MESSAGE );

    }

    public void incrementTeam2(View view){
        char parseResult = parseScoreNumberFrom( ((Button)view).getText().toString() );
        int incrementPoints = Character.getNumericValue(parseResult);
        if( parseResult != ERROR_CHAR_FROM_INCREMENT_BUTTON_TEXT){
            int currentScore = Integer.valueOf( textViewTeam2Score.getText().toString() );
            textViewTeam2Score.setText( String.valueOf(currentScore + incrementPoints) );
        }
        else
            Log.e(LOG_TAG, ERROR_PARSE_INT_MESSAGE );
    }

    protected char parseScoreNumberFrom(String string){
        if (string != null){
            for (char c : string.toCharArray()){
                if (Character.isDigit(c))
                    return (c);
            }
        }
        return 0;
    }

    public void resetTeamScores(View v){
        String startingScore = getResources().getString(R.string.score_starting_point);
        textViewTeam1Score.setText( startingScore );
        textViewTeam2Score.setText( startingScore );
    }
}
