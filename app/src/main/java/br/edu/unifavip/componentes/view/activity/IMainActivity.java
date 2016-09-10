package br.edu.unifavip.componentes.view.activity;

/**
 * Created by pedrodimoura on 10/09/16.
 */

public interface IMainActivity {

    void initNavigationView();

    void setCheckedItemNavigationView(int idFragment);

    void syncDrawerMenu();

    void closeDrawerMenu();

    boolean isCurrentOnDisplay(int idFragment);

    void showFragment(int idFragment);

}
