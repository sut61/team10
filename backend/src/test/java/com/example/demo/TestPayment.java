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
    @Autowired
    private Cardbankrepository cardbankrepository;
    @Autowired
    private Cardtyperepository cardtyperepository;
    @Autowired
    private MemberRepository memberRepository;

    private Validator validator;


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
        member = memberRepository.findByName("dikinakub");
        cardbank = cardbankrepository.findByKey("1");
        cardtype = cardtyperepository.findByKey("1");
    }
    @Test
    public void testSuccess() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(111);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        entityManager.persist(p);
        entityManager.flush();
            System.out.println();
            System.out.println("Data Success--------------------------------");
            System.out.println();

    }
    @Test
    public void testUnique() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(111);
        p.setCard_id("1234567891234567");
        p.setCard_name("pongpol");
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        entityManager.persist(p);
        entityManager.flush();


        Payment p1 = new Payment();
        p1.setPayment_total(1001);
        p1.setCard_cvv(111);
        p1.setCard_id("1234567891234567");
        p1.setCard_name("pongpol");

        p1.setCardbank(cardbank);
        p1.setCardtype(cardtype);
        p1.setMember(member);

        try{
            entityManager.persist(p1);
            entityManager.flush();
            fail("Should not pass to this line");

        }catch (javax.persistence.PersistenceException e){
            System.out.println();
            System.out.println( e + " same  card-id--------------------------------");
            System.out.println();
        }


    }

        @Test
    public void testPriceNegative() {
        Payment p = new Payment();
        p.setPayment_total(-100);
        p.setCard_cvv(111);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
            p.setPhotocollection(photocollection);
            p.setReservationPhotographer(reservationPhotographer);
            p.setReservationStudio(reservationStudio);
            p.setReservationModel(reservationModel);
            p.setReservationequipment(reservationequipment);
            p.setCardbank(cardbank);
            p.setCardtype(cardtype);
            p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"price Negative--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }

    }
    @Test
    public void testPriceZero() {
        Payment p = new Payment();
        p.setPayment_total(0);
        p.setCard_cvv(111);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"price zero--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }

    }
    @Test
    public void testPriceOver() {
        Payment p = new Payment();
        p.setPayment_total(30000);
        p.setCard_cvv(111);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"price over--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testPriceLow() {
        Payment p = new Payment();
        p.setPayment_total(20);
        p.setCard_cvv(111);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"price low--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testCardTypeNameNull(){
        Cardtype ct = new Cardtype();
        ct.setCard_type(null);
        ct.setKey("4");
        try {

            entityManager.persist(ct);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"CardTypeNameNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test
    public void testCardTypeKeyNull(){
        Cardtype ct = new Cardtype();
        ct.setCard_type("aa");
        ct.setKey(null);
        try {

            entityManager.persist(ct);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"CardTypeKeyNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test
    public void testCardBankKeyNull(){
        Cardbank cb = new Cardbank();
        cb.setCard_bank("aa");
        cb.setKey(null);
        try {

            entityManager.persist(cb);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"CardBankKeyNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    @Test
    public void testCardBankNameNull(){
        Cardbank cb = new Cardbank();
        cb.setCard_bank(null);
        cb.setKey("aa");
        try {

            entityManager.persist(cb);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"CardBankNameNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testCvvOver() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(1000);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"cvv Over --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testIdShot() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(111);
        p.setCard_id("1111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+" id shot--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }

    }
    @Test
    public void testIdLong() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(111);
        p.setCard_id("11111111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"id long--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);

        }

    }
    @Test
    public void testIdString() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(111);
        p.setCard_id("33333333ffffffff");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"id have string--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testIdNull() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(111);
        p.setCard_id(null);
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"id null--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testnamehaveint() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(111);
        p.setCard_id("1234567891234567");
        p.setCard_name("pongpol123");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"name have int--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testNameNull() {
        Payment p = new Payment();
        p.setPayment_total(1001);
        p.setCard_cvv(111);
        p.setCard_id("1234567891234567");
        p.setCard_name(null);
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+" name null--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testMemberNull() {
        Payment p = new Payment();
        p.setPayment_total(1200);
        p.setCard_cvv(111);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(cardtype);
        p.setMember(null);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"member null--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testCardTypeNull() {
        Payment p = new Payment();
        p.setPayment_total(1200);
        p.setCard_cvv(111);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(cardbank);
        p.setCardtype(null);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"cardtype null--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
    @Test
    public void testCardBankNull() {
        Payment p = new Payment();
        p.setPayment_total(1200);
        p.setCard_cvv(111);
        p.setCard_id("1111111111111111");
        p.setCard_name("pongpol");
        p.setPhotocollection(photocollection);
        p.setReservationPhotographer(reservationPhotographer);
        p.setReservationStudio(reservationStudio);
        p.setReservationModel(reservationModel);
        p.setReservationequipment(reservationequipment);
        p.setCardbank(null);
        p.setCardtype(cardtype);
        p.setMember(member);
        try {

            entityManager.persist(p);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"cardbank null--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }

    }
}
