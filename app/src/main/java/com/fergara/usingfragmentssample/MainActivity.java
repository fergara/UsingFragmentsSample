package com.fergara.usingfragmentssample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we're being restored from a previous state,
        // then we don't need to do anything and should return or else
        // we could end up with overlapping fragments.

        if (savedInstanceState == null) {

            // add logic to decide which fragment you want to exhibit on the Activity
            // you can replace them also

            FragmentManager fragManager = this.getFragmentManager();
            FragmentTransaction fragTransaction = null;

            //These are the fragments we created and want to use in the Main Activity
            fragTransaction = fragManager.beginTransaction();

            fragTransaction.add(R.id.firstContainer, new FirstFragment());
            fragTransaction.add(R.id.firstContainer, new SecondFragment());

            fragTransaction.commit();

            // this is used when your app needs to support older Androids versions
            //getSupportFragmentManager().beginTransaction().add(R.id.firstContainer, firstFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
