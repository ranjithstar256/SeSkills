package com.example.gaayathri.a6eskills;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gaayathri.a6eskills.adapter.GridListAdapter;

import java.util.ArrayList;

/**
 * Created by sonu on 08/02/17.
 */
public class LevelViewFragment extends Fragment {
    private Context context;
    private GridListAdapter adapter;
    private ArrayList<String> arrayList;

    public LevelViewFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_view_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadListView(view);
        onClickEvent(view);
    }

    private void loadListView(View view) {
        ListView listView = (ListView) view.findViewById(R.id.list_view);
        arrayList = new ArrayList<>();

        arrayList.add("Architect");
        arrayList.add("Lead");
        arrayList.add("Senior Developer");
        arrayList.add("Developer");
        arrayList.add("Ops/Support engineer");

        adapter = new GridListAdapter(context, arrayList, true);
        listView.setAdapter(adapter);
    }

    private void onClickEvent(View view) {
        view.findViewById(R.id.show_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray selectedRows = adapter.getSelectedIds();//Get the selected ids from adapter
                //Check if item is selected or not via size
                if (selectedRows.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    //Loop to all the selected rows array
                    for (int i = 0; i < selectedRows.size(); i++) {

                        //Check if selected rows have value i.e. checked item
                        if (selectedRows.valueAt(i)) {

                            //Get the checked item text from array list by getting keyAt method of selectedRowsarray
                            String selectedRowLabel = arrayList.get(selectedRows.keyAt(i));

                            //append the row label text
                            stringBuilder.append(selectedRowLabel + "\n");
                        }
                    }
                    Toast.makeText(context, "Selected Rows\n" + stringBuilder.toString(), Toast.LENGTH_SHORT).show();

                    Intent homeintent = new Intent(getActivity(), UserDataActivity.class);
                    startActivity(homeintent);
                }

            }
        });
        view.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray selectedRows = adapter.getSelectedIds();//Get the selected ids from adapter
                //Check if item is selected or not via size
                if (selectedRows.size() > 0) {
                    //Loop to all the selected rows array
                    for (int i = (selectedRows.size() - 1); i >= 0; i--) {

                        //Check if selected rows have value i.e. checked item
                        if (selectedRows.valueAt(i)) {

                            //remove the checked item
                            arrayList.remove(selectedRows.keyAt(i));
                        }
                    }

                    //notify the adapter and remove all checked selection
                    adapter.removeSelection();
                }
            }
        });
    }
}
