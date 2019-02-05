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
public class TestReservationequipment {
    @Autowired
    private Reservationequipmentrepository reservationequipmentrepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Member member;
    private Equipment equipment;
    private Timereceive timereceive;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void testReservationequipmentNoInt() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("kihi1531311");
        reser.setMember(member);
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        try {
            reser.setDaterent(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testReservationequipmentMin() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("123456");
        reser.setMember(member);
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        try {
            reser.setDaterent(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testReservationequipmentOver() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("123456789123456");
        reser.setMember(member);
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        try {
            reser.setDaterent(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testReservationequipmentNull() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid(null);
        reser.setMember(member);
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        try {
            reser.setDaterent(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test(expected=javax.persistence.PersistenceException.class)
    public void testUniqueRentwquipment() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1234567891234");
        reser.setMember(member);
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        entityManager.persist(reser);
        entityManager.flush();

        Reservationequipment reser1 = new Reservationequipment();
        reser1.setCardid("1234567891234");
        reser1.setMember(member);
        reser1.setEquipment(equipment);
        reser1.setTimereceive(timereceive);
        entityManager.persist(reser1);
        entityManager.flush();

        fail("Should not pass to this line");
    }

}
