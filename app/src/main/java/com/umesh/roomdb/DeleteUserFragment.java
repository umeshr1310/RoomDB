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
public class DeleteUserFragment extends Fragment {

    private EditText etDelete;
    private Button deleteBtn;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        etDelete = view.findViewById(R.id.et_id_delete);
        deleteBtn = view.findViewById(R.id.button_delete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(etDelete.getText().toString());
                User user = new User();
                user.setId(id);
                MainActivity.myAppDatabase.myDao().deleteUser(user);

                Toast.makeText(getActivity(), "delete success", Toast.LENGTH_SHORT).show();

                etDelete.setText("");
            }
        });
        return view;
    }

}
