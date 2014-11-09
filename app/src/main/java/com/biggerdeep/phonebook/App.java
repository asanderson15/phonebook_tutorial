package com.biggerdeep.phonebook;

import com.biggerdeep.phonebook.resources.ContactResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.lang.Exception;
import java.lang.Override;

/**
 * Created by asanderson on 11/8/14.
 */
public class App extends Application<PhonebookConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<PhonebookConfiguration> b) {}

    @Override
    public void run(PhonebookConfiguration c, Environment e) throws Exception {
        LOGGER.info("Method App#run() called");
        for (int i=0; i < c.getMessageRepetitions(); i++) {
            System.out.println(c.getMessage());
        }
        System.out.println(c.getAdditionalMessage());

        e.jersey().register(new ContactResource());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
