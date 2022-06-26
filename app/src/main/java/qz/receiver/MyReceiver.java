package qz.receiver;
import android.content.*;

abstract class MyReceiver extends BroadcastReceiver{
    public static final String TAG = "MyReceiver";
    @Override
    public void onReceive(Context arg0, Intent arg1) {
        // TODO: Implement this method
        StringBuilder mystrings = new StringBuilder();
        mystrings.append("Action: " + arg1.getAction()+"\n");
        mystrings.append("URI: "+arg1.toUri(Intent.URI_INTENT_SCHEME).toString());
    }
}
