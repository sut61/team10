package com.example.demo;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.Date;
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
public class TestTablePhotogarpher {

    @Autowired
    private TablePhotographerRepository tablePhotographerRepository;
    @Autowired private PromotionTableRepository promotionTableRepository ;
    @Autowired private TimesPhotogarpherRepository timesPhotogarpherRepository;
    @Autowired PhotographerRepository photographerRepository;
    @Autowired private AdminRepository adminRepository;
    @Autowired private TypePhotoRepository typePhotoRepository;

    @Autowired
    private TestEntityManager entityManager;



    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private TimesPhotogarpher timesPhotogarpher;
    private  PromotionTable promotionTable;
    private Photographer photographer;
    private TypePhoto typePhoto;
    private Admin admin;

    Date date = new Date();


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        admin = adminRepository.findByUserid("admin");

        timesPhotogarpher =timesPhotogarpherRepository.findBytimes("8.00-12.00 น.");
        promotionTable = promotionTableRepository.findBypromotionnametable("ครึ่งวันเช้า");
        photographer = photographerRepository.findBykeyp("key1");
        typePhoto =typePhotoRepository.findBykeyt("key1");

    }

    @Test
    public void testTablePhotographeSucsess() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490179");
        tablePhotographer.setLocation("เกาะล้าน");
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerSucsess<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testTablePhotographerAdminNotNull() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(null); //Null
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490179");
        tablePhotographer.setLocation("เกาะล้าน");
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerAdminNotNull<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test ////Test คลาสย่อย Entity Class TimesPhotogarpher
    public void testTimesPhotogarpherNull(){
        TimesPhotogarpher tp = new TimesPhotogarpher();
        tp.setTimes(null);
        try {

            entityManager.persist(tp);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"TimesPhotogarpherNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //Test คลาสย่อย Entity Class PromotionTable
    public void testPromotionNameNull(){
        PromotionTable pt = new PromotionTable();
        pt.setPromotionName(null);
        pt.setPrice(2000);
        try {

            entityManager.persist(pt);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"PromotionNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test //Test คลาสย่อย Entity Class PromotionTable
    public void testPromotionPriceNoPositive(){
        PromotionTable pt = new PromotionTable();
        pt.setPromotionName("ครึ่งวันเช้า");
        pt.setPrice(-1000);
        try {

            entityManager.persist(pt);
            entityManager.flush();

            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e+"NoPricePositive--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testTablePhotographerPromotionNull() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(null); //Null
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490179");
        tablePhotographer.setLocation("เกาะล้าน");
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerPromotionNull<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testTablePhotographerTimesNull() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(null); //Null
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490179");
        tablePhotographer.setLocation("เกาะล้าน");
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerTimesNull<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testTablePhotographerMinsize1() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("087"); //min
        tablePhotographer.setLocation("เกาะล้าน");
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerMinsize1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testTablePhotographerMinsize2() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490179");
        tablePhotographer.setLocation("ลาน"); //min
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerMinsize1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testTablePhotographerMaxsize1() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("087449017949649"); //max
        tablePhotographer.setLocation("เกาะล้าน");
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerMaxsize1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testTablePhotographerMaxsize2() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490179");
        tablePhotographer.setLocation("เกาะล้านรรนยฟห่กนห่ฟนก่นหกน่หฟกร่ฟยหรก่นหฟยก่ยฟห่หกฟห"); //max
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>testTablePhotographerMaxsize2<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testTablePhotographerPattern1() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490ABC"); //Pattern
        tablePhotographer.setLocation("เกาะล้าน");
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>testTablePhotographerPattern1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testTablePhotographerPattern2() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490179");
        tablePhotographer.setLocation("PartyPull"); //Pattern
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>testTablePhotographerPattern2<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testTablePhotographerStringNull1() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel(null); //Null
        tablePhotographer.setLocation("เกาะล้าน");
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerStringNull1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testTablePhotographerStringNull2() {
        TablePhotographer tablePhotographer = new TablePhotographer();

        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0874490179");
        tablePhotographer.setLocation(null); //Null
        try {
            tablePhotographer.setDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(tablePhotographer);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>TablePhotographerStringNull2<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }




    @Test(expected=javax.persistence.PersistenceException.class)
    public void TestUnique1() {
        TablePhotographer tablePhotographer = new TablePhotographer();
        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0885825238");
        tablePhotographer.setLocation("เกาะล้าน");
        entityManager.persist(tablePhotographer);
        entityManager.flush();

        TablePhotographer tablePhotographer2 = new TablePhotographer();
        tablePhotographer2.setAdmin(admin);
        tablePhotographer2.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer2.setPromotionTable(promotionTable);
        tablePhotographer2.setPhotographer(photographer);
        tablePhotographer2.setTypePhoto(typePhoto);
        tablePhotographer2.setTel("0885825238");
        tablePhotographer2.setLocation("เกาะช้างง");
        entityManager.persist(tablePhotographer2);
        entityManager.flush();

        try {
            entityManager.persist(tablePhotographer2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println( e + " same  Tel--------------------------------");
        }
    }

    @Test(expected=javax.persistence.PersistenceException.class)
    public void TestUnique2() {
        TablePhotographer tablePhotographer = new TablePhotographer();
        tablePhotographer.setAdmin(admin);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setPhotographer(photographer);
        tablePhotographer.setTypePhoto(typePhoto);
        tablePhotographer.setTel("0885825238");
        tablePhotographer.setLocation("เกาะล้าน");
        entityManager.persist(tablePhotographer);
        entityManager.flush();

        TablePhotographer tablePhotographer2 = new TablePhotographer();
        tablePhotographer2.setAdmin(admin);
        tablePhotographer2.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer2.setPromotionTable(promotionTable);
        tablePhotographer2.setPhotographer(photographer);
        tablePhotographer2.setTypePhoto(typePhoto);
        tablePhotographer2.setTel("0874490179");
        tablePhotographer2.setLocation("เกาะล้าน");
        entityManager.persist(tablePhotographer2);
        entityManager.flush();

        try {
            entityManager.persist(tablePhotographer2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println( e + " same  Location--------------------------------");
        }
    }



}
