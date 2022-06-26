package qz.receiver;

import android.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
// import com.itsaky.androidide.logsender.LogSender;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import qz.receiver.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // Remove this line if you don't want AndroidIDE to show this app's logs
    // LogSender.startLogging(this);

    super.onCreate(savedInstanceState);
    // Inflate and get instance of binding
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    // set content view to binding's root
    setContentView(binding.getRoot());

    Intent intent = getIntent();
    String action = intent.getAction();
    String type = intent.getType();

    binding.type.setText("Mimetype: " + type);
    binding.actions.setText("Action: " + action.toString());
    try {
      dataReader(intent.getData());
    } catch (Exception e) {
      setResult(e.toString());
    }
  }

  void setResult(String s) {
    binding.result.setText(s);
  }
  void setAppend(String s){
      binding.result.append(s);
      }
  void dataReader(Uri uri) {
    BufferedReader br;
    FileOutputStream fos;
    try {
      br = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(uri)));
      String line;
      while ((line = br.readLine()) != null) {
        setAppend(line + "\n");
      }

    } catch (IOException e) {
      setAppend(e.toString());
    }
  }
}
