package com.example.binoypaul.myapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android .util.Log;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.EditText;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "testB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Creating my layout, this is the base for all the widgets and elements in my screen
        RelativeLayout BinoyLayout = new RelativeLayout(this);
        BinoyLayout.setBackgroundColor(Color.rgb(20,50,80));

        //I have a button, Im just setting some rules to position this button accordingly
        RelativeLayout.LayoutParams buttonPositionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonPositionRules.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonPositionRules.addRule(RelativeLayout.CENTER_VERTICAL);

        //Im creating a new input field - EditText
        EditText inputField1 = new EditText(this);
        inputField1.setId(1);
        inputField1.setWidth(100);

        //Giving input field positioning rules
        RelativeLayout.LayoutParams inputFieldRules = new RelativeLayout.LayoutParams(
          RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        inputFieldRules.addRule(RelativeLayout.CENTER_HORIZONTAL);
        inputFieldRules.setMargins(0,0,50,30);

        int px = (int) TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP , 200 , getResources().getDisplayMetrics() );
        inputField1.setWidth(px);

        int pxHere = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP , 200, getResources().getDisplayMetrics());
        Log.i(TAG, "The Pixel value here is "+String.valueOf(pxHere) );
        //Creating my submit button
        Button SubmitButton1 = new Button(this);

        SubmitButton1.setBackgroundColor(Color.BLACK);
        SubmitButton1.setTextColor(Color.WHITE);
        SubmitButton1.setText("Click Me");
        SubmitButton1.setId(2);
        setContentView(BinoyLayout);

        //Adding the button to the screen --- Unless you add this, you cannot place the relative positioned text field as it depends on your SubmitButton's position
        BinoyLayout.addView(SubmitButton1 , buttonPositionRules);

        //This addRule should be added after you add the button to the view, if you add before that, you wont get the position correctly
        inputFieldRules.addRule(RelativeLayout.ABOVE, SubmitButton1.getId() );

        Resources r = getResources();
        Log.i(TAG, "The display metrics are : "+String.valueOf(r.getDisplayMetrics()));

        BinoyLayout.addView(inputField1, inputFieldRules);

        //    setContentView(R.layout.activity_main);
     //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);
    //    Log.i(TAG,"On Create activity");
    //    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
     //   fab.setOnClickListener(new View.OnClickListener() {
      //      @Override
       //     public void onClick(View view) {
      //          Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
      //                  .setAction("Action", null).show();
       //     }
      //  });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "The App has started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "The app has stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "The App has paused");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Hey the app has resumed");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
