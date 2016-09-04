package com.udacity.gradle.builditbigger;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Tejas Sherdiwala on 9/4/2016.
 */
public class ProgressDialogFragment extends DialogFragment {

    private static final String
            TAG = ProgressDialogFragment.class.getSimpleName(),
            ARGS_MESSAGE = TAG + ".ARGS_MESSAGE";


    public static ProgressDialogFragment newInstance(String message) {

        Bundle args = new Bundle();
        args.putString(ARGS_MESSAGE, message);
        ProgressDialogFragment fragment = new ProgressDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog progressDialog = new ProgressDialog(getActivity());

        progressDialog.setMessage(
                getArguments().getString(ARGS_MESSAGE)
        );

        return progressDialog;
    }
}
