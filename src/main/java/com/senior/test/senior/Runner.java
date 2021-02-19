package com.senior.test.senior;

import com.senior.test.senior.model.CheckIn;
import com.senior.test.senior.model.hospede;
import com.senior.test.senior.repository.CheckInRepository;
import com.senior.test.senior.repository.hospedeRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Runner  implements CommandLineRunner  {
    

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private hospedeRepository hospedeRepository;

    @Autowired
    private CheckInRepository checkinRepository;
    
    @Transactional
    public void run(String... args) throws Exception {

        logger.info("initializing users");

        /*var u1 = new hospede("Paul", "45678409033", "23/09/2020");
        hospedeRepository.save(u1);

        var u2 = new hospede("Robert Black", "93897379238", "17/093/2020");
        hospedeRepository.save(u2);

        var u3 = new hospede("John Doe", "29802080928", "08/03/2020");
        hospedeRepository.save(u3);

        var c1 = new CheckIn("","",false,u1);
        checkinRepository.save(c1);*/
    }
}
