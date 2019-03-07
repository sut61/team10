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
public class TestPhotocollection {

    @Autowired
    private Photocollectionrepository photocollectionrepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private Photoseriesrepository photoseriesrepository;
    @Autowired
    private Shootingstylerepository shootingstylerepository;
    @Autowired
    private Promotionphotocollectionrepository promotionphotocollectionrepository;


    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private  Promotionphotocollection promotionphotocollection;
    private  Shootingstyle shootingstyle;
    private  Photoseries photoseries;
    private  Member member;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        member = memberRepository.findByName("dikinakub");
        promotionphotocollection = promotionphotocollectionrepository.findByname("ครึ่งวันเช้า 300บาท");
        shootingstyle = shootingstylerepository.findByname("สีขาว");
        photoseries = photoseriesrepository.findByname("ชุดว่ายน้ำ");
    }
    @Test
    public void testPhotocollectionTure() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionTure");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotocollectionFlase() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("มีลายจุดhop");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionFlase");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotocollectionMaxSize() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้สวย");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionMaxSize");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotocollectionMinSize() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ดอก");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionMinSize");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotocollectionNull() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite(null);

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotocollectionMemberNull() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(null);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionMemberNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    /*@Test
    public void  testPhotocollectionMember2Null(){
        Member member = new Member();
        member.setName(null);
        try {
            entityManager.persist(member);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e + "PhotopictureMemberNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 7);
        }
    }*/
    @Test
    public void testPhotocollectionPhotoseriesNull() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(null);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionPhotoseriesNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void  testPhotocollectionPhotoseries2Null(){
        Photoseries photoseries = new Photoseries();
        photoseries.setName(null);
        try {
            entityManager.persist(photoseries);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e + "PhotocollectionPhotoseriesNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testPhotocollectionShootingstyleNull() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(null);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionShootingstyleNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void  testPhotocollectionShootingstyle2Null(){
        Shootingstyle shootingstyle = new Shootingstyle();
        shootingstyle.setName(null);
        try {
            entityManager.persist(shootingstyle);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e + "PhotocollectionShootingstyleNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testPhotocollectionPromotionphotocollectionNull() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(null);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotocollectionPromotionphotocollectionNull");
            System.out.println();
        } catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void  testPhotocollectionPromotionphotocollection2Null(){
        Promotionphotocollection promotionphotocollection = new Promotionphotocollection();
        promotionphotocollection.setName(null);
        try {
            entityManager.persist(promotionphotocollection);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e + "PhotocollectionPromotionphotocollectionNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testPhotocollectionunique() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");
        entityManager.persist(photocollection);
        entityManager.flush();

        Photocollection p1 = new Photocollection();
        p1.setMember(member);
        p1.setPhotoseries(photoseries);
        p1.setShootingstyle(shootingstyle);
        p1.setPromotionphotocollection(promotionphotocollection);
        p1.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        try {
            entityManager.persist(p1);
            //entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }
    @Test
    public void testShootingstylenameNull() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename(null);


        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testShootingstylenameNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotoseriesnamenameNull() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        photocollection.setPromotionphotocollectionname("ครึ่งวันเช้า 300บาท");
        photocollection.setPhotoseriesname(null);
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotoseriesnamenameNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPromotionphotocollectionnameNull() {
        Photocollection photocollection = new Photocollection();
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstylenamewrite("ชุดจะมีลายจุดดอกไม้");

        photocollection.setPromotionphotocollectionname(null);
        photocollection.setPhotoseriesname("ชุดไทย");
        photocollection.setShootingstylename("สีขาว");
        try {
            photocollection.setStartdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photocollection);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPromotionphotocollectionnameNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

}
