package br.edu.unifavip.componentes.view.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by pedrodimoura on 10/09/16.
 */

public interface IView {

    void init();

    void setActionBarDrawerToggle();

    void showRootLayout();

    void hideRootLayout();

    void showProgressBar();

    void hideProgressBar();

    void showSnackbarMessage(int resId, int duration);

    void showSnackbarMessage(String message, int duration);

    View getView();

    void startView(Intent intent);

    void finishView();

    Context getViewContext();

}
