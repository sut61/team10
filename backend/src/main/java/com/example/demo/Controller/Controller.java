package com.example.demo.Controller;


import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
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
    @Autowired private Reservationequipmentrepository reservationequipmentrepository;
    @Autowired private Equipmentrepository equipmentrepository;
    @Autowired private Timereceiverepository timereceiverepository;
    @Autowired private PhotographerRepository photographerRepository;
    @Autowired private PromotionPhotographerRepository promotionPhotographerRepository;
    @Autowired private TypePhotoRepository typePhotoRepository;
    @Autowired private ReservationPhotographerRepository reservationPhotographerRepository;
    @Autowired private StartTimeRepository startTimeRepository;
    @Autowired private FinalTimeRepository finalTimeRepository;
    @Autowired private Photocollectionrepository photocollectionrepository;
    @Autowired private Photoseriesrepository photoseriesrepository;
    @Autowired private Promotionphotocollectionrepository promotionphotocollectionrepository;
    @Autowired private Shootingstylerepository shootingstylerepository;
    @Autowired  ReservationModelRepository reservationModelRepository;
    @Autowired  ModelRepository modelRepository;
    @Autowired  PromotionModelRepository promotionModelRepository;
    @Autowired  ProvinceRepository provinceRepository;
    @Autowired  AdminRepository adminRepository;
    @Autowired  CommentRepository commentRepository;
    @Autowired  RepairInvoicedRepository repairInvoicedRepository;

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
    @GetMapping(path = "/province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Province> provinces() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/roomStudio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<RoomStudio> roomStudio() {
        return roomStudioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/timeStudio", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TimeStudio> timeStudio() {
        return timeStudioRepository.findAll().stream().collect(Collectors.toList());
    }
@GetMapping(path = "/Reservationequipment")
public Collection<Reservationequipment> reservationrepository() {
    return reservationequipmentrepository.findAll().stream().collect(Collectors.toList());
}
    @GetMapping(path = "ReservationModels", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ReservationModel> reservation() {
        return reservationModelRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "Model", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Model> model() {
        return modelRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "PromotionModel", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PromotionModel> promotionModel() {
        return promotionModelRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Equipment")
    public Collection<Equipment> equipmentrepository() {
        return equipmentrepository.findAll().stream().collect(Collectors.toList());

    }@GetMapping(path = "/Timereceive")
    public Collection<Timereceive> timereceiverepository() {
        return timereceiverepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Photographer")
    public Collection<Photographer> photographer() {
        return photographerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/PromotionPhotographer")
    public Collection<PromotionPhotographer> promotionPhotographer() {
        return promotionPhotographerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/ReservationPhotographer")
    public Collection<ReservationPhotographer> reservationPhotographer() {
        return reservationPhotographerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/TypePhoto")
    public Collection<TypePhoto> typePhoto() {
        return typePhotoRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/StartTime")
    public Collection<StartTime> startTimes() {
        return startTimeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/FinalTime")
    public Collection<FinalTime> finalTimes() {
        return finalTimeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/repairinvoiced")
    public Collection<RepairInvoiced> repairInvoiceds() {
        return repairInvoicedRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/reservationPhotographer/{name}/{photographer}/{typePhoto}/{promotionPhotographer}/{startTime}/{finalTime}/{timeSelect}/{comment}")
    public ReservationPhotographer reservationPhotographer(@PathVariable String name , @PathVariable Long photographer ,
                                                           @PathVariable Long typePhoto, @PathVariable Long promotionPhotographer,
                                                           @PathVariable Long startTime , @PathVariable Long finalTime,
                                                           @PathVariable Date timeSelect, @PathVariable String comment){

        Member member1 = memberRepository.findByName(name);
        Photographer photographer1 = photographerRepository.findById(photographer).get();
        PromotionPhotographer promotionPhotographer1 = promotionPhotographerRepository.findById(promotionPhotographer).get();
        TypePhoto typePhoto1 = typePhotoRepository.findById(typePhoto).get();
        StartTime startTime1 = startTimeRepository.findById(startTime).get();
        FinalTime finalTime1 = finalTimeRepository.findById(finalTime).get();


        ReservationPhotographer reservationPhotographer1 = new ReservationPhotographer();
        reservationPhotographer1.setMember(member1);
        reservationPhotographer1.setPhotographer(photographer1);
        reservationPhotographer1.setTypePhoto(typePhoto1);
        reservationPhotographer1.setPromotionPhotographer(promotionPhotographer1);
        reservationPhotographer1.setStartTime(startTime1);
        reservationPhotographer1.setFinalTime(finalTime1);
        reservationPhotographer1.setReservation_date(timeSelect);
        reservationPhotographer1.setComment_photo(comment);
        reservationPhotographerRepository.save(reservationPhotographer1);

        return reservationPhotographer1;
    }

    @PostMapping(path = "/reservationStudio/{promotionStudio}/{roomStudio}/{timeStudio}/{reservationDate}/{name}")
    public ReservationStudio reservationStudio(@PathVariable String name ,@PathVariable Long roomStudio , @PathVariable Long promotionStudio , @PathVariable Long timeStudio,@PathVariable Date reservationDate){
        RoomStudio roomStudio1 = roomStudioRepository.findById(roomStudio).get();
        PromotionStudio promotionStudio1 = promotionStudioRepository.findById(promotionStudio).get();
        TimeStudio timeStudio1 = timeStudioRepository.findById(timeStudio).get();
        ReservationStudio reservationStudio = new ReservationStudio();
        Member member = memberRepository.findByName(name);
        reservationStudio.setMember(member);
        reservationStudio.setRoomStudio(roomStudio1);
        reservationStudio.setPromotionStudio(promotionStudio1);
        reservationStudio.setTimeStudio(timeStudio1);
        reservationStudio.setReservationDate(reservationDate);
        return reservationStudioRepository.save(reservationStudio);
    }



    @PostMapping(path = "/member/{address}/{tambon}/{amphoe}/{province}/{postcode}/{name}/{lastname}/{gender}/{tel}/{birthday}/{email}/{userid}/{password}/{title}")
    public Member member(@PathVariable String address , @PathVariable String tambon , @PathVariable String amphoe ,
                         @PathVariable Long province , @PathVariable String postcode , @PathVariable String name ,
                         @PathVariable String lastname , @PathVariable Long gender , @PathVariable String tel , @PathVariable Date birthday,
                         @PathVariable String email , @PathVariable String userid , @PathVariable String password , @PathVariable Long title){
        Address address1 = new Address();
        Province province1 = provinceRepository.findById(province).get();
        address1.setAddress(address);
        address1.setAmphoe(amphoe);
        address1.setPostcode(postcode);
        address1.setTambon(tambon);
        address1.setProvince(province1);
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

    @PostMapping(path = "/repairinvoiced/{equipment_id}/{commentt}/{datein}/{admin}")
    public RepairInvoiced repairInvoiced(@PathVariable Long equipment_id , @PathVariable String commentt ,
                                         @PathVariable Date datein , @PathVariable String admin ){
        Comment comment = new Comment();
        comment.setComments(commentt);
        commentRepository.save(comment);

        Equipment equipment = equipmentrepository.findById(equipment_id).get();
        Admin admin1 = adminRepository.findByUserid(admin);

        RepairInvoiced repairInvoiced = new RepairInvoiced();
        repairInvoiced.setAdmin(admin1);
        repairInvoiced.setComment(comment);
        repairInvoiced.setDatein(datein);
        repairInvoiced.setEquipment(equipment);
        repairInvoicedRepository.save(repairInvoiced);

        return repairInvoiced;

    }

    @PostMapping("/member/{userid}")
    public  Member member(@PathVariable String userid){
        return this.memberRepository.findByUserid(userid);
    }

    @PostMapping("/member/{userid}/password/{password}")
    public  Member member1(@PathVariable String userid , @PathVariable String password){
        return this.memberRepository.findByUseridAndPassword(userid,password);
    }

    @PostMapping("/admin/{userid}/password/{password}")
    public  Admin admin(@PathVariable String userid , @PathVariable String password){
        return this.adminRepository.findByUseridAndPassword(userid,password);
    }


@PostMapping(path = "/reservationequipment/{daterent}/{timereceive}/{equipment}/{name}")
    public Reservationequipment reservationequipment(
            @PathVariable Date daterent ,
                @PathVariable Long timereceive,@PathVariable Long equipment
                ,@PathVariable String  name){

        Member member1 = memberRepository.findByName(name);
        Timereceive timereceive1 = timereceiverepository.findById(timereceive).get();
        Equipment equipment1 = equipmentrepository.findById(equipment).get();

        Reservationequipment reservationequipment = new Reservationequipment();
        reservationequipment.setDaterent(daterent);
        reservationequipment.setMember(member1);
        reservationequipment.setTimereceive(timereceive1);
        reservationequipment.setEquipment(equipment1);

        reservationequipmentrepository.save(reservationequipment);
        return reservationequipment;
    }

    @GetMapping(path = "/Photocollection")
    public Collection<Photocollection> Photocollection() {
        return photocollectionrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Photoseries")
    public Collection<Photoseries> Photoseries() {
        return photoseriesrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Promotionphotocollection")
    public Collection<Promotionphotocollection> Promotionphotocollection() {
        return promotionphotocollectionrepository.findAll().stream().collect(Collectors.toList());
    }



    @GetMapping(path = "/Shootingstyle")
    public Collection<Shootingstyle> Shootingstyle() {
        return shootingstylerepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path = "/photocollection/{name}/{photoseriesIDSelect}/{promotionphotocollectionIDSelect}/{shootingstyleIDSelect}/{startdateIDSelect}/{lastdateIDSelect}")
    public Photocollection photocollection(@PathVariable String name, @PathVariable String photoseriesIDSelect,
                                           @PathVariable String  promotionphotocollectionIDSelect, @PathVariable String shootingstyleIDSelect,
                                           @PathVariable Date startdateIDSelect,@PathVariable Date lastdateIDSelect){

        Photoseries photoseries = photoseriesrepository.findByname(photoseriesIDSelect);
        Promotionphotocollection promotionphotocollection = promotionphotocollectionrepository.findByname(promotionphotocollectionIDSelect);
        Shootingstyle shootingstyle = shootingstylerepository.findByname(shootingstyleIDSelect);

        Photocollection photocollection = new Photocollection();
        Member member = memberRepository.findByName(name);
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setStartdate(startdateIDSelect);
        photocollection.setLastdate(lastdateIDSelect);
        photocollection.setPhotoseriesname(photoseriesIDSelect);
        photocollection.setPromotionphotocollectionname(promotionphotocollectionIDSelect);
        photocollection.setShootingstylename(shootingstyleIDSelect);
        photocollectionrepository.save(photocollection);
        return photocollection;
    }

    @PostMapping(path ="/ReservationModels/{modelnameSelect}/{themesSelect}/{LocationSelect}/{promotionmodelSelect}/{dateSelect}/{name}")
    public ReservationModel reservationModel( @PathVariable Long modelnameSelect ,
                                              @PathVariable String themesSelect, @PathVariable String LocationSelect,
                                              @PathVariable Long promotionmodelSelect, @PathVariable Date dateSelect, @PathVariable String name){

        Model model = modelRepository.findById(modelnameSelect).get();
        PromotionModel promotionModel = promotionModelRepository.findById(promotionmodelSelect).get();
        Member member = memberRepository.findByName(name);
        ReservationModel reservationModel = new ReservationModel();
        reservationModel.setMember(member);
        reservationModel.setModel(model);
        reservationModel.setThemes(themesSelect);
        reservationModel.setLocation(LocationSelect);
        reservationModel.setPromotionModel(promotionModel);
        reservationModel.setDate(dateSelect);

        reservationModelRepository.save(reservationModel);
        return reservationModel;
    }


}

