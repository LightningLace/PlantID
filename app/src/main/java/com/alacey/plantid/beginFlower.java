package com.alacey.plantid;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class beginFlower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_flower);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_begin_flower, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the user chooses the flower option
     */
    public void wildflower(View view) {
        String branchExplanation = "NOTE: This app is designed to identify NATIVE WILDFLOWERS of the Northwestern United States. Garden flowers and other non-natives may not appear in this key.";
        final Toast toast = Toast.makeText(this, branchExplanation, Toast.LENGTH_SHORT);
        toast.show();
        new CountDownTimer(9000, 1000) {
            public void onTick(long millisUntilFinished) {toast.show();}
            public void onFinish() {toast.show();}
        }.start();
        Intent wildflowerIntent = new Intent(this, wildflower.class);
        startActivity(wildflowerIntent);
    }


}
