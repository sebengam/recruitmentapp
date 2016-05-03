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
import cput.ac.za.recruitmentapp.domain.humanResource.HumanResource;
import cput.ac.za.recruitmentapp.repository.humanResource.HumanResourceRepository;


public abstract class HumanResourceRepositoryImpl extends SQLiteOpenHelper implements HumanResourceRepository
{
    public static final String TABLE_NAME = "HumanResource";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_CANDIDATEIMAGE = "candidateImage";
    public static final String COLUMN_INDUSTRY = "industry";
    public static final String COLUMN_OCCUPATION = "occupation";



    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT  NOT NULL , "
            + COLUMN_SURNAME + " TEXT " + " NOT NULL , "
            + COLUMN_CANDIDATEIMAGE + " TEXT NOT NULL ,"
            + COLUMN_INDUSTRY + " TEXT NOT NULL , "
            + COLUMN_OCCUPATION + " TEXT NOT NULL );";



    public HumanResourceRepositoryImpl(Context context)
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
    public HumanResource findById(Long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                 TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_SURNAME,
                        COLUMN_CANDIDATEIMAGE,
                        COLUMN_INDUSTRY,
                        COLUMN_OCCUPATION,},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final HumanResource humanResource = new HumanResource.Builder()

                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .candidateImage(cursor.getString(cursor.getColumnIndex(COLUMN_CANDIDATEIMAGE)))
                        .industry(cursor.getString(cursor.getColumnIndex(COLUMN_INDUSTRY)))
                        .occupation(cursor.getString(cursor.getColumnIndex(COLUMN_OCCUPATION)))
                        .build();
                return humanResource;
            }
            else{
                return null;
            }
        }


    @Override
    public HumanResource save(HumanResource entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_SURNAME, entity.getSurname());
        values.put(COLUMN_CANDIDATEIMAGE, entity.getCandidateImage());
        values.put(COLUMN_INDUSTRY, entity.getIndustry());
        values.put(COLUMN_OCCUPATION, entity.getOccupation());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        HumanResource insertedEntity = new HumanResource.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;

    }

    @Override
    public HumanResource update(HumanResource entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NAME, entity.getName());
        values.put(COLUMN_SURNAME, entity.getSurname());
        values.put(COLUMN_CANDIDATEIMAGE, entity.getCandidateImage());
        values.put(COLUMN_INDUSTRY, entity.getIndustry());
        values.put(COLUMN_OCCUPATION, entity.getOccupation());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public HumanResource delete(HumanResource entity)
    {

        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;


    }

    @Override
    public Set<HumanResource> findAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<HumanResource> humanResourceS = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final HumanResource humanResource  = new HumanResource.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .surname(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .candidateImage(cursor.getString(cursor.getColumnIndex(COLUMN_CANDIDATEIMAGE)))
                        .industry(cursor.getString(cursor.getColumnIndex(COLUMN_INDUSTRY)))
                        .occupation(cursor.getString(cursor.getColumnIndex(COLUMN_OCCUPATION)))
                        .build();
                humanResourceS.add(humanResource);
            } while (cursor.moveToNext());
        }
        return humanResourceS;

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
