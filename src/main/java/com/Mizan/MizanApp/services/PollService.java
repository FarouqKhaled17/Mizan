package com.Mizan.MizanApp.services;

import com.Mizan.MizanApp.Repositories.PollRepository;
import com.Mizan.MizanApp.model.Poll;
import org.springframework.stereotype.Service;

@Service
public class PollService {
    private PollRepository pollRepository;
    public PollService(PollRepository pollRepository){
        this.pollRepository = pollRepository;
    }
    public Poll createPoll(Poll poll){
        return pollRepository.save(poll);
    }
}
