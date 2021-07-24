package com.ltts.googlefittest.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class BaseFragment<V extends ViewModel, D extends ViewDataBinding> extends Fragment {

    protected V mViewModel;
    protected D mViewDataBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutRef(), container, false);
        return mViewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(getViewModelClass());
        mViewDataBinding.setVariable(getDataBindingVariable(), mViewModel);
        mViewDataBinding.setLifecycleOwner(getViewLifecycleOwner());
        mViewDataBinding.executePendingBindings();

        initViews();
        initObservers();
    }

    protected abstract void initObservers();

    protected abstract void initViews();

    protected abstract Class<V> getViewModelClass();

    protected abstract int getDataBindingVariable();

    @LayoutRes
    protected abstract int getLayoutRef();

    @Override
    public void onDestroy() {
        removeObservers();
        super.onDestroy();
    }

    protected abstract void removeObservers();
}
