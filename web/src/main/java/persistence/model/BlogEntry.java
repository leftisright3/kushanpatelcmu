package persistence.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by Kushan Patel 6/19/17.
 */
@Entity
@Table(name = "blog_entry")
public class BlogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", updatable = false)
    Calendar createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_time")
    Calendar modifiedTime;

    @Column(name = "created_by_uid", updatable = false, length = 255, nullable = false)
    String createdByUid;

    @Column(name = "modified_by_uid", length = 255, nullable = false)
    String modifiedByUid;

    @Column(name = "blog_data", length = 2048000)
    @Lob
    byte[] blogData;

    @Column(name = "description", length = 512, nullable = true)
    String description;

    @Column(name = "location", length = 255, nullable = true)
    String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public byte[] getBlogData() {
        return blogData;
    }

    public void setBlogData(byte[] blogData) {
        this.blogData = blogData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
