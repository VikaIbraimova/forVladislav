package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.MP3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MP3DaoImpl implements MP3Dao {
    private static final Logger logger = LoggerFactory.getLogger(MP3DaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<MP3> listMP3() {
        //return null;
        Session session = this.sessionFactory.getCurrentSession();
        List<MP3> mp3List = session.createQuery("from mp3").list();

        for(MP3 mp3: mp3List){
            logger.info("MP3 list: " + mp3);
        }

        return mp3List;
    }
}
