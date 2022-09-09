package com.example.notes.facade;

import com.example.notes.facade.helper.NoteMapper;
import com.example.notes.facade.request.note.NoteCreateRequestDto;
import com.example.notes.facade.response.NoteDto;
import com.example.notes.model.Note;
import com.example.notes.service.UserManagementService;
import com.example.notes.service.request.NoteCreateRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.Assert.notNull;

@Tag(
        name = "Notes API for note",
        description = "This API allows to maintain note by given requests."
)
@RequestMapping(path = "users/{userId}/note")
@RestController
public class NoteController {

    private static final Logger logger = LoggerFactory.getLogger(UserManagementService.class);

    private final UserManagementService userManagementService;
    private final NoteMapper mapper;

    public NoteController(UserManagementService userManagementService, NoteMapper mapper) {
        this.userManagementService = userManagementService;
        this.mapper = mapper;
    }

    @PostMapping()
    public NoteDto create(@PathVariable final long userId, @RequestBody final NoteCreateRequestDto requestDto) {
        notNull(requestDto, "requestDto cannot not be null");
        logger.debug("Creating Note with request:{} for User:{}", requestDto, userId);

        final NoteCreateRequest request = mapper.accumulateCreateRequest(requestDto);
        final Note note = userManagementService.create(userId, request);
        final NoteDto result = mapper.accumulateNoteDto(note);

        logger.info("Done creating Note with request:{} for User:{}", requestDto, userId);
        return result;
    }


}
