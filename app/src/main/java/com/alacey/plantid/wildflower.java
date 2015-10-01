package com.alacey.plantid;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class wildflower extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildflower);

        TextView tx = (TextView)findViewById(R.id.wildflowerText);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/NotoSans-Bold.ttf");

        tx.setTypeface(custom_font);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wildflower, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Button button = (Button)findViewById(R.id.wildflower4);
        button.setOnClickListener(this);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the user chooses the regular option
     */
    public void regular(View view) {
        Intent regularIntent = new Intent(this, regular.class);
        startActivity(regularIntent);
    }

    /**
     * Called when the user chooses the irregular option
     */
    public void irregular(View view) {
        Intent irregularIntent = new Intent(this, irregular.class);
        startActivity(irregularIntent);
    }

    /**
     * Called when the user clicks "what does this mean?"
     */
    public void onClick(View view) {
        String branchExplanation = "Is the flower radially symmetrical (regular) or non-symmetrical (irregular)?";
        final Toast toast = Toast.makeText(this, branchExplanation, Toast.LENGTH_SHORT);
        toast.show();
        new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {toast.show();}
            public void onFinish() {toast.show();}
        }.start();
    }

    public void onHomeButtonClick(View v) {
        startActivity(new Intent(wildflower.this, HomeScreen.class));
    }
}
