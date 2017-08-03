package persistence.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 * Created by Kushan Patel 6/19/17.
 */
@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "travel_date_begin", updatable = false)
    Calendar travelDateBegin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "travel_date_end")
    Calendar travelDateEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", updatable = false)
    Calendar createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_time")
    Calendar modifiedTime;

    @Column(name = "title", length = 255)
    String title;

    @Column(name = "activities", length = 512, nullable = true)
    String description;

    @Column(name = "heading", length = 255)
    String heading;

    @Column(name = "locations", length = 512, nullable = true)
    String locations;

    @Column(name = "activities", length = 255, nullable = true)
    String activities;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entry")
    List<EntrySection> entrySections;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public Calendar getTravelDateBegin() {
        return travelDateBegin;
    }

    public void setTravelDateBegin(Calendar travelDateBegin) {
        this.travelDateBegin = travelDateBegin;
    }

    public Calendar getTravelDateEnd() {
        return travelDateEnd;
    }

    public void setTravelDateEnd(Calendar travelDateEnd) {
        this.travelDateEnd = travelDateEnd;
    }

    public List<EntrySection> getEntrySections() {
        return entrySections;
    }

    public void setEntrySections(List<EntrySection> entrySections) {
        this.entrySections = entrySections;
    }
}
