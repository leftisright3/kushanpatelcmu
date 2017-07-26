package rest.transfer;

/**
 * Created by Kushan Patel 6/19/17.
 */
public class YoutubeVideoIdTO {

    Long id;
    String videoId;
    String videoUrl;
    EntrySectionTO entrySection;

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

    public EntrySectionTO getEntrySection() {
        return entrySection;
    }

    public void setEntrySection(EntrySectionTO entrySection) {
        this.entrySection = entrySection;
    }
}
