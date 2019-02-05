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
public class TestRepairInvoiced {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Comment comment;
    private Equipment equipment;
    private Admin admin;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testCommentNotnull() {
        Comment comment1 = new Comment();
        comment1.setComments(null);

        try {

            entityManager.persist(comment1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testMinsize() {
        Comment comment1 = new Comment();
        comment1.setComments("พั");

        try {

            entityManager.persist(comment1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testMaxSize() {
        Comment comment1 = new Comment();
        comment1.setComments("พพพพพพพพพพพพพพฟหหพพพพพพ");

        try {

            entityManager.persist(comment1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }

    @Test
    public void testPattern() {
        Comment comment1 = new Comment();
        comment1.setComments("eiaskldmkalcn");

        try {

            entityManager.persist(comment1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }


    @Test(expected=javax.persistence.PersistenceException.class)
    public void testUnique() {
        Comment comment1 = new Comment();
        comment1.setComments("พังแล้วจ้า");
        entityManager.persist(comment1);
        entityManager.flush();

        Comment comment2 = new Comment();
        comment2.setComments("พังแล้วจ้า");

        entityManager.persist(comment2);
        entityManager.flush();

        fail("Should not pass to this line");
    }
}
