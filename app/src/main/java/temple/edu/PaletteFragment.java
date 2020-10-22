package temple.edu;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {

    private static final String COLORS_KEY = "colors";
    private static final String STRINGS_KEY = "strings";

    String[] strings;
    String[] colors;

    View myView;

    gvPickedInterface parentActivity;

    public PaletteFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static PaletteFragment newInstance(String[] colors, String[] strings) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(COLORS_KEY, colors);
        args.putStringArray(STRINGS_KEY, strings);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof gvPickedInterface)
            parentActivity = (gvPickedInterface) context;
        else
            throw new RuntimeException("Activity doesn't implement gvPickedInterface");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle;
        if ((bundle = getArguments()) != null) {
           colors = bundle.getStringArray(COLORS_KEY);
           strings = bundle.getStringArray(STRINGS_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_palette, container, false);
        GridView gridView = myView.findViewById(R.id.gvMainFrag);
//
        ColorAdapter colorAdapter = new ColorAdapter(myView.getContext(), colors, strings);
        gridView.setAdapter(colorAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.Selected(colors[position], strings[position]);

            }
        });



        return myView;
    }

    public interface gvPickedInterface{
        void Selected(String color, String string);
    }





}