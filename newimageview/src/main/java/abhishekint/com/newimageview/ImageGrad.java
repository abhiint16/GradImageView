package abhishekint.com.newimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by abhishek on 19-04-2018.
 */

public class ImageGrad extends RelativeLayout {
    /** Core Items*/
    private Context mContext;
    private AttributeSet attrs;
    private int styleAttr;
    private View view;

    public ImageGrad(Context context) {
        super(context);
        this.mContext=context;
    }

    public ImageGrad(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext=context;
        this.attrs=attrs;
    }

    public ImageGrad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
        this.attrs=attrs;
        this.styleAttr=defStyleAttr;
    }

}
