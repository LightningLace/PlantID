package com.alacey.plantid;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class beginTree extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_tree);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_begin_tree, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Button button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(this);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the user chooses the opposite branching option
     */
    public void opposite(View view) {
        Intent oppositeIntent = new Intent(this, opposite.class);
        startActivity(oppositeIntent);
    }

    /**
     * Called when the user chooses the alternate branching option
     */
    public void alternate(View view) {
        Intent alternateIntent = new Intent(this, alternate.class);
        startActivity(alternateIntent);
    }

    /**
     * Called when the user clicks "what does this mean?"
     */
    public void onClick(View view) {
        String branchExplanation = "Look up. Do the tree branches appear to grow in pairs across from each other? Or do they alternate, with one branch growing at each node?";
        final Toast toast = Toast.makeText(this, branchExplanation,Toast.LENGTH_SHORT);
        toast.show();
        new CountDownTimer(9000, 1000) {
            public void onTick(long millisUntilFinished) {toast.show();}
            public void onFinish() {toast.show();}
        }.start();
    }

    public void onHomeButtonClick(View v) {
        startActivity(new Intent(beginTree.this, beginID.class));
    }
}
