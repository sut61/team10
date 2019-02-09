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
    private AdminRepository adminRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private Equipmentrepository equipmentrepository;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Comment comment;
    private Equipment equipment;
    private Admin admin;
    Date date = new Date();


    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        comment = commentRepository.findByComments("ฟหกฟหกฟหกฟหก");
        admin = adminRepository.findByUserid("admin");
        equipment = equipmentrepository.findByKey("1");

    }

    @Test
    public void testRepairInvoicedDateinNotNull() {
        RepairInvoiced repairInvoiced = new RepairInvoiced();

        repairInvoiced.setAdmin(admin);
        repairInvoiced.setComment(comment);
        repairInvoiced.setEquipment(equipment);

        try {
            repairInvoiced.setDatein(null);
            entityManager.persist(repairInvoiced);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>7");
            System.out.println();

    }
    }


    @Test
    public void testRepairInvoicedEquipmentNotNull() {
        RepairInvoiced repairInvoiced = new RepairInvoiced();

        repairInvoiced.setAdmin(admin);
        repairInvoiced.setComment(comment);
        repairInvoiced.setEquipment(null);

        try {
            repairInvoiced.setDatein(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(repairInvoiced);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>7");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
//test

    @Test
    public void testRepairInvoicedaAdminNotNull() {
        RepairInvoiced repairInvoiced = new RepairInvoiced();

        repairInvoiced.setAdmin(null);
        repairInvoiced.setComment(comment);
        repairInvoiced.setEquipment(equipment);

        try {
            repairInvoiced.setDatein(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(repairInvoiced);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>6");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }


    @Test
    public void testRepairInvoicedCommentNotNull() {
        RepairInvoiced repairInvoiced = new RepairInvoiced();

        repairInvoiced.setAdmin(admin);
        repairInvoiced.setComment(null);
        repairInvoiced.setEquipment(equipment);

        try {
            repairInvoiced.setDatein(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(repairInvoiced);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>1");
            System.out.println();
         }catch (ParseException e){
            System.out.println(e);

        }
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
            System.out.println();
            System.out.println(e+"------------------>>>>2");
            System.out.println();
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
            System.out.println();
            System.out.println(e+"------------------>>>>3");
            System.out.println();
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
            System.out.println();
            System.out.println(e+"------------------>>>>4");
            System.out.println();
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
            System.out.println();
            System.out.println(e+"------------------>>>>5");
            System.out.println();
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
