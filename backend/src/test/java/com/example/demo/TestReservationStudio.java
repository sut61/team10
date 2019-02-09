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
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TestReservationStudio {

    @Autowired private ReservationStudioRepository reservationStudioRepository;
    @Autowired private TestEntityManager entityManager;
    @Autowired private MemberRepository memberRepository;
    @Autowired private PromotionStudioRepository promotionStudioRepository;
    @Autowired private RoomStudioRepository roomStudioRepository;
    @Autowired private TimeStudioRepository timeStudioRepository;

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
        member = memberRepository.findByName("dikinakub");
        promotionStudio = promotionStudioRepository.findByPromotionName("7:00-12:00 = 1000บาท");
        roomStudio = roomStudioRepository.findByName("ROOM1");
        timeStudio = timeStudioRepository.findByTimeName("ครึ่งวันเช้า");
    }

    @Test
    public void TestPriceTrue() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(1500);
        reser.setMember(member);
        reser.setPromotionStudio(promotionStudio);
        reser.setRoomStudio(roomStudio);
        reser.setTimeStudio(timeStudio);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
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
    public void TestPriceNotNull() {
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
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestPricePositive() {
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
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestPriceMuch() {
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
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestPriceLittle() {
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

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestMemberNotNull() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(1000);
        reser.setMember(null);
        reser.setPromotionStudio(promotionStudio);
        reser.setRoomStudio(roomStudio);
        reser.setTimeStudio(timeStudio);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
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
    public void TestPromotionNameNotNull() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(1000);
        reser.setMember(member);
        reser.setPromotionStudio(null);
        reser.setRoomStudio(roomStudio);
        reser.setTimeStudio(timeStudio);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
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
    public void TestRoomStudioNameNotNull() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(1000);
        reser.setMember(member);
        reser.setPromotionStudio(promotionStudio);
        reser.setRoomStudio(null);
        reser.setTimeStudio(timeStudio);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
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
    public void TestTimeStudioNotNull() {
        ReservationStudio reser = new ReservationStudio();
        reser.setPrice(1000);
        reser.setMember(member);
        reser.setPromotionStudio(promotionStudio);
        reser.setRoomStudio(roomStudio);
        reser.setTimeStudio(null);

        try {
            reser.setReservationDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
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
