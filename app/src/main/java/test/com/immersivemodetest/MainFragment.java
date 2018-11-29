package test.com.immersivemodetest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

//    protected ListView listView;
    protected RecyclerView recyclerView;

//    protected ListAdapter listAdapter;
    private RecyclerAdapter recyclerAdapter;

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
//        listView = (ListView) getActivity().findViewById(R.id.fragmentList);
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.fragmentList);
//        listView.setVisibility(View.GONE);

//        listAdapter = new ListAdapter(getActivity(), listView, viewItems);
        recyclerAdapter = new RecyclerAdapter(getContext(), viewItems, recyclerView);

//        if (listView != null) {
//            listView.setAdapter(listAdapter);
//            crossFadeAnimation(listView, 650);
//        }

        if(recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(recyclerAdapter);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_recycler, container, false);

    }
}
