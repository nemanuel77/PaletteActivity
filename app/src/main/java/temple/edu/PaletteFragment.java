package temple.edu;

import android.content.Context;
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

    private String[] strings;
    private String[] colors;

    gvPickedInterface parentActivity;


    public PaletteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PaletteFragment.
     */
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

        if(context instanceof  gvPickedInterface){
            parentActivity = (gvPickedInterface) context;
        }
        else{
            throw new RuntimeException("Implement gvPickedInterface interface to attach fragment.");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           colors = getArguments().getStringArray(COLORS_KEY);
           strings = getArguments().getStringArray(STRINGS_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_palette, container, false);
        GridView gridView = myView.findViewById(R.id.gvMainFrag);

        ColorAdapter colorAdapter = new ColorAdapter((Context) parentActivity, colors, strings);
        gridView.setAdapter(colorAdapter);

        //gridView.setAdapter(new ColorAdapter((Context) parentActivity, android.R.layout.simple_list_item_1, colors));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.colorSelected(position);
            }
        });


        return myView;
    }

    interface gvPickedInterface{
        void colorSelected(int index);
    }


}