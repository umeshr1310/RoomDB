package com.umesh.roomdb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateUserFragment extends Fragment {


    private EditText etId, etname, etemail;
    private Button update;
    public UpdateUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update_user, container, false);
        etId = view.findViewById(R.id.et_id);
        etname = view.findViewById(R.id.et_name);
        etemail = view.findViewById(R.id.et_email);

        update = view.findViewById(R.id.button_update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(etId.getText().toString());
                String name = etname.getText().toString();
                String email = etemail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().updateUser(user);

                etId.setText("");
                etname.setText("");
                etemail.setText("");

                Toast.makeText(getActivity(), "update success", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

}
