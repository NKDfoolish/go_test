CREATE TABLE students (
  student_id BIGINT PRIMARY KEY,
  no_language VARCHAR(2)
);

CREATE TABLE scores (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT NOT NULL,
    subject VARCHAR(50) NOT NULL,
    score FLOAT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    UNIQUE (student_id, subject)
);
