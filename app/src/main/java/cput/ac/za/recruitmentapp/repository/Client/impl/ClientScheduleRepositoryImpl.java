package cput.ac.za.recruitmentapp.repository.Client.impl;

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
import cput.ac.za.recruitmentapp.domain.client.ClientSchedule;
import cput.ac.za.recruitmentapp.repository.Client.ClientScheduleRepository;

/**
 * Created by Tank on 5/7/2016.
 */
public class ClientScheduleRepositoryImpl extends SQLiteOpenHelper implements ClientScheduleRepository
{
    public static final String TABLE_NAME = "Client Schedule";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_AVAILABLE = "available";
    public static final String COLUMN_PERSONBOOKED = "personBooked";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DATE + " TEXT  NOT NULL , "
            + COLUMN_AVAILABLE + " TEXT " + " NOT NULL , "
            + COLUMN_PERSONBOOKED + " TEXT NOT NULL);";

    public ClientScheduleRepositoryImpl(Context context)
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
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_CREATE);
    }


    @Override
    public ClientSchedule findById(Long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_DATE,
                        COLUMN_AVAILABLE,
                        COLUMN_PERSONBOOKED,},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final ClientSchedule humanResource = new ClientSchedule.Builder()

                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .date(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)))
                    .available(Boolean.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_AVAILABLE))))
                    .personBooked(cursor.getString(cursor.getColumnIndex(COLUMN_PERSONBOOKED)))
                    .build();
            return humanResource;
        }
        else{
            return null;
        }
    }

    @Override
    public ClientSchedule save(ClientSchedule entity) {
        return null;
    }

    @Override
    public ClientSchedule update(ClientSchedule entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DATE, entity.getDate());
        values.put(COLUMN_AVAILABLE, entity.getAvailable());
        values.put(COLUMN_PERSONBOOKED, entity.getPersonBooked());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public ClientSchedule delete(ClientSchedule entity)
    {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;


    }

    @Override
    public Set<ClientSchedule> findAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<ClientSchedule> hr = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final ClientSchedule humanResource  = new ClientSchedule.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .date(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)))
                        .available(Boolean.valueOf(cursor.getString(cursor.getColumnIndex(COLUMN_AVAILABLE))))
                        .personBooked(cursor.getString(cursor.getColumnIndex(COLUMN_PERSONBOOKED)))
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
