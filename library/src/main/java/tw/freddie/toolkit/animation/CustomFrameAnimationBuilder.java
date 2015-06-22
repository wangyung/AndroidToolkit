package tw.freddie.toolkit.animation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;

/**
 * The build for create frame animation
 * The naming rule of each drawable (image) is
 *     <PREFIX>+<FRAME_NUMBER>
 * for example:
 *     prefix: MA_
 *     frame_number: 001
 *     result: MA_001
 */
public class CustomFrameAnimationBuilder {

    private Resources mResources;
    private AnimationDrawable mAnimationDrawable;
    private String mFormatString = "%03d";
    private String mPackageName;
    private String mPrefix = "";
    private int mFirstFrameNumber = 0;
    private int mFrameCount = 1;
    private int mDuration;
    private boolean mIsOneShot = false;

    public CustomFrameAnimationBuilder(Context context) {
        mResources = context.getResources();
        mPackageName = context.getPackageName();
    }

    public CustomFrameAnimationBuilder prefix(String prefix) {
        mPrefix = prefix;
        return this;
    }

    public CustomFrameAnimationBuilder firstFrameNumber(int firstFrameNumber) {
        mFirstFrameNumber = firstFrameNumber < 0 ? 0 : firstFrameNumber;
        return this;
    }

    public CustomFrameAnimationBuilder frameCount(int count) {
        mFrameCount = count <= 0 ? 1 : count;
        return this;
    }

    public CustomFrameAnimationBuilder oneshot() {
        mIsOneShot = true;
        return this;
    }

    public CustomFrameAnimationBuilder digit(int digit){
        mFormatString = String.format("%%%dd", digit);
        return this;
    }

    public AnimationDrawable build() {
        int durationOfEachFrame = mDuration / mFrameCount;
        String frameNumber;
        if (mAnimationDrawable == null) {
            mAnimationDrawable = new AnimationDrawable();
        }

        mPrefix = mPrefix.toLowerCase();

        for (int i=0; i<mFrameCount; i++) {
            frameNumber = String.format(mFormatString, mFirstFrameNumber + i);
            int resId = mResources.getIdentifier(mPrefix + frameNumber, "drawable", mPackageName);
            if (resId > 0) {
                mAnimationDrawable.addFrame(mResources.getDrawable(resId), durationOfEachFrame);
            }
        }
        mAnimationDrawable.setOneShot(mIsOneShot);
        return mAnimationDrawable;
    }
}
