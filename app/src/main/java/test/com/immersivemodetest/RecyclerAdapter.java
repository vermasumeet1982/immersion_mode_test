package test.com.immersivemodetest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RCViewHolder> {

    private Context mContext;

    private List<MyViewItem> mViewitems;

    private ViewGroup mParentView;

    public RecyclerAdapter(Context mContext, List<MyViewItem> mViewitems, ViewGroup mParentView) {
        this.mContext = mContext;
        this.mViewitems = mViewitems;
        this.mParentView = mParentView;
    }

    @NonNull
    @Override
    public RCViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (mViewitems.get(i).getMyInflatedView() != null) {
            view = mViewitems.get(i).getMyInflatedView();

        } else {
            view = mViewitems.get(i).getView(i, null,
                    mParentView);
        }
        return new RCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCViewHolder rcViewHolder, int i) {
        MyViewItem viewItem = mViewitems.get(i);
    }

    @Override
    public int getItemCount() {
        return mViewitems.size();
    }


    public static class RCViewHolder extends RecyclerView.ViewHolder {

        public RCViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
