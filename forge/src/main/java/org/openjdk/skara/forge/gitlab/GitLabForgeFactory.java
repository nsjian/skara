package org.openjdk.skara.forge.gitlab;

import org.openjdk.skara.forge.*;
import org.openjdk.skara.host.Credential;
import org.openjdk.skara.json.JSONObject;

import java.net.URI;
import java.util.Set;

public class GitLabForgeFactory implements ForgeFactory {
    @Override
    public String name() {
        return "gitlab";
    }

    @Override
    public Set<String> knownHosts() {
        return Set.of("gitlab.com");
    }

    @Override
    public Forge create(URI uri, Credential credential, JSONObject configuration) {
        if (credential != null) {
            return new GitLabHost(uri, credential);
        } else {
            return new GitLabHost(uri);
        }
    }
}
