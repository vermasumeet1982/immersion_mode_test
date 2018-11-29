package test.com.immersivemodetest;

import android.content.Context;
import android.view.View;

import java.util.List;


public class CustomView extends MyViewItem {


    private ViewHolder mViewHolder;

    private IViewEventCallback addPassengerCallback;

    private Boolean addPax;

    public interface TitleChangeListener {
        void onTitleChanged();
    }

    public CustomView(Context context,
                      IViewEventCallback addPassengerCallback, boolean addPax) {
        super(context);
        this.addPassengerCallback = addPassengerCallback;
        this.addPax = addPax;
    }

    @Override
    protected int getLayout() {
        return R.layout.my_custom_view;
    }

    @Override
    protected Object getViewHolder(View v) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.paxNameView = (CustomPassengerView) v.findViewById(R.id.paxNameView);
        return viewHolder;
    }

    @Override
    protected void displayItem(View view, int position) {

        mViewHolder = (ViewHolder) view.getTag();

        addPassengerCallback.onValidateView(true);

    }

    @Override
    public int getViewTypeId() {
        return 1;
    }

    private static class ViewHolder {

        public CustomPassengerView paxNameView;

    }

    @Override
    public boolean isViewEmpty(List<String> viewErrors) {

            return false;

    }

    @Override
    public boolean isViewValid(List<String> viewErrors) {

            return true;
    }
}
