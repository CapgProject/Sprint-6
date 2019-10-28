import {Component, OnInit} from '@angular/core';
import {TestService} from '../_service/app.testservice'
import {Test} from '../_model/app.test';
import { Router } from '@angular/router';



@Component({
    selector:'showtest',
    templateUrl:'../_html/app.showalltest.html'
})

export class ShowAllTestComponent implements OnInit{
    update:any;
    tests:any[]=[];

    constructor(private service:TestService, private router:Router){
    }

    ngOnInit(){ 
        if(sessionStorage.getItem("role")!= "admin"){
            this.router.navigate(['/error403'])
        }else{
            this.service.showAllTests().subscribe((data:Test[])=>this.tests=data);
        }
    }
   
    
}