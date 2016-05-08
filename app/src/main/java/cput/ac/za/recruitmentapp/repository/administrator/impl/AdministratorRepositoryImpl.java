package cput.ac.za.recruitmentapp.repository.administrator.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import cput.ac.za.recruitmentapp.conf.database.DBConstants;
import cput.ac.za.recruitmentapp.domain.Administrator.Administrator;
import cput.ac.za.recruitmentapp.repository.administrator.AdministratorRepository;

/**
 * Created by Tank on 5/7/2016.
 */
public abstract class AdministratorRepositoryImpl extends SQLiteOpenHelper implements AdministratorRepository
{

    public static final String TABLE_NAME = "Client Booking";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STAFFNUMBER = "staffNumber";
    public static final String COLUMN_BOOKING = "booking";
    public static final String COLUMN_TOTALWAGES = "totalWages";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_STAFFNUMBER + " TEXT  NOT NULL , "
            + COLUMN_BOOKING + " TEXT " + " NOT NULL , "
            + COLUMN_TOTALWAGES + " TEXT NOT NULL);";

    public AdministratorRepositoryImpl(Context context)
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
    public Administrator findById(Long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_STAFFNUMBER,
                        COLUMN_BOOKING,
                        COLUMN_TOTALWAGES,},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final Administrator humanResource = new Administrator.Builder()

                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .staffNumber(cursor.getString(cursor.getColumnIndex(COLUMN_STAFFNUMBER)))
                    .booking(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(COLUMN_BOOKING))))
                    .totalWage(Float.parseFloat((cursor.getString(cursor.getColumnIndex(COLUMN_TOTALWAGES)))))
                    .build();
            return humanResource;
        }
        else{
            return null;
        }
    }

    @Override
    public Administrator save(Administrator entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_STAFFNUMBER, entity.getStaffNumber());
        values.put(COLUMN_BOOKING, entity.getBooking());
        values.put(COLUMN_TOTALWAGES, entity.totalWage());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Administrator insertedEntity = new Administrator.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;

    }

    @Override
    public Administrator update(Administrator entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_STAFFNUMBER, entity.getStaffNumber());
        values.put(COLUMN_BOOKING, entity.getBooking());
        values.put(COLUMN_TOTALWAGES, entity.totalWage());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

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
