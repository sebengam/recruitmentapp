package cput.ac.za.recruitmentapp.factory.settings;

/**
 * Created by Tank on 4/21/2016.
 */
import cput.ac.za.recruitmentapp.domain.settings.Settings;

public class SettingsFactory {

    public static Settings getSettings(String email, String orgCode, String password) {
        return new Settings.Builder()
                .username(email)
                .password(password)
                .code(orgCode)
                .build();


    }
}
