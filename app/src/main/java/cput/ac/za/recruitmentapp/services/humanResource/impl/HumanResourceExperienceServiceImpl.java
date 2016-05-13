package cput.ac.za.recruitmentapp.services.humanResource.impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;

import cput.ac.za.recruitmentapp.conf.util.App;
import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceExperience;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceExperienceRepository;
import cput.ac.za.recruitmentapp.repository.humanResource.impl.HumanResourceExperienceRepositoryImpl;
import cput.ac.za.recruitmentapp.restApi.humanResource.api.HumanResourceExperienceAPI;
import cput.ac.za.recruitmentapp.restApi.humanResource.api.impl.HumanResourceExperienceAPIImpl;
import cput.ac.za.recruitmentapp.services.humanResource.HumanResourceExperienceService;

/**
 * Created by Tank on 5/12/2016.
 */
public class HumanResourceExperienceServiceImpl extends IntentService implements HumanResourceExperienceService
{
    private HumanResourceExperienceAPI api = null;
    private HumanResourceExperienceRepository repo = null;

    private static final String ACTION_ADD = "cput.ac.za.recruitmentapp.services.impl.action.ADD";
    private static final String ACTION_UPDATE = "cput.ac.za.recruitmentapp.services.impl.action.UPDATE";

    private static final String EXTRA_ADD = "cput.ac.za.recruitmentapp.services.impl.action.ADD";
    private static final String EXTRA_UPDATE = "cput.ac.za.recruitmentapp.services.impl.action.UPDATE";



   private static HumanResourceExperienceServiceImpl service = null;

    public static HumanResourceExperienceServiceImpl getInstance()
    {
        return service;

    }

    private HumanResourceExperienceServiceImpl()
    {
        super("HumanResourceExperienceServiceImpl");
        api = new HumanResourceExperienceAPIImpl() {
            @Override
            public HumanResourceExperience createHumanResourceExperience(HumanResourceExperience address) throws IOException {
                return null;
            }

            @Override
            public HumanResourceExperience updateHumanResourceExperince(HumanResourceExperience address) throws IOException {
                return null;
            }
        };
        repo = new HumanResourceExperienceRepositoryImpl(App.getAppContext());
    }




    @Override
    public void addHumanResourceExperience(Context context, HumanResourceExperience experience)
    {
        Intent intent = new Intent(context, HumanResourceExperienceServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, experience);
        context.startService(intent);
    }

    @Override
    public void updateHumanResourceExperience(Context context, HumanResourceExperience experience) {
        Intent intent = new Intent(context, HumanResourceExperienceServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, experience);
        context.startService(intent);
    }




    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null)
        {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action))
            {
                final HumanResourceExperience humanResourceExperience = (HumanResourceExperience) intent.getSerializableExtra(EXTRA_ADD);
                postHumanResourceExperience(humanResourceExperience);
            } else if (ACTION_UPDATE.equals(action))
            {
                final HumanResourceExperience humanResourceExperience = (HumanResourceExperience) intent.getSerializableExtra(EXTRA_UPDATE);
                updateHumanResourceExperience(humanResourceExperience);
            }
        }
    }


    private void updateHumanResourceExperience(HumanResourceExperience humanResourceExperience) {
        //POST and Save Local
        try {
            HumanResourceExperience updatedHumanResourceExperience = api.updateHumanResourceExperince(humanResourceExperience);
            repo.save(updatedHumanResourceExperience);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postHumanResourceExperience(HumanResourceExperience humanResourceExperience) {
        //POST and Save Local
        try {
            HumanResourceExperience createdAddress = api.createHumanResourceExperience(humanResourceExperience);
            repo.save(createdAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
