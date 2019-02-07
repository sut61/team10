package com.example.demo.Controller;


import com.example.demo.Entity.*;
import com.example.demo.Entity.RegisterPhotographys.*;
import com.example.demo.Repository.*;
import com.example.demo.Repository.RegisterPhotographysRepository.*;
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
    @Autowired private ReservationStudioRepository reservationStudioRepository;
    @Autowired private RoomStudioRepository roomStudioRepository;
    @Autowired private TimeStudioRepository timeStudioRepository;
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
    @Autowired private ReservationModelRepository reservationModelRepository;
    @Autowired private ModelRepository modelRepository;
    @Autowired private PromotionModelRepository promotionModelRepository;
    @Autowired  ProvinceRepository provinceRepository;
    @Autowired  AdminRepository adminRepository;
    @Autowired  CommentRepository commentRepository;
    @Autowired  RepairInvoicedRepository repairInvoicedRepository;
    @Autowired private Paymentrepository paymentrepository;
    @Autowired private Cardtyperepository cardtyperepository;
    @Autowired private Cardbankrepository cardbankrepository;
    //Diki kawasaki Sprint#2 {
        @Autowired CamaraRepository camaraRepository;
        @Autowired InstructorRepository instructorRepository;
        @Autowired PhotographyTypeRepository photographyTypeRepository;
        @Autowired RegisterPhotographyRepository registerPhotographyRepository;
        @Autowired SkillLevelRepository skillLevelRepository;
        @Autowired StudyTimeRepository studyTimeRepository;
    //}
    //Natthapon sprint 2{
    @Autowired TablePhotographerRepository tablePhotographerRepository; //Ice
    @Autowired TimesPhotogarpherRepository timesPhotogarpherRepository; //ICe
    @Autowired PromotionTableRepository promotionTableRepository; //Ice
//}
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

    @GetMapping(path = "/promotionStudio")
    public Collection<PromotionStudio> promotionStudio() {
        return promotionStudioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/reservationStudio")
    public Collection<ReservationStudio> reservationStudioRepository() {
        return reservationStudioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Province> provinces() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/roomStudio")
    public Collection<RoomStudio> roomStudio() {
        return roomStudioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/timeStudio")
    public Collection<TimeStudio> timeStudio() {
        return timeStudioRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/Reservationequipment")
    public Collection<Reservationequipment> reservationrepository() {
        return reservationequipmentrepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "ReservationModels")
    public Collection<ReservationModel> reservationModelRepository() {
        return reservationModelRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "Model")
    public Collection<Model> model() {
        return modelRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping(path = "PromotionModel")
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
    //Natthapon sprint 2{
    @GetMapping("/tablephotographer")
    public Collection<TablePhotographer> tablePhotographers() {
        return tablePhotographerRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/timesphotogarpher")
    public Collection<TimesPhotogarpher> timesPhotogarphers() {
        return timesPhotogarpherRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/promotiontable")
    public Collection<PromotionTable> promotionTables() {
        return promotionTableRepository.findAll().stream().collect(Collectors.toList());
    }
    //}

    @PostMapping(path = "/reservationPhotographer/{name}/{photographer}/{typePhoto}/{promotionPhotographer}/{startTime}/{finalTime}/{timeSelect}/{comment}")
    public ReservationPhotographer reservationPhotographer(@PathVariable String name , @PathVariable Long photographer ,
                                                           @PathVariable Long typePhoto, @PathVariable Long promotionPhotographer,
                                                           @PathVariable Long startTime , @PathVariable Long finalTime,
                                                           @PathVariable Date timeSelect, @PathVariable String comment){

        Member member1 = memberRepository.findByUserid(name);
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

    @PostMapping(path = "/reservationStudio/{promotionStudio}/{roomStudio}/{timeStudio}/{reservationDate}/{name}/{price}")
    public ReservationStudio reservationStudio(@PathVariable String name ,@PathVariable Long roomStudio , @PathVariable Long promotionStudio ,
                                               @PathVariable Long timeStudio,@PathVariable Date reservationDate,@PathVariable int price){
        RoomStudio roomStudio1 = roomStudioRepository.findById(roomStudio).get();
        PromotionStudio promotionStudio1 = promotionStudioRepository.findById(promotionStudio).get();
        TimeStudio timeStudio1 = timeStudioRepository.findById(timeStudio).get();

        ReservationStudio reservationStudio = new ReservationStudio();
        Member member = memberRepository.findByUserid(name);
        reservationStudio.setMember(member);
        reservationStudio.setRoomStudio(roomStudio1);
        reservationStudio.setPromotionStudio(promotionStudio1);
        reservationStudio.setTimeStudio(timeStudio1);
        reservationStudio.setReservationDate(reservationDate);
        reservationStudio.setPrice(price);
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


    @PostMapping(path = "/reservationequipment/{daterent}/{cardid}/{timereceive}/{equipment}/{name}")
    public Reservationequipment reservationequipment(
            @PathVariable Date daterent ,
            @PathVariable Long timereceive,@PathVariable Long equipment
            ,@PathVariable String  name,@PathVariable String cardid){

        Member member1 = memberRepository.findByUserid(name);
        Timereceive timereceive1 = timereceiverepository.findById(timereceive).get();
        Equipment equipment1 = equipmentrepository.findById(equipment).get();

        Reservationequipment reservationequipment = new Reservationequipment();
        reservationequipment.setCardid(cardid);
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


    @PostMapping(path = "/photocollection/{name}/{photoseriesIDSelect}/{promotionphotocollectionIDSelect}/{shootingstyleIDSelect}/{startdateIDSelect}/{lastdateIDSelect}/{shootingstylenamewriteSelect}")
    public Photocollection photocollection(@PathVariable String name, @PathVariable String photoseriesIDSelect,
                                           @PathVariable String  promotionphotocollectionIDSelect, @PathVariable String shootingstyleIDSelect,
                                           @PathVariable Date startdateIDSelect,@PathVariable Date lastdateIDSelect,@PathVariable String shootingstylenamewriteSelect){

        Photoseries photoseries = photoseriesrepository.findByname(photoseriesIDSelect);
        Promotionphotocollection promotionphotocollection = promotionphotocollectionrepository.findByname(promotionphotocollectionIDSelect);
        Shootingstyle shootingstyle = shootingstylerepository.findByname(shootingstyleIDSelect);

        Photocollection photocollection = new Photocollection();
        Member member = memberRepository.findByUserid(name);
        photocollection.setMember(member);
        photocollection.setPhotoseries(photoseries);
        photocollection.setPromotionphotocollection(promotionphotocollection);
        photocollection.setShootingstyle(shootingstyle);
        photocollection.setStartdate(startdateIDSelect);
        photocollection.setLastdate(lastdateIDSelect);
        photocollection.setPhotoseriesname(photoseriesIDSelect);
        photocollection.setPromotionphotocollectionname(promotionphotocollectionIDSelect);
        photocollection.setShootingstylename(shootingstyleIDSelect);
        photocollection.setShootingstylenamewrite(shootingstylenamewriteSelect);
        photocollectionrepository.save(photocollection);
        return photocollection;
    }

    @PostMapping(path ="/ReservationModels/{modelnameSelect}/{themesSelect}/{LocationSelect}/{promotionmodelSelect}/{dateSelect}/{name}")
    public ReservationModel reservationModel( @PathVariable Long modelnameSelect ,
                                              @PathVariable String themesSelect, @PathVariable String LocationSelect,
                                              @PathVariable Long promotionmodelSelect, @PathVariable Date dateSelect, @PathVariable String name){

        Model model = modelRepository.findById(modelnameSelect).get();
        PromotionModel promotionModel = promotionModelRepository.findById(promotionmodelSelect).get();
        Member member = memberRepository.findByUserid(name);
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
    @GetMapping(path = "/Payment")
    public Collection<Payment> paymentrepository() {
        return paymentrepository.findAll().stream().collect(Collectors.toList());


    }@GetMapping(path = "/Cardtype")
    public Collection<Cardtype> cardtyperepository() {
        return cardtyperepository.findAll().stream().collect(Collectors.toList());

    }

    @GetMapping(path = "/Cardbank")
    public Collection<Cardbank> cardbankrepository() {
        return cardbankrepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/payment/{card_cvv}/{card_name}/{payment_total}/{card_id}/{cardbank}/{card_type}/{name}/{rent5}/{rent2}/{rent4}/{rent3}/{rent1}")
    public Payment payment(@PathVariable int card_cvv  , @PathVariable String card_name
            , @PathVariable long card_type, @PathVariable String card_id, @PathVariable int payment_total,
                           @PathVariable String name, @PathVariable  Long rent1, @PathVariable Long cardbank,
                           @PathVariable Long rent2, @PathVariable Long rent3,
                           @PathVariable Long rent4, @PathVariable Long rent5) {


        Cardtype cardtype = cardtyperepository.findById(card_type).get();
        Cardbank cardbank1 = cardbankrepository.findById(cardbank).get();
        Member member = memberRepository.findByUserid(name);
        Reservationequipment renteq = reservationequipmentrepository.findById(rent1).get();
        ReservationModel reservationModel1 = reservationModelRepository.findById(rent2).get();
        ReservationStudio reservationStudio1 = reservationStudioRepository.findById(rent3).get();
        ReservationPhotographer reservationPhotographer1 = reservationPhotographerRepository.findById(rent4).get();
        Photocollection photocollection1 = photocollectionrepository.findById(rent5).get();

        Payment payment = new Payment();
        payment.setPayment_total(payment_total);
        payment.setMember(member);
        payment.setReservationequipment(renteq);
        payment.setReservationModel(reservationModel1);
        payment.setReservationStudio(reservationStudio1);
        payment.setReservationPhotographer(reservationPhotographer1);
        payment.setPhotocollection(photocollection1);
        payment.setCardtype(cardtype);
        payment.setCard_name(card_name);
        payment.setCard_id(card_id);
        payment.setCard_cvv(card_cvv);
        payment.setCardbank(cardbank1);

        paymentrepository.save(payment);

        return payment;
    }


    //Diki kawasaki Sprint#2 {
        @GetMapping(path = "/Camara", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<Camara> camara() {
            return camaraRepository.findAll().stream().collect(Collectors.toList());
        }
        @GetMapping(path = "/Instructor", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<Instructor> instructor() {
            return instructorRepository.findAll().stream().collect(Collectors.toList());
        }
        @GetMapping(path = "/PhotographyTyp", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<PhotographyType> photographyType() {
            return photographyTypeRepository.findAll().stream().collect(Collectors.toList());
        }
        @GetMapping(path = "/SkillLevel", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<SkillLevel> skillLevel() {
            return skillLevelRepository.findAll().stream().collect(Collectors.toList());
        }
        @GetMapping(path = "/StudyTime", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<StudyTime> studyTime() {
            return studyTimeRepository.findAll().stream().collect(Collectors.toList());
        }
        @GetMapping(path = "/registerPhotography", produces = MediaType.APPLICATION_JSON_VALUE)
        public Collection<RegisterPhotography> registerPhotography() {
            return registerPhotographyRepository.findAll().stream().collect(Collectors.toList());
        }

        @PostMapping(path = "/registerPhotography/{camara}/{instructor}/{photographyType}/{skillLevel}/{studyTime}/{name}/{message}")
        public RegisterPhotography registerPhotography(@PathVariable String name ,@PathVariable Long camara , @PathVariable Long instructor ,
                                                       @PathVariable Long photographyType,@PathVariable Long skillLevel,
                                                       @PathVariable String message,@PathVariable Long studyTime){
        Camara camara1 = camaraRepository.findById(camara).get();
        Instructor instructor1 = instructorRepository.findById(instructor).get();
        PhotographyType photographyType1 = photographyTypeRepository.findById(photographyType).get();
        SkillLevel skillLevel1 = skillLevelRepository.findById(skillLevel).get();
        StudyTime studyTime1 = studyTimeRepository.findById(studyTime).get();

        RegisterPhotography registerPhotography = new RegisterPhotography();
        Member member = memberRepository.findByUserid(name);
        Date registerDate = new Date();
        registerPhotography.setCamara(camara1);
        registerPhotography.setInstructor(instructor1);
        registerPhotography.setPhotographyType(photographyType1);
        registerPhotography.setSkillLevel(skillLevel1);
        registerPhotography.setStudyTime(studyTime1);
        registerPhotography.setRegisterDate(registerDate);
        registerPhotography.setMember(member);
        registerPhotography.setMessage(message);
        return registerPhotographyRepository.save(registerPhotography);
    }
    //}
//Natthapon sprint 2{
    @PostMapping(path ="/tablephotographer/{photoSelect}/{telSelect}/{typephotoSelect}/{timetableSelect}/{promotiontableSelect}/{locationSelect}/{date}/{admin}")
    public TablePhotographer tablePhotographer(@PathVariable Long photoSelect,@PathVariable String telSelect,@PathVariable Long typephotoSelect
            ,@PathVariable Long timetableSelect,@PathVariable Long promotiontableSelect,@PathVariable String locationSelect , @PathVariable Date date, @PathVariable String admin){

        Admin admin1 = adminRepository.findByUserid(admin);
        Photographer photographer1 = photographerRepository.findById(photoSelect).get();
        TypePhoto typePhoto1 = typePhotoRepository.findById(typephotoSelect).get();
        TimesPhotogarpher timesPhotogarpher = timesPhotogarpherRepository.findById(timetableSelect).get();
        PromotionTable promotionTable = promotionTableRepository.findById(promotiontableSelect).get();
        TablePhotographer tablePhotographer = new TablePhotographer();
        tablePhotographer.setAdmin(admin1);
        tablePhotographer.setPhotographer(photographer1);
        tablePhotographer.setTel(telSelect);
        tablePhotographer.setTypePhoto(typePhoto1);
        tablePhotographer.setTimesPhotogarpher(timesPhotogarpher);
        tablePhotographer.setPromotionTable(promotionTable);
        tablePhotographer.setLocation(locationSelect);
        tablePhotographer.setDate(date);
        tablePhotographerRepository.save(tablePhotographer);
        return tablePhotographer;

    }
//}
}

