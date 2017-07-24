package rest;

/**
 * Created by patel_000 on 7/20/2017.
 */
public class CustomerTO
{
    public Long id;
    public String firstName;
    public String lastName;
    public Integer age;
    public String emailAddress;
    public String mailingAddress;
    public String billingAddress;
    public String phoneNumber;
    public String createdByUid;
    public String modifiedByUid;


    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCreatedByUid(String createdByUid) {
        this.createdByUid = createdByUid;
    }

    public void setModifiedByUid(String modifiedByUid) {
        this.modifiedByUid = modifiedByUid;
    }
}
