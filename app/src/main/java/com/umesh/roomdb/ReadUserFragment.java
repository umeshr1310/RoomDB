package com.umesh.roomdb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {


    private TextView text;
    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_user, container, false);
        text = view.findViewById(R.id.txt);

        List<User> users = MainActivity.myAppDatabase.myDao().getUsers();
        String info = "";

        for(User user :users) {
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info+id+"\n"+name+"\n"+email+"\n";
        }
        text.setText(info);
        return view;
    }

}
