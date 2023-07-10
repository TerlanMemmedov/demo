CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID BIGINT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(50) NOT NULL,
    AGE INTEGER,
    POSITION VARCHAR(50),
    PRIMARY KEY (EMPLOYEE_ID),
    COMPANY_ID BIGINT NOT NULL,
    FOREIGN KEY (COMPANY_ID) REFERENCES COMPANY(COMPANY_ID) ON DELETE CASCADE
);