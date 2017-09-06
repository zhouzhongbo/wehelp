package com.btsy.wehelp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.btsy.wehelp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhouzhongbo on 2017/9/4.
 */

public class OrderGridAdapter extends BaseAdapter {

    private List<String> mNameList = new ArrayList<String>();
    private List<Integer> mDrawableList = new ArrayList<Integer>();
    private LayoutInflater mInflater;
    private Context mContext;
    LinearLayout.LayoutParams params;


    public static final int toIntroduce = 1;
    public static final int toProduct = 2;
    public static final int toInventory = 3;
    public static final int toCustomer = 4;
    public static final int toPurchase = 5;
    public static final int toOrder = 6;



    public OrderGridAdapter() {
        super();
    }

    public OrderGridAdapter(Context context, List<String> nameList, List<Integer> drawableId) {
        mNameList = nameList;
        mDrawableList = drawableId;
        mContext = context;
        mInflater = LayoutInflater.from(context);
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
    }

    public int getCount() {
        return mNameList.size();
    }

    public Object getItem(int position) {
        return mNameList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public int getItemType(int position){
        return position+1;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewTag viewTag;

        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.gridview_item, null);

            // construct an item tag
            viewTag = new ItemViewTag((ImageView) convertView.findViewById(R.id.grid_icon), (TextView) convertView.findViewById(R.id.grid_name));
            convertView.setTag(viewTag);
        } else
        {
            viewTag = (ItemViewTag) convertView.getTag();
        }

        // set name
        viewTag.mName.setText(mNameList.get(position));

        // set icon
//        mContext.getDrawable(mDrawableList.get(position).intValue());

        viewTag.mIcon.setBackgroundResource(mDrawableList.get(position));
//        viewTag.mIcon.setImageResource(mDrawableList.get(position));
        viewTag.mIcon.setLayoutParams(params);
        return convertView;
    }

    class ItemViewTag
    {
        protected ImageView mIcon;
        protected TextView mName;

        /**
         * The constructor to construct a navigation view tag
         *
         * @param name
         *            the name view of the item
         * @param icon
         *            the icon view of the item
         */
        public ItemViewTag(ImageView icon, TextView name)
        {
            this.mName = name;
            this.mIcon = icon;
        }
    }

}
