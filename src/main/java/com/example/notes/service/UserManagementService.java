package com.example.notes.service;

import com.example.notes.model.Note;
import com.example.notes.model.User;
import com.example.notes.repository.NoteRepository;
import com.example.notes.service.request.NoteCreateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.springframework.util.Assert.notNull;

@Service
public class UserManagementService {

    private static final Logger logger = LoggerFactory.getLogger(UserManagementService.class);

    private final UserService userService;
    private final NoteService noteService;

    public UserManagementService(UserService userService, NoteRepository noteRepository) {
        this.userService = userService;
        this.noteService = noteService;
    }

    public Note create(final long userId, final NoteCreateRequest request) {
        notNull(request, "request cannot be null");
        logger.trace("Creating Note with request:{}", request);

        final User user = userService.get(userId);
        final Note result = noteService.save(user, request);
        logger.debug("Done creating Note with request:{}", request);
        return result;

    }

    private static Note accumulateCreateNote(final User user, final NoteCreateRequest request) {
        final Note note = new Note();
        note.setUser(user);
        note.setNote(request.getNote());
        note.setTitle(request.getTitle());
        note.setCreatedTime(LocalDateTime.now());
        note.setUpdatedTime(LocalDateTime.now());

        return note;
    }
}
