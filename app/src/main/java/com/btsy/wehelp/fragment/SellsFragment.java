package com.btsy.wehelp.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.btsy.wehelp.R;
import com.btsy.wehelp.adapter.OrderGridAdapter;

/**
 * Created by zhouzhongbo on 2017/9/1.
 */

public class OrderFragment extends Fragment implements AdapterView.OnItemClickListener{

    private GridView gview;
    private OrderGridAdapter adapter;

    public static OrderFragment newInstance(String param1) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public OrderFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_layout, container, false);
        gview = (GridView) view.findViewById(R.id.order_operation_button);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void viewInit(){
        String[] buttonName = getActivity().getResources().getStringArray(R.array.order_button_text);
        int[] buttonImg = getActivity().getResources().getIntArray(R.array.order_button_img);
        adapter = new OrderGridAdapter(getActivity(),buttonName,buttonImg);
        gview.setAdapter(adapter);
        gview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
