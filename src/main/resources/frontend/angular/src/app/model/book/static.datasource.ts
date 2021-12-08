import {Injectable} from "@angular/core";
import {Book} from "./book.model";
import {from, Observable} from "rxjs";



@Injectable()
export class StaticDataSource {

  private books: Array<Book> = [
    new Book(1, "https://picsum.photos/id/10/200/300","Książka","Roman Witek","11-11-2011","Naukowa",true,12,true,"Lorem ipsum dolor sit"),
    new Book(2, "https://picsum.photos/id/27/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(3, "https://picsum.photos/id/37/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",false,2,true,"Lorem ipsum dolor sit"),
    new Book(4, "https://picsum.photos/id/7/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",false,2,false,"Lorem ipsum dolor sit"),
    new Book(5, "https://picsum.photos/id/222/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(6, "https://picsum.photos/id/1002/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",false,2,true,"Lorem ipsum dolor sit"),
    new Book(7, "https://picsum.photos/id/1015/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(8, "https://picsum.photos/id/102/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",false,2,true,"Lorem ipsum dolor sit"),
    new Book(9, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(10, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(11, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(12, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(13, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(14, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(15, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(16, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
    new Book(17, "https://picsum.photos/id/1/200/300","Książka","Tomasz Comasz","10-01-2011","Naukowa",true,2,true,"Lorem ipsum dolor sit"),
  ]

  getBooks(): Observable<Array<Book>> {
    return from([this.books])
  }

}