import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directive',
  templateUrl: './directive.component.html',
  
})
export class DirectiveComponent implements OnInit {

  courseList : string [] = ['Java SE', 'C++', 'Python', 'TypeScript'];

  enable : boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  setEnable() : void {
    this.enable = (this.enable==true) ? false : true;
  }

}
