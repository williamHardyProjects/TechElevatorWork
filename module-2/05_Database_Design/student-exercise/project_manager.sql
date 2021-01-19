CREATE TABLE employee
(
    id SERIAL PRIMARY KEY NOT NULL 
    , title VARCHAR(100) NULL
    , first_name VARCHAR(50) NOT NULL
    , last_name VARCHAR(50) NOT NULL
    , dob DATE NULL
    , hire_date DATE NULL
    , department_id INTEGER NOT NULL
);

CREATE TABLE employee_project
(
    employee_id INTEGER NOT NULL
    , project_id INTEGER NOT NULL
    , PRIMARY KEY (
        employee_id
        , project_id
    )
);

CREATE TABLE department
(
    id SERIAL PRIMARY KEY NOT NULL 
    , name VARCHAR(100) NOT NULL    
);

CREATE TABLE project
(
    id SERIAL PRIMARY KEY NOT NULL 
    , name VARCHAR(100) NOT NULL
    , start_date DATE NULL
);

ALTER TABLE employee
ADD CONSTRAINT fk_employee_department
FOREIGN KEY (department_id) 
REFERENCES department (id);

ALTER TABLE employee_project
ADD CONSTRAINT fk_employee_project_employee
FOREIGN KEY (employee_id) 
REFERENCES employee (id);

ALTER TABLE employee_project
ADD CONSTRAINT fk_employee_project_project
FOREIGN KEY (project_id) 
REFERENCES project (id);

INSERT INTO project
(
    name
    , start_date
)
VALUES
(
    'project1'
    , DATE '01-01-2016'
),
(
    'project2'
    , DATE '01-01-2017'
),
(
    'project3'
    , DATE '01-01-2018'
),
(
    'project4'
    , DATE '01-01-2019'
);

INSERT INTO department
(
    name
)
VALUES
(
    'department1'
),
(
    'department2'
),
(
    'department3'
);

INSERT INTO employee
(
    first_name
    , last_name
    , department_id
)
VALUES
(
    'Amos'
    , 'Stark'
    , 1
),
(
    'Devon'
    , 'Wayne'
    , 2
),
(
    'Chris'
    , 'Lensherr'
    , 3
),
(
    'Max'
    , 'Kent'
    , 1
),
(
    'Georgio'
    , 'Shacklebolt'
    , 2
),
(
    'Alvin'
    , 'Potter'
    , 3
),
(
    'Donald'
    , 'Grindlewald'
    , 1
),
(
    'Kevin'
    , 'Weaseley'
    , 2
);

INSERT INTO employee_project
(
    employee_id
    , project_id
)
VALUES
(
    1
    , 1
),
(
    2
    , 1
),
(
    3
    , 1
),
(
    4
    , 2
),
(
    5
    , 2
),
(
    6
    , 2
),
(
    7
    , 3
),
(
    8
    , 3
);


