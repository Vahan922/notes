package com.example.notes.service.request;

public class NoteCreateRequest {

    private final String title;
    private final String note;

    public NoteCreateRequest(final String title, final String note) {
        this.title = title;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }
}
