package com.example.notes.facade.request.note;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteCreateRequestDto {

    @JsonProperty("title")
    private String title;

    @JsonProperty("note")
    private String note;

    public NoteCreateRequestDto() {
    }

    public NoteCreateRequestDto(final String title, final String note) {
        this.title = title;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
