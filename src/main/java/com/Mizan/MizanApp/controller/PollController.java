package com.Mizan.MizanApp.controller;

import com.Mizan.MizanApp.model.Poll;
import com.Mizan.MizanApp.services.PollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
public class PollController {
    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    @GetMapping
    public List <Poll> getAllPolls(){
        return pollService.getAllPolls();
    }

    @GetMapping("/{id}")
    public Poll getPollById(@PathVariable Long id){
        return pollService.getPollById(id);
    }

    @PutMapping("/{id}")
    public Poll updatePoll(@PathVariable Long id, @RequestBody Poll pollDetails){
        return pollService.updatePoll(id, pollDetails);
    }

    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable Long id){
        pollService.deletePoll(id);
    }
}
