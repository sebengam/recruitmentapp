package cput.ac.za.recruitmentapp.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.test.AndroidTestCase;

import junit.framework.Assert;

import cput.ac.za.recruitmentapp.conf.util.App;
import cput.ac.za.recruitmentapp.services.humanResource.HumanResourceExperienceService;
import cput.ac.za.recruitmentapp.services.humanResource.impl.HumanResourceExperienceServiceImpl;


/**
 * Created by hashcode on 2016/04/25.
 */
public class HumanResourceExperienceServiceTest extends AndroidTestCase {
    private HumanResourceExperienceServiceImpl humanResourceExperienceService;
    private boolean isBound;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(App.getAppContext(), HumanResourceExperienceServiceImpl.class);
        App.getAppContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);


    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            HumanResourceExperienceServiceImpl.ActivateServiceLocalBinder binder
                    = (HumanResourceExperienceServiceImpl.ActivateServiceLocalBinder) service;
            humanResourceExperienceService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;

        }
    };

    public void testActivateAccount() throws Exception {
        String activate = humanResourceExperienceService.activateAccount("bonifae@test.com", "test");
        Assert.assertEquals("ACTIVATED", activate);

    }

    public void testIsAccountActivated() throws Exception {
        Boolean activated = HumanResourceExperienceService.isAccountActivated();
        Assert.assertTrue("ACTIVATED", activated);

    }

    public void testDeactivateAccount() throws Exception {
        Boolean deactivated = humanResourceExperienceService.deactivateAccount();
        Assert.assertTrue("ACTIVATED", deactivated);

    }




}
