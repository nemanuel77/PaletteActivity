package temple.edu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;
import android.content.res.Resources;


import android.widget.GridView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements PaletteFragment.gvPickedInterface {
    //initialize needed variables
    GridView myGV; //to display textviews
    View myView;
    //String[] colors; //to define colors of the textviews
    int[] colors;
    String[] strings; //labels for Assignment 5
    TextView myTV; //test onSelectItem method initial run

    FragmentManager fm;
    CanvasFragment canvasFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        canvasFragment = new CanvasFragment();

        fm
                .beginTransaction()
                .add(R.id.container_1, PaletteFragment.newInstance(
                        getResources().getStringArray(R.array.gv_colors),
                        getResources().getStringArray(R.array.gv_strings)))
                .add(R.id.container_2, canvasFragment)
                .commit();


    }

    @Override
    public void colorSelected(int index) {

    }


//        getSupportActionBar().setTitle(getResources().getString(R.string.pal_name));
//        Resources res = getResources();

//        colors = res.getIntArray(R.array.gv_colors);
//        //colors = res.getStringArray(R.array.gv_colors);
//        strings = res.getStringArray(R.array.gv_strings);
//        //myGV = findViewById(R.id.gvColorPalette);
//        myTV = findViewById(R.id.defaultTextView);

        //new custom adapter object
        //ColorAdapter colorAdapter = new ColorAdapter(this, colors, strings);
        //attach adapter to gridview
        //myGV.setAdapter(colorAdapter);

        //override base gridview adapter functionality
        //initial: display selected text in default textview
        //modified: new Intent object, attach selected textview in myGV (colors[position])
        //        : start new activity with Intent object
////        myGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                myTV.setText(colors[position]);
//                //test comment for commit to main branch
////                Intent myIntent = new Intent(MainActivity.this, CanvasActivity.class);
////                myIntent.putExtra("color", colors[position].toString());
////                myIntent.putExtra("string", strings[position].toString());
////
////                startActivity(myIntent);
//
//
//            }
//        });


}