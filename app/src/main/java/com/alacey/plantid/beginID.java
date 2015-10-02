package com.alacey.plantid;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class beginID extends AppCompatActivity {

    Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_id);
        Intent intent = getIntent();

        TextView text = (TextView) findViewById(R.id.textView2);
        Typeface.createFromAsset(this.getResources().getAssets(), "fonts/Roboto-Bold.ttf");
        text.setTypeface(tf);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_begin_id, menu);
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
    public void beginFlower(View view) {
        Intent flowerIntent = new Intent(this, beginFlower.class);
        startActivity(flowerIntent);
    }

    /**
     * Called when the user chooses the tree option
     */
    public void beginTree(View view) {
        Intent treeIntent = new Intent(this, beginTree.class);
        startActivity(treeIntent);
    }
}
