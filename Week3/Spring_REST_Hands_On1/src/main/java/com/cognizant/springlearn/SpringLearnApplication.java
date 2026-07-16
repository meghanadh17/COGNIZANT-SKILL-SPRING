package com.cognizant.springlearn;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("START");
        SpringLearnApplication app = new SpringLearnApplication();
        app.displayDate();
        app.displayCountry();
        app.displayCountries();
        SpringApplication.run(SpringLearnApplication.class, args);
        LOGGER.info("END");
    }

    public void displayDate() throws Exception {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        Date date = format.parse("31/12/2018");
        LOGGER.debug("Date: " + date);
        LOGGER.info("END");
    }

    public void displayCountry() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country country = context.getBean("in", Country.class);
        Country anotherCountry = context.getBean("in", Country.class);
        LOGGER.debug("Country : {}", country.toString());
        LOGGER.info("END");
    }

    public void displayCountries() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        List<Country> countries = context.getBean("countryList", List.class);
        LOGGER.debug("Countries : {}", countries.toString());
        LOGGER.info("END");
    }
}