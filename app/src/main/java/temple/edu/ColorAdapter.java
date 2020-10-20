package temple.edu;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;




public class ColorAdapter extends BaseAdapter {


//    no fundamental change in this adapter from Lab 3. The utilization
//    remains the same - set a string value and color to a textview.

    Context context;
    //int[] colors;
    String[] colors;
    String[] strings;

    //initial constructor
    public ColorAdapter(Context context, String[] colors, String[] strings) {
        this.context = context;
        this.colors = colors;
        this.strings = strings;



    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TextView textView = new TextView(context);


        //set value to textview objects
        textView.setText(strings[position]);
        //textView.setBackgroundColor(Color.parseColor(colors[position]));

        return textView;
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        TextView txtView = new TextView(context);

        return super.getDropDownView(position, txtView, parent);
    }
}

