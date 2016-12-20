package com.devcolibri.dataexam.repository;

import com.devcolibri.dataexam.entity.MP3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MP3Repository extends JpaRepository<MP3,Long> {
    @Query("select b from mp3 b where b.name = :name")
    MP3 findByName(@Param("name") String name);

    List<MP3> findByLastName(String lastName);
}
