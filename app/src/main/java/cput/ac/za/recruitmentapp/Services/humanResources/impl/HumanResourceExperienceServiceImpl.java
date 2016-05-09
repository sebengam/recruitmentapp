package cput.ac.za.recruitmentapp.Services.humanResources.impl;

import android.app.IntentService;

import cput.ac.za.recruitmentapp.Services.humanResources.HumanResourceExperienceService;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceExperienceRepository;

/**
 * Created by Tank on 5/7/2016.
 */
public class HumanResourceExperienceServiceImpl extends IntentService implements HumanResourceExperienceService
{

    private final HumanResourceExperienceAPI api;
    private final HumanResourceExperienceRepository repo;

    public static final String ACTION_ADD = "zm.hashcode.hashdroidpvt.services.person.Impl.action.ADD";
    public static final String ACTION_UPDATE = "zm.hashcode.hashdroidpvt.services.person.Impl.action.UPDATE";

    public static final String EXTRA_ADD = "zm.hashcode.hashdroidpvt.services.person.Impl.extra.ADD";
    public static final String EXTRA_UPDATE = "zm.hashcode.hashdroidpvt.services.person.Impl.extra.UPDATE";

    private static PersonContactServiceImpl service = null;

    public static PersonContactServiceImpl getInstance() {
        if (service == null)
            service = new PersonContactServiceImpl();
        return service;
    }

    private PersonContactServiceImpl() {
        super("PersonContactServiceImpl");
        api = new PersonContactAPIImpl();
        repo = new PersonContactRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addPersonContact(Context context, PersonContact contact) {
        Intent intent = new Intent(context, PersonContactServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_UPDATE, contact);
        context.startService(intent);

    }

    @Override
    public void updatePersonContact(Context context, PersonContact contact) {
        Intent intent = new Intent(context, PersonContactServiceImpl.class);
        intent.setAction(ACTION_UPDATE);
        intent.putExtra(EXTRA_UPDATE, contact);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final PersonContact personContact = (PersonContact) intent.getSerializableExtra(EXTRA_ADD);
                postContact(personContact);
            } else if (ACTION_UPDATE.equals(action)) {
                final PersonContact personContact = (PersonContact) intent.getSerializableExtra(EXTRA_UPDATE);
                updateContact(personContact);
            }
        }
    }

    private void updateContact(PersonContact personContact) {
        //REMOTE UPADTE AND LOCAL UPDATE
        try {
            PersonContact updatedContact = api.updatePersonContact(personContact);
            repo.save(updatedContact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void postContact(PersonContact personContact) {
        //POST AND LOCAL SAVE
        try {
            PersonContact createdContact = api.createPersonContact(personContact);
            repo.save(createdContact);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
