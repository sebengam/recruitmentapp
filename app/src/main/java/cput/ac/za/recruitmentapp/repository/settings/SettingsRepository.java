package cput.ac.za.recruitmentapp.repository.settings;


import android.database.sqlite.SQLiteDatabase;

import cput.ac.za.recruitmentapp.domain.settings.Settings;
import cput.ac.za.recruitmentapp.repository.Repository;

/**
 * Created by hashcode on 2016/04/09.
 */
public interface SettingsRepository extends Repository<Settings,Long> {
    void onCreate(SQLiteDatabase db);

    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
}
