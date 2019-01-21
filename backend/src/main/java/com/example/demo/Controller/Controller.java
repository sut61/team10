package com.example.demo.Controller;


import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired AddressRepository addressRepository ;
    @Autowired GenderReposiory genderReposiory ;
    @Autowired MemberRepository memberRepository ;
    @Autowired TitleRepository titleRepository ;
    @Autowired PromotionStudioRepository promotionStudioRepository;
    @Autowired ReservationStudioRepository reservationStudioRepository;
    @Autowired RoomStudioRepository roomStudioRepository;
    @Autowired TimeStudioRepository timeStudioRepository;

    @GetMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Address> address() {
        return addressRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/gender", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Gender> gender() {
        return genderReposiory.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/member", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Member> member() {
        return memberRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/title", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Title> title() {
        return titleRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/promotionStudio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PromotionStudio> promotionStudio() {
        return promotionStudioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/reservationStudio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ReservationStudio> reservationStudio() {
        return reservationStudioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/roomStudio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<RoomStudio> roomStudio() {
        return roomStudioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/timeStudio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TimeStudio> timeStudio() {
        return timeStudioRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/reservationStudio/{promotionStudio}/{roomStudio}/{timeStudio}/{reservationDate}")
    public ReservationStudio reservationStudio(@PathVariable Long roomStudio , @PathVariable Long promotionStudio , @PathVariable Long timeStudio,@PathVariable Date reservationDate){
        RoomStudio roomStudio1 = roomStudioRepository.findById(roomStudio).get();
        PromotionStudio promotionStudio1 = promotionStudioRepository.findById(promotionStudio).get();
        TimeStudio timeStudio1 = timeStudioRepository.findById(timeStudio).get();
        ReservationStudio reservationStudio = new ReservationStudio();
        reservationStudio.setRoomStudio(roomStudio1);
        reservationStudio.setPromotionStudio(promotionStudio1);
        reservationStudio.setTimeStudio(timeStudio1);
        reservationStudio.setReservationDate(reservationDate);
        return reservationStudioRepository.save(reservationStudio);
    }

    @GetMapping(path ="/member/{userid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member checkuserid(@PathVariable String userid){
        return memberRepository.findByUserid(userid);
    }

    @PostMapping(path = "/member/{address}/{tambon}/{amphoe}/{province}/{postcode}/{name}/{lastname}/{gender}/{tel}/{birthday}/{email}/{userid}/{password}/{title}")
    public Member member(@PathVariable String address , @PathVariable String tambon , @PathVariable String amphoe ,
                          @PathVariable String province , @PathVariable String postcode , @PathVariable String name ,
                         @PathVariable String lastname , @PathVariable Long gender , @PathVariable String tel , @PathVariable Date birthday,
                         @PathVariable String email , @PathVariable String userid , @PathVariable String password , @PathVariable Long title){
            Address address1 = new Address();
            address1.setAddress(address);
            address1.setAmphoe(amphoe);
            address1.setPostcode(postcode);
            address1.setProvince(province);
            address1.setTambon(tambon);
            addressRepository.save(address1);

            Gender gender1 = genderReposiory.findById(gender).get();
            Title title1 = titleRepository.findById(title).get();

            Member member = new Member();
            member.setAddress(address1);
            member.setBirthdate(birthday);
            member.setEmail(email);
            member.setGender(gender1);
            member.setLastname(lastname);
            member.setName(name);
            member.setPassword(password);
            member.setUserid(userid);
            member.setTitle(title1);
            member.setTel(tel);

            memberRepository.save(member);
            return member;
    }



}
