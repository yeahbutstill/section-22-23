package com.yeahbutstill.section2223.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

class CreateCSVTest {

    private static final Logger LOGGER = Logger.getLogger(CreateCSVTest.class.getName());

    @Test
    void testCreateCSV() throws IOException {

        StringWriter writer = new StringWriter();

        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        csvPrinter.printRecord("Dani", "Setiawan", 28);
        csvPrinter.printRecord("Maya", "Setiawan", 27);
        csvPrinter.printRecord("Winda", "Setiawan", 25);
        csvPrinter.flush();

        Assertions.assertNotNull(writer.getBuffer().toString());
        LOGGER.info(writer.getBuffer().toString());

    }

    @Test
    void testReadCSV() throws IOException {

        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
        for (CSVRecord record : parser) {
            LOGGER.info("First Name : " + record.get(0));
            LOGGER.info("Last Name : " + record.get(1));
            LOGGER.info("Age : " + record.get(2));
        }

        Assertions.assertNotNull(parser);

    }

    @Test
    void testReadCSVWithHeader() throws IOException {
        Path path = Path.of("sample.csv");
        Reader reader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().build();
        CSVParser parser = new CSVParser(reader, format);
        for (CSVRecord record : parser) {
            LOGGER.info("First Name : " + record.get("First Name"));
            LOGGER.info("Last Name : " + record.get("Last Name"));
            LOGGER.info("Age : " + record.get("Age"));
        }

        Assertions.assertNotNull(parser);
    }

    @Test
    void testCreateCSVWithHeader() throws IOException {

        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("First Name", "Last Name", "Age")
                .build();
        CSVPrinter csvPrinter = new CSVPrinter(writer, format);
        csvPrinter.printRecord("Dani", "Setiawan", 28);
        csvPrinter.printRecord("Maya", "Setiawan", 27);
        csvPrinter.printRecord("Winda", "Setiawan", 25);
        csvPrinter.flush();

        Assertions.assertNotNull(writer.getBuffer().toString());
        LOGGER.info(writer.getBuffer().toString());

    }

    @Test
    void testCreateCSVWithFormat() throws IOException {

        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.TDF.builder()
                .setHeader("First Name", "Last Name", "Age")
                .build();
        CSVPrinter csvPrinter = new CSVPrinter(writer, format);
        csvPrinter.printRecord("Dani", "Setiawan", 28);
        csvPrinter.printRecord("Maya", "Setiawan", 27);
        csvPrinter.printRecord("Winda", "Setiawan", 25);
        csvPrinter.flush();

        Assertions.assertNotNull(writer.getBuffer().toString());
        LOGGER.info(writer.getBuffer().toString());

    }

}