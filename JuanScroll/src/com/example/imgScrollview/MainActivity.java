package com.example.imgScrollview;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.dampview.R;
import com.example.imgScrollview.ImageViewScroll.OnRefreshLister;

public class MainActivity extends Activity {
	private ImageView img;
	private ProgressBar bar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupView();
	}

	public void setupView() {
		bar=(ProgressBar)findViewById(R.id.bar);
		img = (ImageView) findViewById(R.id.img);
		ImageViewScroll view = (ImageViewScroll) findViewById(R.id.dampview);
		view.setImageView(img);
		view.setOnRefreshListner(new OnRefreshLister() {
			
			@Override
			public void onRefresh() {
				new AsyncTask<String , Integer, String>() {

					@Override
					protected String doInBackground(String... arg0) {
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return null;
					}

					@Override
					protected void onPostExecute(String result) {
						bar.setVisibility(View.GONE);
						super.onPostExecute(result);
					}

					@Override
					protected void onPreExecute() {
						bar.setVisibility(View.VISIBLE);
						super.onPreExecute();
					}
					
					
				}.execute();
				
				
			
			}
		});
	}
	
	public void onImgClick(View view){
		Toast.makeText(this, "单击背景", Toast.LENGTH_SHORT).show();
	}
	
	public void onPhotoClick(View view){
		Toast.makeText(this, "单击图像", Toast.LENGTH_SHORT).show();
	}

}
