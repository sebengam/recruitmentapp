package cput.ac.za.recruitmentapp.administrator;

import android.test.AndroidTestCase;

import junit.framework.Assert;

import java.util.Set;

import cput.ac.za.recruitmentapp.domain.Administrator.AdminPayment;
import cput.ac.za.recruitmentapp.repository.administrator.AdminPaymentRepository;
import cput.ac.za.recruitmentapp.repository.administrator.impl.AdminPaymentRepositoryImpl;

/**
 * Created by Tank on 5/7/2016.
 */
public class AdminPaymentRepositoryTest extends AndroidTestCase
{
    private static final String TAG="HUMANRESOURCE TEST";
    private Long id;

    public void
    testCreateReadUpdateDelete() throws Exception
    {
        AdminPaymentRepository repo = new AdminPaymentRepositoryImpl(this.getContext())
        {
            @Override
            public AdminPayment save(AdminPayment Entity) {
                return null;
            }

            @Override
            public AdminPayment delete(AdminPayment entity) {
                return null;
            }

            @Override
            public Set<AdminPayment> findAll() {
                return null;
            }
        };
        // CREATE
        AdminPayment createEntity = new AdminPayment.Builder()
                .bank("FDCD")
                .accountNumber("12")
                .amount(200f)
                .build();
        AdminPayment insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<AdminPayment> humanResources = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",humanResources.size()>0);

        //READ ENTITY
        AdminPayment entity = (AdminPayment) repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        AdminPayment updateEntity = new AdminPayment.Builder()
                .copy(entity)
                .bank("TEST47")
                .build();
        repo.update(updateEntity);
        AdminPayment newEntity = (AdminPayment) repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "TEST47", newEntity.getBank());

        // DELETE ENTITY
        repo.delete(updateEntity);
        AdminPayment deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
