package com.subsconvertor.detector;

import com.subsconvertor.model.SubtitleType;
import org.junit.Ignore;

/**
 *
 */
@Ignore
public class SubtitleDetectVoTest {

    private String name;
    private SubtitleType type;

    public SubtitleDetectVoTest(String name, SubtitleType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public SubtitleType getType() {
        return type;
    }
}
