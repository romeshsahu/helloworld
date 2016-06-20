package com.example.gcm;


import com.google.android.gcm.GCMRegistrar;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	private String gcmRegId="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//registerClient();
	}


	private void registerClient() {

		try {
			GCMRegistrar.checkDevice(MainActivity.this);
			GCMRegistrar.checkManifest(MainActivity.this);

			registerReceiver(mHandleMessageReceiver, new IntentFilter(
					CommonUtilities.DISPLAY_MESSAGE_ACTION));

			gcmRegId = GCMRegistrar.getRegistrationId(MainActivity.this);
			Log.v("REG ID", gcmRegId);

			if (gcmRegId.equals("")) {
				GCMRegistrar.register(MainActivity.this,
						CommonUtilities.SENDER_ID);
				Log.v("REG ID IN IF", gcmRegId);
			} else {
				if (GCMRegistrar.isRegisteredOnServer(MainActivity.this)) {
					// regId = GCMRegistrar.getRegistrationId(this);
					System.out.println("GCM Register on server" + gcmRegId);
				} else {
					GCMRegistrar
							.setRegisteredOnServer(MainActivity.this, true);
				}
			}

			//GpsService.gcmId = gcmRegId;
			Log.v("", "Already registered:  " + gcmRegId);

		} catch (UnsupportedOperationException e) {
			Log.v("JCv", "No GCM");
		}

	}

	private final BroadcastReceiver mHandleMessageReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String newMessage = intent.getExtras().getString(
					CommonUtilities.EXTRA_MESSAGE);
			System.out.println("FUCK THIS SHIT");
		}

	};

}
