# IPL Dashboard App
## Backend (Spring Boot)

Run main App class - `DashboardApplication` -> check logs

## UI (React)

Navigate to `src/frontend` folder and download all needed dependencies with `npm`:

    npm install

Start UI with `yarn`:

    yarn start

From IDE login page should be open:

    http://localhost:3000/

Some URLs for testing

    http://localhost:3000/teams/Delhi%20Capitals

    http://localhost:3000/teams/Mumbai%20Indians/matches/2017

---
Browse your favorite IPL teams and access their past games details, wins and losses ratios - accessible by team and tournament year.

This is a companion project for the Java Brains course on Full Stack Development using Spring Boot and React JS.

## Screenshots

### Team Page

![Team Page Page](/README/team-page.jpg)

### Matches Page

![Matches Page](/README/matches-page.jpg)

## Technologies

* Spring Boot
* Spring Batch
* Java Persistence API, Repositories and JPQL
* HSQL DB
* React JS
* AWS BeanStalk

## Data Set Used
https://www.kaggle.com/patrickb1912/ipl-complete-dataset-20082020/metadata

---

Deployed to Heroku (dead now):

    https://ipl-dashboard-service.herokuapp.com/

---
After updating UI part, run 

    yarn build 

Updated resources will be copied to Spring Boot App. And launched as regular Spring Boot App. 

