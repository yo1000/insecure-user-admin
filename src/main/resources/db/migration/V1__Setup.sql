CREATE TABLE USER (
  KEY         INT           NOT NULL,
  USERNAME    VARCHAR(1024) NOT NULL,
  PASSWORD    VARCHAR(1024) NOT NULL,
  FULLNAME    VARCHAR(1024) NOT NULL,
  PRIMARY KEY(KEY)
);

INSERT INTO USER(KEY, USERNAME, PASSWORD, FULLNAME) VALUES (1, 'YAGAMI'   , 'L'         , '夜神月');
INSERT INTO USER(KEY, USERNAME, PASSWORD, FULLNAME) VALUES (2, 'AMANE'    , 'SHITTE'    , '弥海砂');
INSERT INTO USER(KEY, USERNAME, PASSWORD, FULLNAME) VALUES (3, 'MATSUDA'  , 'IRUKA'     , '松田桃太');
INSERT INTO USER(KEY, USERNAME, PASSWORD, FULLNAME) VALUES (4, 'MOGI'     , 'SHINI-GAMI', '模木完造');
INSERT INTO USER(KEY, USERNAME, PASSWORD, FULLNAME) VALUES (5, 'AIZAWA'   , 'HA'        , '相沢周市');
INSERT INTO USER(KEY, USERNAME, PASSWORD, FULLNAME) VALUES (6, 'IDE'      , 'RINGO'     , '伊出英基');
INSERT INTO USER(KEY, USERNAME, PASSWORD, FULLNAME) VALUES (7, 'DEMEGAWA' , 'SHIKA'     , '出目川仁');
INSERT INTO USER(KEY, USERNAME, PASSWORD, FULLNAME) VALUES (8, 'TAKADA'   , 'TABE-NAI'  , '高田清美');
