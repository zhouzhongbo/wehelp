package com.btsy.wehelp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.btsy.wehelp.R;
import com.btsy.wehelp.adapter.OrderGridAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhouzhongbo on 2017/9/1.
 */

public class SellsFragment extends Fragment implements AdapterView.OnItemClickListener{

    private GridView gview;
    private OrderGridAdapter adapter;

    public static SellsFragment newInstance(String param1) {
        SellsFragment fragment = new SellsFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public SellsFragment() {

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
        viewInit();
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

    private void viewInit() {
        String[] name = getActivity().getResources().getStringArray(R.array.order_button_text);
        List<String> buttonName =Arrays.asList(name);

        TypedArray ar = getActivity().getResources().obtainTypedArray(R.array.order_button_img);
        int len = ar.length();
        List<Integer> buttonImg = new ArrayList<Integer>();
        for (int i = 0; i < len; i++)
            buttonImg.add(Integer.valueOf(ar.getResourceId(i, 0)));
        ar.recycle();
//        int[] buttonImg = getActivity().getResources().getIntArray(R.array.order_button_img);
        adapter = new OrderGridAdapter(getActivity(),buttonName,buttonImg);
        gview.setAdapter(adapter);
        gview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        int type = adapter.getItemType(position);
        Intent mintent = new Intent();
        switch(type){
            case OrderGridAdapter.toIntroduce:
                mintent.setAction("com.btsy.wehelp.tointroduce");
                break;
            case OrderGridAdapter.toProduct:
                mintent.setAction("com.btsy.wehelp.toproduct");
                break;
            case OrderGridAdapter.toInventory:
                mintent.setAction("com.btsy.wehelp.toinventory");
                break;
            case OrderGridAdapter.toPurchase:
                mintent.setAction("com.btsy.wehelp.topurchase");
                break;
            case OrderGridAdapter.toCustomer:
                mintent.setAction("com.btsy.wehelp.tocustomer");
                break;
            case OrderGridAdapter.toOrder:
                mintent.setAction("com.btsy.wehelp.toorder");
                break;
            default:
                break;
        }
        mintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mintent);
    }
}
