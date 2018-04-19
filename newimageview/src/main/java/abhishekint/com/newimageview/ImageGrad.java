package abhishekint.com.newimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

/**
 * Created by abhishek on 19-04-2018.
 */

public class ImageGrad extends RelativeLayout {
    /**
     * Core Items
     */
    private Context mContext;
    private AttributeSet attrs;
    private int styleAttr;
    private View view;

    /**
     * Core Components
     */
    ImageView image;
    View alphaLayer;

    /**
     * Attributes
     **/
    Drawable imageFile;
    Drawable imagePlaceHolder;
    Drawable imageError;
    Drawable gradient;


    public ImageGrad(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public ImageGrad(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.attrs = attrs;
        initView();
    }

    public ImageGrad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        this.attrs = attrs;
        this.styleAttr = defStyleAttr;
        initView();
    }

    private void initView() {
        this.view = this;
        inflate(mContext, R.layout.image_grad, this);

        TypedArray arr = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.ImageGrad,
                styleAttr, 0);

        imageFile = arr.getDrawable(R.styleable.ImageGrad_imageSrc);
        imageError = arr.getDrawable(R.styleable.ImageGrad_imageError);
        imagePlaceHolder = arr.getDrawable(R.styleable.ImageGrad_imagePlaceholder);
        gradient = arr.getDrawable(R.styleable.ImageGrad_gradient);

        image = (ImageView) findViewById(R.id.image_grad_iv);
        alphaLayer = findViewById(R.id.image_grad_view);

        if (imageFile != null) {
            setDrawableImage(imageFile);
        }

        if (gradient != null) {
            alphaLayer.setBackground(gradient);
        }
        arr.recycle();

    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        image.setScaleType(scaleType);
    }

    public void setGradient(Drawable gradient) {
        alphaLayer.setBackground(gradient);
    }

    public void setDrawableImage(Drawable imageFile) {
        image.setImageDrawable(imageFile);
    }

    public void setDrawableImage(int imageFile, int imageError, int imagePlaceHolder,
                                 ImageView.ScaleType scaleType) {

        image.setScaleType(scaleType);
        Glide
                .with(mContext)
                .load(imageFile)
                .placeholder(imagePlaceHolder)
                .crossFade()
                .dontAnimate()
                .error(imageError)
                .into(image);

    }

    public void setUrlImage(String url, int imageError, int imagePlaceHolder,
                            ImageView.ScaleType scaleType) {
        image.setScaleType(scaleType);
        Glide
                .with(mContext)
                .load(url)
                .placeholder(imagePlaceHolder)
                .crossFade()
                .dontAnimate()
                .error(imageError)
                .into(image);

    }

    public void setResImage(int resID, ImageView.ScaleType scaleType) {
        image.setScaleType(scaleType);
        image.setImageResource(resID);
    }


}