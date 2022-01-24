package org.tp.logservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "logs", schema = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String endpoint;
    @Column(name = "submitted_at", updatable = false)
    private Date submitted;
    private String customText;

    public Log() {
    }

    @PrePersist
    protected void onCreate() {
        submitted = new Date();
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
                ", submitted=" + submitted +
                ", customText='" + customText + '\'' +
                '}';
    }
}
