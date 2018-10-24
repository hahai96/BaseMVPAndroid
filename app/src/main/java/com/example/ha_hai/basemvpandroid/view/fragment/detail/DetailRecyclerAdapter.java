package com.example.ha_hai.basemvpandroid.view.fragment.detail;

import android.content.Context;
import android.view.ViewGroup;

import com.example.ha_hai.basemvpandroid.R;
import com.example.ha_hai.basemvpandroid.baseapp.ui.adapter.BaseRecyclerAdapter;
import com.example.ha_hai.basemvpandroid.data.remote.model.forecast.List;


/**
 * Created by deni rohimat on 17/02/15.
 */
public class DetailRecyclerAdapter extends BaseRecyclerAdapter<List, DetailHolder> {

    public DetailRecyclerAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemResourceLayout(int viewType) {
        return R.layout.details_row;
    }

    @Override
    public DetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DetailHolder(mContext, getView(parent, viewType), mItemClickListener, mLongItemClickListener);
    }

}
