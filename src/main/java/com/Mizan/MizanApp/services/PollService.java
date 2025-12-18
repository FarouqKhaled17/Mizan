package com.Mizan.MizanApp.services;

import com.Mizan.MizanApp.Repositories.PollRepository;
import com.Mizan.MizanApp.exception.PollNotFoundException;
import com.Mizan.MizanApp.model.Poll;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {
    private PollRepository pollRepository;
    public PollService(PollRepository pollRepository){
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll){
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls(){
        return pollRepository.findAll();
    }

    public Poll getPollById(Long id) {
        return pollRepository.findById(id).orElseThrow(()->new PollNotFoundException("Poll Not Found!"));
    }

    public Poll updatePoll(Long id, Poll pollDetails){
        Poll poll = pollRepository.findById(id).orElseThrow(()->new PollNotFoundException("Poll Not Found!"));
        poll.setQuestion(pollDetails.getQuestion());
        poll.setOptions(pollDetails.getOptions());
        return pollRepository.save(poll);
    }

    public void deletePoll(Long id){
        boolean isExist=pollRepository.existsById(id);
        if(!isExist){
            throw new PollNotFoundException("Poll Not Found!");
        } else {
            pollRepository.deleteById(id);
        }
    }

}
