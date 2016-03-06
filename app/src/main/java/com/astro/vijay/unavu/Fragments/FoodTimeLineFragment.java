package com.astro.vijay.unavu.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.astro.vijay.unavu.EndpointsAsyncTask;
import com.astro.vijay.unavu.FoodListAdapter;
import com.astro.vijay.unavu.R;
import com.uttamavillain.unavu.backend.unavuApi.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uttamavillain on 3/5/16.
 */
public class FoodTimeLineFragment extends Fragment implements EndpointsAsyncTask.AsyncResponseListener{

    public static final String TAG = FoodTimeLineFragment.class.getName();
    private ArrayList<FoodItem> foodItems;
    private ListView lvFoodList;
    private FoodListAdapter foodListAdapter;

    public FoodTimeLineFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_list, parent, false);
        lvFoodList = (ListView) view.findViewById(R.id.lvFoodList);
        lvFoodList.setAdapter(foodListAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        foodItems = new ArrayList<FoodItem>();
        foodListAdapter = new FoodListAdapter(getActivity(), foodItems);
    }

    @Override
    public void onResume() {
        super.onResume();
        populateTimeline();
    }

    private void populateTimeline() {
        new EndpointsAsyncTask(this).execute(new Pair<Context, String>(getActivity(), "Manfred"));
    }

    @Override
    public void OnAsyncTaskCompleted(List<FoodItem> items) {
        foodItems.clear();
        foodItems.addAll(items);
    }
}
