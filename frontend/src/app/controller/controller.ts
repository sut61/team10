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

          public checkuserid(userid:string):Observable<any>{
             return this.httpClient.get('//localhost:8080/member/'+userid);
           }
}
