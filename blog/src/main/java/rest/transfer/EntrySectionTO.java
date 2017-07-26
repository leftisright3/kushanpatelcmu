package rest.transfer;

import java.util.Calendar;
import java.util.Set;

/**
 * Created by Kushan Patel 6/19/17.
 */
public class EntrySectionTO {

    Long id;
    Calendar createdTime;
    Calendar modifiedTime;
    String sectionTitle;
    String sectionHeading;
    String sectionDescription;
    String sectionContent;
    EntryTO entry;
    Calendar sectionDateBegin;
    Calendar sectionDateEnd;
    Set<YoutubeVideoIdTO> youtubeVideoIds;

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

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String location) {
        this.sectionTitle = location;
    }

    public Set<YoutubeVideoIdTO> getYoutubeVideoIds() {
        return youtubeVideoIds;
    }

    public void setYoutubeVideoIds(Set<YoutubeVideoIdTO> youtubeVideoIds) {
        this.youtubeVideoIds = youtubeVideoIds;
    }

    public String getSectionHeading() {
        return sectionHeading;
    }

    public void setSectionHeading(String sectionHeading) {
        this.sectionHeading = sectionHeading;
    }

    public String getSectionContent() {
        return sectionContent;
    }

    public void setSectionContent(String sectionContent) {
        this.sectionContent = sectionContent;
    }

    public Calendar getSectionDateBegin() {
        return sectionDateBegin;
    }

    public void setSectionDateBegin(Calendar sectionDateBegin) {
        this.sectionDateBegin = sectionDateBegin;
    }

    public Calendar getSectionDateEnd() {
        return sectionDateEnd;
    }

    public void setSectionDateEnd(Calendar sectionDateEnd) {
        this.sectionDateEnd = sectionDateEnd;
    }

    public EntryTO getEntry() {
        return entry;
    }

    public void setEntry(EntryTO entry) {
        this.entry = entry;
    }
}
