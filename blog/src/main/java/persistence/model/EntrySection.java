package persistence.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Collection;

/**
 * Created by Kushan Patel 6/19/17.
 */
@Entity
@Table(name = "entry_section")
public class EntrySection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", updatable = false)
    Calendar createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_time")
    Calendar modifiedTime;

    @Column(name = "section_title", length = 255)
    String sectionTitle;

    @Column(name = "section_heading", length = 255)
    String sectionHeading;

    @Column(name = "section_description", length = 255)
    String sectionDescription;

    @Column(name = "section_content", length = 2048)
    String sectionContent;

    @ManyToOne(optional = true)
    @JoinColumn(name = "entry_id", referencedColumnName = "id")
    Entry entry;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "section_date_begin")
    Calendar sectionDateBegin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "section_date_end")
    Calendar sectionDateEnd;

    @OneToMany(mappedBy = "entrySection", cascade = CascadeType.ALL)
    Collection<YoutubeVideo> youtubeVideos;

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

    public Collection<YoutubeVideo> getYoutubeVideos() {
        return youtubeVideos;
    }

    public void setYoutubeVideos(Collection<YoutubeVideo> youtubeVideos) {
        this.youtubeVideos = youtubeVideos;
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

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
}
