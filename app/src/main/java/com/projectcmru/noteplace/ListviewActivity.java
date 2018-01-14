package com.projectcmru.noteplace;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class ListviewActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.listview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fm = null;
        FragmentTransaction ft;
        String strTitle = "";

        switch (item.getItemId()){
            case R.id.nav_myplace:
                fm = new fmAllnotesview();
                strTitle = "สถานที่ของฉัน";
                break;

            case R.id.nav_rating:
                fm = new fmRatingview();
                strTitle = "ระดับคะแนน";
                break;

            case R.id.nav_restaurant:
                fm = new fmRatingview();
                strTitle = "ร้านอาหาร";
                break;

            case R.id.nav_fixshop:
                fm = new fmFixshopview();
                strTitle = "ร้านซ่อมต่างๆ";
                break;

            case R.id.nav_travel:
                fm = new fmTravelview();
                strTitle = "สถานที่ท่องเที่ยว";
                break;

            case R.id.nav_service:
                fm = new fmServiceview();
                strTitle = "สถานที่ให้บริการต่างๆ";
                break;

            case R.id.nav_space:
                fm = new fmOtherplaceview();
                strTitle = "สถานที่ประเภทอื่นๆ";
                break;

            case R.id.nav_share:
                fm = new fmShare();
                strTitle = "สถานที่ประเภทอื่นๆ";
                break;

            case R.id.nav_signout:
                fm = new fmSignout();
                strTitle = "ออกจากระบบ";
                break;
        }

        if (fm != null) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.maincontent, fm);
            ft.commit();
            toolbar.setTitle(strTitle);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
