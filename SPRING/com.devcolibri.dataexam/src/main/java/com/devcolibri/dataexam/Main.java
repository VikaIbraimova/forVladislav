package com.devcolibri.dataexam;


import com.devcolibri.dataexam.entity.Customer;
import com.devcolibri.dataexam.entity.MP3;
import com.devcolibri.dataexam.repository.MP3Repository;
import org.springframework.context.annotation.Bean;

/**
 * Created by vika on 19.12.16.
 */
public class Main {

    public static void main(String[] args) {

        MP3 mp3 = new MP3("Song_1","Author_1");
        System.out.println("Hello,Vika!!!");
    }


}
