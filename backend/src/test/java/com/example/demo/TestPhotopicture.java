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



}
