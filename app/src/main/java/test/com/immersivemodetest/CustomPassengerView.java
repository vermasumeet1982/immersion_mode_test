package test.com.immersivemodetest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class CustomPassengerView extends LinearLayout {
    public CustomPassengerView(Context context) {
        super(context);
        init();
    }

    public CustomPassengerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.custom_view, this);
    }


}
