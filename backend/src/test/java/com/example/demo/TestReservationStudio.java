package com.example.demo;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TestReservationStudio {

    @Autowired
    private ReservationStudioRepository reservationStudioRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Member member;
    private PromotionStudio promotionStudio;
    private RoomStudio roomStudio;
    private TimeStudio timeStudio;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testReservationStudio() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(0);
        reser.setMember(member);
        reser.setPromotionStudio(promotionStudio);
        reser.setRoomStudio(roomStudio);
        reser.setTimeStudio(timeStudio);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReservationStudio1() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(-123);
        reser.setMember(member);
        reser.setPromotionStudio(promotionStudio);
        reser.setRoomStudio(roomStudio);
        reser.setTimeStudio(timeStudio);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
            entityManager.flush();

          //  fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReservationStudio2() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(2001);
        reser.setMember(member);
        reser.setPromotionStudio(promotionStudio);
        reser.setRoomStudio(roomStudio);
        reser.setTimeStudio(timeStudio);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
            entityManager.flush();

            //  fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReservationStudio3() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(999);
        reser.setMember(member);
        reser.setPromotionStudio(promotionStudio);
        reser.setRoomStudio(roomStudio);
        reser.setTimeStudio(timeStudio);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
            entityManager.flush();

            //  fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }




}
