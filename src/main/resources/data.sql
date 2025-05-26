INSERT INTO USERS(name, email, password) VALUES('Student', 'student@email.com', '123456');

INSERT INTO COURSE(name, category) VALUES('Spring Boot', 'Programming');
INSERT INTO COURSE(name, category) VALUES('HTML 5', 'Front-end');

INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question', 'Error creating project', '2019-05-05 20:00:00', 'UNANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question 2', 'Project won’t compile', '2019-05-05 20:00:00', 'UNANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, course_id) VALUES('Question 3', 'HTML Tag', '2019-05-05 20:00:00', 'UNANSWERED', 1, 2);

-- everytime the app starts the Spring framework will populate the H2 database using this.