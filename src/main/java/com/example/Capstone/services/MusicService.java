package com.example.Capstone.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.Capstone.entities.Music;
import com.example.Capstone.repositories.MusicRepository;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

	private static Logger logger = LoggerFactory.getLogger(MusicService.class);
	
    @Autowired
    private MusicRepository MusicRepository;

    public Iterable<Music> GetAllMusic()
    {
        return MusicRepository.findAll();
    }


    public Iterable<Music> SearchKeywordMusic(String keyword)
    {
        //TODO: this needs to be made much more robust.
        List<Music> returnList = new ArrayList<Music>();

        //TODO: we would want to search all attributes of music for the keyword, not just name.

        for (Music m : MusicRepository.findAll()) {
            if (m.getName().contains(keyword)) {
                returnList.add(m);
            }
        }
        return returnList;
    }
    public Optional<Music> GetMusicById(Long id)  {
        Optional<Music> foundMusic = MusicRepository.findById(id);

        return (foundMusic);
    }
    
    public Music findByMusicName(String name) throws Exception {
		
		Music music = MusicRepository.findMusicByName(name);
		if (music != null) {
			logger.info("album: " + music.toString());
			return music;
		}
		
		logger.error("song is null");
		throw new Exception("Song not found");
	}

    public Music AddMusic(Music music) {
        return MusicRepository.save(music);
    }

    public void DeleteMusic(Music music) {
        MusicRepository.delete(music);
    }


}
