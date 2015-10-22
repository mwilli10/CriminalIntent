package com.bignerdranch.android.criminalintent;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
/**
 * Created by user on 10/21/15.
 */

public class ChoiceDialogFragment extends DialogFragment {
    public static final String EXTRA_CHOICE = "com.bignerdranch.android.criminalintent.choice";

    private int mChoice = 5;//random number that could possibly throw exception

    public static final int CHOICE_DATE = 0;
    public static final int CHOICE_TIME = 1;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(R.string.dialog_editDateOrTime)
                .setPositiveButton(R.string.dialog_editDate, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mChoice = CHOICE_DATE;
                        sendResult(Activity.RESULT_OK);
                    }
                })
                .setNegativeButton(R.string.dialog_editTime, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mChoice = CHOICE_TIME;
                        sendResult(Activity.RESULT_OK);
                    }
                });
        return builder.create();

    }

    private void sendResult(int resultCode) {
        if (getTargetFragment() == null) return;
        Intent i = new Intent();
        i.putExtra(EXTRA_CHOICE, mChoice);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, i);
    }
}

