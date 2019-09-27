package other;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;

import com.sum.rvadapter.R;

/**
 * Created by sdl on 2018/9/26.
 */
public class PhoneActivity extends FragmentActivity {
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);


        setContentView(R.layout.activity_phone);

        String msg = getIntent().getStringExtra("msg");
        button = findViewById(R.id.btn_1);
        button.setText("onCreate->" + msg);
        button.setOnClickListener(v -> finish());

        Log.e("phone", "onCreate->" + msg);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("phone", "onResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String msg = intent.getStringExtra("msg");
        PowerManager pm = (PowerManager) this.getSystemService(Context.POWER_SERVICE);

        Log.e("phone", "onNewIntent->" + msg + "," + pm.isScreenOn());
        button.setText("onNewIntent->" + msg);

        if (!pm.isScreenOn()) {
            Log.e("phone", "又收到消息:" + msg);
            //点亮屏幕
            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP |
                    PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "bright");
            wl.acquire();
            wl.release();
        }
    }
}
