package test.com.immersivemodetest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    protected ListView listView;

    protected ListAdapter listAdapter;

    protected List<MyViewItem> viewItems = new ArrayList<MyViewItem>();

    IViewEventCallback mViewListener;

    private boolean addPax;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof IViewEventCallback) {
            mViewListener = (IViewEventCallback) getActivity();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initUI();
    }

    private void initUI() {
        viewItems.add(new CustomView(getActivity(),
                mViewListener, addPax));
        listView = (ListView) getActivity().findViewById(R.id.fragmentList);
//        listView.setVisibility(View.GONE);
        listAdapter = new ListAdapter(getActivity(), listView, viewItems);
        if (listView != null) {
            listView.setAdapter(listAdapter);
//            crossFadeAnimation(listView, 650);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }
}
