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
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceLocationRepository;

/**
 * Created by Tank on 5/6/2016.
 */
public class HumanResourceLocationRepositoryImpl  extends SQLiteOpenHelper implements HumanResourceLocationRepository
{
    public static final String TABLE_NAME = "HumanResourceLocation";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_STREET = "street";
    public static final String COLUMN_SURBURB = "surburb";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_PROVINCE = "province";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NUMBER + " TEXT  NOT NULL , "
            + COLUMN_STREET + " TEXT " + " NOT NULL , "
            + COLUMN_SURBURB + " TEXT NOT NULL ,"
            + COLUMN_CITY + " TEXT NOT NULL , "
            + COLUMN_PROVINCE + " TEXT NOT NULL );";


    public HumanResourceLocationRepositoryImpl(Context context)
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
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public HumanResourceLocation findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NUMBER,
                        COLUMN_STREET,
                        COLUMN_CITY,
                        COLUMN_PROVINCE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final HumanResourceLocation humanResourceLocation = new HumanResourceLocation.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .number(Double.parseDouble(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER))))
                    .street(cursor.getString(cursor.getColumnIndex(COLUMN_STREET)))
                    .city(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                    .province(cursor.getString(cursor.getColumnIndex(COLUMN_PROVINCE)))
                    .build();
            return humanResourceLocation;
        } else {

            return null;
        }
    }

    @Override
    public HumanResourceLocation save(HumanResourceLocation entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NUMBER, entity.getNumber());
        values.put(COLUMN_STREET, entity.getStreet());
        values.put(COLUMN_SURBURB, entity.getSurburb());
        values.put(COLUMN_CITY, entity.getCity());
        values.put(COLUMN_PROVINCE, entity.getProvince());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        HumanResourceLocation insertedEntity = new HumanResourceLocation.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;

    }

    @Override
    public HumanResourceLocation update(HumanResourceLocation entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NUMBER, entity.getNumber());
        values.put(COLUMN_STREET, entity.getStreet());
        values.put(COLUMN_SURBURB, entity.getSurburb());
        values.put(COLUMN_CITY, entity.getCity());
        values.put(COLUMN_PROVINCE, entity.getProvince());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public HumanResourceLocation delete(HumanResourceLocation entity)
    {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;


    }

    @Override
    public Set<HumanResourceLocation> findAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<HumanResourceLocation> hr = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final HumanResourceLocation humanResource  = new HumanResourceLocation.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .number(cursor.getDouble(cursor.getColumnIndex(COLUMN_NUMBER)))
                        .street(cursor.getString(cursor.getColumnIndex(COLUMN_STREET)))
                        .surburb(cursor.getString(cursor.getColumnIndex(COLUMN_SURBURB)))
                        .city(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                        .province(cursor.getString(cursor.getColumnIndex(COLUMN_PROVINCE)))
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
