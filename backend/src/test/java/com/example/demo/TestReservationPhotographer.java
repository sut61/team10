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
    private PromotionPhotographerRepository promotionPhotographerRepository;
    @Autowired
    private PhotographerRepository photographerRepository;
    @Autowired
    private TypePhotoRepository typePhotoRepository;
    @Autowired
    private StartTimeRepository startTimeRepository;

    @Autowired
    private TestEntityManager entityManager;
    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Member member;
    private PromotionPhotographer promotionPhotographer;
    private Photographer photographer;
    private TypePhoto typePhoto;
    private StartTime startTime;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        photographer = photographerRepository.findBykeyp("key1");
        typePhoto =typePhotoRepository.findBykeyt("key1");
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

    @Test
    public void testPromotionPhotographerNull(){
        PromotionPhotographer promotionph = new PromotionPhotographer();
        promotionph.setPromotionphoto_name(null);
        promotionph.setPromotion_time(1L);
        promotionph.setPromotion_price(1500L);
        try {

            entityManager.persist(promotionph);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"promotionPhotographerNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testPromotionPhotographerTimeNull(){
        PromotionPhotographer promotionph = new PromotionPhotographer();
        promotionph.setPromotionphoto_name("เซฟนะครับ");
        promotionph.setPromotion_time(0L);
        promotionph.setPromotion_price(1500L);
        try {

            entityManager.persist(promotionph);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"promotionPhotographerNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testPromotionPhotographerPriceNull(){
        PromotionPhotographer promotionph = new PromotionPhotographer();
        promotionph.setPromotionphoto_name("เซฟนะครับ");
        promotionph.setPromotion_time(1L);
        promotionph.setPromotion_price(0L);
        try {

            entityManager.persist(promotionph);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"promotionPhotographerNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testnPhotographerNull(){
        Photographer photog = new Photographer();
        photog.setPhotographer_name(null);
        photog.setPhotographer_age(20);
        photog.setPhotographer_email("aaaaa@gmail.com");
        photog.setPhotographer_tel("0989999999");
        photog.setKeyp("keyp1");
        try {

            entityManager.persist(photog);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"PhotographerNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testnPhotographerAgeNull(){
        Photographer photog = new Photographer();
        photog.setPhotographer_name("ดิกินะครับ");
        photog.setPhotographer_age(0);
        photog.setPhotographer_email("aaaaa@gmail.com");
        photog.setPhotographer_tel("0989999999");
        photog.setKeyp("keyp1");
        try {

            entityManager.persist(photog);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"PhotographerNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testnPhotographerEmailNull(){
        Photographer photog = new Photographer();
        photog.setPhotographer_name("ดิกกินะครับ");
        photog.setPhotographer_age(20);
        photog.setPhotographer_email(null);
        photog.setPhotographer_tel("0989999999");
        photog.setKeyp("keyp1");
        try {

            entityManager.persist(photog);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"PhotographerNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testnPhotographerTelNull(){
        Photographer photog = new Photographer();
        photog.setPhotographer_name("ดิกกินะครับ");
        photog.setPhotographer_age(20);
        photog.setPhotographer_email("aaaaa@gmail.com");
        photog.setPhotographer_tel(null);
        photog.setKeyp("keyp1");
        try {

            entityManager.persist(photog);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"PhotographerNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testnStartTimeNull(){
        StartTime st = new StartTime();
        st.setStratTime(null);
        try {

            entityManager.persist(st);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"StratTimeNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testTypePhotoNull(){
        TypePhoto tp = new TypePhoto();
        tp.setTypephoto_name(null);
        tp.setKeyt("keyt1");
        try {

            entityManager.persist(tp);
            entityManager.flush();

            //fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"TypePhotoNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }


}
