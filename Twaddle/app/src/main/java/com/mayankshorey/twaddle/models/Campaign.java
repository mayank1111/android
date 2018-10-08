package com.mayankshorey.twaddle.models;

public class Campaign {

    public String organiser;
    public String cause;
    public String description;


    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganiser() {

        return organiser;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }
}
