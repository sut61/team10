package com.example.demo;

import com.example.demo.Entity.*;
import com.example.demo.Entity.RegisterPhotographys.*;
import com.example.demo.Repository.*;
import com.example.demo.Repository.RegisterPhotographysRepository.RegisterPhotographyRepository;
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

public class TestRegisterPhotographys {

    @Autowired private RegisterPhotographyRepository registerPhotographyRepository;
    @Autowired private TestEntityManager entityManager;
    @Autowired private MemberRepository memberRepository;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Member member;
    private Camara camara;
    private Instructor instructor;
    private PhotographyType photographyType;
    private SkillLevel skillLevel;
    private StudyTime studyTime;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    public void TestTrueString() {
        RegisterPhotography registerPhotography1 = new RegisterPhotography();
        registerPhotography1.setMessage("dikinakub1234");
        registerPhotography1.setMember(member);
        registerPhotography1.setCamara(camara);
        registerPhotography1.setInstructor(instructor);
        registerPhotography1.setPhotographyType(photographyType);
        registerPhotography1.setSkillLevel(skillLevel);
        registerPhotography1.setStudyTime(studyTime);
        try {
            registerPhotography1.setRegisterDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(registerPhotography1);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 0);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>TestTrueString>>>>>>>>>>>>1>>>>>>>>>>>>>>>>>"+e+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<1");
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestNotNull() {
        RegisterPhotography registerPhotography1 = new RegisterPhotography();
        registerPhotography1.setMessage(null);
        registerPhotography1.setMember(member);
        registerPhotography1.setCamara(camara);
        registerPhotography1.setInstructor(instructor);
        registerPhotography1.setPhotographyType(photographyType);
        registerPhotography1.setSkillLevel(skillLevel);
        registerPhotography1.setStudyTime(studyTime);
        try {
            registerPhotography1.setRegisterDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(registerPhotography1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>TestNotNull>>>>>>>>>>>>>>>2>>>>>>>>>>>>>>"+e+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<2");
        }catch (ParseException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void TestLongString() {
        RegisterPhotography registerPhotography1 = new RegisterPhotography();
        registerPhotography1.setMessage("fsdfdsfdsfsdfdsfsdfdsfsdfsdfdsfsdfdsfdsfdsfdsfdsfdsfsdfsdfsdfsdfsdfsdfdsfdsfsdfdsfdsfdsfdsf");
        registerPhotography1.setMember(member);
        registerPhotography1.setCamara(camara);
        registerPhotography1.setInstructor(instructor);
        registerPhotography1.setPhotographyType(photographyType);
        registerPhotography1.setSkillLevel(skillLevel);
        registerPhotography1.setStudyTime(studyTime);
        try {
            registerPhotography1.setRegisterDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(registerPhotography1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>TestLongString>>>>>>>>>>>>>3>>>>>>>>>>>>>>>>>"+e+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<3");
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestShotString() {
        RegisterPhotography registerPhotography1 = new RegisterPhotography();
        registerPhotography1.setMessage("d");
        registerPhotography1.setMember(member);
        registerPhotography1.setCamara(camara);
        registerPhotography1.setInstructor(instructor);
        registerPhotography1.setPhotographyType(photographyType);
        registerPhotography1.setSkillLevel(skillLevel);
        registerPhotography1.setStudyTime(studyTime);
        try {
            registerPhotography1.setRegisterDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(registerPhotography1);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>TestShotString>>>>>>>4>>>>>>>>>>>>>>>>>>>>>"+e+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<4");
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestFalsePattern() {
        RegisterPhotography registerPhotography1 = new RegisterPhotography();
        registerPhotography1.setMessage(".....");
        registerPhotography1.setMember(member);
        registerPhotography1.setCamara(camara);
        registerPhotography1.setInstructor(instructor);
        registerPhotography1.setPhotographyType(photographyType);
        registerPhotography1.setSkillLevel(skillLevel);
        registerPhotography1.setStudyTime(studyTime);
        try {
            registerPhotography1.setRegisterDate(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(registerPhotography1);
            entityManager.flush();

            //fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>TestFalsePattern>>>>>>>>>>>>5>>>>>>>>>>>>>>>>>>>>"+e+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<5");
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test(expected=javax.persistence.PersistenceException.class)
    public void TestUnique() {
        RegisterPhotography registerPhotography1 = new RegisterPhotography();
        registerPhotography1.setMessage("dikinakub");
        registerPhotography1.setMember(member);
        registerPhotography1.setCamara(camara);
        registerPhotography1.setInstructor(instructor);
        registerPhotography1.setPhotographyType(photographyType);
        registerPhotography1.setSkillLevel(skillLevel);
        registerPhotography1.setStudyTime(studyTime);
        entityManager.persist(registerPhotography1);
        entityManager.flush();

        RegisterPhotography registerPhotography2 = new RegisterPhotography();
        registerPhotography2.setMessage("dikinakub");
        registerPhotography2.setMember(member);
        registerPhotography2.setCamara(camara);
        registerPhotography2.setInstructor(instructor);
        registerPhotography2.setPhotographyType(photographyType);
        registerPhotography2.setSkillLevel(skillLevel);
        registerPhotography2.setStudyTime(studyTime);
        entityManager.persist(registerPhotography2);
        entityManager.flush();

        try {
            entityManager.persist(registerPhotography2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            //Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            //assertEquals(violations.isEmpty(), false);
            //assertEquals(violations.size(), 1);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>TestUnique>>>>>>>>>>>>>6>>>>>>>>>>>>>>>>>>"+e+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<6");
        }
    }
}
