package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        //same as any application
        TextView tv = findViewById(R.id.acTextView);
        //not a view
        ConstraintLayout myLayout = findViewById(R.id.ac2ConstraintLayout);
        //kinda wild how I can point to this class in the Intent Object and it just knows from getIntent()
        Intent myIntent = getIntent();
        //set value to IntentString (the color to parse)
        String color = myIntent.getStringExtra("color");

        //set text to string value and parse its color
        tv.setText(color);
        myLayout.setBackgroundColor(Color.parseColor(color));


    }
}