package com.umesh.roomdb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnAdd,btnView,btnDelete, btnUpdate;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        btnAdd = view.findViewById(R.id.button_add);
        btnAdd.setOnClickListener(this);
        btnView = view.findViewById(R.id.button_view);
        btnView.setOnClickListener(this);
        btnDelete = view.findViewById(R.id.button_delete);
        btnDelete.setOnClickListener(this);
        btnUpdate = view.findViewById(R.id.button_update);
        btnUpdate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_add:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.button_view:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.button_delete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.button_update:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateUserFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
