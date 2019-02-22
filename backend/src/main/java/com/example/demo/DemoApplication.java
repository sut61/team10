package com.example.demo;

import com.example.demo.Entity.RegisterPhotographys.*;
import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import com.example.demo.Repository.RegisterPhotographysRepository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(MemberRepository memberRepository , GenderReposiory genderReposiory , TitleRepository titleRepository , PromotionStudioRepository promotionStudioRepository ,
                           RoomStudioRepository roomStudioRepository , TimeStudioRepository timeStudioRepository, Reservationequipmentrepository reservationequipmentrepository,
                           Equipmentrepository equipmentrepository, Timereceiverepository timereceiverepository, PhotographerRepository photographerRepository,
                           PromotionPhotographerRepository promotionPhotographerRepository, TypePhotoRepository typePhotoRepository, StartTimeRepository startTimeRepository,
                           Photocollectionrepository photocollectionrepository, Photoseriesrepository photoseriesrepository,
                           Promotionphotocollectionrepository promotionphotocollectionrepository, Shootingstylerepository shootingstylerepository, ModelRepository modelRepository,
                           PromotionModelRepository promotionModelRepository , ProvinceRepository provinceRepository, AdminRepository adminRepository, CamaraRepository camaraRepository,
                           InstructorRepository instructorRepository, PhotographyTypeRepository photographyTypeRepository, RegisterPhotographyRepository registerPhotographyRepository,
                           SkillLevelRepository skillLevelRepository, StudyTimeRepository studyTimeRepository,Cardbankrepository cardbankrepository,Cardtyperepository cardtyperepository,
                           TimesPhotogarpherRepository timesPhotogarpherRepository,PromotionTableRepository promotionTableRepository , CommentRepository commentRepository,Phototyperepository phototyperepository,
                           Photosizerepository photosizerepository,AddressRepository addressRepository,ReviewRepository reviewRepository,ScoreRepository scoreRepository,SystemNameRepository systemNameRepository,
                           ReservationModelRepository reservationModelRepository ,TablePhotographerRepository tablePhotographerRepository){
        return args -> {
            Admin admin = new Admin();
            admin.setPassword("admin");
            admin.setUserid("admin");
            adminRepository.save(admin);


            Stream.of("กรุงเทพมหานคร", "กระบี่", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี",
                    "ฉะเชิงเทรา", "ชลบุรี", "ชัยนาท", "ชัยภูมิ", "ชุมพร", "เชียงราย", "เชียงใหม่", "ตรัง", "ตราด",
                    "ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช", "นครสวรรค์", "นนทบุรี",
                    "นราธิวาส", "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี",
                    "พระนครศรีอยุธยา", "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "เพชรบุรี", "เพชรบูรณ์", "แพร่",
                    "พะเยา", "ภูเก็ต", "มหาสารคาม", "มุกดาหาร", "แม่ฮ่องสอน", "ยะลา", "ยโสธร", "ร้อยเอ็ด", "ระนอง",
                    "ระยอง", "ราชบุรี", "ลพบุรี", "ลำปาง", "ลำพูน", "เลย", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล",
                    "สมุทรปราการ", "สมุทรสงคราม", "สมุทรสาคร", "สระแก้ว", "สระบุรี", "สิงห์บุรี", "สุโขทัย",
                    "สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "หนองคาย", "หนองบัวลำภู", "อ่างทอง", "อุดรธานี",
                    "อุทัยธานี", "อุตรดิตถ์", "อุบลราชธานี", "อำนาจเจริญ").forEach(province -> {
                Province provinces = new Province();
                provinces.setProvincename(province);
                provinceRepository.save(provinces);
            });
            Gender gender1 = new Gender("ชาย");
            Gender gender2 = new Gender("หญิง");
            genderReposiory.save(gender1);
            genderReposiory.save(gender2);

            Title title1 = new Title("นาย");
            Title title2 = new Title("นางสาว");
            Title title3 = new Title("นาง");
            titleRepository.save(title1);
            titleRepository.save(title2);
            titleRepository.save(title3);

            Member member = new Member();
            Date datenew = new Date();
            Address address = new Address();
            Province provinces1 = new Province();
            provinces1.setProvincename("ตาก");
            provinceRepository.save(provinces1);
            address.setTambon("popo");
            address.setPostcode("60150");
            address.setAmphoe("rerere");
            address.setAddress("12345ddffff");
            address.setProvince(provinces1);
            addressRepository.save(address);
            member.setName("dikinakub");
            member.setBirthdate(datenew);
            member.setEmail("diki@gmail.com");
            member.setLastname("kawasaki");
            member.setPassword("1234");
            member.setTel("0834318890");
            member.setUserid("diki");
            member.setAddress(address);
            member.setGender(gender1);
            member.setTitle(title1);
            memberRepository.save(member);



            PromotionStudio promotionStudio1 = new PromotionStudio();
            PromotionStudio promotionStudio2 = new PromotionStudio();
            PromotionStudio promotionStudio3 = new PromotionStudio();
            promotionStudio1.setPromotionName("7:00-12:00 = 1000บาท");
            promotionStudio2.setPromotionName("13:00-17:00 = 1000บาท");
            promotionStudio3.setPromotionName("8:00-18:00 = 2000บาท");
            promotionStudio1.setPrice(1000);
            promotionStudio2.setPrice(1000);
            promotionStudio3.setPrice(2000);
            promotionStudioRepository.save(promotionStudio1);
            promotionStudioRepository.save(promotionStudio2);
            promotionStudioRepository.save(promotionStudio3);

            RoomStudio roomStudio1 = new RoomStudio();
            RoomStudio roomStudio2 = new RoomStudio();
            RoomStudio roomStudio3 = new RoomStudio();
            RoomStudio roomStudio4 = new RoomStudio();
            roomStudio1.setName("ROOM1");
            roomStudio2.setName("ROOM2");
            roomStudio3.setName("ROOM3");
            roomStudio4.setName("ROOM4");
            roomStudio1.setStudio_status("ว่าง");
            roomStudio2.setStudio_status("ว่าง");
            roomStudio3.setStudio_status("ว่าง");
            roomStudio4.setStudio_status("ว่าง");
            roomStudioRepository.save(roomStudio1);
            roomStudioRepository.save(roomStudio2);
            roomStudioRepository.save(roomStudio3);
            roomStudioRepository.save(roomStudio4);

            TimeStudio timeStudio1 = new TimeStudio();
            TimeStudio timeStudio2 = new TimeStudio();
            TimeStudio timeStudio3 = new TimeStudio();
            timeStudio1.setTimeName("ครึ่งวันเช้า");
            timeStudio2.setTimeName("ครึ่งวันบ่าย");
            timeStudio3.setTimeName("เต็มวัน");
            timeStudioRepository.save(timeStudio1);
            timeStudioRepository.save(timeStudio2);
            timeStudioRepository.save(timeStudio3);

            Timereceive du1 = new Timereceive("รับ 9:00");
            du1.setKeytime("1");
            Timereceive du2 = new Timereceive("รับ 12:00");
            du2.setKeytime("2");
            Timereceive du3 = new Timereceive("รับ 18:00");
            du3.setKeytime("3");
            timereceiverepository.save(du1);
            timereceiverepository.save(du2);
            timereceiverepository.save(du3);


            Equipment equipment1 = new Equipment();
            equipment1.setEquipment_name("6D II");
            equipment1.setEquipment_price(900);
            equipment1.setEquipment_type("camera");
            equipment1.setEquipment_brand("canon");
            equipment1.setKey("1");
            equipmentrepository.save(equipment1);

            Equipment equipment2 = new Equipment();
            equipment2.setEquipment_name("D5");
            equipment2.setEquipment_price(1200);
            equipment2.setEquipment_type("camera");
            equipment2.setEquipment_brand("nikon");
            equipment2.setKey("2");
            equipmentrepository.save(equipment2);

            Equipment equipment3 = new Equipment();
            equipment3.setEquipment_name("a7 iii");
            equipment3.setEquipment_price(1000);
            equipment3.setEquipment_type("camera");
            equipment3.setEquipment_brand("sony");
            equipment3.setKey("3");
            equipmentrepository.save(equipment3);

            Equipment equipment4 = new Equipment();
            equipment4.setEquipment_name("1dx");
            equipment4.setEquipment_price(1500);
            equipment4.setEquipment_type("camera");
            equipment4.setEquipment_brand("canon");
            equipment4.setKey("4");
            equipmentrepository.save(equipment4);

            Equipment equipment5 = new Equipment();
            equipment5.setEquipment_name("D850");
            equipment5.setEquipment_price(1500);
            equipment5.setEquipment_type("camera");
            equipment5.setEquipment_brand("nikon");
            equipment5.setKey("5");
            equipmentrepository.save(equipment5);

            Equipment equipment6 = new Equipment();
            equipment6.setEquipment_name("a9");
            equipment6.setEquipment_price(1600);
            equipment6.setEquipment_type("camera");
            equipment6.setEquipment_brand("sony");
            equipment6.setKey("6");
            equipmentrepository.save(equipment6);

            Equipment equipment7 = new Equipment();
            equipment7.setEquipment_name("17-40 f2.8l is");
            equipment7.setEquipment_price(500);
            equipment7.setEquipment_brand("canon");
            equipment7.setEquipment_type("lens");
            equipment7.setKey("7");
            equipmentrepository.save(equipment7);

            Equipment equipment8 = new Equipment();
            equipment8.setEquipment_name("70-200 f2.8l is ii");
            equipment8.setEquipment_price(600);
            equipment8.setEquipment_brand("canon");
            equipment8.setEquipment_type("lens");
            equipment8.setKey("8");
            equipmentrepository.save(equipment8);

            Equipment equipment9 = new Equipment();
            equipment9.setEquipment_name("24-70 f2.8 vr nano ");
            equipment9.setEquipment_price(600);
            equipment9.setEquipment_brand("nikon");
            equipment9.setEquipment_type("lens");
            equipment9.setKey("9");
            equipmentrepository.save(equipment9);

            Equipment equipment10 = new Equipment();
            equipment10.setEquipment_name("14-24 f4 vr ");
            equipment10.setEquipment_price(500);
            equipment10.setEquipment_brand("nikon");
            equipment10.setEquipment_type("lens");
            equipment10.setKey("10");
            equipmentrepository.save(equipment10);

            Equipment equipment11 = new Equipment();
            equipment11.setEquipment_name("28-75 f2.8 tamron for sony");
            equipment11.setEquipment_price(500);
            equipment11.setEquipment_brand("sony");
            equipment11.setEquipment_type("lens");
            equipment11.setKey("11");
            equipmentrepository.save(equipment11);

            Equipment equipment12 = new Equipment();
            equipment12.setEquipment_name("70-200 f2.8 G-master");
            equipment12.setEquipment_price(500);
            equipment12.setEquipment_brand("sony");
            equipment12.setEquipment_type("lens");
            equipment12.setKey("12");
            equipmentrepository.save(equipment12);

            Equipment equipment13 = new Equipment();
            equipment13.setEquipment_name("ex-600rt");
            equipment13.setEquipment_price(300);
            equipment13.setEquipment_brand("canon");
            equipment13.setEquipment_type("flash");
            equipment13.setKey("13");
            equipmentrepository.save(equipment13);

            Equipment equipment14 = new Equipment();
            equipment14.setEquipment_name("SB-600");
            equipment14.setEquipment_price(300);
            equipment14.setEquipment_brand("nikon");
            equipment14.setEquipment_type("flash");
            equipment14.setKey("14");
            equipmentrepository.save(equipment14);

            Equipment equipment15 = new Equipment();
            equipment15.setEquipment_name("hvl-f60m");
            equipment15.setEquipment_price(300);
            equipment15.setEquipment_brand("sony");
            equipment15.setEquipment_type("flash");
            equipment15.setKey("15");
            equipmentrepository.save(equipment15);

            //สร้าง photographer
            Photographer ph1 = new Photographer("Hero",22,"Hero@gmail.com","0895xxxxxx","key1");
            Photographer ph2 = new Photographer("Diki",21,"diki@gmail.com","0902xxxxxx","key2");
            Photographer ph3 = new Photographer("Safefy",20,"safefy@gmail.com","0801xxxxxx","key3");
            Photographer ph4 = new Photographer("Eka",20,"Eka@gmail.com","0831xxxxxx","key4");
            Photographer ph5 = new Photographer("Moty",23,"moty@gmail.com","0821xxxxxx","key5");

            photographerRepository.save(ph1);
            photographerRepository.save(ph2);
            photographerRepository.save(ph3);
            photographerRepository.save(ph4);
            photographerRepository.save(ph5);

            //สร้าง Promotion
            PromotionPhotographer pg1 = new PromotionPhotographer("ช่วงเช้า 1500 บาท", 1, 1500);
            PromotionPhotographer pg2 = new PromotionPhotographer("ช่วงบ่าย 1600 บาท", 2, 1600);
            PromotionPhotographer pg3 = new PromotionPhotographer("เต็มวัน 2100 บาท", 3, 2100);
            promotionPhotographerRepository.save(pg1);
            promotionPhotographerRepository.save(pg2);
            promotionPhotographerRepository.save(pg3);
            
            //สร้าง Type Photo
            TypePhoto tp1 = new TypePhoto("Fashion Photography","key1");
            TypePhoto tp2 = new TypePhoto("Wedding Photography","key2");
            TypePhoto tp3 = new TypePhoto("Vintage Photography","key3");
            TypePhoto tp4 = new TypePhoto("Widlife photography","key4");
            typePhotoRepository.save(tp1);
            typePhotoRepository.save(tp2);
            typePhotoRepository.save(tp3);
            typePhotoRepository.save(tp4);

            //สร้าง startTime and finalTime
            StartTime s1 = new StartTime("6:00-12:00");
            StartTime s2 = new StartTime("13:00-19:00");
            StartTime s3 = new StartTime("8:00-19:00");

            startTimeRepository.save(s1);
            startTimeRepository.save(s2);
            startTimeRepository.save(s3);



            Photoseries photoseries1 = new Photoseries("ชุดว่ายน้ำ");
            Photoseries photoseries2 = new Photoseries("ชุดไทย");
            Photoseries photoseries3 = new Photoseries("ชุดราตรี");
            Photoseries photoseries4 = new Photoseries("ชุดแฟนซี");
            Photoseries photoseries5 = new Photoseries("ชุดแต่งงาน");
            Photoseries photoseries6 = new Photoseries("ชุดเดรส");
            Photoseries photoseries7 = new Photoseries("ชุดกี่เพ้า");
            Photoseries photoseries8 = new Photoseries("ชุดบิกินี่");
            photoseriesrepository.save(photoseries1);
            photoseriesrepository.save(photoseries2);
            photoseriesrepository.save(photoseries3);
            photoseriesrepository.save(photoseries4);
            photoseriesrepository.save(photoseries5);
            photoseriesrepository.save(photoseries6);
            photoseriesrepository.save(photoseries7);
            photoseriesrepository.save(photoseries8);
            Promotionphotocollection promotionphotocollection1 = new Promotionphotocollection("ครึ่งวันเช้า 300บาท");
            Promotionphotocollection promotionphotocollection2 = new Promotionphotocollection("ครึ่งวันบ่าย 300บาท");
            Promotionphotocollection promotionphotocollection3 = new Promotionphotocollection("ทั้งวัน 500บาท");
            promotionphotocollectionrepository.save(promotionphotocollection1);
            promotionphotocollectionrepository.save(promotionphotocollection2);
            promotionphotocollectionrepository.save(promotionphotocollection3);
            Shootingstyle shootingstyle1 = new Shootingstyle("สีขาว");
            Shootingstyle shootingstyle2 = new Shootingstyle("สีดำ");
            Shootingstyle shootingstyle3 = new Shootingstyle("สีน้ำเงิน");
            Shootingstyle shootingstyle4 = new Shootingstyle("สีแดง");
            Shootingstyle shootingstyle5 = new Shootingstyle("สีเขียว");
            Shootingstyle shootingstyle6 = new Shootingstyle("สีฟ้า");
            Shootingstyle shootingstyle7 = new Shootingstyle("สีเหลือง");
            Shootingstyle shootingstyle8 = new Shootingstyle("สีส้ม");
            Shootingstyle shootingstyle9 = new Shootingstyle("สีชมพู");
            shootingstylerepository.save(shootingstyle1);
            shootingstylerepository.save(shootingstyle2);
            shootingstylerepository.save(shootingstyle3);
            shootingstylerepository.save(shootingstyle4);
            shootingstylerepository.save(shootingstyle5);
            shootingstylerepository.save(shootingstyle6);
            shootingstylerepository.save(shootingstyle7);
            shootingstylerepository.save(shootingstyle8);
            shootingstylerepository.save(shootingstyle9);

            Model md1 = new Model("สมใจ","แสนสุข");
            Model md2 = new Model("สมหญิง","สุดใจ");
            Model md3 = new Model("สุกานดา","วารวร");
            Model md4 = new Model("สุนิสา","แสนศรี");
            Model md5 = new Model("ทิวา","เจริญสุข");
            modelRepository.save(md1);
            modelRepository.save(md2);
            modelRepository.save(md3);
            modelRepository.save(md4);
            modelRepository.save(md5);

            PromotionModel p1 = new PromotionModel("8:00-12:00 800บาท",800);
            PromotionModel p2 = new PromotionModel("13:00-16:00 800บาท",800);
            PromotionModel p3 = new PromotionModel("8:00-16:00 1500บาท",1500);
            promotionModelRepository.save(p1);
            promotionModelRepository.save(p2);
            promotionModelRepository.save(p3);

         /*   ReservationModel r1 = new ReservationModel ();
            r1.setThemes("ชุดนักเรียน");
            r1.setLocation( "โรงเรียน");
            r1.setMember(member);
            r1.setDate(datenew);
            r1.setModel(md1);
            r1.setPromotionModel(p1);
            reservationModelRepository.save(r1);*/

            Camara c1 = new Camara();
            Camara c2 = new Camara();
            Camara c3 = new Camara();
            Camara c4 = new Camara();
            Camara c5 = new Camara();
            c1.setCamaraName("Canon 5D");
            c1.setCamaraType("DSLR");
            c2.setCamaraName("Nikon D750");
            c2.setCamaraType("DSLR");
            c3.setCamaraName("Canon M5 EFM1");
            c3.setCamaraType("Mirrorless");
            c2.setCamaraName("Nikon D750");
            c2.setCamaraType("DSLR");
            c4.setCamaraName("Fujifilm X-E3");
            c4.setCamaraType("Mirrorless");
            c5.setCamaraName("Sony a6500");
            c5.setCamaraType("Mirrorless");
            camaraRepository.save(c1);
            camaraRepository.save(c2);
            camaraRepository.save(c3);
            camaraRepository.save(c4);
            camaraRepository.save(c5);

            Instructor i1 = new Instructor();
            Instructor i2 = new Instructor();
            Instructor i3 = new Instructor();
            i1.setInstructorName("Mr.Diki kawasaki");
            i2.setInstructorName("Mr.Itsarapong rattanasak");
            i3.setInstructorName("Mr.Sonporn passorn");
            instructorRepository.save(i1);
            instructorRepository.save(i2);
            instructorRepository.save(i3);

            PhotographyType photographyType1 = new PhotographyType();
            PhotographyType photographyType2 = new PhotographyType();
            PhotographyType photographyType3 = new PhotographyType();
            PhotographyType photographyType4 = new PhotographyType();
            PhotographyType photographyType5 = new PhotographyType();
            photographyType1.setPhotographyType("Portrait Photography");
            photographyType2.setPhotographyType("Wedding Photography");
            photographyType3.setPhotographyType("Macro Photography");
            photographyType4.setPhotographyType("Bird Photography");
            photographyType5.setPhotographyType("Street Photography");
            photographyTypeRepository.save(photographyType1);
            photographyTypeRepository.save(photographyType2);
            photographyTypeRepository.save(photographyType3);
            photographyTypeRepository.save(photographyType4);
            photographyTypeRepository.save(photographyType5);

            SkillLevel skillLevel1 = new SkillLevel();
            SkillLevel skillLevel2 = new SkillLevel();
            SkillLevel skillLevel3 = new SkillLevel();
            skillLevel1.setSkill("มีความรู้ในเรื่องการถ่ายภาพน้อย");
            skillLevel2.setSkill("มีความรู้ในเรื่องการถ่ายภาพปานกลาง");
            skillLevel3.setSkill("มีความรู้ในเรื่องการถ่ายภาพมาก");
            skillLevelRepository.save(skillLevel1);
            skillLevelRepository.save(skillLevel2);
            skillLevelRepository.save(skillLevel3);

            StudyTime studyTime1 = new StudyTime();
            StudyTime studyTime2 = new StudyTime();
            StudyTime studyTime3 = new StudyTime();
            studyTime1.setStudyTime("ทุกๆวันเสาร์-อาทิตย์ : 9.00-12.00am.");
            studyTime2.setStudyTime("ทุกๆวันเสาร์-อาทิตย์ : 13.00-16.00pm.");
            studyTime3.setStudyTime("ทุกๆวันเสาร์-อาทิตย์ : 17.00-20.00pm.");
            studyTimeRepository.save(studyTime1);
            studyTimeRepository.save(studyTime2);
            studyTimeRepository.save(studyTime3);

            Cardtype ct1 = new Cardtype("Visa");
            ct1.setKeyt("1");
            Cardtype ct2 = new Cardtype("Mastercard");
            ct2.setKeyt("2");
            Cardtype ct3 = new Cardtype("JCB");
            ct3.setKeyt("3");
            Cardtype ct4 = new Cardtype("UnionPay");
            ct4.setKeyt("4");
            cardtyperepository.save(ct1);
            cardtyperepository.save(ct2);
            cardtyperepository.save(ct3);
            cardtyperepository.save(ct4);


            Cardbank cb1 = new Cardbank("กรุงไทย");
            cb1.setKeyb("1");
            Cardbank cb2 = new Cardbank("ไทยพาณิชย์");
            cb2.setKeyb("2");
            Cardbank cb3 = new Cardbank("กรุงเทพ");
            cb3.setKeyb("3");
            Cardbank cb4 = new Cardbank("กสิกรไทย");
            cb4.setKeyb("4");
            Cardbank cb5 = new Cardbank("กรุงศรีอยุธยา");
            cb5.setKeyb("5");
            cardbankrepository.save(cb1);
            cardbankrepository.save(cb2);
            cardbankrepository.save(cb3);
            cardbankrepository.save(cb4);
            cardbankrepository.save(cb5);

            //Natthapon sprint 2{

            TimesPhotogarpher timesPhotogarpher1 = new TimesPhotogarpher();
            TimesPhotogarpher timesPhotogarpher2 = new TimesPhotogarpher();
            TimesPhotogarpher timesPhotogarpher3 = new TimesPhotogarpher();
            timesPhotogarpher1.setTimes("8.00-12.00 น.");
            timesPhotogarpher2.setTimes("13.00-17.00 น.");
            timesPhotogarpher3.setTimes("8.00-17.00 น.");
            timesPhotogarpherRepository.save(timesPhotogarpher1);
            timesPhotogarpherRepository.save(timesPhotogarpher2);
            timesPhotogarpherRepository.save(timesPhotogarpher3);

            PromotionTable promotionTable1 = new PromotionTable();
            PromotionTable promotionTable2 = new PromotionTable();
            PromotionTable promotionTable3 = new PromotionTable();
            promotionTable1.setPromotionName("ครึ่งวันเช้า");promotionTable1.setPrice(2000);
            promotionTable2.setPromotionName("ครึ่งวันบ่าย");promotionTable2.setPrice(2000);
            promotionTable3.setPromotionName("เต็มวัน");promotionTable3.setPrice(4500);
            promotionTableRepository.save(promotionTable1);
            promotionTableRepository.save(promotionTable2);
            promotionTableRepository.save(promotionTable3);

            Comment comment = new Comment();
            comment.setComments("ฟหกฟหกฟหกฟหก");
            commentRepository.save(comment);

            /*TablePhotographer  Table1 = new  TablePhotographer();
            Table1.setLocation("เเกาะล้าน");
            Table1.setTel("0885825238");
            Table1.setDate(datenew);
            Table1.setAdmin(admin);
            Table1.setTimesPhotogarpher(timesPhotogarpher1);
            Table1.setPromotionTable(promotionTable1);
            Table1.setPhotographer();
            tablePhotographerRepository.save(Table1);*/
        //}
            //{sprint2 Somporn passorn
            Photosize photosize1 = new Photosize("A4");
            Photosize photosize2 = new Photosize("A3");
            Photosize photosize3 = new Photosize("4*6 in");
            Photosize photosize4 = new Photosize("FullSize");
            photosizerepository.save(photosize1);
            photosizerepository.save(photosize2);
            photosizerepository.save(photosize3);
            photosizerepository.save(photosize4);
            Phototype phototype1 = new Phototype("Aulbum");
            Phototype phototype2 = new Phototype("Single");
            Phototype phototype3 = new Phototype("BigSize");
            phototyperepository.save(phototype1);
            phototyperepository.save(phototype2);
            phototyperepository.save(phototype3);
            //}

        //    ReservationPhotographer rp1 = new ReservationPhotographer();
           // rp1.setMember(member);
           // rp1.setReservation_date(datenew);
           // rp1.setAppointment("qqqq");
           // rp1.setComment_photo("123456");
           // rp1.setEmailuser("12132132");
           // rp1.setPhoneusr("0888888888");

                        //Pam 2{
                            Score ss1 = new Score();
                            Score ss2 = new Score();
                            Score ss3  = new Score();
                            Score ss4 = new Score();
                            Score ss5 = new Score();
                            ss1.setScore(1);
                            ss2.setScore(2);
                            ss3.setScore(3);
                            ss4.setScore(4);
                            ss5.setScore(5);
                            scoreRepository.save(ss1);
                            scoreRepository.save(ss2);
                            scoreRepository.save(ss3);
                            scoreRepository.save(ss4);
                            scoreRepository.save(ss5);
                
                            SystemName systemName1 = new SystemName();
                            SystemName systemName2 = new SystemName();
                            SystemName systemName3 = new SystemName();
                            SystemName systemName4 = new SystemName();
                            SystemName systemName5 = new SystemName();
                            SystemName systemName6 = new SystemName();
                            SystemName systemName7 = new SystemName();
                            SystemName systemName8 = new SystemName();
                            SystemName systemName9 = new SystemName();
                            SystemName systemName10 = new SystemName();
                
                            systemName1.setSytemstudio_name("จองสตูดิโอถ่ายภาพ");
                            systemName2.setSytemstudio_name("จองชุดถ่ายภาพ");
                            systemName3.setSytemstudio_name("จองนางแบบ");
                            systemName4.setSytemstudio_name("จองช่างภาพ");
                            systemName5.setSytemstudio_name("เช่าอุปกรณ์ถ่ายภาพ");
                            systemName6.setSytemstudio_name("สมัครเรียนถ่ายรูป");
                            systemName7.setSytemstudio_name("บันทึการจ่ายเงิน");
                            systemName8.setSytemstudio_name("แจ้งซ่อมอุปกรณ์");
                            systemName9.setSytemstudio_name("บันทึกการส่งรูป");
                            systemName10.setSytemstudio_name("จัดตารางงานช่างภาพ");
                            systemNameRepository.save(systemName1);
                            systemNameRepository.save(systemName2);
                            systemNameRepository.save(systemName3);
                            systemNameRepository.save(systemName4);
                            systemNameRepository.save(systemName5);
                            systemNameRepository.save(systemName6);
                            systemNameRepository.save(systemName7);
                            systemNameRepository.save(systemName8);
                            systemNameRepository.save(systemName9);
                            systemNameRepository.save(systemName10);
                

                            //}
        };
    }
}
