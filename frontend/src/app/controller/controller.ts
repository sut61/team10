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
             getFinalTime(): Observable<any> {
               return this.httpClient.get(this.API + '/FinalTime');
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
               public getReservation(): Observable<any> {
                 return this.httpClient.get(this.API + '/ReservationModels');
               }

               public getModel(): Observable<any> {
                 return this.httpClient.get(this.API + '/Model');
               }

               public getPromotionModel(): Observable<any> {
                 return this.httpClient.get(this.API + '/PromotionModel');
               }

}
//kuy