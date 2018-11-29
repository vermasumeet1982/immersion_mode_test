package test.com.immersivemodetest;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public abstract class MyViewItem implements IViewValidator {

    //Add it for calculate click position on screen
    public static int top = 0;

    protected static final String UNKNOWN = "unknown";

    protected Context context;

    protected IViewEventCallback viewEventListener;

    protected MyViewItem(final Context context) {
        this.context = context;
    }

    protected MyViewItem(final Context context, final IViewEventCallback viewEventCallback) {
        this.context = context;
        this.viewEventListener = viewEventCallback;
    }

    public View getView(final int position, View convertView, final ViewGroup parentView) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getLayout(),
                    parentView, false);
            convertView.setTag(getViewHolder(convertView));
        }
        displayItem(convertView, position);
        return convertView;
    }

    protected abstract int getLayout();

    protected abstract Object getViewHolder(View v);

    protected abstract void displayItem(View view, int position);

    public abstract int getViewTypeId();

    public View getMyInflatedView() {
        return null;
    }


    public String getErrorText(final int stringId1, final int stringId2) {
        return String.format(context.getString(stringId1),
                context.getString(stringId2).toLowerCase());
    }

    //get click position on screen for translate animation
    public static int getTopPosition() {
        return top;
    }

    //calculate click position on screen for translate animation
    public static void setTopPosition(final View view) {
        final int[] screenLocation = new int[2];
        view.getLocationOnScreen(screenLocation);
        top = screenLocation[1];
    }
}