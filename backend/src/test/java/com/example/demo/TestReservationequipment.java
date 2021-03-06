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
    @Autowired
    private Equipmentrepository equipmentrepository;
    @Autowired
    private Timereceiverepository timereceiverepository;
    @Autowired
    private MemberRepository memberRepository;


    private Validator validator;
    private Equipment equipment;
    private Timereceive timereceive;
    private Member member;


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        timereceive = timereceiverepository.findByKeytime("2");
        member = memberRepository.findByName("dikinakub");
        equipment = equipmentrepository.findByKey("1");
    }

    @Test
    public void testReservationEquipmentSuccess () {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1249900467392");
        reser.setDetail_equipment("aa");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        reser.setMember(member);
        entityManager.persist(reser);
        entityManager.flush();
        System.out.println();
        System.out.println(" Success Data --------------------------------");
        System.out.println();
    }


    @Test
    public void testReservationEquipmentHaveString () {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("kihi1531311");
        reser.setDetail_equipment("aa");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        reser.setMember(member);
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
    public void testReservationEquipmentNameNull () {
        Equipment eq = new Equipment();
        eq.setEquipment_name(null);
        eq.setEquipment_brand("aa");
        eq.setEquipment_type("fg");
        eq.setEquipment_price(100);
        eq.setKey("1");

        try {

            entityManager.persist(eq);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Name equipment Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationBrandNameNull () {
        Equipment eq = new Equipment();
        eq.setEquipment_name("qqdf");
        eq.setEquipment_brand(null);
        eq.setEquipment_type("fg");
        eq.setEquipment_price(100);
        eq.setKey("1");

        try {

            entityManager.persist(eq);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " BrandName Equipment Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationTypeNameNull () {
        Equipment eq = new Equipment();
        eq.setEquipment_name("aa");
        eq.setEquipment_brand("aa");
        eq.setEquipment_type(null);
        eq.setEquipment_price(100);
        eq.setKey("1");

        try {

            entityManager.persist(eq);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Name type Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationEquipmentPriceZero () {
        Equipment eq = new Equipment();
        eq.setEquipment_name("aa");
        eq.setEquipment_brand("aa");
        eq.setEquipment_type("fg");
        eq.setEquipment_price(0);
        eq.setKey("1");

        try {

            entityManager.persist(eq);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " price equipment 000 --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationEquipmentKeyNull () {
        Equipment eq = new Equipment();
        eq.setEquipment_name("qq");
        eq.setEquipment_brand("aa");
        eq.setEquipment_type("fg");
        eq.setEquipment_price(100);
        eq.setKey(null);

        try {

            entityManager.persist(eq);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Key equipment Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationTimeReceiveNameNull () {
        Timereceive t = new Timereceive();
        t.setTimereceive_name(null);
        t.setKeytime("aa");


        try {

            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Name Timereceive Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationTimeReceiveKeyNull () {
        Timereceive t = new Timereceive();
        t.setTimereceive_name("aa");
        t.setKeytime(null);

        try {

            entityManager.persist(t);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Key Timereceive Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationEquipmentMin() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("123456");
        reser.setDetail_equipment("aa");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        reser.setMember(member);
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
    public void testReservationEquipmentOver() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("123456789123456");
        reser.setDetail_equipment("aa");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        reser.setMember(member);
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
    public void testReservationEquipmentCardNull() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid(null);
        reser.setDetail_equipment("aa");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        reser.setMember(member);
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
    @Test
    public void testReservationDetailNull() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1234567891234");
        reser.setDetail_equipment(null);
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        reser.setMember(member);
        try {

            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Null Detail--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationDateNull() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1234567891234");
        reser.setDetail_equipment("aa");
        reser.setDaterent(null);
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        reser.setMember(member);
        try {

            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Null Date--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationEquipmentNull() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1234567891234");
        reser.setDetail_equipment("aa");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(null);
        reser.setTimereceive(timereceive);
        reser.setMember(member);
        try {

            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Null Equipment--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationTimeNull() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1234567891234");
        reser.setDetail_equipment("aa");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setTimereceive(null);
        reser.setMember(member);
        try {

            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Null Time--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReservationMemberNull() {
        Reservationequipment reser = new Reservationequipment();
        reser.setCardid("1234567891234");
        reser.setDetail_equipment("aa");
        reser.setDaterent(new Date(2018-1900,2-1,1));
        reser.setEquipment(equipment);
        reser.setTimereceive(timereceive);
        reser.setMember(null);
        try {

            entityManager.persist(reser);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + " Null Member--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testUnique() {
        Reservationequipment p = new Reservationequipment();
        p.setCardid("1249900467392");
        p.setDetail_equipment("aa");
        p.setDaterent(new Date(2018-1900,2-1,1));
        p.setEquipment(equipment);
        p.setTimereceive(timereceive);
        p.setMember(member);
        entityManager.persist(p);
        entityManager.flush();

        Reservationequipment p1 = new Reservationequipment();
        p1.setCardid("1249900467392");
        p1.setDetail_equipment("aa");
        p1.setDaterent(new Date(2018-1900,2-1,1));
        p1.setEquipment(equipment);
        p1.setTimereceive(timereceive);
        p1.setMember(member);
        try{
            entityManager.persist(p1);
            entityManager.flush();
            fail("Should not pass to this line");

        }catch (javax.persistence.PersistenceException e){
            System.out.println();
            System.out.println( e + " same Cardid --------------------------------");
            System.out.println();

        }


    }

}