package com.juanricardorc.viewmodelprovidersof.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.juanricardorc.viewmodelprovidersof.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        DashboardViewModelFactory factory = new DashboardViewModelFactory(getContext());

        // Sin Factory
        /*dashboardViewModel = new ViewModelProvider(this)
                .get(DashboardViewModel.class);*/

        // Con Factory, requireActivity().getViewModelStore()
        /*dashboardViewModel = new ViewModelProvider(requireActivity()
                .getViewModelStore(), factory)
                .get(DashboardViewModel.class);*/

        // Con Factory, requireParentFragment().getViewModelStore()
        /*dashboardViewModel = new ViewModelProvider(requireParentFragment()
                .getViewModelStore(), factory)
                .get(DashboardViewModel.class);*/

        // Con Factory, getViewModelStore()
        dashboardViewModel = new ViewModelProvider(getViewModelStore(), factory)
                .get(DashboardViewModel.class);

        //dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
