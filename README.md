# 🏏 IPL Automation Framework

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange"/>
  <img src="https://img.shields.io/badge/Selenium-WebDriver-green"/>
  <img src="https://img.shields.io/badge/TestNG-Framework-blue"/>
  <img src="https://img.shields.io/badge/Maven-Build-red"/>
  <img src="https://img.shields.io/badge/Design-POM-yellow"/>
</p>

---

## 📌 Project Overview

The **IPL Automation Framework** is a UI Automation Testing framework developed to validate critical functionalities of the IPL official website:
👉 https://www.iplt20.com/

This framework is built using **industry best practices** and follows the **Page Object Model (POM)** design pattern to ensure:

* ✔ Scalability
* ✔ Reusability
* ✔ Maintainability

---

## 🎯 Objective

* Automate key user journeys of the IPL website
* Build a **scalable and reusable automation framework**
* Implement **Page Object Model (POM)**
* Maintain proper separation of concerns
* Generate structured reports and debugging artifacts

---

## 🏗️ Framework Architecture

```
Test Layer (TestNG)
        ↓
Page Object Model (POM)
        ↓
Base Class (Driver Setup)
        ↓
Utility Classes (Waits, Screenshots, Actions)
        ↓
Selenium WebDriver
        ↓
Browser (Chrome / Edge)
        ↓
Reporting Layer (Reports + Screenshots)
```

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
│   │   ├── base/
│   │   ├── tests/
│   │   ├── utils/
│
│── testng.xml
│── testng-chrome.xml
│── testng-edge.xml
│── pom.xml
│── README.md
│── reports/
│── screenshots/
```

---

## ⚙️ Tech Stack

* **Java (JDK 17+)**
* **Selenium WebDriver (v4)**
* **TestNG**
* **Maven**
* **Page Object Model (POM)**
* **Git**

---

## 🔄 Execution Flow

1. Test execution starts from `testng.xml`
2. TestNG triggers test classes
3. Test classes call Page Object methods
4. Page classes interact with WebDriver
5. Base class initializes browser
6. Utility classes handle waits and screenshots
7. Browser performs actions
8. Reports and screenshots are generated

---

## ⚙️ Framework Features

* ✔ Page Object Model (POM) implementation
* ✔ Reusable utility classes
* ✔ Dynamic waits using WebDriverWait
* ✔ Clean and maintainable code
* ✔ TestNG XML-based execution
* ✔ Screenshot capture for failed tests
* ✔ Cross-browser execution (Chrome & Edge)

---

## 🧪 Test Scenarios

### ✅ 1. Footer Links Verification

* Validate footer sections (TEAM, ABOUT, GUIDELINES, CONTACT)

### ✅ 2. Team Details Verification

* Verify team logos
* Validate trophy-winning years on hover

### ✅ 3. Points Table Validation

* Validate Rank 1 team
* Verify matches and points

### ✅ 4. News Search Functionality

* Search: **"Auction 2026"**
* Validate relevant articles

---

## ▶️ Execution Steps

### 🔹 Run using Maven

```
mvn clean install
```

### 🔹 Run using TestNG

```
mvn test -DsuiteXmlFile=testng-chrome.xml
mvn test -DsuiteXmlFile=testng-edge.xml
```

---

## 🌐 Cross Browser Support

* 🌐 Google Chrome
* 🌐 Microsoft Edge

---

## 📊 Reporting & Screenshots

* TestNG reports are generated after execution
* Reports are stored in `/reports` folder
* Screenshots are captured automatically for failed tests

📁 Example:

* `/reports/test-output/index.html`
* `/screenshots/`

---

## 📈 Evaluation Coverage

* ✔ Architecture Design
* ✔ Framework Implementation
* ✔ UI Automation Coverage
* ✔ Code Quality
* ✔ Data Driven Testing
* ✔ Logging & Reporting
* ✔ Cross Browser Support
* ✔ Git Usage
* ✔ Documentation

---

## 📦 Deliverables

* README documentation
* Architecture diagram
* Execution reports (stored in `/reports`)
* Git repository link
* Screenshots for failed tests
* Roles and responsibilities document

---

## 👤 Authors & Roles

* **Roshitha Kurma** – Test Case Design, Execution, Validation & Reporting
* **Alekhya Kaki** – Framework Development, POM Design, Driver Setup

---

## 🚀 Future Enhancements

* 🔹 Jenkins CI/CD integration
* 🔹 Allure Reporting
* 🔹 Parallel execution
* 🔹 Docker support

---

## ⭐ Conclusion

This project demonstrates a complete **UI Automation Framework design**, not just test scripts, following **industry standards and best practices**.

It showcases strong expertise in:

* Selenium WebDriver
* TestNG
* Page Object Model
* Automation Framework Design

---

## 💡 Author Note

This project reflects a strong foundation in **QA Automation Engineering** and demonstrates the ability to design scalable and maintainable test frameworks suitable for real-world applications.
