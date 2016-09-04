package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.knoxpo.JokeDisplayActivity;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void tellJoke(View view) {
        //Toast.makeText(this, mJokesGenerator.getJoke(), Toast.LENGTH_SHORT).show();
       /* Intent displayIntent = JokeDisplayActivity.getIntent(this, mJokesGenerator.getJoke());
        startActivity(displayIntent);*/
        new MyTask().execute();
    }

    private class MyTask extends EndpointsAsyncTask{

        private static final String DIALOG_TAG = "dialog";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            ProgressDialogFragment fragment = ProgressDialogFragment.newInstance(getString(R.string.fetching_joke));
            fragment.show(getSupportFragmentManager(),DIALOG_TAG);

        }

        @Override
        protected void onPostExecute(String s) {

            Fragment fragment = getSupportFragmentManager().findFragmentByTag(DIALOG_TAG);
            if(fragment instanceof ProgressDialogFragment){
                ((ProgressDialogFragment)fragment).dismiss();
            }
            Intent displayIntent = JokeDisplayActivity.getIntent(MainActivity.this, s);
            startActivity(displayIntent);
            //super.onPostExecute(s);
        }
    }

}
