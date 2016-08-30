package com.example.piktotestmap.drawing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

import com.example.piktotestmap.MyCounter;
import com.example.piktotestmap.R;
import com.example.piktotestmap.SMLetterMappingActivity;
import com.example.piktotestmap.utils.Feedback_alertBuilder;
import com.example.piktotestmap.utils.Feedback_alertBuilder2;
import com.example.piktotestmap.utils.IDContainer;
import com.example.piktotestmap.utils.SharedPreferenceHelper;

public class PanelMapping extends View implements OnTouchListener {

	private Canvas mCanvas;
	MyPaths mMyPaths;
	Context context;
	private ArrayList<MyPaths> paths = new ArrayList<MyPaths>();
	private ArrayList<MyPaths> pathsX = new ArrayList<MyPaths>();
	private ArrayList<MyPaths> total = new ArrayList<MyPaths>();
	private int defaultColor = Color.parseColor("#7d5fbcd3"),// default color
			backColor = Color.TRANSPARENT,// Color.TRANSPARENT
			selectedColor = Color.parseColor("#7dff5555");// Color.RED
	private int selectedFontSize = (int) SMLetterMappingActivity.screenheight * 25 / 320,
			imageSize;
	private Bitmap mBitmap, bitLetter, bitLetter1, bitPic, bitPic1;
	private int count = 0;
	private Boolean isTouched = false;
	private int currentItemId, selectedItemId;
	private float currentXPos, currentYPos, selectedXPos, selectedYPos, width,
			height;
	private MediaPlayer mPlayer;

	Random random = new Random();
	private int[] mMatchImageAllId;

	int countforFinish = 0;

	private int[] mLetterImageAllId;
	private ArrayList<MappingContent> mLetterPicVIdList = new ArrayList<MappingContent>();
	private ArrayList<MappingContent> mLetterCdnVIdList = new ArrayList<MappingContent>();
	private ArrayList<MappingContent> mPicCdnVIdList = new ArrayList<MappingContent>();
	private ArrayList<MappingContent> mToatlCdnVIdList = new ArrayList<MappingContent>();
	private ArrayList<MappingContent> mWrongPosList = new ArrayList<MappingContent>();
	private ArrayList<Integer> mCorrectIDList = new ArrayList<Integer>();

	private Paint getPaintFormat() {
		Paint mPaint = new Paint();
		// mPaint.setAntiAlias(true);
		// mPaint.setDither(true);
		mPaint.setColor(defaultColor);
		mPaint.setStyle(Paint.Style.STROKE);
		// mPaint.setStrokeJoin(Paint.Join.ROUND);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setShadowLayer(0, 0, 0, 0);

		// mPaint.set
		mPaint.setStrokeWidth(selectedFontSize);
		return mPaint;
	}

	public PanelMapping(Context context) {
		super(context);
		this.context = context;
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setOnTouchListener(this);

		mMatchImageAllId = IDContainer.mMatchImageAllId;
		mLetterImageAllId = IDContainer.mLetterImageAllId;

		mCanvas = new Canvas();
		mPlayer = new MediaPlayer();

		Path mPath = new Path();
		mMyPaths = new MyPaths(mPath, getPaintFormat());
		paths.add(mMyPaths);
		pathsX.add(mMyPaths);
		total.add(mMyPaths);

		Log.d("ViewCount", Integer.toString(countforFinish));
		// for (int i = 0; i < mMatchImageAllId.length; i++) {
		// if(mMatchImageAllId[i]==2){
		// setView2();
		// }
		// else {
		setView();
		// }
		//
		// }
		// setView();
		// if (MyCounter.counter ==1) {
		// MyCounter.counter = 0;
		// //((Activity) context).finish();
		// Feedback_alertBuilder2.makerDialog(context,((Activity) context) );
		// setMusic();
		// MyCounter.counter2++;
		// }
		// else if(MyCounter.counter2 ==2){
		// MyCounter.counter2 = 0;
		// Toast.makeText(context, "Exit", 1000).show();
		//
		// }
//		switch (MyCounter.counter2) {
//	
//		case 6:
//			Feedback_alertBuilder.makerDialog(context, ((Activity) context));
//			setMusic2();
//			
//			break;
//		default:
//			//MyCounter.counter2 = 0;
//			break;
//		}

	}

	public void setMusic2() {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Log.e("Checking", "Start Music");
		try {
			Log.e("Checking", "Reset MediaPlayer");
			mPlayer.reset();
			Log.e("Checking", "Initialize MediaPlayer");
			mPlayer = MediaPlayer.create(context, R.raw.positivebell_long);
			Log.e("Checking", "Prepare MediaPlayer");
			// mPlayer.prepare();
			Log.e("Checking", "Start MediaPlayer");
			mPlayer.start();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

			mBitmap = Bitmap.createBitmap(SMLetterMappingActivity.screenwidth,
					SMLetterMappingActivity.screenheight,
					Bitmap.Config.ARGB_8888);

		canvas.drawBitmap(mBitmap, 0, 0, new Paint());
		for (MyPaths p : pathsX) {

			// p.mPaint.setColor(selectedColor);
			// Log.i("pppp", "ppp");
			canvas.drawPath(p.mPath, getPaintFormat());
		}

	}

	private void setView() {
		// TODO Auto-generated method stub
		count = 0;
		//MyCounter.counter++;
		System.out.println("Counter refresh: " + MyCounter.counter2);
		// mPlayer.release();
		width = SMLetterMappingActivity.screenwidth;
		height = SMLetterMappingActivity.screenheight;
		imageSize = (int) SMLetterMappingActivity.screenheight * 80 / 320;
		mLetterPicVIdList.clear();
		mLetterCdnVIdList.clear();
		mPicCdnVIdList.clear();
		mToatlCdnVIdList.clear();
		mWrongPosList.clear();
		mCorrectIDList.clear();
		for (int i = 0; i < mLetterImageAllId.length; i++) {
			mLetterPicVIdList.add(new MappingContent(mLetterImageAllId[i],
					mMatchImageAllId[i]));
		}
		Collections.shuffle(mLetterPicVIdList);
		mLetterCdnVIdList.add(new MappingContent((float) width * 80 / 480,
				(float) height * 30 / 320));
		// mLetterCdnVIdList.set(index, object);
		mLetterCdnVIdList.add(new MappingContent((float) width * 80 / 480,
				(float) height * 125 / 320));
		mLetterCdnVIdList.add(new MappingContent((float) width * 80 / 480,
				(float) height * 220 / 320));
		Collections.shuffle(mLetterCdnVIdList);
		mPicCdnVIdList.add(new MappingContent((float) width * 300 / 480,
				(float) height * 30 / 320));
		mPicCdnVIdList.add(new MappingContent((float) width * 300 / 480,
				(float) height * 125 / 320));
		mPicCdnVIdList.add(new MappingContent((float) width * 300 / 480,
				(float) height * 220 / 320));
		Collections.shuffle(mPicCdnVIdList);
		for (int i = 0; i < mLetterCdnVIdList.size(); i++) {
			mToatlCdnVIdList.add(new MappingContent(i,
					mLetterCdnVIdList.get(i).xPos,
					mLetterCdnVIdList.get(i).yPos, mPicCdnVIdList.get(i).xPos,
					mPicCdnVIdList.get(i).yPos));
		}
		mBitmap = Bitmap.createBitmap(SMLetterMappingActivity.screenwidth,
				SMLetterMappingActivity.screenheight, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(mBitmap);
		for (int i = 0; i < mToatlCdnVIdList.size(); i++) {
			// bitLetter = BitmapFactory.decodeResource(getResources(),
			// mLetterPicVIdList.get(i).Letterimageid);
			bitLetter = IDContainer.decodeSampledBitmapFromResource(
					getResources(), mLetterPicVIdList.get(i).Letterimageid,
					SMLetterMappingActivity.mappingLettersize);

			bitLetter1 = Bitmap.createScaledBitmap(bitLetter, imageSize,
					imageSize, false);
			bitLetter.recycle();
			// bitPic = BitmapFactory.decodeResource(getResources(),
			// mLetterPicVIdList.get(i).PicImageId);
			bitPic = IDContainer.decodeSampledBitmapFromResource(
					getResources(), mLetterPicVIdList.get(i).PicImageId,
					SMLetterMappingActivity.mappingPicSize);
			bitPic1 = Bitmap.createScaledBitmap(bitPic, imageSize, imageSize,
					false);
			bitPic.recycle();
			canvas.drawBitmap(bitLetter1, mToatlCdnVIdList.get(i).x1,
					mToatlCdnVIdList.get(i).y1, new Paint());
			canvas.drawBitmap(bitPic1, mToatlCdnVIdList.get(i).x2,
					mToatlCdnVIdList.get(i).y2, new Paint());
			// countforFinish++;
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

		Canvas c = new Canvas(mBitmap);
		Paint paint = getPaintFormat();
		paint.setColor(selectedColor);
		paint.setMaskFilter(new EmbossMaskFilter(new float[] { 1, 1, 1 }, 0.2f,
				10, 8.2f));
		c.drawLine(selectedXPos + imageSize / 2, selectedYPos + imageSize / 2,
				currentXPos + imageSize / 2, currentYPos + imageSize / 2, paint);

	}

	private void setView2() {
		// TODO Auto-generated method stub
		count = 0;
		MyCounter.counter2++;
		System.out.println("Counter refresh: " + MyCounter.counter);
		// mPlayer.release();
		width = SMLetterMappingActivity.screenwidth;
		height = SMLetterMappingActivity.screenheight;
		imageSize = (int) SMLetterMappingActivity.screenheight * 80 / 320;
		mLetterPicVIdList.clear();
		mLetterCdnVIdList.clear();
		mPicCdnVIdList.clear();
		mToatlCdnVIdList.clear();
		mWrongPosList.clear();
		mCorrectIDList.clear();
		for (int i = 0; i < mLetterImageAllId.length; i++) {
			mLetterPicVIdList.add(new MappingContent(mLetterImageAllId[i],
					mMatchImageAllId[i]));
		}
		Collections.shuffle(mLetterPicVIdList);
		mLetterCdnVIdList.add(new MappingContent((float) width * 80 / 480,
				(float) height * 30 / 320));
		// mLetterCdnVIdList.set(index, object);
		mLetterCdnVIdList.add(new MappingContent((float) width * 80 / 480,
				(float) height * 125 / 320));
		mLetterCdnVIdList.add(new MappingContent((float) width * 80 / 480,
				(float) height * 220 / 320));
		Collections.shuffle(mLetterCdnVIdList);
		mPicCdnVIdList.add(new MappingContent((float) width * 300 / 480,
				(float) height * 30 / 320));
		mPicCdnVIdList.add(new MappingContent((float) width * 300 / 480,
				(float) height * 125 / 320));
		mPicCdnVIdList.add(new MappingContent((float) width * 300 / 480,
				(float) height * 220 / 320));
		Collections.shuffle(mPicCdnVIdList);
		for (int i = 0; i < mLetterCdnVIdList.size(); i++) {
			mToatlCdnVIdList.add(new MappingContent(i,
					mLetterCdnVIdList.get(i).xPos,
					mLetterCdnVIdList.get(i).yPos, mPicCdnVIdList.get(i).xPos,
					mPicCdnVIdList.get(i).yPos));
		}
		mBitmap = Bitmap.createBitmap(SMLetterMappingActivity.screenwidth,
				SMLetterMappingActivity.screenheight, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(mBitmap);
		for (int i = 0; i < mToatlCdnVIdList.size(); i++) {
			// bitLetter = BitmapFactory.decodeResource(getResources(),
			// mLetterPicVIdList.get(i).Letterimageid);
			bitLetter = IDContainer.decodeSampledBitmapFromResource(
					getResources(), mLetterPicVIdList.get(i).Letterimageid,
					SMLetterMappingActivity.mappingLettersize);

			bitLetter1 = Bitmap.createScaledBitmap(bitLetter, imageSize,
					imageSize, false);
			bitLetter.recycle();
			// bitPic = BitmapFactory.decodeResource(getResources(),
			// mLetterPicVIdList.get(i).PicImageId);
			bitPic = IDContainer.decodeSampledBitmapFromResource(
					getResources(), mLetterPicVIdList.get(i).PicImageId,
					SMLetterMappingActivity.mappingPicSize);
			bitPic1 = Bitmap.createScaledBitmap(bitPic, imageSize, imageSize,
					false);
			bitPic.recycle();
			canvas.drawBitmap(bitLetter1, mToatlCdnVIdList.get(i).x1,
					mToatlCdnVIdList.get(i).y1, new Paint());
			canvas.drawBitmap(bitPic1, mToatlCdnVIdList.get(i).x2,
					mToatlCdnVIdList.get(i).y2, new Paint());
			// countforFinish++;
		}

	}
// reset
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
			getTouchedInfo(x, y);
			//current item select and initialize  then isTouched is true after is
			if (isTouched) {

				selectedItemId = currentItemId;
				selectedXPos = currentXPos;
				selectedYPos = currentYPos;
				touch_start(x, y);
				invalidate();
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if (isTouched) {
				touch_move(x, y);
				invalidate();
			}
			break;
		case MotionEvent.ACTION_UP:
			if (isTouched) {
				getTouchedInfo(x, y);
				if (isTouched) {

					// select item first show green
					if (selectedItemId == currentItemId
							&& selectedXPos != currentXPos) {

						selectedColor = Color.parseColor("#7d80ff80");// green
						setMusic();
						touch_up();
						if (!mCorrectIDList.contains(selectedItemId)) {
							mCorrectIDList.add(selectedItemId);
							count++;

						}

						if (count == mToatlCdnVIdList.size()) {
							// Reaz counter
							// setMusic();
							if (SharedPreferenceHelper.getBoolean(context,
									IDContainer.CHECK_SOUND)) {
								setMusic();

							}

							for (MappingContent content : mWrongPosList) {
								Canvas c = new Canvas(mBitmap);
								Paint paint = getPaintFormat();
								paint.setXfermode(new PorterDuffXfermode(
										PorterDuff.Mode.DST_OUT));
								paint.setMaskFilter(new EmbossMaskFilter(
										new float[] { 1, 1, 1 }, 0.2f, 10, 8.2f));
								c.drawLine(content.x1 + imageSize / 2,
										content.y1 + imageSize / 2, content.x2
												+ imageSize / 2, content.y2
												+ imageSize / 2, paint);

							}
							// after finish positive answer
							if(MyCounter.counter2==5){
								Feedback_alertBuilder.makerDialog(context, ((Activity) context));
								setMusic2();
							}else {
								Feedback_alertBuilder2.makerDialog(context, ((Activity) context));
								setMusic2();
							}
							
						
						}

					} else if (selectedXPos == currentXPos) {
						selectedColor = Color.TRANSPARENT;

					}

					else {
						// wrong answer
						selectedColor = Color.parseColor("#7dff5555");
						// selectedColor = Color.parseColor("#7dff5555"); // red
						mWrongPosList.add(new MappingContent(currentItemId,
								selectedXPos, selectedYPos, currentXPos,
								currentYPos));
						touch_up();
						// resetPain();
					}
				} else {
					selectedColor = Color.TRANSPARENT;

				}
				// touch_up();
				resetPain();
				invalidate();

			}
			break;
		}
		return true;
	}

	private void getTouchedInfo(float x, float y) {
		// id,x,y  initialize  for current item
		for (MappingContent content : mToatlCdnVIdList) {
			if (x >= content.x1 && x <= content.x1 + imageSize
					&& y >= content.y1 && y <= content.y1 + imageSize) {
				isTouched = true;
				currentItemId = content.id;
				currentXPos = content.x1;
				currentYPos = content.y1;
				break;

			} else if (x >= content.x2 && x <= content.x2 + imageSize
					&& y >= content.y2 && y <= content.y2 + imageSize) {
				isTouched = true;
				currentItemId = content.id;
				currentXPos = content.x2;
				currentYPos = content.y2;
				break;

			} else {
				isTouched = false;
			}
		}
	}

	private void setMusic() {
		// TODO Auto-generated method stub
		Log.e("Checking", "Start Music");
		try {
			Log.e("Checking", "Reset MediaPlayer");
			mPlayer.reset();
			Log.e("Checking", "Initialize MediaPlayer");
			mPlayer = MediaPlayer.create(context, R.raw.positivebell_short2);
			Log.e("Checking", "Prepare MediaPlayer");
			// mPlayer.prepare();
			Log.e("Checking", "Start MediaPlayer");
			mPlayer.start();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// mPlayer.setOnCompletionListener(new OnCompletionListener() {
		//
		// @Override
		// public void onCompletion(MediaPlayer arg0) {
		// // TODO Auto-generated method stub
		// arg0.stop();
		// arg0.release();
		// }
		// });

		// countforFinish++;

	}

}