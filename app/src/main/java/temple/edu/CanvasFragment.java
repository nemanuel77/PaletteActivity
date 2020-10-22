package temple.edu;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CanvasFragment extends Fragment {

    TextView myText;
    View l;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


//    // TODO: Rename and change types and number of parameters
//    public static CanvasFragment newInstance(String param1, String param2) {
//        CanvasFragment fragment = new CanvasFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }


    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_canvas,container,false);
        myText = l.findViewById(R.id.txtFrag);
        myText.setText(getResources().getString(R.string.canv_name));
        return l;

    }

    public void changeColor(String color){
        l.setBackgroundColor(Color.parseColor(color));
    }
    public void changeText(String string){
        myText.setText(string);
    }



//    public void displayText(String reference){
//        myText.setText(reference);
//    }
}