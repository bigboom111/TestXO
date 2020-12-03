package com.project.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class XOActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons;

    private boolean player1Turn = true;
    private int num;

    private int roundCount;

    private int player1Points;
    private int player2Points;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_o);

        final Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        num = Integer.parseInt(number);
        buttons = new Button[num][num];

        textViewPlayer1 = findViewById(R.id.textView1);
        textViewPlayer2 = findViewById(R.id.textView2);

        LinearLayout ly = findViewById(R.id.ly1);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0 ; i < num ; i++){
            LinearLayout row = new LinearLayout(this);

            for (int j = 0 ; j < num ; j++){
                Button button = new Button(this);
                int id = j +1 + (i * num);
                button.setId(id);
                button.setTextSize(30);
                row.addView(button);
            }

            layout.addView(row);
        }
        ly.addView(layout);


        for (int i = 0 ; i < num ; i++){
            for (int j = 0 ; j < num ; j++){
                int id = j +1 + (i * num);
                buttons[i][j] = findViewById(id);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.btn_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        Button buttonBack = findViewById(R.id.btn_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(XOActivity.this , MainActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onClick(View view) {

        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (player1Turn) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("O");
        }

        roundCount++;

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == num*num) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin(){

        if (num == 3){
            String[][] field = new String[num][num];

            for (int i = 0; i < num; i++){
                for (int j = 0; j < num; j++){
                    field[i][j] = buttons[i][j].getText().toString();
                }
            }
            for (int i = 0; i<num;i++){
                if(field[i][0].equals(field[i][1]) &&
                        field[i][0].equals(field[i][2]) &&
                        !field[i][0].equals("")){
                    return true;
                }
            }

            for (int i = 0; i<num;i++){
                if(field[0][i].equals(field[1][i]) &&
                        field[0][i].equals(field[2][i]) &&
                        !field[0][i].equals("")){
                    return true;
                }
            }

            if(field[0][0].equals(field[1][1]) &&
                    field[0][0].equals(field[2][2]) &&
                    !field[0][0].equals("")){
                return true;
            }

            if(field[0][2].equals(field[1][1]) &&
                    field[0][2].equals(field[2][0]) &&
                    !field[0][2].equals("")){
                return true;
            }
        }

        if (num == 4){
            String[][] field = new String[num][num];

            for (int i = 0; i < num; i++){
                for (int j = 0; j < num; j++){
                    field[i][j] = buttons[i][j].getText().toString();
                }
            }
            for (int i = 0; i<num;i++){
                if(field[i][0].equals(field[i][1]) &&
                        field[i][0].equals(field[i][2]) &&
                        field[i][0].equals(field[i][3]) &&
                        !field[i][0].equals("")){
                    return true;
                }
            }

            for (int i = 0; i<num;i++){
                if(field[0][i].equals(field[1][i]) &&
                        field[0][i].equals(field[2][i]) &&
                        field[0][i].equals(field[3][i]) &&
                        !field[0][i].equals("")){
                    return true;
                }
            }

            if(field[0][0].equals(field[1][1]) &&
                    field[0][0].equals(field[2][2]) &&
                    field[0][0].equals(field[3][3]) &&
                    !field[0][0].equals("")){
                return true;
            }

            if(field[0][3].equals(field[1][2]) &&
                    field[1][2].equals(field[2][1]) &&
                    field[3][0].equals(field[2][1]) &&
                    !field[0][3].equals("")){
                return true;
            }
        }

        if (num == 5){
            String[][] field = new String[num][num];

            for (int i = 0; i < num; i++){
                for (int j = 0; j < num; j++){
                    field[i][j] = buttons[i][j].getText().toString();
                }
            }
            for (int i = 0; i<num;i++){
                if(field[i][0].equals(field[i][1]) &&
                        field[i][0].equals(field[i][2]) &&
                        field[i][0].equals(field[i][3]) &&
                        field[i][0].equals(field[i][4]) &&
                        !field[i][0].equals("")){
                    return true;
                }
            }

            for (int i = 0; i<num;i++){
                if(field[0][i].equals(field[1][i]) &&
                        field[0][i].equals(field[2][i]) &&
                        field[0][i].equals(field[3][i]) &&
                        field[0][i].equals(field[4][i]) &&
                        !field[0][i].equals("")){
                    return true;
                }
            }

            if(field[0][0].equals(field[1][1]) &&
                    field[0][0].equals(field[2][2]) &&
                    field[0][0].equals(field[3][3]) &&
                    field[0][0].equals(field[4][4]) &&
                    !field[0][0].equals("")){
                return true;
            }

            if(field[0][4].equals(field[1][3]) &&
                    field[1][3].equals(field[2][2]) &&
                    field[2][2].equals(field[3][1]) &&
                    field[3][1].equals(field[4][0]) &&
                    !field[0][4].equals("")){
                return true;
            }
        }

        if (num == 6){
            String[][] field = new String[num][num];

            for (int i = 0; i < num; i++){
                for (int j = 0; j < num; j++){
                    field[i][j] = buttons[i][j].getText().toString();
                }
            }
            for (int i = 0; i<num;i++){
                if(field[i][0].equals(field[i][1]) &&
                        field[i][0].equals(field[i][2]) &&
                        field[i][0].equals(field[i][3]) &&
                        field[i][0].equals(field[i][4]) &&
                        field[i][0].equals(field[i][5]) &&
                        !field[i][0].equals("")){
                    return true;
                }
            }

            for (int i = 0; i<num;i++){
                if(field[0][i].equals(field[1][i]) &&
                        field[0][i].equals(field[2][i]) &&
                        field[0][i].equals(field[3][i]) &&
                        field[0][i].equals(field[4][i]) &&
                        field[0][i].equals(field[5][i]) &&
                        !field[0][i].equals("")){
                    return true;
                }
            }

            if(field[0][0].equals(field[1][1]) &&
                    field[0][0].equals(field[2][2]) &&
                    field[0][0].equals(field[3][3]) &&
                    field[0][0].equals(field[4][4]) &&
                    field[0][0].equals(field[5][5]) &&
                    !field[0][0].equals("")){
                return true;
            }

            if(field[0][5].equals(field[1][4]) &&
                    field[1][4].equals(field[2][3]) &&
                    field[2][3].equals(field[3][2]) &&
                    field[3][2].equals(field[4][1]) &&
                    field[4][1].equals(field[5][0]) &&
                    !field[0][4].equals("")){
                return true;
            }

        }

        if (num == 7){
            String[][] field = new String[num][num];

            for (int i = 0; i < num; i++){
                for (int j = 0; j < num; j++){
                    field[i][j] = buttons[i][j].getText().toString();
                }
            }
            for (int i = 0; i<num;i++){
                if(field[i][0].equals(field[i][1]) &&
                        field[i][0].equals(field[i][2]) &&
                        field[i][0].equals(field[i][3]) &&
                        field[i][0].equals(field[i][4]) &&
                        field[i][0].equals(field[i][5]) &&
                        field[i][0].equals(field[i][6]) &&
                        !field[i][0].equals("")){
                    return true;
                }
            }

            for (int i = 0; i<num;i++){
                if(field[0][i].equals(field[1][i]) &&
                        field[0][i].equals(field[2][i]) &&
                        field[0][i].equals(field[3][i]) &&
                        field[0][i].equals(field[4][i]) &&
                        field[0][i].equals(field[5][i]) &&
                        field[0][i].equals(field[6][i]) &&
                        !field[0][i].equals("")){
                    return true;
                }
            }

            if(field[0][0].equals(field[1][1]) &&
                    field[0][0].equals(field[2][2]) &&
                    field[0][0].equals(field[3][3]) &&
                    field[0][0].equals(field[4][4]) &&
                    field[0][0].equals(field[5][5]) &&
                    field[0][0].equals(field[6][6]) &&
                    !field[0][0].equals("")){
                return true;
            }

            if(field[0][6].equals(field[1][5]) &&
                    field[1][5].equals(field[2][4]) &&
                    field[2][4].equals(field[3][3]) &&
                    field[3][3].equals(field[4][2]) &&
                    field[4][2].equals(field[5][1]) &&
                    field[5][1].equals(field[6][0]) &&
                    !field[0][6].equals("")){
                return true;
            }
        }

        return false;
    }

    private void player1Wins(){
        player1Points++;
        updatePointsText();

        Toast.makeText(this , "Player X wins" ,Toast.LENGTH_LONG).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(XOActivity.this);
        builder.setTitle("Winner");
        builder.setMessage("Player X wins");
        builder.setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                resetBorad();
            }
        });
        builder.setNegativeButton("Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(XOActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void player2Wins(){
        player2Points++;
        updatePointsText();

        Toast.makeText(this , "Player O wins" ,Toast.LENGTH_LONG).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(XOActivity.this);
        builder.setTitle("Winner");
        builder.setMessage("Player O wins");
        builder.setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                resetBorad();
            }
        });
        builder.setNegativeButton("Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(XOActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void draw(){
        Toast.makeText(this , "Draw!" ,Toast.LENGTH_LONG).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(XOActivity.this);
        builder.setTitle("Winner");
        builder.setMessage("Draw!");
        builder.setPositiveButton("Play Again!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                resetBorad();
            }
        });
        builder.setNegativeButton("Home", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(XOActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void updatePointsText(){
        textViewPlayer1.setText("Player X : " +player1Points);
        textViewPlayer2.setText("Player O : " +player2Points);
    }

    private void resetBorad(){

        for (int i = 0 ; i < num ; i++){
            for (int j = 0; j < num ; j++){
                buttons[i][j].setText("");
            }
        }
        roundCount = 0;
        player1Turn = true;
    }

    private void resetGame(){
        player1Points = 0;
        player2Points = 0;
        updatePointsText();
        resetBorad();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("player1Turn", player1Turn);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        roundCount = savedInstanceState.getInt("roundCount");
        player1Points = savedInstanceState.getInt("player1Points");
        player2Points = savedInstanceState.getInt("player2Points");
        player1Turn = savedInstanceState.getBoolean("player1Turn");
    }


}