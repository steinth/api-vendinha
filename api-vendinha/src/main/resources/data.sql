CREATE TABLE USERS(
ID INTEGER PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255) NOT NULL,
EMAIL VARCHAR(255) NOT NULL,
PASSWORD VARCHAR(255) NOT NULL,
CPF_CNPJ VARCHAR(255) NOT NULL,
IS_ACTIVE BOOLEAN DEFAULT TRUE
);
CREATE TABLE PRODUCTS(
ID INTEGER PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255) NOT NULL,
QUANTITY INTEGER NOT NULL,
PRICE FLOAT NOT NULL,
USER_ID INTEGER REFERENCES USERS(ID)
)