package com.juanricardorc.viewmodelprovidersof.home;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private Context context;

    public DashboardViewModel(Context context) {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
        this.context = context;
    }

    public LiveData<String> getText() {
        return mText;
    }
}