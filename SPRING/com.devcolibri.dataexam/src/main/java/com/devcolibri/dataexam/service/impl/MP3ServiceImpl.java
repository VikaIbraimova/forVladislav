package com.devcolibri.dataexam.service.impl;

import com.devcolibri.dataexam.entity.Customer;
import com.devcolibri.dataexam.repository.MP3Repository;
import com.devcolibri.dataexam.service.MP3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MP3ServiceImpl implements MP3Service{

    @Autowired
    private MP3Repository mp3Repository;

    @Override
    public List<Customer> getAll() {
        return mp3Repository.findAll();
    }
}