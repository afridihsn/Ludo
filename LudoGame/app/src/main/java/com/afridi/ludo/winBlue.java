package com.afridi.ludo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class winBlue extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_blue);
    }

    public void over(View view){
        Intent in= new Intent(winBlue.this, PlayerSelect.class);
        startActivity(in);
    }

}
