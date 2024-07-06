package org.example.traodoisub.config.security;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecurityConfigSettings {
    public static class AnonymousUrlConfig {
        private HttpMethod httpMethod;
        private String[] urls;

        public AnonymousUrlConfig(HttpMethod httpMethod, String... urls) {
            this.httpMethod = httpMethod;
            this.urls = urls;
        }

        public HttpMethod getHttpMethod() {
            return httpMethod;
        }

        public void setHttpMethod(HttpMethod httpMethod) {
            this.httpMethod = httpMethod;
        }

        public String[] getUrls() {
            return urls;
        }

        public void setUrls(String... urls) {
            this.urls = urls;
        }
    }

    private final List<AnonymousUrlConfig> anonymousUrlConfigs;

    public SecurityConfigSettings() {
        anonymousUrlConfigs = new ArrayList();
        anonymousUrlConfigs.add(new AnonymousUrlConfig(HttpMethod.GET,
                "/**/test"

        ));
        anonymousUrlConfigs.add(new AnonymousUrlConfig(HttpMethod.POST,
                "/**/user/login"
        ));
// anonymousUrlConfigs.add(new AnonymousUrlConfig(HttpMethod.DELETE,
// ""
//
// ));
    }

    public List<AnonymousUrlConfig> getAnonymousUrlConfigs() {
        return anonymousUrlConfigs;
    }


}
