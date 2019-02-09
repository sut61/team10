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
import javax.persistence.PersistenceException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@RunWith(SpringRunner.class)
@DataJpaTest

public class TestPayment {
    @Autowired
    private Paymentrepository paymentrepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired private MemberRepository memberRepository;
    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private ReservationStudio reservationStudio;
    private  ReservationModel reservationModel;
    private  ReservationPhotographer reservationPhotographer;
    private  Reservationequipment reservationequipment;
    private  Photocollection photocollection;
    private Member member;
    private  Cardtype cardtype;
    private Cardbank cardbank;
    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testSuccess() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(231);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        entityManager.persist(p);
        entityManager.flush();
            System.out.println();
            System.out.println("1.Data Success--------------------------------");
            System.out.println();

    }
    @Test
    public void testUnique() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(231);
        p.setCard_id("1234567891234567");
        p.setCard_name("pongpol");

        entityManager.persist(p);
        entityManager.flush();


        Payment p1 = new Payment();
        p1.setPayment_total(1001);
        p1.setCard_cvv(231);
        p1.setCard_id("1234567891234567");
        p1.setCard_name("pongpol");


        try{
            entityManager.persist(p1);
            entityManager.flush();
            fail("Should not pass to this line");

        }catch (javax.persistence.PersistenceException e){
            System.out.println();
            System.out.println( e + "2. same --------------------------------");
            System.out.println();
        }


    }

        @Test
    public void testPriceNegative() {
        Payment p = new Payment();
        p.setPayment_total(-100);
        p.setCard_cvv(231);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");

        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"3.price Negative--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testPricenotzero() {
        Payment p = new Payment();
        p.setPayment_total(0);
        p.setCard_cvv(231);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");

        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"4.price zero--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testcvvlong() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(231132);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");

        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+" 5.cvv long--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testcvvshot() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(2323);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");

        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"6.cvv low--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }

    @Test
    public void testidshot() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(231);
        p.setCard_id("1111111");
        p.setCard_name("pongpol");

        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+" 7.id shot--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }

    }
    @Test
    public void testidlong() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(231);
        p.setCard_id("11111111111111111111");
        p.setCard_name("pongpol");

        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"8.id long--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }

    }

    @Test
    public void testnamehaveint() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(231);
        p.setCard_id("1234567891234567");
        p.setCard_name("pongpol123");

        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"9.name have int--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }

}
