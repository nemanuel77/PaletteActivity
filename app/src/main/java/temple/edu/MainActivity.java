package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;


import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //initialize needed variables
    GridView myGV; //to display textviews
    //View myView;
    String[] colors; //to define colors of the textviews
    TextView myTV; //test onSelectItem method initial run

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGV = findViewById(R.id.gvColorPalette);
        //myView = findViewById(R.id.Layout_Constraint);
        colors = getResources().getStringArray(R.array.gv_colors);
        myTV = findViewById(R.id.textView);

        //new custom adapter object
        ColorAdapter colorAdapter = new ColorAdapter(this, colors);
        //attach adapter to gridview
        myGV.setAdapter(colorAdapter);

        //override base gridview adapter functionality
        //initial: display selected text in default textview
        //modified: new Intent object, attach selected textview in myGV (colors[position])
        //        : start new activity with Intent object
        myGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myTV.setText(colors[position]);
//                Intent myIntent = new Intent(MainActivity.this, CanvasActivity.class);
//                myIntent.putExtra("color", colors[position].toString());
//
//                startActivity(myIntent);


            }
        });

    }
}