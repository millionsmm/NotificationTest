package activitytest.example.com.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import java.io.File;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice=(Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.send_notice:
                        NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);//获取NotificationManager
                        NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this);//创建NotificationCompat.Builder
                        Intent intent =new Intent(MainActivity.this,NotificationActivity.class);
                        PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                        builder.setContentIntent(pi);
                        builder.setSmallIcon(R.drawable.ic_launcher);//图标
                        builder.setTicker("You have a  new message");//瞬时一过的信息
                        builder.setWhen(System.currentTimeMillis());//瞬时显示时间
                        builder.setContentTitle("This is title");//标题
                        builder.setContentText("This is text");//内容
                        builder.setAutoCancel(true);//允许消失

                        Notification notification=builder.build();//使用Builder创建通知 注意位置！
                        notification.defaults=Notification.DEFAULT_ALL;

                        manager.notify(1,notification);//显示一个通知


                        break;
                    default:
                        break;
                }
            }
        });
    }
}
