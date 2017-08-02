package rest.transfer;

import java.util.Calendar;
import java.util.Collection;

/**
 * Created by Kushan Patel 6/19/17.
 */
public class EntryTO {

    Long id;
    Calendar travelDateBegin;
    Calendar travelDateEnd;
    Calendar createdTime;
    Calendar modifiedTime;
    String title;
    String description;
    String heading;
    String locations;
    String activities;
    Collection<EntrySectionTO> entrySections;

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

    public Collection<EntrySectionTO> getEntrySections() {
        return entrySections;
    }

    public void setEntrySections(Collection<EntrySectionTO> entrySections) {
        this.entrySections = entrySections;
    }
}
