package com.munvo.enrichment.input;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.munvo.enrichment.model.Subscriber;
import com.munvo.enrichment.parser.FileReaderParser;

public class InputSource {
    private Map<Integer, Subscriber> subscriberMap;

    public InputSource(FileReaderParser fileReaderParser, String filename) throws URISyntaxException, IOException {
        List<String> inRecords =
                Files.readAllLines(
                        Paths.get(Thread
                                .currentThread()
                                .getContextClassLoader()
                                .getResource(filename).toURI()), Charset.defaultCharset());
        // read map
        subscriberMap =
                inRecords.stream()
                        .map(fileReaderParser::parseSubscriber)
                        .collect(Collectors.toMap(Subscriber::getId, s -> s));
    }

    public Subscriber query(int id) {
        return subscriberMap.get(id);
    }
}
