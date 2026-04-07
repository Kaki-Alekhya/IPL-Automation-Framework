# 🏏 IPL Automation Framework

---

## 📌 Project Overview

The **IPL Automation Framework** is a UI Automation Testing framework developed to validate critical functionalities of the IPL official website:
👉 https://www.iplt20.com/

This framework is built using **industry best practices** and follows the **Page Object Model (POM)** design pattern to ensure scalability, reusability, and maintainability.

---

## 🎯 Objective

* Automate key user journeys of the IPL website
* Build a **scalable and reusable automation framework**
* Implement **Page Object Model (POM)**
* Maintain proper separation of concerns
* Generate structured reports and debugging artifacts

---

## 🛠️ Tech Stack

* Java (JDK 17+)
* Maven
* Selenium WebDriver (v4)
* TestNG
* Page Object Model (POM)
* Git

---

## 📂 Project Structure

```
IPL-Automation-Framework/
│── src/
│   ├── main/java/
│   │   ├── base/
│   │   ├── pages/
│   │   ├── utils/
│   ├── test/java/
│   │   ├── tests/
│
│── testng-chrome.xml
│── testng-edge.xml
│── pom.xml
│── README.md
│── reports/
│── screenshots/
```

---

## 📊 Framework Architecture

```
                +---------------------------+
                |   Test Layer (TestNG)     |
                | - Test Classes            |
                | - TestNG XML              |
                +------------+--------------+
                             |
                             v
                +---------------------------+
                |   Page Object Model (POM) |
                | - HomePage                |
                | - TeamsPage               |
                | - StatsPage               |
                | - NewsPage                |
                +------------+--------------+
                             |
                             v
                +---------------------------+
                |   Base Class              |
                | - Driver Initialization   |
                | - Browser Setup           |
                +------------+--------------+
                             |
        +--------------------+--------------------+
        |                                         |
        v                                         v
+------------------------+          +-----------------------------+
|   Utility Classes      |          |   Test Data / Config        |
| - Wait Utilities       |          | - Test Data                 |
| - Common Actions       |          | - Config Properties         |
| - Screenshot Capture   |          +-----------------------------+
+-----------+------------+
            |
            v
        +-----------------------------+
        |   Selenium WebDriver        |
        +-------------+---------------+
                      |
                      v
        +-----------------------------+
        |   Browser (Chrome / Edge)   |
        +-------------+---------------+
                      |
                      v
        +-----------------------------+
        |   Reporting Layer           |
        | - TestNG Reports            |
        | - Screenshots on Failure    |
        +-------------+---------------+
                      |
          +-----------+-----------+
          |                       |
          v                       v
   Reports Folder         Screenshots Folder
```

---

## 🔄 Execution Flow

1. Test execution starts from **TestNG test classes** using `testng-chrome.xml`
2. Test classes interact with **Page Object Model (POM) classes**
3. Page classes contain locators and reusable actions
4. Base class initializes WebDriver and manages browser setup
5. Utility classes provide reusable methods like waits, actions, and screenshots
6. Selenium WebDriver interacts with browser (Chrome/Edge)
7. Test data and configurations are used during execution
8. Reports and screenshots are generated after execution

---

## ⚙️ Framework Features

* Page Object Model (POM) implementation
* Reusable utility classes
* Dynamic waits using WebDriverWait
* Clean and maintainable code
* TestNG XML-based execution
* Screenshot capture for failed tests
* Cross-browser execution (Chrome & Edge)

---

## 🧪 Test Scenarios

### 1. Footer Links Verification

* Validate footer sections (TEAM, ABOUT, GUIDELINES, CONTACT)

### 2. Team Details Verification

* Verify team logos
* Validate trophy-winning years on hover

### 3. Points Table Validation

* Validate Rank 1 team
* Verify matches and points

### 4. News Search Functionality

* Search: "Auction 2026"
* Validate relevant articles

---


## 🌐 Cross Browser Support

* Google Chrome
* Microsoft Edge

---

## 📊 Reporting & Screenshots

* Execution reports generated after test run
* Screenshots captured automatically for failed tests

Stored in:

* `surefire-reports`
* `/screenshots`

---

## 📈 Evaluation Coverage

* Architecture Design ✔
* Framework Implementation ✔
* UI Automation Coverage ✔
* Code Quality ✔
* Data Driven Testing ✔
* Logging & Reporting ✔
* Cross Browser Support ✔
* Git Usage ✔
* Documentation ✔

---

## 📦 Deliverables

* README documentation
* Architecture diagram
* Execution reports
* Git repository link
* Screenshots for failed tests
* Contribution details

---

## 👤 Authors

* **Roshitha Kurma** –POM Design, Test Case 3 and 4 Design, Driver Setup and Validation
* **Alekhya Kaki** – Framework Development, Test Case 3 and 4 Design, Execution, Validation & Reporting

---

## 🚀 Future Enhancements

* CI/CD integration (Jenkins)
* Allure Reporting
* Parallel execution
* Docker support

---

## ⭐ Conclusion

This project demonstrates a complete **UI Automation Framework design**, not just test scripts, following industry standards and best practices.
