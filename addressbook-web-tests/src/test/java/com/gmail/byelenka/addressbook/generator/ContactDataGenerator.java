package com.gmail.byelenka.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.gmail.byelenka.addressbook.model.ContactData;
import com.gmail.byelenka.addressbook.model.GroupData;
import com.gmail.byelenka.addressbook.model.Groups;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContact(count);
        if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognizable format " + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactData.class);
        String xml = xStream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private List<ContactData> generateContact(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                    .withFirstname(String.format("Firstname %s", i)).withLastname(String.format("Lastname %s", i))
                    .withAddress(String.format("Address %s", i)).withEmail(String.format("email%s@gmail.com", i))
                    .withHomeNumber(String.format("+123456789%s", i))); //add groups!
        }
        return contacts;
    }
}
