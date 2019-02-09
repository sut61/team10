package com.example.demo;
import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.sql.Time;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Null;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TestReservationPhotographer {
    @Autowired
    private  ReservationPhotographerRepository reservationPhotographerRepository;
    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void TestDataAll() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser("aaa@gmail.com");
        reserph.setPricephoto(1500L);
        reserph.setComment_photo("สู้ๆต่อไป");
        reserph.setPhoneusr("0945553212");

        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestPattern() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("AAAA");
        reserph.setEmailuser("aaa@gmail.com");
        reserph.setPricephoto(1555L);
        reserph.setComment_photo("AAAAAA");
        reserph.setPhoneusr("0945553212");

        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestPointNULL() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment(null);
        reserph.setEmailuser("aaa@gmail.com");
        reserph.setPricephoto(1555L);
        reserph.setPhoneusr("0945553212");
        reserph.setComment_photo("โคราช");


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestEmailNULL() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser(null);
        reserph.setPricephoto(1555L);
        reserph.setPhoneusr("0945553212");
        reserph.setComment_photo("สู้ต่อไป");


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestPhoneNULL() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser("aaaa@gmail.com");
        reserph.setPricephoto(1555L);
        reserph.setPhoneusr(null);
        reserph.setComment_photo("สู้ต่อไป");


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestCommentNULL() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser("aaa@gmail.com");
        reserph.setPricephoto(1555L);
        reserph.setPhoneusr("0945553212");
        reserph.setComment_photo(null);


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void TestCommentMin() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser("aaa@gmail.com");
        reserph.setPricephoto(1555L);
        reserph.setPhoneusr("0945553212");
        reserph.setComment_photo("ปป");


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestCommentMax() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser("aaaa@gmail.com");
        reserph.setPricephoto(1555L);
        reserph.setPhoneusr("0945553212");
        reserph.setComment_photo("สู้ต่อไปปปปปปปปปปปปปปปปปปปปปปปปปปปปปปปปปปปปป");


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
  }
    @Test
    public void TestPricePositive() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser("aaaa@gmail.com");
        reserph.setPricephoto(0L);
        reserph.setPhoneusr("0945553212");
        reserph.setComment_photo("สู้ต่อไป");


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestPricePhotoMin() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser("aaaa@gmail.com");
        reserph.setPricephoto(800L);
        reserph.setPhoneusr("0945553212");
        reserph.setComment_photo("สู้ต่อไป");


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestPricePhotoMax() {
        ReservationPhotographer reserph = new ReservationPhotographer();
        reserph.setAppointment("โคราช");
        reserph.setEmailuser("aaaa@gmail.com");
        reserph.setPricephoto(3001L);
        reserph.setPhoneusr("0945553212");
        reserph.setComment_photo("สู้ต่อไป");


        try {
            reserph.setReservation_date(formatter5.parse("2019-03-24 00:00:00"));
            entityManager.persist(reserph);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
