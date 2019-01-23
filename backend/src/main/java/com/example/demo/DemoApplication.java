/*package com.example.demo;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(MemberRepository memberRepository , GenderReposiory genderReposiory , TitleRepository titleRepository , PromotionStudioRepository promotionStudioRepository , RoomStudioRepository roomStudioRepository , TimeStudioRepository timeStudioRepository,
                           Reservationequipmentrepository reservationequipmentrepository, Equipmentrepository equipmentrepository,
                           Timereceiverepository timereceiverepository,PhotographerRepository photographerRepository, PromotionPhotographerRepository promotionPhotographerRepository, TypePhotoRepository typePhotoRepository,
                           StartTimeRepository startTimeRepository,FinalTimeRepository finalTimeRepository , Photocollectionrepository photocollectionrepository,
                           Photoseriesrepository photoseriesrepository, Promotionphotocollectionrepository promotionphotocollectionrepository,
                           Shootingstylerepository shootingstylerepository, ModelRepository modelRepository, PromotionModelRepository promotionModelRepository){
        return args -> {


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
            timeStudio1.setTime_name("ครึ่งวันเช้า");
            timeStudio2.setTime_name("ครึ่งวันบ่าย");
            timeStudio3.setTime_name("เต็มวัน");
            timeStudioRepository.save(timeStudio1);
            timeStudioRepository.save(timeStudio2);
            timeStudioRepository.save(timeStudio3);

            Timereceive du1 = new Timereceive("รับ 9:00");
            Timereceive du2 = new Timereceive("รับ 12:00");
            Timereceive du3 = new Timereceive("รับ 18:00");
            timereceiverepository.save(du1);
            timereceiverepository.save(du2);
            timereceiverepository.save(du3);

            Equipment equipment1 = new Equipment();
            equipment1.setEquipment_name("6D II");
            equipment1.setEquipment_price(900);
            equipment1.setEquipment_type("camera");
            equipment1.setEquipment_brand("canon");
            equipmentrepository.save(equipment1);

            Equipment equipment2 = new Equipment();
            equipment2.setEquipment_name("D5");
            equipment2.setEquipment_price(1200);
            equipment2.setEquipment_type("camera");
            equipment2.setEquipment_brand("nikon");
            equipmentrepository.save(equipment2);

            Equipment equipment3 = new Equipment();
            equipment3.setEquipment_name("a7 iii");
            equipment3.setEquipment_price(1000);
            equipment3.setEquipment_type("camera");
            equipment3.setEquipment_brand("sony");
            equipmentrepository.save(equipment3);

            Equipment equipment4 = new Equipment();
            equipment4.setEquipment_name("1dx");
            equipment4.setEquipment_price(1500);
            equipment4.setEquipment_type("camera");
            equipment4.setEquipment_brand("canon");
            equipmentrepository.save(equipment4);

            Equipment equipment5 = new Equipment();
            equipment5.setEquipment_name("D850");
            equipment5.setEquipment_price(1500);
            equipment5.setEquipment_type("camera");
            equipment5.setEquipment_brand("nikon");
            equipmentrepository.save(equipment5);

            Equipment equipment6 = new Equipment();
            equipment6.setEquipment_name("a9");
            equipment6.setEquipment_price(1600);
            equipment6.setEquipment_type("camera");
            equipment6.setEquipment_brand("sony");
            equipmentrepository.save(equipment6);

            Equipment equipment7 = new Equipment();
            equipment7.setEquipment_name("17-40 f2.8l is");
            equipment7.setEquipment_price(500);
            equipment7.setEquipment_brand("canon");
            equipment7.setEquipment_type("lens");
            equipmentrepository.save(equipment7);

            Equipment equipment8 = new Equipment();
            equipment8.setEquipment_name("70-200 f2.8l is ii");
            equipment8.setEquipment_price(600);
            equipment8.setEquipment_brand("canon");
            equipment8.setEquipment_type("lens");
            equipmentrepository.save(equipment8);

            Equipment equipment9 = new Equipment();
            equipment9.setEquipment_name("24-70 f2.8 vr nano ");
            equipment9.setEquipment_price(600);
            equipment9.setEquipment_brand("nikon");
            equipment9.setEquipment_type("lens");
            equipmentrepository.save(equipment9);

            Equipment equipment10 = new Equipment();
            equipment10.setEquipment_name("14-24 f4 vr ");
            equipment10.setEquipment_price(500);
            equipment10.setEquipment_brand("nikon");
            equipment10.setEquipment_type("lens");
            equipmentrepository.save(equipment10);

            Equipment equipment11 = new Equipment();
            equipment11.setEquipment_name("28-75 f2.8 tamron for sony");
            equipment11.setEquipment_price(500);
            equipment11.setEquipment_brand("sony");
            equipment11.setEquipment_type("lens");
            equipmentrepository.save(equipment11);

            Equipment equipment12 = new Equipment();
            equipment12.setEquipment_name("70-200 f2.8 G-master");
            equipment12.setEquipment_price(500);
            equipment12.setEquipment_brand("sony");
            equipment12.setEquipment_type("lens");
            equipmentrepository.save(equipment12);

            Equipment equipment13 = new Equipment();
            equipment13.setEquipment_name("ex-600rt");
            equipment13.setEquipment_price(300);
            equipment13.setEquipment_brand("canon");
            equipment13.setEquipment_type("flash");
            equipmentrepository.save(equipment13);

            Equipment equipment14 = new Equipment();
            equipment14.setEquipment_name("SB-600");
            equipment14.setEquipment_price(300);
            equipment14.setEquipment_brand("nikon");
            equipment14.setEquipment_type("flash");
            equipmentrepository.save(equipment14);

            Equipment equipment15 = new Equipment();
            equipment15.setEquipment_name("hvl-f60m");
            equipment15.setEquipment_price(300);
            equipment15.setEquipment_brand("sony");
            equipment15.setEquipment_type("flash");
            equipmentrepository.save(equipment15);

            //สร้าง photographer
            Photographer ph1 = new Photographer("Hero",22,"Hero@gmail.com","0895xxxxxx");
            Photographer ph2 = new Photographer("Diki",21,"diki@gmail.com","0902xxxxxx");
            Photographer ph3 = new Photographer("Safefy",20,"safefy@gmail.com","0801xxxxxx");
            Photographer ph4 = new Photographer("Eka",20,"Eka@gmail.com","0831xxxxxx");
            Photographer ph5 = new Photographer("Moty",23,"moty@gmail.com","0821xxxxxx");
            photographerRepository.save(ph1);
            photographerRepository.save(ph2);
            photographerRepository.save(ph3);
            photographerRepository.save(ph4);
            photographerRepository.save(ph5);

            //สร้าง Promotion
            PromotionPhotographer pg1 = new PromotionPhotographer("1ชม. 200บาท", 1, 200);
            PromotionPhotographer pg2 = new PromotionPhotographer("2ชม. 400บาท", 2, 400);
            PromotionPhotographer pg3 = new PromotionPhotographer("3ชม. 600บาท", 3, 600);
            PromotionPhotographer pg4 = new PromotionPhotographer("4ชม. 800บาท", 4, 800);
            PromotionPhotographer pg5 = new PromotionPhotographer("5ชม. 1000บาท", 5, 1000);
            PromotionPhotographer pg6 = new PromotionPhotographer("6ชม. 1200บาท", 6, 1200);
            PromotionPhotographer pg7 = new PromotionPhotographer("7ชม. 1400บาท", 7, 1400);
            PromotionPhotographer pg8 = new PromotionPhotographer("8ชม. 1500บาท", 8, 1500);
            PromotionPhotographer pg9 = new PromotionPhotographer("9ชม. 1800บาท", 9, 1800);
            promotionPhotographerRepository.save(pg1);
            promotionPhotographerRepository.save(pg2);
            promotionPhotographerRepository.save(pg3);
            promotionPhotographerRepository.save(pg4);
            promotionPhotographerRepository.save(pg5);
            promotionPhotographerRepository.save(pg6);
            promotionPhotographerRepository.save(pg7);
            promotionPhotographerRepository.save(pg8);
            promotionPhotographerRepository.save(pg9);

            //สร้าง Type Photo
            TypePhoto tp1 = new TypePhoto("Fashion Photography");
            TypePhoto tp2 = new TypePhoto("Wedding Photography");
            TypePhoto tp3 = new TypePhoto("Vintage Photography");
            TypePhoto tp4 = new TypePhoto("Widlife photography");
            typePhotoRepository.save(tp1);
            typePhotoRepository.save(tp2);
            typePhotoRepository.save(tp3);
            typePhotoRepository.save(tp4);

            //สร้าง startTime and finalTime
            StartTime s1 = new StartTime("6:00");
            StartTime s2 = new StartTime("7:00");
            StartTime s3 = new StartTime("8:00");
            StartTime s4 = new StartTime("9:00");
            StartTime s5 = new StartTime("10:00");
            StartTime s6 = new StartTime("11:00");
            StartTime s7 = new StartTime("12:00");
            StartTime s8 = new StartTime("13:00");
            StartTime s9 = new StartTime("14:00");
            StartTime s10 = new StartTime("15:00");
            StartTime s11 = new StartTime("16:00");
            StartTime s12 = new StartTime("17:00");
            StartTime s13 = new StartTime("18:00");
            StartTime s14 = new StartTime("19:00");
            StartTime s15 = new StartTime("20:00");
            StartTime s16 = new StartTime("21:00");
            StartTime s17 = new StartTime("22:00");
            startTimeRepository.save(s1);
            startTimeRepository.save(s2);
            startTimeRepository.save(s3);
            startTimeRepository.save(s4);
            startTimeRepository.save(s5);
            startTimeRepository.save(s6);
            startTimeRepository.save(s7);
            startTimeRepository.save(s8);
            startTimeRepository.save(s9);
            startTimeRepository.save(s10);
            startTimeRepository.save(s11);
            startTimeRepository.save(s12);
            startTimeRepository.save(s13);
            startTimeRepository.save(s14);
            startTimeRepository.save(s15);
            startTimeRepository.save(s16);
            startTimeRepository.save(s17);



            FinalTime f1 = new FinalTime("6:00");
            FinalTime f2 = new FinalTime("7:00");
            FinalTime f3 = new FinalTime("8:00");
            FinalTime f4 = new FinalTime("9:00");
            FinalTime f5 = new FinalTime("10:00");
            FinalTime f6 = new FinalTime("11:00");
            FinalTime f7 = new FinalTime("12:00");
            FinalTime f8 = new FinalTime("13:00");
            FinalTime f9 = new FinalTime("14:00");
            FinalTime f10 = new FinalTime("15:00");
            FinalTime f11 = new FinalTime("16:00");
            FinalTime f12 = new FinalTime("17:00");
            FinalTime f13 = new FinalTime("18:00");
            FinalTime f14 = new FinalTime("19:00");
            FinalTime f15 = new FinalTime("20:00");
            FinalTime f16 = new FinalTime("21:00");
            FinalTime f17 = new FinalTime("22:00");
            finalTimeRepository.save(f1);
            finalTimeRepository.save(f2);
            finalTimeRepository.save(f3);
            finalTimeRepository.save(f4);
            finalTimeRepository.save(f5);
            finalTimeRepository.save(f6);
            finalTimeRepository.save(f7);
            finalTimeRepository.save(f8);
            finalTimeRepository.save(f9);
            finalTimeRepository.save(f10);
            finalTimeRepository.save(f11);
            finalTimeRepository.save(f12);
            finalTimeRepository.save(f13);
            finalTimeRepository.save(f14);
            finalTimeRepository.save(f15);
            finalTimeRepository.save(f16);
            finalTimeRepository.save(f17);

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
            Promotionphotocollection promotionphotocollection1 = new Promotionphotocollection("1วัน 300บาท");
            Promotionphotocollection promotionphotocollection2 = new Promotionphotocollection("2วัน 400บาท");
            Promotionphotocollection promotionphotocollection3 = new Promotionphotocollection("3วัน 500บาท");
            Promotionphotocollection promotionphotocollection4 = new Promotionphotocollection("44ัน 600บาท");
            Promotionphotocollection promotionphotocollection5 = new Promotionphotocollection("5วัน 700บาท");
            Promotionphotocollection promotionphotocollection6 = new Promotionphotocollection("6วัน 800บาท");
            Promotionphotocollection promotionphotocollection7 = new Promotionphotocollection("7วัน 900บาท");
            promotionphotocollectionrepository.save(promotionphotocollection1);
            promotionphotocollectionrepository.save(promotionphotocollection2);
            promotionphotocollectionrepository.save(promotionphotocollection3);
            promotionphotocollectionrepository.save(promotionphotocollection4);
            promotionphotocollectionrepository.save(promotionphotocollection5);
            promotionphotocollectionrepository.save(promotionphotocollection6);
            promotionphotocollectionrepository.save(promotionphotocollection7);
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


        };
    }
}
*/