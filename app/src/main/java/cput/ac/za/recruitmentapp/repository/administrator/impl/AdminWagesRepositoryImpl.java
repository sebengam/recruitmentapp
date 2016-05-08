package cput.ac.za.recruitmentapp.repository.administrator.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Set;

import cput.ac.za.recruitmentapp.conf.database.DBConstants;
import cput.ac.za.recruitmentapp.domain.Administrator.AdminWages;
import cput.ac.za.recruitmentapp.repository.administrator.AdminWagesRepository;

/**
 * Created by Tank on 5/7/2016.
 */
public abstract class AdminWagesRepositoryImpl extends SQLiteOpenHelper implements AdminWagesRepository
{
    public static final String TABLE_NAME = "AdminWages";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_HOURS = "hours";
    public static final String COLUMN_RATEPERHOUR = "ratePerHour";
    public static final String COLUMN_TOTALWAGES = "totalWages";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_HOURS + " TEXT  NOT NULL , "
            + COLUMN_RATEPERHOUR + " TEXT " + " NOTNULL , "
            + COLUMN_TOTALWAGES + " TEXT NOT NULL);";
    public AdminWagesRepositoryImpl(Context context)
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
    public AdminWages findById(Long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_HOURS,
                        COLUMN_RATEPERHOUR,
                        COLUMN_TOTALWAGES,},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final AdminWages humanResource = new AdminWages.Builder()

                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .hours(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_HOURS))))
                    .ratePerHour(Float.parseFloat((cursor.getString(cursor.getColumnIndex(COLUMN_RATEPERHOUR)))))
                    .totalWages(Float.parseFloat((cursor.getString(cursor.getColumnIndex(COLUMN_TOTALWAGES)))))
                    .build();
            return humanResource;
        }
        else{
            return null;
        }
    }

    @Override
    public AdminWages save(AdminWages entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_HOURS, entity.getHours());
        values.put(COLUMN_RATEPERHOUR, entity.getRatePerHour());
        values.put(COLUMN_TOTALWAGES, entity.getTotalWages());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        AdminWages insertedEntity = new AdminWages.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;

    }

    @Override
    public AdminWages update(AdminWages entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_HOURS, entity.getHours());
        values.put(COLUMN_RATEPERHOUR, entity.getRatePerHour());
        values.put(COLUMN_TOTALWAGES, entity.getTotalWages());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    public abstract AdminWagesRepository save(AdminWagesRepository Entity);

    @Override
    public AdminWages delete(AdminWages entity) {
        return null;
    }

    @Override
    public Set<AdminWages> findAll() {
        return null;
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
