package com.sqs.qe.features.albums;

import com.sqs.qe.steps.AlbumSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class WhenAddingAlbum {

    @Steps
    AlbumSteps steps;

    @Test
    public void AddAlbum() throws Exception {

        steps.add("James", "James Hart");
    }

}
