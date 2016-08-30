package com.example.piktotestmap.utils;



import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.piktotestmap.MyCounter;
import com.example.piktotestmap.R;
import com.example.piktotestmap.SMLetterMappingActivity;
import com.example.piktotestmap.SMLetterMappingActivity.DataLoader;
import com.example.piktotestmap.drawing.PanelMapping;



public class Feedback_alertBuilder2 {
	public static void makerDialog(Context ctx, final Activity activity) {

		final Dialog dialog = new Dialog(ctx,R.style.CustomAlertDialog);
		// R.style.CustomAlertDialog);
	
		dialog.setCancelable(false);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.feed_back_layout);
		
		final Button no_bt = (Button) dialog.findViewById(R.id.dialog_no);
		final Button yes_bt = (Button) dialog.findViewById(R.id.dialog_yes);
		ImageView imageView = (ImageView) dialog
				.findViewById(R.id.dialogImageView);
		
		yes_bt.setText("Continue");
		yes_bt.setGravity(Gravity.RIGHT);
		
		no_bt.setVisibility(View.INVISIBLE);
		
		Animation shake=AnimationUtils.loadAnimation(ctx,
                R.anim.shake_anim);

		yes_bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				MyCounter.counter2++;
				System.out.println("Counter refreshDialog: " + MyCounter.counter2);
				Handler mHandler = new Handler();
				Runnable mRunnable = new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						// mPlayer.release();
						
						
						SMLetterMappingActivity.mapLayout
								.removeAllViews();
						SMLetterMappingActivity.mapLayout
								.addView(new PanelMapping(activity));
						// countforFinish++;
					}

				};
				mHandler.postDelayed(mRunnable, 500);
			//	new DataLoader().execute();
//				Context	 ac=(Context)activity;
//				//ac.resetPictures_and_Text();
//				activity.finish();
			}
		});

		no_bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				dialog.dismiss();
				
		     Context	 ac=(Context)activity;
		//ac.resetPictures_and_Text();
				activity.finish();
			}
		});

		dialog.show();
		imageView.setAnimation(shake);
	}
	
	
	
}
