package controller;

import persistence.model.Entry;
import persistence.model.EntrySection;
import persistence.model.YoutubeVideoId;
import rest.transfer.EntrySectionTO;
import rest.transfer.EntryTO;
import rest.transfer.YoutubeVideoIdTO;

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
        entrySection.setEntry(convertEntryTO(entrySectionTO.getEntry()));
        entrySection.setSectionContent(entrySectionTO.getSectionContent());
        entrySection.setSectionDateBegin(entrySectionTO.getSectionDateBegin());
        entrySection.setSectionDateEnd(entrySectionTO.getSectionDateEnd());
        entrySection.setSectionDescription(entrySectionTO.getSectionDescription());
        entrySection.setSectionHeading(entrySectionTO.getSectionHeading());
        entrySection.setSectionDescription(entrySectionTO.getSectionDescription());
        entrySection.setSectionTitle(entrySectionTO.getSectionTitle());
        return entrySection;
    }

    public static YoutubeVideoId convertYoutubeVideoId(YoutubeVideoIdTO youtubeVideoIdTO) {
        YoutubeVideoId youtubeVideoId = new YoutubeVideoId();
        youtubeVideoId.setId(youtubeVideoIdTO.getId());
        youtubeVideoId.setEntrySection(convertEntrySectionTO(youtubeVideoIdTO.getEntrySection()));
        youtubeVideoId.setVideoId(youtubeVideoIdTO.getVideoId());
        youtubeVideoId.setVideoUrl(youtubeVideoIdTO.getVideoUrl());
        return youtubeVideoId;
    }


}
