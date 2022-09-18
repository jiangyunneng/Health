package cn.njcit.p02_2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.hngc.activity.MainActivity;
import com.hngc.activity.R;

public class SplashActivity extends AppCompatActivity {


    private Handler handler = new Handler();
    private Runnable runnableToMainActivity= new Runnable() {
        @Override
        public void run() {
            toMainActivity();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags
                (WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(runnableToMainActivity,5000);
    }
    /**
     * 跳转到主界面
     */
    private void toMainActivity() {
        
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄漏
        handler.removeCallbacks(runnableToMainActivity);
    }
}
