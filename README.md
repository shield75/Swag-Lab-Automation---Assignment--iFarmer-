# **Swag Labs Automation**

## **Overview**
Swag Labs Automation is a Selenium and TestNG-based automation testing framework built to validate the functionalities of Swag Labs web application. Designed with modularity and scalability in mind, this framework supports running tests across multiple workflows such as login, cart management, and visual validations, while also leveraging **Allure** for professional-grade reporting. Additionally, this project is integrated with GitHub Actions for continuous integration. On every push to the main branch, the pipeline automatically executes the test suite and generates interactive Allure Reports, ensuring that test feedback and reporting remain consistent and up-to-date.

---

## **Features**
- Fully automated testing for the Swag Labs web application's critical functionalities.
- Supports detailed **TestNG** test cases and scenarios.
- Modular design using reusable base classes, page objects, and utility functions.
- Efficient test data management for scenario-based and data-driven testing.
- Detailed test progress and results reporting using **Allure**.
- Screenshots for visual validation and error debugging using **Screenshot**.
- Cross-browser support (Chrome, Firefox, Edge) managed by **WebDriverManager**.
- Continuous Integration with **GitHub Actions** to automatically run tests and generate Allure reports on each push to `main`.
- Scalable and maintainable framework architecture following industry best practices.


---

## **Prerequisites**
1. **Java Development Kit (JDK)** — version 20 or later.
   - Required to compile and run the Selenium TestNG framework.

2. **Apache Maven** — for project build and dependency management.
   - All dependencies (Selenium, TestNG, WebDriverManager, Allure, etc.) are managed through `pom.xml`.

3. **Supported Web Browsers** — latest versions of Chrome, Firefox, or Edge.
   - Browser drivers are automatically handled using **WebDriverManager** (no manual setup required).

4. **Allure Command-Line Tool** — for generating and serving rich test reports.
   - Install via **Homebrew** (macOS) or **Chocolatey** (Windows).

5. **Git & GitHub** — for version control and CI/CD.
   - Project integrates with **GitHub Actions** to run tests and publish Allure reports on pushes to `main`.


---

## **Setup**

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```

2. Install necessary dependencies:
   ```bash
   mvn clean install
   ```

3. Configure `config.properties` file:
    - Update the values for:
        - `baseURL` - Application's URL (Swag Labs).
        - `browser` - (e.g., Chrome, Firefox).
    - The file is located at: `src/test/resources/config.properties`.

4. Framework structure

   - **src/test/java/pages/** → Contains Page Object Model (POM) classes representing different pages of the application. Includes `BasePage` for common page actions and `CommonElements` for shared UI elements.

   - **src/test/java/testCases/** → Contains all TestNG test classes that define different workflows and test scenarios (login, cart, checkout, sorting, logout).

   - **src/test/java/utilities/** → Contains helper and utility classes:
      - `DriverManager.java` → Manages WebDriver setup and teardown.
      - `configProperties.java` → Reads configuration values from `config.properties`.
      - `Data.java` → Stores test data for tests.

   - **src/test/resources/** → Stores configuration files (`config.properties`, `testng.xml`) and other test resources.

   - **allure-results/** → Stores the test results for Allure reporting.

   - **assets/** → Stores assets like screenshots or other supporting files.

   - **.github/** → Contains GitHub Actions workflow files for CI/CD integration.

   - **pom.xml** → Maven configuration for dependencies, build, and plugin management.

   - **README.md** → Project documentation.

---

## **Execution**

### Run All Tests
Run all test cases from the framework:
```bash
mvn clean test
```

### Run Specific Test Cases
To run specific test cases, edit `testNg.xml` in `src/test/resources`. Add or exclude the test classes you wish to execute.

A sample `testNg.xml` snippet:
```xml
<classes>
    <class name="testCases.LoginTestCase"></class>
    <class name="testCases.AddToCartTestCase"></class>
</classes>
```

---

## **Test Cases**

### **1. LoginTestCase.java**
#### **Description:**
Validates the login functionality under various scenarios.
#### **Test Scenarios:**
- Valid user credentials should log in successfully.
- Invalid credentials should not allow login and an error message should display.
- Login attempt for a non-existent user.
- Empty field validation (username/password).

---

### **2. ProductSortingTestCase.java**
#### **Description:**
Tests product details page sorting functionality.
#### **Test Scenarios:**
- Verify the correct product sorting.
---

### **3. AddToCartTestCase.java**
#### **Description:**
Validates the product addition and cart behavior.
#### **Test Scenarios:**
- Single product addition and verification.
- Add multiple products and verify cart contents.
- Verify item prices and total.

---

### **4. RemoveFromCartTestCase.java**
#### **Description:**
Tests removing items from the cart functionality.
#### **Test Scenarios:**
- Verify removing a single product works correctly.


---

### **5. CheckoutProcessTestCase.java**
#### **Description:**
Validates the steps involved during the checkout process.
#### **Test Scenarios:**
- Add items to cart and start checkout.
- Enter valid customer details to proceed.
- Verify successful checkout completion.

---

### **6. LogoutTestCase.java**
#### **Description:**
Tests the logout functionality of the application.
#### **Test Scenarios:**
- Successful logout from the home page.
- Confirm the user is redirected to the login page after logout.

---

## 🔄 Continuous Integration

### GitHub Actions Workflow
This project uses GitHub Actions for continuous integration. The workflow automatically:
- Runs tests on push and pull requests
- Generates and deploys Allure reports
- Runs tests in headless mode
- Caches dependencies for faster builds


### GitHub Actions Features
- Automated test execution on push/pull requests
- Allure report generation and deployment to GitHub Pages
- Maven dependency caching
- Parallel test execution support
- Headless browser testing in CI environment

### Viewing Test Reports
1. Go to the Actions tab in the repository
2. Click on the latest workflow run
3. Navigate to the deployed Allure report
4. Reports are also available as artifacts for each run

### Local vs CI Execution
- Local: Tests run in regular browser mode
- CI: Tests run in headless mode for better performance
___

## **Test Reporting**

This framework integrates **Allure** for modern and interactive reporting:

1. **Run Tests**:
   ```bash
   mvn clean test
   ```

2. **Generate Allure Report**:
   ```bash
   allure generate --clean target/allure-results
   ```

3. **Serve Allure Report**:
   ```bash
   allure serve target/allure-results
   ```

---

## **Sample Test Report**

To present test results, you can include images in the `assets/` folder. Update the README file to reference them as shown below.

### Example:
- **Test Summary Dashboard**:

![Test Summary](assets/overview.png)

- **Detailed Test Case Report**:

![Test Case Details](assets/singletestcase.png)

- **Swag Lab Automation Test Cases**:

![Test Cases](assets/testcases.png)

---


## **Supported Browsers**
The framework supports the following browsers:
- Google Chrome
- Mozilla Firefox
- Microsoft Edge

WebDriverManager provides automatic browser driver setup.

---

## **Contributing**
Feel free to contribute to this project by forking the repository, making necessary changes, and submitting a pull request.

---

## **License**
This project is licensed under [shield75].

---
