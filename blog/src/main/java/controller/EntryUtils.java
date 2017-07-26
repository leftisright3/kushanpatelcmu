package controller;

import persistence.model.Entry;
import persistence.model.EntrySection;
import persistence.model.YoutubeVideo;
import rest.transfer.EntrySectionTO;
import rest.transfer.EntryTO;
import rest.transfer.YoutubeVideoTO;

/**
 * Created by kushan on 7/26/17.
 */
public class EntryUtils {


    public static Entry convertEntryTO(EntryTO entryTO) {
        Entry entry = new Entry();
        entry.setId(entryTO.getId());
        entry.setLocations(entryTO.getLocations());
        entry.setDescription(entryTO.getDescription());
        entry.setTitle(entryTO.getTitle());
        entry.setHeading(entryTO.getHeading());
        entry.setActivities(entryTO.getActivities());
        entry.setTravelDateBegin(entryTO.getTravelDateBegin());
        entry.setTravelDateEnd(entryTO.getTravelDateEnd());
        return entry;
    }

    public static EntrySection convertEntrySectionTO(EntrySectionTO entrySectionTO) {
        EntrySection entrySection = new EntrySection();
        entrySection.setId(entrySectionTO.getId());
        if (entrySectionTO.getEntry() != null) {
            entrySection.setEntry(convertEntryTO(entrySectionTO.getEntry()));
        }
        entrySection.setSectionContent(entrySectionTO.getSectionContent());
        entrySection.setSectionDateBegin(entrySectionTO.getSectionDateBegin());
        entrySection.setSectionDateEnd(entrySectionTO.getSectionDateEnd());
        entrySection.setSectionDescription(entrySectionTO.getSectionDescription());
        entrySection.setSectionHeading(entrySectionTO.getSectionHeading());
        entrySection.setSectionDescription(entrySectionTO.getSectionDescription());
        entrySection.setSectionTitle(entrySectionTO.getSectionTitle());
        return entrySection;
    }

    public static YoutubeVideo convertYoutubeVideoId(YoutubeVideoTO youtubeVideoTO) {
        YoutubeVideo youtubeVideo = new YoutubeVideo();
        youtubeVideo.setId(youtubeVideoTO.getId());
        youtubeVideo.setEntrySection(convertEntrySectionTO(youtubeVideoTO.getEntrySection()));
        youtubeVideo.setVideoId(youtubeVideoTO.getVideoId());
        youtubeVideo.setVideoUrl(youtubeVideoTO.getVideoUrl());
        return youtubeVideo;
    }


}
