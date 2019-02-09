import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable()
export class Controller {

  public API = '//localhost:8080';

  constructor( private httpClient:HttpClient ){}

         getTitle(): Observable<any> {
            return this.httpClient.get(this.API + '/title');
         }
         getGender(): Observable<any> {
            return this.httpClient.get(this.API + '/gender');
         }
         getRoomStudio(): Observable<any> {
            return this.httpClient.get(this.API + '/roomStudio');
         }
         getPromotionStudio(): Observable<any> {
            return this.httpClient.get(this.API + '/promotionStudio');
         }
         getTimeStudio(): Observable<any> {
             return this.httpClient.get(this.API + '/timeStudio');
         }
         getRepairInvoiced(): Observable<any> {
                      return this.httpClient.get(this.API + '/repairinvoiced');
                  }
           getMember(): Observable<any> {
                       return this.httpClient.get(this.API + '/member');
                   }
          getTimereceive(): Observable<any> {
                       return this.httpClient.get(this.API + '/Timereceive');
          }

          getEquipment(): Observable<any> {
                       return this.httpClient.get(this.API + '/Equipment');
          }
          findUserid(user:String): Observable<any>{
          return this.httpClient.post(this.API+'/member/'+user,{})
          }
          findMember(user:String , pass:String): Observable<any>{
                        return this.httpClient.post(this.API+'/member/'+user+'/password/'+pass,{})
           }
          findAdmin(user:String , pass:String): Observable<any>{
                         return this.httpClient.post(this.API+'/admin/'+user+'/password/'+pass,{})
           }
           getPhotographer(): Observable<any> {
               return this.httpClient.get(this.API + '/Photographer');
             }

             getTypePhoto(): Observable<any> {
               return this.httpClient.get(this.API + '/TypePhoto');
             }

             getPromotionPhotographer(): Observable<any> {
               return this.httpClient.get(this.API + '/PromotionPhotographer');
             }

             getStartTime(): Observable<any> {
               return this.httpClient.get(this.API + '/StartTime');
             }

             getComment(): Observable<any> {
               return this.httpClient.get(this.API + '/ReservationPhotographer');
             }

                public getPhotoseriesID(): Observable<any> {
                         return this.httpClient.get(this.API + '/Photoseries');
                      }
                      public getPromotionphotocollectionID(): Observable<any> {
                         return this.httpClient.get(this.API + '/Promotionphotocollection');
                      }
                      public getShootingstyleID(): Observable<any> {
                         return this.httpClient.get(this.API + '/Shootingstyle');
                      }
                      public getPhotocollection(): Observable<any> {
                         return this.httpClient.get(this.API + '/Photocollection');
                      }
                public getPhotosizeID(): Observable<any> {
                    return this.httpClient.get(this.API + '/Photosize');
                }
                public getPhototypeID(): Observable<any> {
                    return this.httpClient.get(this.API + '/Phototype');
                }
                public getPhotopictureID(): Observable<any> {
                    return this.httpClient.get(this.API + '/Photopicture');
                }
               public getReservation(): Observable<any> {
                 return this.httpClient.get(this.API + '/ReservationModels');
               }

               public getModel(): Observable<any> {
                 return this.httpClient.get(this.API + '/Model');
               }

               public getPromotionModel(): Observable<any> {
                 return this.httpClient.get(this.API + '/PromotionModel');
               }
                public getProvince(): Observable<any> {
                  return this.httpClient.get(this.API + '/province');
                }
getReservationequipment_id(): Observable<any> {
      return this.httpClient.get(this.API + '/Reservationequipment');
    }

getReservationStudio_id(): Observable<any> {
      return this.httpClient.get(this.API + '/reservationStudio');
    }
getReservationphotographer_id(): Observable<any> {
      return this.httpClient.get(this.API + '/ReservationPhotographer');
    }
getPhotocollection_id(): Observable<any> {
      return this.httpClient.get(this.API + '/Photocollection');
    }
getCardtype(): Observable<any> {
      return this.httpClient.get(this.API + '/Cardtype');
    }

getCardbank(): Observable<any> {
      return this.httpClient.get(this.API + '/Cardbank');
    }


         //diki kawasaki sprint-2
         public getCamara(): Observable<any> {
              return this.httpClient.get(this.API + '/Camara');
         }
         public getInstructor(): Observable<any> {
              return this.httpClient.get(this.API + '/Instructor');
         }
         public getPhotographyType(): Observable<any> {
              return this.httpClient.get(this.API + '/PhotographyTyp');
         }
         public getSkillLevel(): Observable<any> {
              return this.httpClient.get(this.API + '/SkillLevel');
         }
         public getStudyTime(): Observable<any> {
              return this.httpClient.get(this.API + '/StudyTime');
         }
         public getRegisterPhotography(): Observable<any> {
              return this.httpClient.get(this.API + '/registerPhotography');
         }
         public getReservationStudio(): Observable<any> {
              return this.httpClient.get(this.API + '/reservationStudio');
         }

            getTablePhotogarpher(): Observable<any> {
            return this.httpClient.get(this.API + '/tablephotographer');
            }
            getTimeTable(): Observable<any> {
            return this.httpClient.get(this.API + '/timesphotogarpher');
            }
            getPromotionTable(): Observable<any> {
            return this.httpClient.get(this.API + '/promotiontable');
            }//MM

}
