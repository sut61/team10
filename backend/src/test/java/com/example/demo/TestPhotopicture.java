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
public class TestPhotopicture {

    @Autowired
    private Photopicturerepository photopicturerepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private Photosizerepository photosizerepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private Phototyperepository phototyperepository;

    private Validator validator;
    private SimpleDateFormat formatter5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Admin admin;
    private Member member;
    private Phototype phototype;
    private Photosize photosize;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        admin = adminRepository.findByUserid("admin");
        member = memberRepository.findByName("dikinakub");
        phototype = phototyperepository.findBynamephototype("A4");
        photosize = photosizerepository.findBynamephotosize("Aulbum");
    }
    @Test
    public void testPhotopictureTure() {
        Photopicture photopic = new Photopicture();
        photopic.setDataname("ส่งไปษณีย์");
        photopic.setPhototype(phototype);
        photopic.setPhotosize(photosize);
        photopic.setAdmin(admin);
        photopic.setMember(member);


        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopictureTure");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotopictureFalse() {
        Photopicture photopic = new Photopicture();
        photopic.setDataname("ส่งไปรษณีย์60000");
        photopic.setPhototype(phototype);
        photopic.setPhotosize(photosize);
        photopic.setAdmin(admin);
        photopic.setMember(member);


        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopictureFalse");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotopictureMaxSize() {
        Photopicture photopic = new Photopicture();
        photopic.setDataname("ส่งให้ทางไปษณีย์นายสมพรพัสสรสวัสดีครับวันนี้เราจะมาทำอาหารกันนะครับ");
        photopic.setPhototype(phototype);
        photopic.setPhotosize(photosize);
        photopic.setAdmin(admin);
        photopic.setMember(member);


        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopictureMaxSize");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void testPhotopictureMinsize() {
        Photopicture photopic = new Photopicture();
        photopic.setDataname("ส่ง");
        photopic.setPhototype(phototype);
        photopic.setPhotosize(photosize);
        photopic.setAdmin(admin);
        photopic.setMember(member);


        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopictureMinsize");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }

    @Test
    public void testPhotopictureNull() {
        Photopicture photopic = new Photopicture();
        photopic.setDataname(null);
        photopic.setPhototype(phototype);
        photopic.setPhotosize(photosize);
        photopic.setAdmin(admin);
        photopic.setMember(member);


        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopictureNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void  testPhotopictureMemberNull(){
        Photopicture photopic = new Photopicture();
        photopic.setDataname("ส่งไปษณีย์");
        photopic.setPhototype(phototype);
        photopic.setPhotosize(photosize);
        photopic.setAdmin(admin);
        photopic.setMember(null);

        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopictureMemberNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
   /* @Test
    public void  testPhotopictureMember2Null(){
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
    public void  testPhotopicturePhototypeNull(){
        Photopicture photopic = new Photopicture();
        photopic.setDataname("ส่งไปษณีย์");
        photopic.setPhototype(null);
        photopic.setPhotosize(photosize);
        photopic.setAdmin(admin);
        photopic.setMember(member);

        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopicturePhototypeNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void  testPhotopicturePhototype2Null(){
        Phototype phototype = new Phototype();
        phototype.setName(null);

        try {
            entityManager.persist(phototype);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e + "PhotopicturePhototypeNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void  testPhotopicturePhotosizeNull(){
        Photopicture photopic = new Photopicture();
        photopic.setDataname("ส่งไปษณีย์");
        photopic.setPhototype(phototype);
        photopic.setPhotosize(null);
        photopic.setAdmin(admin);
        photopic.setMember(member);

        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopicturePhotosizeNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void  testPhotopicturePhotosize2Null(){
        Photosize photosize = new Photosize();
        photosize.setName(null);

        try {
            entityManager.persist(photosize);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e + "PhotopicturePhotosizeNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void  testPhotopictureAminNull(){
        Photopicture photopic = new Photopicture();
        photopic.setDataname("ส่งไปษณีย์");
        photopic.setPhototype(phototype);
        photopic.setPhotosize(photosize);
        photopic.setAdmin(null);
        photopic.setMember(member);

        try {
            photopic.setDatedata(formatter5.parse("2019-02-04 00:00:00"));
            entityManager.persist(photopic);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println(e+"------------------>>>>testPhotopictureAminNull");
            System.out.println();
        }catch (ParseException e){
            System.out.println(e);

        }
    }
    @Test
    public void  testPhotopictureAmin2Null(){
        Admin admin = new  Admin();
        admin.setUserid(null);

        try {
            entityManager.persist(admin);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println();
            System.out.println(e + "PhotopictureAminNull--------------------------------");
            System.out.println();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testPhotopictureDataUnique() {
        Photopicture photopic = new Photopicture();
        photopic.setAdmin(admin);
        photopic.setMember(member);
        photopic.setDataname("ส่งไปษณีย์");
        photopic.setPhototype(phototype);
        photopic.setPhotosize(photosize);
        entityManager.persist(photopic);
      //  entityManager.flush();

        Photopicture p1 = new Photopicture();
        p1.setAdmin(admin);
        p1.setMember(member);
        p1.setDataname("ส่งไปษณีย์");
        p1.setPhototype(phototype);
        p1.setPhotosize(photosize);

        try {
            entityManager.persist(p1);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }



}
