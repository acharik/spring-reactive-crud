DROP TABLE IF EXISTS Loc_contract;
    CREATE TABLE Loc_contract (
                                    ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                                    date_begin TIMESTAMP NOT NULL,
                                    date_end TIMESTAMP,
                                    num_contract VARCHAR(100) not null,
                                    sum DECIMAL(17,4),
                                    comment VARCHAR(255),
                              CONSTRAINT num_uniq UNIQUE (num_contract),
                              CONSTRAINT date_check CHECK (date_end >date_begin)
);