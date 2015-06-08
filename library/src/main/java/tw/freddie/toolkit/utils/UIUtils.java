package tw.freddie.toolkit.utils;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Utility functions for UI
 */
public class UiUtils {
    public static int[] getViewLocation(View view) {
        int[] location = new int[2];
        if (view != null) {
            view.getLocationOnScreen(location);
        }
        return location;
    }

    public static int[] getScreenDimension(Activity activity) {
        int[] screenDimension = new int[2];
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        screenDimension[0] = displaymetrics.widthPixels;
        screenDimension[1] = displaymetrics.heightPixels;
        return screenDimension;
    }
}
