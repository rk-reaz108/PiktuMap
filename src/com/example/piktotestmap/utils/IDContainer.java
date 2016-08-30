package com.example.piktotestmap.utils;

import com.example.piktotestmap.R;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;

public class IDContainer {

	public static String CHECK_SOUND = "CHECK_SOUND";
	public static String DRAG_DROP_VOWEL = "DRAG_DROP_VOWEL";
	public static String DRAG_DROP_CONSONANT = "DRAG_DROP_CONSONANT";
	public static String MAPPING = "MAPPING";
	public static String ORDER_VOWEL = "ORDER_VOWEL";
	public static String ORDER_CONSONANT = "ORDER_CONSONANT";
	public static String HEAR_SELECTION = "HEAR_SELECTION";
	public static String WATCH_SELECTION = "WATCH_SELECTION";
	public static ProgressDialog progress;

	public static int[] mSoundVId = {};

	public static int[] mSoundCId = {};

	public static int[] mSoundReadID = {};

	public static int[] mSoundAllId = {};

	public static int[] mReadImageAllId = {};

	public static int[] mDrawImageAllId = {};

	public static int[] mLetterImageVId = {};

	public static int[] mLetterImageCId = {};

	public static int[] mLetterImageAllId = { R.drawable.a,
			R.drawable.img_letter_b, R.drawable.img_letter_c,
			R.drawable.img_letter_d, R.drawable.img_letter_e,
			R.drawable.img_letter_f, R.drawable.img_letter_g,
			R.drawable.img_letter_h, R.drawable.img_letter_i,
			R.drawable.img_letter_j, R.drawable.img_letter_k,
			R.drawable.img_letter_m, R.drawable.img_letter_n,
			R.drawable.img_letter_n1, R.drawable.img_letter_o,
			R.drawable.img_letter_p, R.drawable.img_letter_q,
			R.drawable.img_letter_r, R.drawable.img_letter_s,
			R.drawable.img_letter_t, R.drawable.img_letter_u,
			R.drawable.img_letter_v, R.drawable.img_letter_w,
			R.drawable.img_letter_x, R.drawable.img_letter_y, R.drawable.z,
			R.drawable.alarma, R.drawable.almohada, R.drawable.autobus_a,
			R.drawable.avion, R.drawable.aviones, R.drawable.azucarero,
			R.drawable.balon_de_baloncesto, R.drawable.bano,
			R.drawable.barco, R.drawable.barrendero, R.drawable.bicicleta,
			R.drawable.bola_de_bolos, R.drawable.bolas_de_billar,
			R.drawable.bombero, R.drawable.cafe, R.drawable.camion_trailer,
			R.drawable.cantante, R.drawable.carromato, R.drawable.casa_a,
			R.drawable.cepillo_a, R.drawable.cerdo, R.drawable.cerdo,
			R.drawable.chucherias, R.drawable.chucherias, R.drawable.coche,
			R.drawable.cocina_d, R.drawable.colegio, R.drawable.conserje,
			R.drawable.cuaderno, R.drawable.cuchara, R.drawable.cuchillo_w,
			R.drawable.ducha_w, R.drawable.ducha, R.drawable.enfermera,
			R.drawable.folios, R.drawable.espejo, R.drawable.folios,
			R.drawable.galletas_de_chocolate, R.drawable.gato_negro_a,
			R.drawable.gato, R.drawable.goma, R.drawable.gorila,
			R.drawable.grifo, R.drawable.helado };
	// public static int[] mLetterImageAllId = { R.drawable.a,
	// R.drawable.img_letter_b, R.drawable.img_letter_c };

	// public static int[] mMatchImageAllId = { R.drawable.a,
	// R.drawable.img_letter_b, R.drawable.img_letter_c };

	public static int[] mMatchImageAllId = { R.drawable.a,
		R.drawable.img_letter_b, R.drawable.img_letter_c,
		R.drawable.img_letter_d, R.drawable.img_letter_e,
		R.drawable.img_letter_f, R.drawable.img_letter_g,
		R.drawable.img_letter_h, R.drawable.img_letter_i,
		R.drawable.img_letter_j, R.drawable.img_letter_k,
		R.drawable.img_letter_m, R.drawable.img_letter_n,
		R.drawable.img_letter_n1, R.drawable.img_letter_o,
		R.drawable.img_letter_p, R.drawable.img_letter_q,
		R.drawable.img_letter_r, R.drawable.img_letter_s,
		R.drawable.img_letter_t, R.drawable.img_letter_u,
		R.drawable.img_letter_v, R.drawable.img_letter_w,
		R.drawable.img_letter_x, R.drawable.img_letter_y, R.drawable.z,
		R.drawable.alarma, R.drawable.almohada, R.drawable.autobus_a,
		R.drawable.avion, R.drawable.aviones, R.drawable.azucarero,
		R.drawable.balon_de_baloncesto, R.drawable.bano,
		R.drawable.barco, R.drawable.barrendero, R.drawable.bicicleta,
		R.drawable.bola_de_bolos, R.drawable.bolas_de_billar,
		R.drawable.bombero, R.drawable.cafe, R.drawable.camion_trailer,
		R.drawable.cantante, R.drawable.carromato, R.drawable.casa_a,
		R.drawable.cepillo_a, R.drawable.cerdo, R.drawable.cerdo,
		R.drawable.chucherias, R.drawable.chucherias, R.drawable.coche,
		R.drawable.cocina_d, R.drawable.colegio, R.drawable.conserje,
		R.drawable.cuaderno, R.drawable.cuchara, R.drawable.cuchillo_w,
		R.drawable.ducha_w, R.drawable.ducha, R.drawable.enfermera,
		R.drawable.folios, R.drawable.espejo, R.drawable.folios,
		R.drawable.galletas_de_chocolate, R.drawable.gato_negro_a,
		R.drawable.gato, R.drawable.goma, R.drawable.gorila,
		R.drawable.grifo, R.drawable.helado };

	// public static void showDialog(final Context context, int resource,
	// final String key) {
	// // TODO Auto-generated method stub
	// final Dialog instructionDialog = new Dialog(context);
	// instructionDialog.getWindow().setBackgroundDrawable(
	// new ColorDrawable(Color.TRANSPARENT));
	// instructionDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	// instructionDialog.setContentView(R.layout.smorder_dialog);
	// instructionDialog.setCancelable(true);
	// instructionDialog.show();
	// CheckBox checkBox = (CheckBox) instructionDialog
	// .findViewById(R.id.chekbox);
	// checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	// @Override
	// public void onCheckedChanged(CompoundButton buttonView,
	// boolean isChecked) {
	// if (isChecked) {
	// SharedPreferenceHelper.setBoolean(context, key, false);
	//
	// } else {
	// SharedPreferenceHelper.setBoolean(context, key, true);
	//
	// }
	// }
	// });
	// instructionDialog.findViewById(R.id.btncross).setOnClickListener(
	// new View.OnClickListener() {
	//
	// @Override
	// public void onClick(View v) {
	// // TODO Auto-generated method stub
	//
	// instructionDialog.cancel();
	// }
	// });
	//
	//
	// }

	public static Bitmap decodeSampledBitmapFromResource(Resources res,
			int resId, int samplesize) {
		// First decode with inJustDecodeBounds=true to check dimensions
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(res, resId, options);
		options.inSampleSize = samplesize;
		// options.inSampleSize=calculateInSampleSize(options, reqWidth,
		// reqHeight);
		// Decode bitmap with inSampleSize set
		options.inJustDecodeBounds = false;
		options.inPurgeable = true;
		options.inInputShareable = true;
		return BitmapFactory.decodeResource(res, resId, options);
	}

	public static int calculateInSampleSize(BitmapFactory.Options options,
			int reqWidth, int reqHeight) {
		// Raw height and width of image
		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;
		if (height > reqHeight || width > reqWidth) {
			if (width > height) {
				inSampleSize = Math.round((float) height / (float) reqHeight);
			} else {
				inSampleSize = Math.round((float) width / (float) reqWidth);
			}
		}
		return inSampleSize;
	}

	public static void showDialog(Context mContext) {
		// progress = ProgressDialog.show(mContext, null, null);
		// progress.setContentView(R.layout.loader);

	}

	public static void cancelDialog() {
		progress.dismiss();
	}

}
