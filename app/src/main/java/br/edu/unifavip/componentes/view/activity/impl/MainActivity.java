package br.edu.unifavip.componentes.view.activity.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import br.edu.unifavip.componentes.R;
import br.edu.unifavip.componentes.util.Constants;
import br.edu.unifavip.componentes.view.activity.IMainActivity;
import br.edu.unifavip.componentes.view.activity.IView;
import br.edu.unifavip.componentes.view.fragment.impl.FragmentOne;
import br.edu.unifavip.componentes.view.fragment.impl.FragmentTwo;

public class MainActivity extends AppCompatActivity  implements IView, IMainActivity, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private int mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activityMainToolbar);
        setSupportActionBar(toolbar);

        init();
        setActionBarDrawerToggle();
        initNavigationView();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                syncDrawerMenu();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void init() {
        this.mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.mNavigationView = (NavigationView) findViewById(R.id.navigationView);
    }

    @Override
    public void setActionBarDrawerToggle() {
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void showRootLayout() {

    }

    @Override
    public void hideRootLayout() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showSnackbarMessage(int resId, int duration) {
        Snackbar.make(getView(), resId, duration).show();
    }

    @Override
    public void showSnackbarMessage(String message, int duration) {
        Snackbar.make(getView(), message, duration).show();
    }

    @Override
    public View getView() {
        return MainActivity.this.findViewById(R.id.coordinatorLayout);
    }

    @Override
    public void startView(Intent intent) {
        MainActivity.this.startActivity(intent);
    }

    @Override
    public void finishView() {
        MainActivity.this.finish();
    }

    @Override
    public Context getViewContext() {
        return MainActivity.this;
    }

    @Override
    public void initNavigationView() {
        this.mNavigationView.getMenu().clear();
        this.mNavigationView.inflateMenu(R.menu.menu_drawer_layout);
        this.mNavigationView.setNavigationItemSelectedListener(MainActivity.this);

        this.showFragment(Constants.FRAGMENT_ONE);
    }

    @Override
    public void setCheckedItemNavigationView(int idFragment) {
        switch (idFragment) {
            case Constants.FRAGMENT_ONE:
                this.mNavigationView.setCheckedItem(R.id.drawer_menu_one);
                break;
            case Constants.FRAGMENT_TWO:
                this.mNavigationView.setCheckedItem(R.id.drawer_menu_two);
                break;
        }
    }

    @Override
    public void syncDrawerMenu() {
        if (!this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) this.mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void closeDrawerMenu() {
        this.mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean isCurrentOnDisplay(int idFragment) {
        return (this.mCurrentFragment == idFragment);
    }

    @Override
    public void showFragment(int idFragment) {
        switch (idFragment) {
            case Constants.FRAGMENT_ONE:
                if (!this.isCurrentOnDisplay(Constants.FRAGMENT_ONE)) {
                    this.mCurrentFragment = Constants.FRAGMENT_ONE;

                    this.setCheckedItemNavigationView(Constants.FRAGMENT_ONE);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new FragmentOne())
                            .commit();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        closeDrawerMenu();
                    }
                }, 120);

                break;
            case Constants.FRAGMENT_TWO:
                if (!this.isCurrentOnDisplay(Constants.FRAGMENT_TWO)) {
                    this.mCurrentFragment = Constants.FRAGMENT_TWO;

                    this.setCheckedItemNavigationView(Constants.FRAGMENT_TWO);
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, new FragmentTwo())
                            .commit();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        closeDrawerMenu();
                    }
                }, 120);

                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.drawer_menu_one:
                this.showFragment(Constants.FRAGMENT_ONE);
                return true;
            case R.id.drawer_menu_two:
                this.showFragment(Constants.FRAGMENT_TWO);
                return true;
        }
        return false;
    }
}
