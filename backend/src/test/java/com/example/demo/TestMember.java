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
public class TestMember {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Address address ;
    private Gender gender ;
    private Title title ;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void testNameMinsize() {
        Member member = new Member();
        member.setTitle(title);
        member.setUserid("savett808");
        member.setTel("0972120091");
        member.setPassword("zz0896075364");
        member.setLastname("eiei");
        member.setGender(gender);
        member.setEmail("savezts2@gmail.com");
        member.setAddress(address);
        member.setName("s");

        try {
            member.setBirthdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(member);
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
    public void testLastnameOversize() {
        Member member = new Member();
        member.setTitle(title);
        member.setUserid("savett808");
        member.setTel("0972120091");
        member.setPassword("zz0896075364");
        member.setLastname("eieissssssssssssssssssssss");
        member.setGender(gender);
        member.setEmail("savezts2@gmail.com");
        member.setAddress(address);
        member.setName("Itsarapong");

        try {
            member.setBirthdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(member);
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
    public void testPatternNotMath() {
        Member member = new Member();
        member.setTitle(title);
        member.setUserid("savett808");
        member.setTel("095");
        member.setPassword("zz0896075364");
        member.setLastname("rattanasak");
        member.setGender(gender);
        member.setEmail("savezts2@gmail.com");
        member.setAddress(address);
        member.setName("Itsarapong");

        try {
            member.setBirthdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(member);
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
    public void testPasswordNotNull() {
        Member member = new Member();
        member.setTitle(title);
        member.setUserid("savett808");
        member.setTel("0972120091");
        member.setPassword(null);
        member.setLastname("rattanasak");
        member.setGender(gender);
        member.setEmail("savezts2@gmail.com");
        member.setAddress(address);
        member.setName("Itsarapong");

        try {
            member.setBirthdate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(member);
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





}
