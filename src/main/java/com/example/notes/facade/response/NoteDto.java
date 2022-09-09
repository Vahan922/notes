package com.example.notes.facade.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class NoteDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("note")
    private String note;

    @JsonProperty("created_time")
    private LocalDateTime createdTime;

    @JsonProperty("updated_time")
    private LocalDateTime updatedTime;

    public NoteDto(final Long id, final Long userId, final String title, final String note, final LocalDateTime createdTime, final LocalDateTime updatedTime) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.note = note;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public NoteDto() {
    }
}
