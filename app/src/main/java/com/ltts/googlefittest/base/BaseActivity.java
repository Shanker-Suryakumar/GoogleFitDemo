package com.ltts.googlefittest.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public abstract class BaseActivity<V extends ViewModel, D extends ViewDataBinding> extends AppCompatActivity {

    protected V mViewModel;
    protected D mViewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutRef());
        mViewModel = ViewModelProviders.of(this).get(getViewModelClass());
        mViewDataBinding.setVariable(getDataBindingVariable(), mViewModel);
        mViewDataBinding.setLifecycleOwner(this);
        mViewDataBinding.executePendingBindings();
        initViews();
        initObservers();
    }

    protected abstract void initObservers();

    protected abstract void initViews();

    @LayoutRes
    protected abstract int getLayoutRef();

    protected abstract Class<V> getViewModelClass();

    protected abstract int getDataBindingVariable();

    @Override
    protected void onDestroy() {
        removeObservers();
        super.onDestroy();
    }

    protected abstract void removeObservers();
}
