package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testVerifyAsyncTask() {
        EndpointsAsyncTask task = new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String s) {
                assertNotNull("String result is null",s);
            }
        };

        task.execute();
    }
}
