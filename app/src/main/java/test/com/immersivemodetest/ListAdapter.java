package test.com.immersivemodetest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class ListAdapter extends ArrayAdapter<MyViewItem> {
    private Context mContext;

    private List<MyViewItem> mViewitems;

    private ViewGroup mParentView;

    public ListAdapter(Context context, ViewGroup parentView,
                         List<MyViewItem> viewItems) {
        super(context, 0, viewItems);
        mContext = context;
        mViewitems = viewItems;
        this.mParentView = parentView;
    }

    @Override
    public int getCount() {
        return mViewitems.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parentView) {
        if (mViewitems.get(position).getMyInflatedView() != null) {
            return mViewitems.get(position).getMyInflatedView();

        } else {
            convertView = mViewitems.get(position).getView(position, convertView,
                    mParentView);
            return convertView;
        }

    }

    @Override
    public int getViewTypeCount() {
        return mViewitems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mViewitems.get(position).getViewTypeId();
    }
}
