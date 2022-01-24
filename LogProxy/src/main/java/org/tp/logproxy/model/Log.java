package org.tp.logproxy.model;

import java.util.Date;

public class Log {

    private Integer id;
    private String endpoint;
    private String customText;
    private Date submitted;

    public Log() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public String getCustomText() {
        return customText;
    }

    public void setCustomText(String customText) {
        this.customText = customText;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", endpoint='" + endpoint + '\'' +
                ", customText='" + customText + '\'' +
                ", submitted=" + submitted +
                '}';
    }
}
