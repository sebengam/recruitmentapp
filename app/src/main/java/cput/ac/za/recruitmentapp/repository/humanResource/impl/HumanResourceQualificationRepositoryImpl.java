package cput.ac.za.recruitmentapp.repository.humanResource.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import cput.ac.za.recruitmentapp.conf.database.DBConstants;
import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceLocation;
import cput.ac.za.recruitmentapp.domain.humanResource.HumanResourceQualification;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceQualificationRepository;

/**
 * Created by Tank on 5/6/2016.
 */
public class HumanResourceQualificationRepositoryImpl  extends SQLiteOpenHelper implements HumanResourceQualificationRepository
{
    public static final String TABLE_NAME = "HumanResource";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_INSTITUTION = "institution";
    public static final String COLUMN_HIGHESTQUALIFICATION = "qualification";
    public static final String COLUMN_YEAR= "year";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_INSTITUTION + " TEXT  NOT NULL , "
            + COLUMN_HIGHESTQUALIFICATION + " TEXT " + " NOT NULL , "
            + COLUMN_YEAR + " TEXT NOT NULL ,";

    public HumanResourceQualificationRepositoryImpl(Context context)
    {
        super(context, DBConstants.DATABASE_NAME,null,DBConstants.DATABASE_VERSION);
    }

    public void open()throws SQLException
    {
        db = this.getWritableDatabase();
    }

    public void close()
    {
        this.close();
    }

    @Override
    public HumanResourceQualification findById(Long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_INSTITUTION,
                        COLUMN_HIGHESTQUALIFICATION,
                        COLUMN_YEAR,},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final HumanResourceQualification humanResource = new HumanResourceQualification.Builder()

                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .institution(cursor.getString(cursor.getColumnIndex(COLUMN_INSTITUTION)))
                    .highestQualification(cursor.getString(cursor.getColumnIndex(COLUMN_HIGHESTQUALIFICATION)))
                    .year(cursor.getString(cursor.getColumnIndex(COLUMN_YEAR)))
                    .build();
            return humanResource;
        }
        else{
            return null;
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_CREATE);
    }



        @Override
        public HumanResourceQualification save(HumanResourceQualification entity)
        {
            open();
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, entity.getId());
            values.put(COLUMN_INSTITUTION, entity.getInstitution());
            values.put(COLUMN_HIGHESTQUALIFICATION, entity.getHighestQualification());
            values.put(COLUMN_YEAR, entity.getYear());

            long id = db.insertOrThrow(TABLE_NAME, null, values);
            HumanResourceQualification insertedEntity = new HumanResourceQualification.Builder()
                    .copy(entity)
                    .id(new Long(id))
                    .build();
            return insertedEntity;

        }

    @Override
    public HumanResourceQualification update(HumanResourceQualification entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_INSTITUTION, entity.getInstitution());
        values.put(COLUMN_HIGHESTQUALIFICATION, entity.getHighestQualification());
        values.put(COLUMN_YEAR, entity.getYear());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public HumanResourceQualification delete(HumanResourceQualification entity)
    {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;


    }

    @Override
    public Set<HumanResourceQualification> findAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<HumanResourceQualification> hr = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final HumanResourceQualification humanResource  = new HumanResourceQualification.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .institution(cursor.getString(cursor.getColumnIndex(COLUMN_INSTITUTION)))
                        .highestQualification(cursor.getString(cursor.getColumnIndex(COLUMN_HIGHESTQUALIFICATION)))
                        .year(cursor.getString(cursor.getColumnIndex(COLUMN_YEAR)))
                        .build();
                hr.add(humanResource);
            } while (cursor.moveToNext());
        }
        return hr;

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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);


    }

}

