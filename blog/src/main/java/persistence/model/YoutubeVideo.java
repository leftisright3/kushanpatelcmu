package persistence.model;

import javax.persistence.*;

/**
 * Created by Kushan Patel 6/19/17.
 */
@Entity
@Table(name = "youtube_video_ids")
public class YoutubeVideo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "video_id", length = 512)
    String videoId;

    @Column(name = "video_url", length = 755)
    String videoUrl;

    @ManyToOne(optional = true)
    @JoinColumn(name = "entry_section_id", referencedColumnName = "id")
    EntrySection entrySection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl= videoUrl;
    }

    public EntrySection getEntrySection() {
        return entrySection;
    }

    public void setEntrySection(EntrySection entrySection) {
        this.entrySection = entrySection;
    }
}
