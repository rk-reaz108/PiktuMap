package com.example.piktotestmap.drawing;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.example.piktotestmap.SMLetterMappingActivity;
//import com.sm.banglaalphabet.SMDrawActivity;
//import com.sm.banglaalphabet.SMHomeActivity;

public class Panel extends View implements OnTouchListener {

	private Canvas mCanvas;
	MyPaths mMyPaths;
	private ArrayList<MyPaths> paths = new ArrayList<MyPaths>();
	private ArrayList<MyPaths> pathsX = new ArrayList<MyPaths>();
	private ArrayList<MyPaths> total = new ArrayList<MyPaths>();
	public static int selectedColor, backColor = Color.TRANSPARENT;
	private int selectedFontSize = (int)SMLetterMappingActivity.screenheight*17/320;
	Bitmap mBitmap;

	private Paint getPaintFormat() {
		Paint mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setDither(true);
		
		mPaint.setColor(selectedColor);
		mPaint.setStyle(Paint.Style.STROKE);
		mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeWidth(selectedFontSize);
		return mPaint;
	}

	public Panel(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setOnTouchListener(this);
		mCanvas = new Canvas();
		Path mPath = new Path();
		mMyPaths = new MyPaths(mPath, getPaintFormat());
		paths.add(mMyPaths);
		pathsX.add(mMyPaths);
		total.add(mMyPaths);
	//	SMDrawActivity.isEmpty=true;

	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(backColor);

		if (mBitmap == null)

			mBitmap = Bitmap.createBitmap(getWidth(), getHeight(),
					Bitmap.Config.ARGB_8888);

		canvas.drawBitmap(mBitmap, 0, 0, new Paint());
		for (MyPaths p : pathsX) {
			 //p.mPaint.setColor(selectedColor);
			canvas.drawPath(p.mPath, getPaintFormat());
		}

	}

	private float mX, mY;
	private static final float TOUCH_TOLERANCE = 4;

	private void touch_start(float x, float y) {
		// mMyPaths.mPath.reset();
		mMyPaths.mPath.moveTo(x, y);

		mX = x;
		mY = y;
	}

	private void touch_move(float x, float y) {
		float dx = Math.abs(x - mX);
		float dy = Math.abs(y - mY);
		if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
			mMyPaths.mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
			mX = x;
			mY = y;

		}
	}

	private void touch_up() {
		// commit the path to our offscreen
		mCanvas.drawPath(mMyPaths.mPath, mMyPaths.mPaint);
		// kill this so we don't double draw
		mMyPaths = new MyPaths(new Path(), mMyPaths.mPaint);
		total.add(mMyPaths);
		paths.add(mMyPaths);
		Canvas c = new Canvas(mBitmap);
		for (MyPaths p : paths) {
			p.mPaint.setColor(selectedColor);
			c.drawPath(p.mPath, p.mPaint);
		}

	}

	public void resetPain() {
		// mPaint = getPaintFormat();
		pathsX.clear();
		paths.clear();
		total.clear();
		Path mPath = new Path();
		mMyPaths = new MyPaths(mPath, getPaintFormat());
		paths.add(mMyPaths);
		pathsX.add(mMyPaths);
		total.add(mMyPaths);
	}

	@Override
	public synchronized boolean onTouch(View arg0, MotionEvent event) {
		float x = event.getX();
		float y = event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// resetPain();
			touch_start(x, y);
			invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			touch_move(x, y);
		//	SMDrawActivity.isEmpty=false;
			invalidate();
			break;
		case MotionEvent.ACTION_UP:
			touch_up();
			resetPain();
			invalidate();
			break;
		}
		return true;
	}

}