# Swag Labs Automation — Project Documentation

Version: 1.0  
Date: 2025-09-19

---

## 1) Summary and Objectives
This repository contains an end-to-end UI test automation framework for the Swag Labs web application, built with Selenium WebDriver, TestNG, and the Page Object Model (POM). The project emphasizes maintainability, readability, and CI-readiness, using Allure for rich reporting and a configurable driver setup for cross‑browser testing.

Primary objectives:
- Validate core user journeys: login, product sorting, add-to-cart, checkout, and logout.
- Provide a scalable test architecture with reusable page components and utilities.
- Produce actionable test reports with screenshots through Allure.
- Enable reliable execution locally and on CI.

Repository link(s):
- Main project: [ADD_YOUR_GITHUB_REPO_URL_HERE]

---

## 2) Thought Process
Design decisions were guided by practical test automation principles:
- Separation of concerns via POM to isolate UI locators and flows from test logic.
- A thin BasePage for synchronized interactions (waits/clicks/inputs) and shared helpers.
- Centralized driver lifecycle management to avoid flakiness and to simplify suite setup/teardown.
- Test data decoupled from test logic to support reuse and easy changes.
- Deterministic runs in CI using headless browser modes and predictable timeouts.
- Report-first mindset: integrate Allure early so that failures are diagnosable with screenshots and steps.

---

## 3) Approach and Methodology
- Test Design:
  - Scenario-based TestNG tests per workflow: Login, Add to Cart, Checkout, Product Sorting, and Logout.
  - Soft assertions where appropriate to aggregate verifications without aborting early.
- Architecture:
  - Page Object Model (POM) classes in `src/test/java/pages` encapsulate locators and behaviors.
  - `BasePage` provides synchronized actions (explicit waits, safe clicks, inputs, dropdown selects) and Allure attachments.
  - `PageFactory` holds a shared WebDriverWait and initializes page elements.
  - `utilities` contain driver management and config readers.
- Environment & Config:
  - `config.properties` drives base URL and browser selection.
  - `DriverManager` supports Chrome (headless by default for CI), Firefox (headless), Edge, and Safari.
  - Implicit and explicit waits are used judiciously (10s defaults) to reduce flakiness.
- Reporting:
  - Allure annotations (@Step, @Attachment) and automatic screenshots for richer context.
- CI/CD:
  - Project is structured to be GitHub Actions–friendly. Tests can run headless on push to main. Allure results live under `allure-results/` and `target/allure-results/`.

---

## 4) Steps Taken to Complete the Tasks
1. Established project skeleton with Maven, Selenium, TestNG, and Allure dependencies (`pom.xml`).
2. Implemented core pages using POM:
   - `LoginPage`, `ProductsPage`, `CartPage`, `CheckoutPage`, and shared `CommonElements`.
3. Built `BasePage` utilities:
   - Safe clicking, text input with visibility checks, dropdown selecting, visibility verifications, and Allure screenshot attachments.
4. Added `PageFactory` to initialize elements and provide a shared `WebDriverWait`.
5. Implemented `DriverManager` to centralize browser setup/teardown with CI-friendly headless options and implicit wait/maximize.
6. Created TestNG test cases for each workflow in `src/test/java/testCases`:
   - `LoginTestCase`, `AddToCartTestCase`, `ProductSortingTestCase`, `CheckoutTestCase`, `LogOutTestCase`.
7. Set up configuration management via `utilities.configProperties` and `src/test/resources/config.properties`.
8. Wired Allure reporting and attached screenshots on demand via `BasePage.takeScreenshot`.
9. Added TestNG suite configuration (`src/test/resources/testNg.xml`) to orchestrate test runs and selective execution.
10. Verified local and CI runs, producing `target/surefire-reports` and Allure results artifacts.

---

## 5) Final Achievements
- Stable, maintainable Selenium + TestNG test suite for key Swag Labs scenarios.
- Reusable POM abstraction with synchronized interactions to minimize flaky tests.
- Headless execution paths suitable for CI.
- Allure enriched reporting with steps and screenshots.
- Structured test data management for login and checkout.
- Clear suite configuration (TestNG XML) for targeted runs and grouping.

Artifacts produced by sample executions (already present in repo):
- `allure-results/` JSON and attachments
- `target/surefire-reports/` HTML, XML reports
- `assets/` screenshots and illustrative images

---

## 6) How to Run the Suite
- Pre-requisites: JDK 20+, Maven, a modern browser. Allure CLI optional for report serving.
- Commands:
  - Run entire suite: `mvn clean test`
  - Serve Allure report (if CLI installed): `allure serve allure-results`
  - Target specific tests: edit `src/test/resources/testNg.xml` classes section.

---

## 7) How to Export this Documentation to PDF
This documentation is available as both Markdown and HTML in the `docs/` directory.

Option A — Using your Browser (no installation):
1. Open `docs/Project-Documentation.html` in any modern browser.
2. Press Ctrl+P (Cmd+P on macOS) and choose "Save as PDF".
3. Save to your preferred location.

Option B — Using Pandoc (optional):
- If you have Pandoc installed: `pandoc docs/Project-Documentation.md -o docs/Project-Documentation.pdf`

---

## 8) Repository Links
- Swag Labs Automation (this project): [ADD_YOUR_GITHUB_REPO_URL_HERE]

If you have multiple related projects, list them here with their GitHub URLs.

---

## 9) File Map Reference (Key Files)
- `src/test/java/pages/BasePage.java` — shared UI actions, waits, and Allure support.
- `src/test/java/pages/PageFactory.java` — element initialization and shared wait.
- `src/test/java/pages/*.java` — POM classes per application page.
- `src/test/java/testCases/*.java` — TestNG workflow tests.
- `src/test/java/utilities/DriverManager.java` — WebDriver initialization/teardown.
- `src/test/java/utilities/configProperties.java` — config reader and environment writer.
- `src/test/resources/testNg.xml` — suite definition.
- `src/test/resources/config.properties` — base URL, browser, and other settings.

---

## 10) Notes & Future Improvements
- Add parallel execution support using TestNG parallelism and thread-safe page objects.
- Enhance retry logic for known transient failures.
- Integrate a GitHub Actions workflow to auto-publish Allure reports as build artifacts or GitHub Pages.
- Parameterize environments (dev/stage/prod) via Maven profiles.
