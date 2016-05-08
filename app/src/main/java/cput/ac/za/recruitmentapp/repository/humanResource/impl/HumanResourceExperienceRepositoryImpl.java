package cput.ac.za.recruitmentapp.repository.humanResource.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import cput.ac.za.recruitmentapp.conf.database.DBConstants;
import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceExperience;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceExperienceRepository;


/**
 * Created by Tank on 4/24/2016.
 */

public class HumanResourceExperienceRepositoryImpl extends SQLiteOpenHelper implements HumanResourceExperienceRepository
{
    public static final String TABLE_NAME = "HumanResourceExperience";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_COMPANYNAME = "companyName";
    public static final String COLUMN_DUTIES = "duties";
    public static final String COLUMN_STARTDATE = "startDate";
    public static final String COLUMN_ENDDATE = "endDate";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_COMPANYNAME + " TEXT NOT NULL , "
            + COLUMN_DUTIES + " TEXT NOT NULL , "
            + COLUMN_STARTDATE + " TEXT NOT NULL ,"
            + COLUMN_ENDDATE + " TEXT NOT NULL );";

   //private HumanResourceExperience entity;

    public HumanResourceExperienceRepositoryImpl(Context context)
    {
        super(context, DBConstants.DATABASE_NAME,null,DBConstants.DATABASE_VERSION);
    }

    public void open ()throws android.database.SQLException
    {
            db = this.getWritableDatabase();
    }

    public void close()
    {
        this.close();
    }

    @Override
    public HumanResourceExperience findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_COMPANYNAME,
                        COLUMN_DUTIES,
                        COLUMN_STARTDATE,
                        COLUMN_STARTDATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final HumanResourceExperience humanResourceExperience = new HumanResourceExperience.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .companyName(cursor.getString(cursor.getColumnIndex(COLUMN_COMPANYNAME)))
                    .duties(cursor.getString(cursor.getColumnIndex(COLUMN_DUTIES)))
                    .startDate(cursor.getString(cursor.getColumnIndex(COLUMN_STARTDATE)))
                    .endDate(cursor.getString(cursor.getColumnIndex(COLUMN_ENDDATE)))
                    .build();
            return humanResourceExperience;
        } else {

            return null;
        }
    }

    @Override
    public HumanResourceExperience save(HumanResourceExperience entity)
    {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_COMPANYNAME, entity.getCompanyName());
        values.put(COLUMN_DUTIES, entity.getDuties());
        values.put(COLUMN_STARTDATE, entity.getStartDate());
        values.put(COLUMN_ENDDATE, entity.getEndDate());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        HumanResourceExperience insertedEntity = new HumanResourceExperience.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;

    }

    @Override
    public HumanResourceExperience update(HumanResourceExperience entity)
    {

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_COMPANYNAME, entity.getCompanyName());
        values.put(COLUMN_DUTIES, entity.getDuties());
        values.put(COLUMN_STARTDATE, entity.getStartDate());
        values.put(COLUMN_ENDDATE, entity.getEndDate());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public HumanResourceExperience delete(HumanResourceExperience entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<HumanResourceExperience> findAll()
    {

        SQLiteDatabase db = this.getReadableDatabase();
        Set<HumanResourceExperience> hRExperience = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final HumanResourceExperience humanResourceExp = new HumanResourceExperience.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .companyName(cursor.getString(cursor.getColumnIndex(COLUMN_COMPANYNAME)))
                        .duties(cursor.getString(cursor.getColumnIndex(COLUMN_DUTIES)))
                        .startDate(cursor.getString(cursor.getColumnIndex(COLUMN_STARTDATE)))
                        .endDate(cursor.getString(cursor.getColumnIndex(COLUMN_ENDDATE)))
                        .build();
                hRExperience.add(humanResourceExp);
            } while (cursor.moveToNext());
        }
        return hRExperience;

    }




    @Override
    public int deleteAll()
    {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;

    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
             db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
                Log.w(this.getClass().getName(),
                        "Upgrading database from version " + oldVersion + " to "
                                + newVersion + ", which will destroy all old data");
                db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                onCreate(db);
    }

}
