package com.astro.vijay.unavu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.uttamavillain.unavu.backend.unavuApi.model.FoodItem;

import java.util.List;

/**
 * Created by uttamavillain on 3/5/16.
 */
public class FoodListAdapter extends ArrayAdapter<FoodItem> {
    public FoodListAdapter(Context context, List<FoodItem> items) {
        super(context, android.R.layout.simple_list_item_1, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final FoodItem foodItem = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_food, parent, false);
        }

        ImageView ivFoodPic = (ImageView) convertView.findViewById(R.id.ivFoodPic);
        TextView tvFoodName = (TextView) convertView.findViewById(R.id.tvFoodName);

        Picasso.with(getContext()).load(foodItem.getImageUrl()).into(ivFoodPic);
        tvFoodName.setText(foodItem.getName());

        return convertView;
    }
}
