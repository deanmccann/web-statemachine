package com.webco.domain;

import java.util.UUID;

/**
 * Created by dean on 14/03/16.
 */
public class Profile {

    UUID uuid;
    String Artifact;

    public Profile(UUID uuid) {
        this.uuid = uuid;
    }

    public Profile(String artifact, UUID uuid) {
        Artifact = artifact;
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
