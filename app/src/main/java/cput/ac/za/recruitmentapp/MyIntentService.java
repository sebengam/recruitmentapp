package cput.ac.za.recruitmentapp;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Tank on 5/31/2016.
 */
public class

MyIntentService extends IntentService
{
    private static final String TAG = "service one";
    @Override
    protected void onHandleIntent(Intent arg0)
    {
        Log.i(TAG,"Intent service started");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "Service onStartCommand " + startId);

        final int currentId = startId;

        Runnable r = new Runnable() {
            public void run() {

                for (int i = 0; i < 3; i++)
                {
                    long endTime = System.currentTimeMillis() +
                            10*1000;

                    while (System.currentTimeMillis() < endTime) {
                        synchronized (this) {
                            try {
                                wait(endTime -
                                        System.currentTimeMillis());
                            } catch (Exception e) {
                            }
                        }
                    }
                    Log.i(TAG, "Service running " + currentId);
                }
                stopSelf();
            }
        };

        Thread t = new Thread(r);
        t.start();
        return Service.START_STICKY;
    }

    public  MyIntentService()
    {
        super("MyIntentService");
    }
}
