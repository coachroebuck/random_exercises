package com.coachroebuck.experiement.exercise.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by michaelroebuck on 12/10/16.
 */

public class AlertDialogFactory {

    public static AlertDialog inputDialog(final Context context,
                                                            final AlertDialogResponseListener listener,
                                                            final String title,
                                                            final String message,
                                                            final String positiveText,
                                                            final String negativeText) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);

        final EditText editText = new EditText(context);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        alertDialog.setView(editText);

        alertDialog.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onInputProvided(editText.getText().toString());
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                listener.onCancelled();
                dialog.cancel();
            }});

        final AlertDialog dialog = alertDialog.create();

        editText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    listener.onInputProvided(editText.getText().toString());
                    dialog.dismiss();
                    return true;
                }
                return false;
            }
        });

        return dialog;
    }

    public static AlertDialog confirmationDialog(final Context context,
                                                         final AlertDialogResponseListener listener,
                                                         final String title,
                                                         final String message,
                                                         final String positiveText,
                                                         final String negativeText) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);

        alertDialog.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onConfirmation();
                dialog.dismiss();
            }
        });
        alertDialog.setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                listener.onCancelled();
                dialog.cancel();
            }});

        return alertDialog.create();
    }

    public static AlertDialog dialogWithAlert(final Context context,
                                                         final AlertDialogResponseListener listener,
                                                         final String title,
                                                         final String message,
                                                         final String positiveText) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);

        alertDialog.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return alertDialog.create();
    }

    public interface AlertDialogResponseListener {
        void onConfirmation();
        void onCancelled();
        void onInputProvided(String input);
    }
}
