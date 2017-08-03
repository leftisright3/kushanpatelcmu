package controller;

import persistence.model.Entry;
import persistence.model.EntrySection;
import persistence.model.YoutubeVideo;
import persistence.service.EntryDataService;
import rest.transfer.EntrySectionTO;
import rest.transfer.EntryTO;
import rest.transfer.YoutubeVideoTO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kushan on 6/19/17.
 */
public class EntryController {

    @Inject
    EntryDataService eds;

    public List<Entry>  getAllEntries(){
        return eds.getAllEntries();
    }

    public Entry findById(Long id) {return eds.getById(id);}


    public Entry addNewEntry(EntryTO entryTO) {
        return eds.addNewEntry(EntryUtils.convertEntryTO(entryTO));
    }

    public EntrySection addNewEntrySection(EntrySectionTO entrySectionTO) {
        return eds.addNewEntrySection(EntryUtils.convertEntrySectionTO(entrySectionTO));
    }

    public YoutubeVideo addNewYoutubeVideo(YoutubeVideoTO youtubeVideoTO) {
        return eds.addNewYoutubeVideo(EntryUtils.convertYoutubeVideoId(youtubeVideoTO));
    }

}