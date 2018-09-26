package other;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by sdl on 2018/9/26.
 */
public class ReceiverMsg extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("phone", "onReceive: 收到广播,action->" + intent.getAction());
        //拿到传来过来数据
        String msg = intent.getStringExtra("msg");
        //拿到锁屏管理者
        KeyguardManager km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        if (km == null) {
            return;
        }
        Log.e("phone", "km->" + km.isKeyguardLocked() + "，msg->" + msg);
//        if (km.isKeyguardLocked())
        {   //为true就是锁屏状态下
            //启动Activity
            Intent alarmIntent = new Intent(context, PhoneActivity.class);
            //携带数据
            alarmIntent.putExtra("msg", msg == null ? "null_msg" : msg);
            //activity需要新的任务栈
            alarmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            context.startActivity(alarmIntent);
        }

    }
}
