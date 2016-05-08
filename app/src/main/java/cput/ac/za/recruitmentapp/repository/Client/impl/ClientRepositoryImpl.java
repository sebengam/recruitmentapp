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
import cput.ac.za.recruitmentapp.domain.client.Client;
import cput.ac.za.recruitmentapp.repository.Client.ClientRepository;

/**
 * Created by Tank on 5/6/2016.
 */
public class ClientRepositoryImpl   extends SQLiteOpenHelper implements ClientRepository
{
    public static final String TABLE_NAME = "Client";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_COMPANYNAME = "companyName";
    public static final String COLUMN_REGNUMBER = "duties";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_COMPANYNAME + " TEXT  NOT NULL , "
            + COLUMN_REGNUMBER + " TEXT " + " NOT NULL ,);";

    public ClientRepositoryImpl(Context context)
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
    public Client findById(Long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_COMPANYNAME,
                        COLUMN_REGNUMBER,},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final Client humanResource = new Client.Builder()

                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .companyName(cursor.getString(cursor.getColumnIndex(COLUMN_COMPANYNAME)))
                    .regNumber(cursor.getString(cursor.getColumnIndex(COLUMN_REGNUMBER)))
                    .build();
            return humanResource;
        }
        else{
            return null;
        }
    }

    @Override
    public Client save(Client entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_COMPANYNAME, entity.getCompanyName());
        values.put(COLUMN_REGNUMBER, entity.getRegNumber());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Client insertedEntity = new Client.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Client update(Client entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_COMPANYNAME, entity.getCompanyName());
        values.put(COLUMN_REGNUMBER, entity.getRegNumber());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }


    @Override
    public Client delete(Client entity)
    {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;


    }

    @Override
    public Set<Client> findAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Client> hr = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Client humanResource  = new Client.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .companyName(cursor.getString(cursor.getColumnIndex(COLUMN_COMPANYNAME)))
                        .regNumber(cursor.getString(cursor.getColumnIndex(COLUMN_REGNUMBER)))
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
