package com.example.notes.facade.helper;

import com.example.notes.facade.request.note.NoteCreateRequestDto;
import com.example.notes.facade.response.NoteDto;
import com.example.notes.model.Note;
import com.example.notes.service.request.NoteCreateRequest;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public NoteDto accumulateNoteDto(Note note) {
        return new NoteDto(
                note.getId(),
                note.getUser().getId(),
                note.getTitle(),
                note.getNote(),
                note.getCreatedTime(),
                note.getUpdatedTime()
        );
    }

    public NoteCreateRequest accumulateCreateRequest(NoteCreateRequestDto requestDto) {
        return new NoteCreateRequest(
                requestDto.getTitle(),
                requestDto.getNote()
        );
    }
}
