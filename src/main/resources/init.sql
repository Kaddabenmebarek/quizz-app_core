/*USER*/

INSERT INTO `quizdb`.`users` (`id`, `email`, `is_admin`, `password`, `username`) VALUES ('1', 'admin@test.com', 1, 'admin', 'admin');
INSERT INTO `quizdb`.`users` (`id`, `email`, `is_admin`, `password`, `username`) VALUES ('2', 'user@test.com', 0, 'user', 'user');
commit;

/*QUIZZES*/
INSERT INTO `` (`id`,`quiz_name`,`technology`) VALUES (1,'Java Quiz','Java');
INSERT INTO `` (`id`,`quiz_name`,`technology`) VALUES (2,'SQL Quiz','SQL');
commit;

/*Questions*/
INSERT INTO `` (`id`,`correct_option`,`option1`,`option2`,`option3`,`option4`,`question_text`,`technology`) VALUES (1,3,'6','7','8','9','Number of primitive data types in Java are?','Java');
INSERT INTO `` (`id`,`correct_option`,`option1`,`option2`,`option3`,`option4`,`question_text`,`technology`) VALUES (2,1,'char[] ch = new char[5]','char[] ch = new char()','char[] ch = new char()','char[] ch = new char[]',' Select the valid statement.','Java');
INSERT INTO `` (`id`,`correct_option`,`option1`,`option2`,`option3`,`option4`,`question_text`,`technology`) VALUES (3,3,'True','False','An int value','None','compareTo() returns','Java');
INSERT INTO `` (`id`,`correct_option`,`option1`,`option2`,`option3`,`option4`,`question_text`,`technology`) VALUES (4,2,'101','Compile error as ++a is not valid identifier','100','None','Find the output of the following code. int ++a = 100; System.out.println(++a);','Java');
INSERT INTO `` (`id`,`correct_option`,`option1`,`option2`,`option3`,`option4`,`question_text`,`technology`) VALUES (5,1,'Binary Large Objects','Big Large Objects','Binary Language for Objects','None of the above','What does BLOB in SQL stand for?','SQL');
INSERT INTO `` (`id`,`correct_option`,`option1`,`option2`,`option3`,`option4`,`question_text`,`technology`) VALUES (6,3,'Left outer join','Right outer join','Inner join','Natural join','Which of the join operations do not preserve non matched tuples?','SQL');
INSERT INTO `` (`id`,`correct_option`,`option1`,`option2`,`option3`,`option4`,`question_text`,`technology`) VALUES (7,3,'Equi-join','Natural join','Outer join','All of the mentioned','What type of join is needed when you wish to include rows that do not have matching values?','SQL');
INSERT INTO `` (`id`,`correct_option`,`option1`,`option2`,`option3`,`option4`,`question_text`,`technology`) VALUES (8,2,'Select Name,ID from Courses,Student where Student_ID = ID','Select Name, ID from Student natural join Courses','Select Name, ID from Student','Select ID from Student join Courses;','SELECT Name, ID   FROM Student, Courses   WHERE Student_ID = Courses_ID is equivalent to','SQL');
commit;

/*QuizQuestion*/
INSERT INTO `` (`id`,`question_id`,`quiz_id`) VALUES (1,1,1);
INSERT INTO `` (`id`,`question_id`,`quiz_id`) VALUES (2,2,1);
INSERT INTO `` (`id`,`question_id`,`quiz_id`) VALUES (3,3,1);
INSERT INTO `` (`id`,`question_id`,`quiz_id`) VALUES (4,4,1);
INSERT INTO `` (`id`,`question_id`,`quiz_id`) VALUES (5,5,2);
INSERT INTO `` (`id`,`question_id`,`quiz_id`) VALUES (6,6,2);
INSERT INTO `` (`id`,`question_id`,`quiz_id`) VALUES (7,7,2);
INSERT INTO `` (`id`,`question_id`,`quiz_id`) VALUES (8,8,2);
commit;