package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.MP3Dao;
import net.proselyte.bookmanager.model.MP3;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MP3ServiceImpl implements MP3Service {
    private MP3Dao mp3Dao;

    public void setMp3Dao(MP3Dao mp3Dao) {
        this.mp3Dao = mp3Dao;
    }

    @Override
    @Transactional
    public List<MP3> listMP3() {
        return this.mp3Dao.listMP3();
    }
}