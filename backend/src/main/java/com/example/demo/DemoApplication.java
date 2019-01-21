package com.example.demo;

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
	ApplicationRunner init(MemberRepository memberRepository , GenderReposiory genderReposiory , TitleRepository titleRepository , PromotionStudioRepository promotionStudioRepository , RoomStudioRepository roomStudioRepository , TimeStudioRepository timeStudioRepository){
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



			};
		}
	}
