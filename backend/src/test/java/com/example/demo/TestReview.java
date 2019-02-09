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
public class TestReview {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    private Member member;
    private Payment payment;
    private SystemName systemName;
    private Score score;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    @Test
    public void TestDataAll() {
        Review review = new Review();
        review.setComment_review("ก็มาดิค้าบบบบบบบ");
        review.setGood_comment("VERY GOOD");
        review.setDis_comment("BAD");
        review.setTopic("บ้าบอคอแตก");
        review.setDirection(10L);

        try {
            entityManager.persist(review);
            entityManager.flush();
            System.out.println();
            System.out.println("Review Success --------------------------------");
            System.out.println();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
   public void testReviewNotPattern () {
        Review review = new Review();
        review.setTopic("Review");
       review.setGood_comment("not good");
       review.setDis_comment("Noting");
       review.setComment_review("Nice system");
        review.setDirection(5L);
        try {

            entityManager.persist(review);
           entityManager.flush();

            fail("Should not pass to this line");
       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
          System.out.println();
            System.out.println( e + "Review Not mat Pattern --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testReviewMin() {
        Review review = new Review();
        review.setTopic("AA");
        review.setGood_comment("Good");
        review.setDis_comment("Noting");
        review.setComment_review("Good");
        review.setDirection(5L);
        try {
            entityManager.persist(review);
            entityManager.flush();
           fail("Should not pass to this line");

       } catch(javax.validation.ConstraintViolationException e) {
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           System.out.println();
            System.out.println( e + "Review Min Comment--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }

    }
    @Test
    public void testReviewOver() {
        Review review = new Review();
        review.setTopic("ฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟฟ");
        review.setGood_comment("Good");
        review.setDis_comment("Noting");
        review.setComment_review("Good");
        review.setDirection(5L);
        try {

            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + "Review Over size--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTopicNull() {
        Review review = new Review();
        review.setTopic(null);
        review.setGood_comment("Good");
        review.setDis_comment("Noting");
        review.setComment_review("Good");
        review.setDirection(5L);

        try {

            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + "Reveiew Topic Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testGoodComNull() {
        Review review = new Review();
        review.setTopic("ช่างภาพ");
        review.setGood_comment(null);
        review.setDis_comment("Noting");
        review.setComment_review("Good");
        review.setDirection(5L);

        try {

            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + "Reveiew good comment Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testDisComNull() {
        Review review = new Review();
        review.setTopic("ช่างภาพ");
        review.setGood_comment("Good");
        review.setDis_comment(null);
        review.setComment_review("Good");
        review.setDirection(5L);

        try {

            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + "Reveiew dis comment Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testCommentNull() {
        Review review = new Review();
        review.setTopic("ช่างภาพ");
        review.setGood_comment("Good");
        review.setDis_comment("Noting");
        review.setComment_review(null);
        review.setDirection(5L);

        try {

            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println( e + "Reveiew comment Null --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPositive() {
        Review review = new Review();
        review.setTopic("ช่างภาพ");
        review.setGood_comment("Good");
        review.setDis_comment("Noting");
        review.setComment_review("Good");
        review.setDirection(0L);

        try {

            entityManager.persist(review);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println("Review Positive --------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


}
