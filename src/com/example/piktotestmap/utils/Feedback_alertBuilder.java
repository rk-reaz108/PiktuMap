package com.example.piktotestmap.utils;



import com.example.piktotestmap.MyCounter;
import com.example.piktotestmap.R;
import com.example.piktotestmap.SMLetterMappingActivity;
import com.example.piktotestmap.drawing.PanelMapping;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Feedback_alertBuilder {

	public static void makerDialog(Context ctx, final Activity activity) {

		final Dialog dialog = new Dialog(ctx,R.style.CustomAlertDialog);
		// R.style.CustomAlertDialog);

		
		
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(R.layout.feed_back_layout);
		dialog.setCancelable(false);
		
		final Button no_bt = (Button) dialog.findViewById(R.id.dialog_no);
		final Button yes_bt = (Button) dialog.findViewById(R.id.dialog_yes);
		ImageView imageView = (ImageView) dialog
				.findViewById(R.id.dialogImageView);
		
		Animation shake=AnimationUtils.loadAnimation(ctx,
                R.anim.shake_anim);

		yes_bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				activity.finish();
				MyCounter.counter2 = 0;
			}
		});

		no_bt.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SMLetterMappingActivity ac=(SMLetterMappingActivity)activity;
//				ac.resetGame();
//				ac.resetPictures_and_Text();
				MyCounter.counter2 = 0;
				dialog.dismiss();
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
			}
		});

		dialog.show();
		imageView.setAnimation(shake);
	}

}
