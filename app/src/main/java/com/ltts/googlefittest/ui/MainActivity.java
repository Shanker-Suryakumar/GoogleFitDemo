package com.ltts.googlefittest.ui;

import com.ltts.googlefittest.R;
import com.ltts.googlefittest.base.BaseActivity;
import com.ltts.googlefittest.databinding.ActivityMainBinding;

import static com.ltts.googlefittest.BR.mainViewModel;

public class MainActivity extends BaseActivity<MainViewModel, ActivityMainBinding> {

    @Override
    protected void initObservers() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutRef() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    protected int getDataBindingVariable() {
        return mainViewModel;
    }

    @Override
    protected void removeObservers() {

    }
}
