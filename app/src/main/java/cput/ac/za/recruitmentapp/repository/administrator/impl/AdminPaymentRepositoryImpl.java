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
import cput.ac.za.recruitmentapp.domain.Administrator.AdminPayment;
import cput.ac.za.recruitmentapp.repository.administrator.AdminPaymentRepository;

/**
 * Created by Tank on 5/7/2016.
 */
public class AdminPaymentRepositoryImpl extends SQLiteOpenHelper implements AdminPaymentRepository
{
    public static final String TABLE_NAME = "Client Booking";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BANK= "bank";
    public static final String COLUMN_ACCOUNTNUMBER = "accountNumber";
    public static final String COLUMN_AMOUNT = "amount";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_BANK + " TEXT  NOT NULL , "
            + COLUMN_ACCOUNTNUMBER + " TEXT " + " NOT NULL , "
            + COLUMN_AMOUNT + " TEXT NOT NULL);";

    public AdminPaymentRepositoryImpl(Context context)
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
    public AdminPayment findById(Long id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_BANK,
                        COLUMN_ACCOUNTNUMBER,
                        COLUMN_AMOUNT,},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {

            final AdminPayment humanResource = new AdminPayment.Builder()

                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .bank(cursor.getString(cursor.getColumnIndex(COLUMN_BANK)))
                    .accountNumber(cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNTNUMBER)))
                    .amount(Float.parseFloat((cursor.getString(cursor.getColumnIndex(COLUMN_AMOUNT)))))
                    .build();
            return humanResource;
        }
        else{
            return null;
        }
    }

    @Override
    public AdminPayment save(AdminPayment entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_BANK, entity.getBank());
        values.put(COLUMN_ACCOUNTNUMBER, entity.getAccountNumber());
        values.put(COLUMN_AMOUNT, entity.getAmount());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        AdminPayment insertedEntity = new AdminPayment.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;

    }

    @Override
    public AdminPayment update(AdminPayment entity)
    {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_BANK, entity.getBank());
        values.put(COLUMN_ACCOUNTNUMBER, entity.getAccountNumber());
        values.put(COLUMN_AMOUNT, entity.getAmount());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public AdminPayment delete(AdminPayment entity) {
        return null;
    }

    @Override
    public Set<AdminPayment> findAll() {
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
