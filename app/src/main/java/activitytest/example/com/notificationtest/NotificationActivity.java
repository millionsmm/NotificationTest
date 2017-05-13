package activitytest.example.com.notificationtest;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2017/3/12 0012.
 */

public class NotificationActivity extends Activity {
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.notification_layout);
    }
}
