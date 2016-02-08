# Mom and Pop Books

## User Roles
- Visitor
	- Browse, interact with cart (add/remove), checkout, search
- Customer
	- Same as visitor
- Administrator
	- Run reports
- Partner
	- Interact with API (SOAP or REST)
- All Users
	- Login
	- Logout
	- Register

## Suggested Components
1. Data Access
	This component mediates between your application’s business logic and the data base. It should be scalable, use `connectionPool` and be configurable.
2. Product Catalog Component/Service
	The Product Catalog is offered both as a servlet (backend for the web front end of the e-store) and as a Web Service (SOAP or REST). When offered as a service, it is just for external Partners. It should support: `getProductInfo(productId)`
3. Order Process Component/Service
	The Order Process is offered both as a servlet and as a Service (REST). It is offered as a service for external Partners. It should support: `getOrdersByPartNumber(partNumber)`
4. Session Controller
	The session controller mediates between the “model” (B and C above) and the “views” (E, F, and G below).  The controller manages session information related to the shopping cart (items selected, address, etc.).  Ideally the Session Controller is a Servlet.
5. Book Store Main Page
	Displays the contents of the store organized by category and by product. 
6. Web services
	Your application has two web services, as specified above, each one with one method (the italic method). The web services respond to REST or SOAP messages. The REST message should reply with an XML message using the XML schema `po.xml`, available [here](http://www.w3.org/TR/xmlschema-0/)
7. Performance and Scalability
	Conduct a performance test of your application. For this project focus just on one Service (2 or 3 above). Test your application with `1, 2, ..., n` clients. Draw the throughput and the response time curves.
8. Security
	The store website should run under https (SSL). Account Order page and “Confirm Order” action must be secured so that a login is required and the password is not passed in plain text. The visitor MUST type in their credit card each time.  It should not be stored.

## Use Cases
- M1 -- Visitor can browse Book Categories and see the books available
- M2 -- Visitor can select a book and see the information for that title
- M3 -- Visitor can add a review for book
- M4 -- Visitor can search the store
- M5 -- Visitor can add an individual book to shopping cart
- M6 -- Visitor can use the shopping cart button
- C1 -- Shopping cart has a view view of all the items in the shopping basket and their information (price, etc.)
- C2 -- Shopping cart supports removal individual items from the shopping cart or increase/decrease the quantity (while doing so, the total bill is updated)
- C3 -- Shopping cart contains "Payment" submit button indicating they wish to purchase the items in the shopping cart
- P1 -- Payment page requires visitor either log into their account with a password, or create a new account.
- P2 -- Payment page for a new account requires they enter their account name, password, and default billing and shipping information
- P3 -- Payment page requires that to submit their order, they verify their billing and shipping information, and enter in their credit card number
- P4 -- Payment page contains a "Confirm order" button, which fails every third request
- A1 -- Administrator can generate a report with the books sold each month

## Design Document
- Less than 10 pages
- Has a front page with the title, team members
- Has a table of contents
- Has the architecture, including UML use cases, class diagrams and 2 sequence diagrams (for 2 use cases). Describe the patterns you used, the main design decisions, trade-offs
- Implementation decisions, trade-offs. Discuss the limitations, especially with regard to testing
- Performance testing report
- Team member contributions: In one paragraph, describe how the team worked, how often you met and how you collaborated. Then for each team member, detail the individual contributions in one paragraph/member; also explain how each team member learned about elements of the projects done by other members.
- Each member of the team sign the document to attest that team member contributions reflect the reality.

## WAR File
- Source code included
- Test drivers and test data
- Code samples for Partner
- SQL file to create and populate DB
- README file explaining to how install and run application, run tests
- Index file containing information of other files

## Deliverables
A single zip file containing the following:
1. Design Document
2. WAR File

## Grading
* Use Cases -- 35 marks
* Documentation -- 15 marks
* Robustness and Testing -- 15 marks
* Source Code and Design -- 15 marks
* Quality (compared to other groups) -- 20 marks
