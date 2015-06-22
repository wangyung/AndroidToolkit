package tw.freddie.toolkit.utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import tw.freddie.toolkit.R;

/**
 * Created by freddie.
 */
public class DialogUtils {
    private static DialogInterface.OnClickListener mDefaultClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    };

    private static DialogInterface.OnClickListener mDefaultDismissClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    };

    public static AlertDialog createMessageInfoDialog(Context context, String title, String message,
                                                      DialogInterface.OnClickListener clickListener) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        DialogInterface.OnClickListener listener = clickListener == null ? mDefaultDismissClick : clickListener;
        alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_info)
                .setTitle(title)
                .setPositiveButton(context.getString(R.string.ok), listener)
                .setMessage(message);
        return alertDialogBuilder.create();
    }

    public static ProgressDialog createWaitingDialog(Context context, String message, boolean cacelable) {
        ProgressDialog dialog = new ProgressDialog(context);
        dialog.setTitle("");
        dialog.setMessage(message);
        dialog.setCancelable(cacelable);
        dialog.setIndeterminate(true);
        return dialog;
    }
}
