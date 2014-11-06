package com.example.numberseekbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SearchView;
import android.widget.SeekBar;

public class MySeekbar extends SeekBar {

	public MySeekbar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initdata();
	}

	public MySeekbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		initdata();
	}

	@SuppressLint("NewApi")
	private void initdata() {
		toast = new BitmapDrawable(getResources(),
				BitmapFactory.decodeResource(getResources(),
						R.drawable.popwindow_bg1));
		toast_width = toast.getIntrinsicWidth();
		toast_heigth = toast.getIntrinsicHeight();
		Rect thumbRect = getThumb().getBounds();
		thumb_width = thumbRect.centerY() * 2;
		setPadding((toast_width - thumb_width) / 2, toast_heigth,
				(toast_width - thumb_width) / 2, 0);
		
		textpaint=new Paint();
		textpaint.setAntiAlias(true);
		textpaint.setColor(Color.YELLOW);
		textpaint.setTextSize(16);
		
	}
	private Paint textpaint;
	private Drawable toast;
	private int toast_width;
	private int toast_heigth;
	private int thumb_width;

	@SuppressLint("NewApi")
	@Override
	protected synchronized void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Rect rect = getThumb().getBounds();
		System.out.println("thumb..." + rect.toString());
		// Rect(393, 0 - 438, 45)
		toast.setBounds(rect.left - ((toast_width - thumb_width) / 2),
				rect.top, rect.right + ((toast_width - thumb_width) / 2),
				toast_heigth);
		toast.draw(canvas);
		String text=getProgress()/getMax()+" %";
		Rect bounds=new Rect();
		textpaint.getTextBounds(text, 0, text.length(), bounds);
		canvas.drawText(text, rect.left-bounds.centerX(), 0, textpaint);
	}

}
