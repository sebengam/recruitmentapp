package cput.ac.za.recruitmentapp.domain.Administrator;

/**
 * Created by Tank on 4/23/2016.
 */
public class AdminPayment
{   Long id;
    String bank;
    String accountNumber;
    float amount;

    public AdminPayment(Builder builder) {
        this.id = builder.id;
        this.bank = builder.bank;
        this.accountNumber = builder.accountNumber;
        this.amount = builder.amount;
    }

    public float getAmount() {
        return amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBank() {
        return bank;
    }

    public Long getId() {
        return id;
    }

    public static class Builder
    {
        Long id;
        String bank;
        String accountNumber;
        float amount;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder bank(String value)
        {
            this.bank = value;
            return this;
        }

        public Builder accountNumber(String value) {
            this.accountNumber = value;
            return this;
        }

        public Builder amount(float value) {
            this.amount = value;
            return this;
        }

        public Builder copy(AdminPayment value)
        {
            this.id = value.id;
            this.bank = value.bank;
            this.amount = value.amount;
            return this;
        }

        public AdminPayment build()
        {
            return new AdminPayment(this)
            {};
        }
    }

}
