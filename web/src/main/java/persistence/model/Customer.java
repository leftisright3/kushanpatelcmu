package persistence.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by patel_000 on 7/19/2017.
 */

@Entity
@Table(name = "customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 255, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 255, nullable = false)
    private String lastName;

    @Column(name = "age", nullable = true)
    private Integer age;

    @Column(name = "email_address", length = 255, nullable = false)
    private String emailAddress;

    @Column(name = "phone_number", length = 255, nullable = true)
    private String phoneNumber;

    @Column(name = "billing_address", length = 255, nullable = true)
    private String billingAddress;

    @Column(name = "mailing_address", length = 255, nullable = true)
    private String mailingAddress;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", updatable = false)
    private Calendar createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_time", updatable = true)
    private Calendar modifiedTime;

    @Column(name = "created_by_uid", updatable = false, length = 255, nullable = false)
    private String createdByUid;

    @Column(name = "modified_by_uid", updatable = true, length = 255, nullable = false)
    private String modifiedByUid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public Calendar getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Calendar createdTime) {
        this.createdTime = createdTime;
    }

    public Calendar getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Calendar modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getCreatedByUid() {
        return createdByUid;
    }

    public void setCreatedByUid(String createdByUid) {
        this.createdByUid = createdByUid;
    }

    public String getModifiedByUid() {
        return modifiedByUid;
    }

    public void setModifiedByUid(String modifiedByUid) {
        this.modifiedByUid = modifiedByUid;
    }


}
