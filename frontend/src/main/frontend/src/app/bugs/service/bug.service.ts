import { Injectable }                   from '@angular/core';
import {Http, RequestOptions, Response} from '@angular/http';
import { Observable }                   from "rxjs";

import { Bug }                          from '../model/bug';

@Injectable()
export class BugService {

  private bugsUrl = '/api/bugs/list';
  private bugsCreate = '/api/bugs';

  constructor(private http: Http) {}

  getAddedBugs(): Observable<Bug[]> {
    return this.http
        .get(this.bugsUrl)
        .map((res) => this.extractData(res))
        .catch((err) => this.handleError(err));
  }

  addBug(bug: Bug) {
    console.log(bug);
    return this.http.post(this.bugsCreate, bug)
      .map((res) => this.extractData(res))
      .catch((err) => this.handleError(err));
  }

  updateBug(bug: Bug) {
    bug.updatedBy = "todo";
    bug.modificationDate = Date.now();
    return this.http.put(this.bugsCreate, bug)
      .map((res) => this.extractData(res))
      .catch((err) => this.handleError(err));
  }

  private extractData(res: Response) {
    let body = res.json();
    console.log(body);
    return body as Bug;
  }

  private handleError (error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
