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
import cput.ac.za.recruitmentapp.domain.client.ClientBooking;
import cput.ac.za.recruitmentapp.repository.Client.ClientBookingRepository;

/**
 * Created by Tank on 5/7/2016.
 */
public class ClientBookingRepositoryImpl  extends SQLiteOpenHelper implements ClientBookingRepository
{

    public static final String TABLE_NAME = "Client Booking";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BOOKEDPERSON = "bookedPerson";
    public static final String COLUMN_BOOKINGCOMPANY = "bookingCompany";
    public static final String COLUMN_AVAILABILITY = "availability";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_BOOKEDPERSON + " TEXT  NOT NULL , "
            + COLUMN_BOOKINGCOMPANY + " TEXT " + " NOT NULL , "
            + COLUMN_AVAILABILITY + " TEXT NOT NULL);";

    public ClientBookingRepositoryImpl(Context context)
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
    public ClientBooking findById(Long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_BOOKEDPERSON,
                        COLUMN_BOOKINGCOMPANY,
                        COLUMN_AVAILABILITY,},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final ClientBooking humanResource = new ClientBooking.Builder()

                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .bookingPerson(cursor.getString(cursor.getColumnIndex(COLUMN_BOOKEDPERSON)))
                    .bookingCompany(cursor.getString(cursor.getColumnIndex(COLUMN_BOOKINGCOMPANY)))
                    .availability(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(COLUMN_AVAILABILITY))))
                    .build();
            return humanResource;
        }
        else{
            return null;
        }
    }

    @Override
    public ClientBooking save(ClientBooking entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_BOOKEDPERSON, entity.getBookedPerson());
        values.put(COLUMN_BOOKINGCOMPANY, entity.getBookingCompany());
        values.put(COLUMN_AVAILABILITY, entity.getAvailability());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        ClientBooking insertedEntity = new ClientBooking.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;

    }

     @Override
    public ClientBooking update(ClientBooking entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_BOOKEDPERSON, entity.getBookedPerson());
        values.put(COLUMN_BOOKINGCOMPANY, entity.getBookingCompany());
        values.put(COLUMN_AVAILABILITY, entity.getAvailability());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public ClientBooking delete(ClientBooking entity)
    {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;


    }

    @Override
    public Set<ClientBooking> findAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<ClientBooking> hr = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final ClientBooking humanResource  = new ClientBooking.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .bookingPerson(cursor.getString(cursor.getColumnIndex(COLUMN_BOOKEDPERSON)))
                        .bookingCompany(cursor.getString(cursor.getColumnIndex(COLUMN_BOOKINGCOMPANY)))
                        .availability(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(COLUMN_AVAILABILITY))))
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
