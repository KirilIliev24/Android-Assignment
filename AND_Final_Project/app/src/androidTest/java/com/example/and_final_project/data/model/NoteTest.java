package com.example.and_final_project.data.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {

    private Note note;
    @Before
    public void setUp() throws Exception {
        note = new Note("Test note", "This note is for testing purposes", 10);
    }

    @Test
    public void getTitle() {
        String noteTitle = note.getTitle();
        assertEquals(noteTitle, "Test note");
    }

    @Test
    public void getDescription() {
        String noteDescription = note.getDescription();
        assertEquals(noteDescription, "This note is for testing purposes");
    }

    @Test
    public void getPriority() {
        int priority = note.getPriority();
        assertEquals(priority, 10);
    }
}