package chaos.dandroid.fonduemachsix;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dandroid on 4/8/15.
 */

public class TabFragment extends Fragment {

    private int index;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        index = data.getInt("idx");
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment, null);
            switch (index){
            case 0:
                v = inflater.inflate(R.layout.fragment, null);
                TextView tv = (TextView) v.findViewById(R.id.msg);
                tv.setText("Fragment 1");
                break;
            case 1:
                v = inflater.inflate(R.layout.fragment2, null);
                /*EditText tv2 = (EditText) v.findViewById(R.id.msg2);
                tv2.setText("Add Notes Here");*/
                break;
        }

        return v;

    }



}
