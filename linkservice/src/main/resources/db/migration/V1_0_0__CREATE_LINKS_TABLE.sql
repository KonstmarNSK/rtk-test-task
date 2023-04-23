CREATE TABLE links(
    short_link VARCHAR2(50) NOT NULL,
    long_link VARCHAR2(500) NOT NULL,
    PRIMARY KEY(short_link)
);

create sequence next_link_num;