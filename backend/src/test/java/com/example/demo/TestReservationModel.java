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

public class TestReservationModel {
    @Autowired
    private ReservationModelRepository reservationModelRepository;
    @Autowired private TestEntityManager entityManager;
    @Autowired private MemberRepository memberRepository;
    @Autowired private ModelRepository modelRepository;
    @Autowired private PromotionModelRepository promotionModelRepository;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Member member;
    private Model model;
    private PromotionModel promotionModel;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        member = memberRepository.findByName("dikinakub");
        model = modelRepository.findByfirstnamemodel("สุกานดา");
        promotionModel = promotionModelRepository.findBypromotionnamemodel("8:00-12:00 800บาท");

    }
    @Test
    public void testReservationModelSuccess() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationModel.setLocation("เกาะล้าน"); //ถูก
        reservationModel.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }
    @Test
    public void testReservationModelNotNull() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(null);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationModel.setLocation("เกาะล้าน"); //ถูก
        reservationModel.setPromotionModel(promotionModel);
        try {

            entityManager.persist(reservationModel);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelMemberNotNull<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    @Test
    public void testReservationModelNotNull2() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(null);
        reservationModel.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationModel.setLocation("เกาะล้าน"); //ถูก
        reservationModel.setPromotionModel(promotionModel);
        try {

            entityManager.persist(reservationModel);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ModelNotNull<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    public void testReservationModelNotNull3() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationModel.setLocation("เกาะล้าน"); //ถูก
        reservationModel.setPromotionModel(null);
        try {

            entityManager.persist(reservationModel);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ProNotNull<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    @Test
    public void testReservationModelMaxsize1() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationModel.setLocation("โรงเรียนอุบลรัตนราชกัญญาราชวิทยาลัย"); //สตริงเกินMax
        reservationModel.setPromotionModel(null);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelMaxsize1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }

    @Test
    public void testReservationModelMaxsize2() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดว่ายน้ำและชุดนักเรียน"); //สตริงเกิน Max
        reservationModel.setLocation("โรงเรียน"); //ถูก
        reservationModel.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelMaxsize1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    @Test
    public void testReservationModelMinsize1() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุด"); //สตริงน้อยกว่า Min
        reservationModel.setLocation("โรงเรียน");//ถูก
        reservationModel.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelMinsize1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    @Test
    public void testReservationModelMinsize2() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationModel.setLocation("สระ");  //สตริงน้อยกว่า Min
        reservationModel.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelMinsize2<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    @Test
    public void testReservationModelStringNull() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes(null);//สตริงเป็นnull
        reservationModel.setLocation("โรงเรียน");//ถูก
        reservationModel.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelStringNull<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    @Test
    public void testReservationModelStringNull2() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดนักเรียน");//ถูก
        reservationModel.setLocation(null);//สตริงเป็นnull
        reservationModel.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelStringNull<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
        }

    @Test
    public void testReeservationModelPattern1() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("two piece"); //ผิดpatten
        reservationModel.setLocation("เกาะล้าน");
        reservationModel.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelPattern1<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    @Test
    public void testReeservationModelPattern2() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationModel.setLocation("Partypool"); //ผิดpatten
        reservationModel.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println();
            System.out.println(e+">>>>>>>>>>>>>>>>ReservationModelPattern2<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println();
        }
    }
    @Test
    public void testReservationModelunique() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationModel.setLocation("เกาะล้าน"); //ถูก
        reservationModel.setPromotionModel(promotionModel);

        ReservationModel reservationMod2 = new ReservationModel();
        reservationMod2.setMember(member);
        reservationMod2.setModel(model);
        reservationMod2.setThemes("ชุดว่ายน้ำ"); //ถูก
        reservationMod2.setLocation("เกาะเฃช้าง"); //ถูก
        reservationMod2.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }

    @Test
    public void testReservationModelunique2() {
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes("ชุดนักเรียน"); //ถูก
        reservationModel.setLocation("โรงเรียน"); //ถูก
        reservationModel.setPromotionModel(promotionModel);

        ReservationModel reservationMod2 = new ReservationModel();
        reservationMod2.setMember(member);
        reservationMod2.setModel(model);
        reservationMod2.setThemes("ชุดไทย"); //ถูก
        reservationMod2.setLocation("โรงเรียน"); //ถูก
        reservationMod2.setPromotionModel(promotionModel);

        try {
            entityManager.persist(reservationModel);
            entityManager.flush();


        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
        }
    }


    }
