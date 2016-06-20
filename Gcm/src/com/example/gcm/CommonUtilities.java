package com.example.gcm;

import android.content.Context;
import android.content.Intent;

public final class CommonUtilities {

	// give your server registration url here
	// static final String SERVER_URL =
	// "http://10.0.2.2/gcm_server_php/register.php";
	// static final String SERVER_URL =
	// "http://parkhya.org/test/GCM/register.php";
	// Google project id
	// public static final String SENDER_ID = "700079896076";
	 public static final String SENDER_ID = "192505512966";
	// public static final String SENDER_ID = "853059873688";
	//public static final String SENDER_ID = "853059873688";

	// 617151409471
	// api_key=AIzaSyD2bszNVm8ogLzviz6AIGnaJDPOyNlJJBQ

	/**
	 * Tag used on log messages.
	 */
	static final String TAG = "Security App";
	public static final String DISPLAY_MESSAGE_ACTION = "com.example.gcm.DISPLAY_MESSAGE";
	public static final String EXTRA_MESSAGE = "message";

	/**
	 * Notifies UI to display a message.
	 * <p>
	 * This method is defined in the common helper because it's used both by the
	 * UI and the background service.
	 * 
	 * @param context
	 *            application's context.
	 * @param message
	 *            message to be displayed.
	 */

	public static void displayMessage(Context context, String message) {
		Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
		intent.putExtra(EXTRA_MESSAGE, message);
		context.sendBroadcast(intent);
	}
}
