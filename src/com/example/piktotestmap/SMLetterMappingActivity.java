package com.example.piktotestmap;



import android.app.Activity;
import android.media.AudioManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.piktotestmap.drawing.PanelMapping;
import com.example.piktotestmap.utils.Feedback_alertBuilder2;

public class SMLetterMappingActivity extends Activity implements
		OnClickListener {

	public static LinearLayout mapLayout;
	PanelMapping panel;
	private Button btnRefresh;
	
	public static int screenheight, screenwidth;
	private double density;

	public static int galleryBitmapSize, mappingLettersize, mappingPicSize;

//	int counter=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_smlettermapping);
		calculateDisplaySize();
		initWidget();
		
		System.out.println("myHellow"+MyCounter.counter);
//		if (MyCounter.counter == 5) {
//			MyCounter.counter=0;
//			Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_LONG).show();
//			finish();
//
//		}
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		MyCounter.counter2=0;
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		MyCounter.counter2=0;
	}
	public void calculateDisplaySize() {
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenheight = metrics.heightPixels;
		screenwidth = metrics.widthPixels;
		density = getDensity(metrics.density);
		double x = Math.pow(metrics.widthPixels / density, 2);
		double y = Math.pow(metrics.heightPixels / density, 2);
		double screenInches = Math.sqrt(x + y);
		setBitmapSampleSize(screenInches);


	}

	public double getDensity(double density) {

		double densityy = density * 160;

		// if (density < 1) {
		// densityy = density * 120;
		// } else if (density >= 1 && density < 1.5) {
		// densityy = density * 160;
		// } else if (density >= 1.5 && density < 2) {
		// densityy = density * 145;
		// } else if (density >= 2 && density < 3) {
		// densityy = density * 155;
		// } else if (density >= 3 && density < 4) {
		// densityy = density * 130;
		// } else if (density >= 4) {
		// densityy = density * 90;
		// }else{
		// densityy = density * 160;
		// }

		return densityy;

	}

	public void setBitmapSampleSize(Double screensizeInch) {
		if (screensizeInch > 6) {
			galleryBitmapSize = 1;
			mappingLettersize = 1;
			mappingPicSize = 1;
		} else if (screensizeInch < 6 && screensizeInch > 4.9) {
			galleryBitmapSize = 2;
			mappingLettersize = 1;
			mappingPicSize = 2;
		} else if (screensizeInch < 4.9) {
			galleryBitmapSize = 3;
			mappingLettersize = 2;
			mappingPicSize = 3;
		} else {
			galleryBitmapSize = 1;
			mappingLettersize = 1;
			mappingPicSize = 1;
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		System.gc();
		super.onBackPressed();
	}



	private void initWidget() {
		// TODO Auto-generated method stub
		
		
		mapLayout = (LinearLayout) findViewById(R.id.layoutmapping);
		btnRefresh = (Button) findViewById(R.id.refreshbtn);
		btnRefresh.setVisibility(View.INVISIBLE);
		btnRefresh.setOnClickListener(this);
		int buttonSize = (int) (screenheight / 6.4);
		btnRefresh.getLayoutParams().height = buttonSize;
		btnRefresh.getLayoutParams().width = buttonSize;
		
		
		panel = new PanelMapping(SMLetterMappingActivity.this);
		
		// mapLayout.addView(panel);
		new DataLoader().execute();

	}



@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	if (v.getId() == R.id.refreshbtn) {
		//v.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
		try {
			mapLayout.removeAllViews();
		} catch (Exception e) {

		} finally {
			panel = new PanelMapping(this);
			new DataLoader().execute();
		}
		// mapLayout.addView(panel);

	}

}



@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
	switch (keyCode) {
	case KeyEvent.KEYCODE_VOLUME_UP:
		audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
				AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
		return true;
	case KeyEvent.KEYCODE_VOLUME_DOWN:
		audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
				AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
		return true;
	case KeyEvent.KEYCODE_BACK:
		onBackPressed();
		return true;
	default:
		return false;
	}
}

public class DataLoader extends AsyncTask<Void, Void, Void> {

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
	}

	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("I am called");
				
				mapLayout.addView(panel);
			   int a=MyCounter.counter;
			   System.out.println("I am called"+a);
			   
			
			}
		});

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}
}

}

