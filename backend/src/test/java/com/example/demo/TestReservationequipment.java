package com.example.demo;


import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import java.util.Collections;
import java.util.Date;
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
public class TestReservationequipment {
    @Autowired
    private Reservationequipmentrepository reservationequipmentrepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired private MemberRepository memberRepository;

    private Validator validator;

    private Member member;
    private Equipment equipment;
    private Timereceive timereceive;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testReservationequipmentSuccess () {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1249900467392");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setMember(member);
        reser.setTimereceive(timereceive);
        entityManager.persist(reser);
        entityManager.flush();
        System.out.println();
        System.out.println(" Success Data --------------------------------");
        System.out.println();
    }
    @Test
    public void testUnique() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1234567891234");

        entityManager.persist(reser);
        entityManager.flush();

        Reservationequipment reser1 = new Reservationequipment();
        reser1.setCardid("1234567891234");



        try{
            entityManager.persist(reser1);
            entityManager.flush();
            fail("Should not pass to this line");

        }catch (javax.persistence.PersistenceException e){
            System.out.println();
            System.out.println( e + " same Cardid --------------------------------");
            System.out.println();
        }
    }
    @Test
    public void testReservationequipmenthaveString () {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("kihi1531311");

        try {

            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " have String in Cardid --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testReservationequipmentMin() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("123456");

        try {
            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Min cardid--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }

    }
    @Test
    public void testReservationequipmentOver() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("123456789123456");

        try {

            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Over cardid--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    @Test
    public void testReservationequipmentNull() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid(null);

        try {

            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Null cardid--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


}
